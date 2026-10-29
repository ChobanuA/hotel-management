
package ro.ugal.hotel_management.controller;

import org.springframework.web.bind.annotation.*;
import ro.ugal.hotel_management.model.Camera;
import ro.ugal.hotel_management.repository.CameraRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camere")
public class CameraController {

    private final CameraRepository cameraRepository;

    public CameraController(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    @GetMapping
    public List<Camera> getAllCamere() {
        return cameraRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Camera> getCameraById(@PathVariable Long id) {
        return cameraRepository.findById(id);
    }

    @PostMapping
    public Camera adaugaCamera(@RequestBody Camera camera) {
        return cameraRepository.save(camera);
    }

    @PutMapping("/{id}")
    public Camera modificaCamera(@PathVariable Long id,
                                 @RequestBody Camera cameraNoua) {
        Camera camera = cameraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Camera nu exista"));

        camera.setNumarCamera(cameraNoua.getNumarCamera());
        camera.setTip(cameraNoua.getTip());
        camera.setPretNoapte(cameraNoua.getPretNoapte());
        camera.setStatus(cameraNoua.getStatus());

        return cameraRepository.save(camera);
    }

    @DeleteMapping("/{id}")
    public void stergeCamera(@PathVariable Long id) {
        cameraRepository.deleteById(id);
    }
}
