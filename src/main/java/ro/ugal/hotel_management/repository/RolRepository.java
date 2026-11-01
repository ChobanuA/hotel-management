package ro.ugal.hotel_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ugal.hotel_management.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {
}