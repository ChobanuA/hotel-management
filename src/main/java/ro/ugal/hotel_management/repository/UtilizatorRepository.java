package ro.ugal.hotel_management.repository;

import ro.ugal.hotel_management.model.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {
}
