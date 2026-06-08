package hr.java.spring.boot.Example.service.impl;

import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.domain.HardwareType;
import hr.java.spring.boot.Example.dto.HardwareDTO;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import hr.java.spring.boot.Example.service.HardwareService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HardwareServiceImpl implements HardwareService {

    private final HardwareRepository hardwareRepository;

    public HardwareServiceImpl(HardwareRepository hardwareRepository) {
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {

        return hardwareRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public Optional<HardwareDTO> findByCode(String code) {

        return hardwareRepository.findByCode(code)
                .map(this::mapToDTO);
    }

    @Override
    public HardwareDTO create(HardwareDTO dto) {
        Hardware hardware = new Hardware(
                dto.getCode(),
                dto.getName(),
                dto.getPrice(),
                HardwareType.OTHER,
                0
        );

        return mapToDTO(hardwareRepository.save(hardware));
    }

    @Override
    public HardwareDTO update(String code, HardwareDTO dto) {
        Hardware updated = new Hardware(
                code,
                dto.getName(),
                dto.getPrice(),
                HardwareType.OTHER,
                0
        );

        return mapToDTO(hardwareRepository.update(code, updated));
    }

    @Override
    public void delete(String code) {
        hardwareRepository.delete(code);
    }

    private HardwareDTO mapToDTO(Hardware hardware) {
        return new HardwareDTO(
                hardware.getCode(),
                hardware.getName(),
                hardware.getPrice()
        );
    }
}