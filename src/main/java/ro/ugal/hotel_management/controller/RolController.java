
package ro.ugal.hotel_management.controller;

import ro.ugal.hotel_management.model.Rol;
import ro.ugal.hotel_management.repository.RolRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/roluri")
public class RolController {

    private final RolRepository repository;

    public RolController(RolRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public List<Rol> getAll() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Rol getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Rolul nu a fost gasit"));
    }


    @PostMapping
    public Rol create(@RequestBody Rol rol) {
        try {
            return repository.saveAndFlush(rol);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Acest nume de rol exista deja.");
        }
    }


    @PutMapping("/{id}")
    public Rol update(@PathVariable Long id, @RequestBody Rol rol) {
        Rol existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Rolul nu a fost gasit"));

        existing.setNume(rol.getNume());

        try {
            return repository.saveAndFlush(existing);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Acest nume de rol exista deja.");
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Rolul nu a fost gasit");
        }

        try {
            repository.deleteById(id);
            repository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Nu se poate sterge rolul deoarece este folosit de utilizatori.");
        }
    }
}
