package hr.java.spring.boot.Example.controller;

import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.service.HardwareService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hardware")
public class HardwareController {

    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllHardware() {
        return hardwareService.findAll();
    }

    @GetMapping("/{code}")
    public HardwareDTO getHardwareByCode(@PathVariable String code) {

        return hardwareService.findByCode(code)
                .orElseThrow(() ->
                        new RuntimeException("Hardware not found"));
    }

    @PostMapping
    public HardwareDTO create(@Valid @RequestBody HardwareDTO dto) {
        return hardwareService.create(dto);
    }

    @PutMapping("/{code}")
    public HardwareDTO update(@PathVariable String code,
                              @Valid @RequestBody HardwareDTO dto) {
        return hardwareService.update(code, dto);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code) {
        hardwareService.delete(code);
    }
}