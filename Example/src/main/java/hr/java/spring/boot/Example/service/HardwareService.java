package hr.java.spring.boot.Example.service;



import hr.java.spring.boot.Example.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> findAll();

    Optional<HardwareDTO> findByCode(String code);

    HardwareDTO create(HardwareDTO dto);

    HardwareDTO update(String code, HardwareDTO dto);

    void delete(String code);
}