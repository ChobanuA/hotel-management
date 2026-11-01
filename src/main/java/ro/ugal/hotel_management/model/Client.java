
package ro.ugal.hotel_management.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clienti")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long id;

    @Column(name = "nume", nullable = false, length = 100)
    private String nume;

    @Column(name = "prenume", nullable = false, length = 100)
    private String prenume;

    @Column(name = "email", unique = true, length = 150)
    private String email;

    @Column(name = "telefon", length = 20)
    private String telefon;

    @Column(name = "data_crearii", insertable = false, updatable = false)
    private LocalDateTime dataCrearii;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public LocalDateTime getDataCrearii() {
        return dataCrearii;
    }

    public void setDataCrearii(LocalDateTime dataCrearii) {
        this.dataCrearii = dataCrearii;
    }
}
