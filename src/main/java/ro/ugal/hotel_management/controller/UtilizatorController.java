
package ro.ugal.hotel_management.controller;

import ro.ugal.hotel_management.model.Utilizator;
import ro.ugal.hotel_management.repository.UtilizatorRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/utilizatori")
public class UtilizatorController {

    private final UtilizatorRepository repository;

    public UtilizatorController(UtilizatorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Utilizator> getAll() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Utilizator getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Utilizatorul nu a fost gasit"));
    }


    @PostMapping
    public Utilizator create(@RequestBody Utilizator utilizator) {
        try {
            return repository.saveAndFlush(utilizator);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username, email sau id_rol invalid.");
        }
    }


    @PutMapping("/{id}")
    public Utilizator update(
            @PathVariable Long id,
            @RequestBody Utilizator utilizator) {

        Utilizator existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Utilizatorul nu a fost gasit"));

        existing.setNumeComplet(utilizator.getNumeComplet());
        existing.setUsername(utilizator.getUsername());
        existing.setEmail(utilizator.getEmail());
        existing.setActiv(utilizator.getActiv());
        existing.setIdRol(utilizator.getIdRol());

        if (utilizator.getParolaHash() != null &&
                !utilizator.getParolaHash().isBlank()) {
            existing.setParolaHash(utilizator.getParolaHash());
        }

        try {
            return repository.saveAndFlush(existing);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username, email sau id_rol invalid.");
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Utilizatorul nu a fost gasit");
        }

        repository.deleteById(id);
    }
}
