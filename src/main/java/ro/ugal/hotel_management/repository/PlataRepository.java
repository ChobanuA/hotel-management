package ro.ugal.hotel_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ugal.hotel_management.model.Plata;

public interface PlataRepository extends JpaRepository<Plata, Long> {
}