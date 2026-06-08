package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

    Hardware save(Hardware hardware);

    Hardware update(String code, Hardware hardware);

    void delete(String code);
}