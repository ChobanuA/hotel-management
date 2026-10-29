package ro.ugal.hotel_management.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "camere")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_camera")
    private Long id;

    @Column(name = "numar_camera", nullable = false, unique = true)
    private String numarCamera;

    @Column(name = "tip", nullable = false)
    private String tip;

    @Column(name = "pret_noapte", nullable = false)
    private BigDecimal pretNoapte;

    @Column(name = "status", nullable = false)
    private String status;

    public Camera() {
    }

    public Long getId() {
        return id;
    }

    public String getNumarCamera() {
        return numarCamera;
    }

    public void setNumarCamera(String numarCamera) {
        this.numarCamera = numarCamera;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public BigDecimal getPretNoapte() {
        return pretNoapte;
    }

    public void setPretNoapte(BigDecimal pretNoapte) {
        this.pretNoapte = pretNoapte;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}