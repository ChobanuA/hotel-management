
package ro.ugal.hotel_management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ugal.hotel_management.Rezervare;
import ro.ugal.hotel_management.repository.RezervareRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/rezervari")
public class RezervareController {

    private final RezervareRepository repository;

    public RezervareController(RezervareRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Rezervare> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rezervare> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Rezervare create(@RequestBody Rezervare rezervare) {
        rezervare.setId(null);
        return repository.save(rezervare);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rezervare> update(
            @PathVariable Long id,
            @RequestBody Rezervare dateNoi) {

        return repository.findById(id)
                .map(rezervare -> {
                    rezervare.setDataCheckin(dateNoi.getDataCheckin());
                    rezervare.setDataCheckout(dateNoi.getDataCheckout());
                    rezervare.setIdClient(dateNoi.getIdClient());
                    rezervare.setIdCamera(dateNoi.getIdCamera());
                    rezervare.setStatus(dateNoi.getStatus());

                    return ResponseEntity.ok(repository.save(rezervare));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        try {
            repository.deleteById(id);
            repository.flush();
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Nu se poate sterge rezervarea deoarece are plati asociate."
            );
        }
    }}
