
package ro.ugal.hotel_management.controller;

import ro.ugal.hotel_management.model.Client;
import ro.ugal.hotel_management.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clienti")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Clientul nu a fost gasit"));
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        client.setId(null);
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client dateNoi) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Clientul nu a fost gasit"));

        client.setNume(dateNoi.getNume());
        client.setPrenume(dateNoi.getPrenume());
        client.setEmail(dateNoi.getEmail());
        client.setTelefon(dateNoi.getTelefon());

        return clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Clientul nu a fost gasit"));

        clientRepository.delete(client);
    }
}
