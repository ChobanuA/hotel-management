
package ro.ugal.hotel_management.repository;

import ro.ugal.hotel_management.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
