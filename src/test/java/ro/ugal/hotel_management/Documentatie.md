# Sistem web pentru gestiunea unui hotel

## Etapa 0 – Definirea temei

### 1. Domeniul de activitate

Proiectul constă în dezvoltarea unei aplicații web pentru gestionarea activităților unui hotel.

Aplicația permite administrarea camerelor, clienților, rezervărilor, plăților și serviciilor suplimentare.

Scopul sistemului este de a centraliza informațiile și de a simplifica activitățile personalului hotelului.

### 2. Obiectivele proiectului

Obiectivele principale sunt:

- Gestionarea camerelor și a disponibilității acestora.
- Înregistrarea și administrarea clienților.
- Crearea și actualizarea rezervărilor.
- Înregistrarea plăților.
- Gestionarea serviciilor suplimentare.
- Autentificarea utilizatorilor și controlul accesului pe bază de roluri.
- Optimizarea interogărilor bazei de date.
- Testarea performanței API-ului.
- Generarea rapoartelor pe baza datelor existente.

### 3. Tehnologii utilizate

Aplicația va fi dezvoltată folosind Java 21 și Spring Boot.

Pentru stocarea datelor va fi utilizat sistemul de gestiune a bazelor de date relaționale PostgreSQL.

Accesul la date va fi realizat prin Spring Data JPA și Hibernate. Autentificarea și autorizarea vor fi implementate cu Spring Security.

Interfața web va utiliza Thymeleaf și Bootstrap, iar Maven va fi folosit pentru gestionarea dependențelor și construirea aplicației.

Testarea performanței API-ului va fi realizată cu Apache JMeter.

### 4. Tipurile de utilizatori

Sistemul va avea trei roluri principale:

- ADMIN – administrarea completă a aplicației.
- RECEPTIONIST – gestionarea clienților, camerelor și rezervărilor.
- MANAGER – acces la rapoarte și informații statistice.

Drepturile fiecărui rol vor fi verificate la nivelul aplicației.

### 5. Paginile interfeței

- Autentificare – permite conectarea utilizatorilor.
- Dashboard – afișează informații generale despre activitatea hotelului.
- Gestionarea camerelor – permite vizualizarea și administrarea camerelor.
- Gestionarea clienților – permite înregistrarea și actualizarea datelor clienților.
- Gestionarea rezervărilor – permite crearea și administrarea rezervărilor.
- Gestionarea plăților – permite înregistrarea și consultarea plăților.
- Gestionarea serviciilor – permite administrarea serviciilor suplimentare.
- Gestionarea utilizatorilor – permite administrarea conturilor și a rolurilor, în funcție de permisiuni.
- Rapoarte – permite consultarea și exportul rapoartelor.

### 6. Rezultatul urmărit

Rezultatul proiectului va fi o aplicație web funcțională pentru gestionarea unui hotel, bazată pe o bază de date relațională și care include operații CRUD, autentificare, roluri, date de test, optimizarea interogărilor, testarea performanței și generarea rapoartelor.