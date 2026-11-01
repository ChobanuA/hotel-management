package ro.ugal.hotel_management.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "plati")
public class Plata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plata")
    private Long id;

    @Column(name = "id_rezervare", nullable = false)
    private Long idRezervare;

    @Column(name = "suma", nullable = false)
    private BigDecimal suma;

    @Column(name = "metoda", nullable = false)
    private String metoda;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "data_platii")
    private LocalDateTime dataPlatii;

    public Plata() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRezervare() {
        return idRezervare;
    }

    public void setIdRezervare(Long idRezervare) {
        this.idRezervare = idRezervare;
    }

    public BigDecimal getSuma() {
        return suma;
    }

    public void setSuma(BigDecimal suma) {
        this.suma = suma;
    }

    public String getMetoda() {
        return metoda;
    }

    public void setMetoda(String metoda) {
        this.metoda = metoda;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataPlatii() {
        return dataPlatii;
    }

    public void setDataPlatii(LocalDateTime dataPlatii) {
        this.dataPlatii = dataPlatii;
    }
}