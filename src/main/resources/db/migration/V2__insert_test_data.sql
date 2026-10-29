
INSERT INTO roluri (nume, descriere) VALUES
    ('ADMIN', 'Administratorul aplicatiei'),
    ('RECEPTIONIST', 'Gestioneaza clientii si rezervarile'),
    ('MANAGER', 'Gestioneaza activitatea hotelului');


INSERT INTO utilizatori (
    nume_complet,
    username,
    email,
    parola_hash,
    id_rol
)
SELECT
    'Administrator Test',
    'admin',
    'admin@hotel.test',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    id_rol
FROM roluri
WHERE nume = 'ADMIN';

INSERT INTO utilizatori (
    nume_complet,
    username,
    email,
    parola_hash,
    id_rol
)
SELECT
    'Receptioner Test',
    'receptionist',
    'receptionist@hotel.test',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    id_rol
FROM roluri
WHERE nume = 'RECEPTIONIST';

INSERT INTO utilizatori (
    nume_complet,
    username,
    email,
    parola_hash,
    id_rol
)
SELECT
    'Manager Test',
    'manager',
    'manager@hotel.test',
    '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy',
    id_rol
FROM roluri
WHERE nume = 'MANAGER';


INSERT INTO clienti (nume, prenume, email, telefon) VALUES
    ('Popescu', 'Andrei', 'andrei.popescu@example.com', '0712345678'),
    ('Ionescu', 'Maria', 'maria.ionescu@example.com', '0723456789'),
    ('Dumitru', 'Alexandru', 'alexandru.dumitru@example.com', '0734567890'),
    ('Stan', 'Elena', 'elena.stan@example.com', '0745678901'),
    ('Radu', 'Mihai', 'mihai.radu@example.com', '0756789012');


INSERT INTO camere (numar_camera, tip, pret_noapte, status) VALUES
    ('101', 'SINGLE', 180.00, 'LIBERA'),
    ('102', 'DOUBLE', 250.00, 'LIBERA'),
    ('103', 'TWIN', 240.00, 'LIBERA'),
    ('201', 'SUITE', 450.00, 'LIBERA'),
    ('202', 'DOUBLE', 270.00, 'MENTENANTA');


INSERT INTO rezervari (
    id_client,
    id_camera,
    data_checkin,
    data_checkout,
    status
)
SELECT
    c.id_client,
    ca.id_camera,
    DATE '2026-11-01',
    DATE '2026-11-04',
    'CONFIRMATA'
FROM clienti c
CROSS JOIN camere ca
WHERE c.email = 'andrei.popescu@example.com'
  AND ca.numar_camera = '101';

INSERT INTO rezervari (
    id_client,
    id_camera,
    data_checkin,
    data_checkout,
    status
)
SELECT
    c.id_client,
    ca.id_camera,
    DATE '2026-11-05',
    DATE '2026-11-08',
    'CONFIRMATA'
FROM clienti c
CROSS JOIN camere ca
WHERE c.email = 'maria.ionescu@example.com'
  AND ca.numar_camera = '102';

INSERT INTO rezervari (
    id_client,
    id_camera,
    data_checkin,
    data_checkout,
    status
)
SELECT
    c.id_client,
    ca.id_camera,
    DATE '2026-11-10',
    DATE '2026-11-12',
    'IN_ASTEPTARE'
FROM clienti c
CROSS JOIN camere ca
WHERE c.email = 'alexandru.dumitru@example.com'
  AND ca.numar_camera = '201';


INSERT INTO plati (
    id_rezervare,
    suma,
    metoda,
    status,
    data_platii
)
SELECT
    r.id_rezervare,
    540.00,
    'CARD',
    'ACHITATA',
    CURRENT_TIMESTAMP
FROM rezervari r
JOIN clienti c ON c.id_client = r.id_client
WHERE c.email = 'andrei.popescu@example.com'
  AND r.data_checkin = DATE '2026-11-01'
  AND r.data_checkout = DATE '2026-11-04';

INSERT INTO plati (
    id_rezervare,
    suma,
    metoda,
    status,
    data_platii
)
SELECT
    r.id_rezervare,
    750.00,
    'CASH',
    'ACHITATA',
    CURRENT_TIMESTAMP
FROM rezervari r
JOIN clienti c ON c.id_client = r.id_client
WHERE c.email = 'maria.ionescu@example.com'
  AND r.data_checkin = DATE '2026-11-05'
  AND r.data_checkout = DATE '2026-11-08';

INSERT INTO plati (
    id_rezervare,
    suma,
    metoda,
    status
)
SELECT
    r.id_rezervare,
    900.00,
    'TRANSFER',
    'IN_ASTEPTARE'
FROM rezervari r
JOIN clienti c ON c.id_client = r.id_client
WHERE c.email = 'alexandru.dumitru@example.com'
  AND r.data_checkin = DATE '2026-11-10'
  AND r.data_checkout = DATE '2026-11-12';
