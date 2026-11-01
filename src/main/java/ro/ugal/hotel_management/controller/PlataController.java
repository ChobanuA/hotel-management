package ro.ugal.hotel_management.controller;

import ro.ugal.hotel_management.model.Plata;
import ro.ugal.hotel_management.repository.PlataRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/plati")
public class PlataController {

    private final PlataRepository repository;

    public PlataController(PlataRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Plata> getAll() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Plata getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Plata nu a fost gasita"));
    }


    @PostMapping
    public Plata create(@RequestBody Plata plata) {
        return repository.save(plata);
    }


    @PutMapping("/{id}")
    public Plata update(@PathVariable Long id, @RequestBody Plata plata) {
        Plata existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Plata nu a fost gasita"));

        existing.setIdRezervare(plata.getIdRezervare());
        existing.setSuma(plata.getSuma());
        existing.setMetoda(plata.getMetoda());
        existing.setDataPlatii(plata.getDataPlatii());
        existing.setStatus(plata.getStatus());

        return repository.save(existing);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Plata nu a fost gasita");
        }

        try {
            repository.deleteById(id);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Nu se poate sterge plata deoarece este folosita in alta inregistrare.");
        }
    }
}