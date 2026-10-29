package ro.ugal.hotel_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ugal.hotel_management.model.Camera;

public interface CameraRepository extends JpaRepository<Camera, Long> {
}