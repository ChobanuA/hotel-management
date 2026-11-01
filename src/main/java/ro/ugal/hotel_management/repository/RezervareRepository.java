
package ro.ugal.hotel_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ugal.hotel_management.Rezervare;

public interface RezervareRepository
        extends JpaRepository<Rezervare, Long> {
}
