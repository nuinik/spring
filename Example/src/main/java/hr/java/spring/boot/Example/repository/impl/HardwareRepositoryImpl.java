package hr.java.spring.boot.Example.repository.impl;

import hr.java.spring.boot.Example.domain.HardwareType;
import hr.java.spring.boot.Example.domain.Hardware;
import hr.java.spring.boot.Example.repository.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private final List<Hardware> hardwareList = new ArrayList<>();

    public HardwareRepositoryImpl() {

        hardwareList.add(
                new Hardware(
                        "CPU001",
                        "Ryzen 7 7800X3D",
                        new BigDecimal("449.99"),
                        HardwareType.CPU,
                        10));

        hardwareList.add(
                new Hardware(
                        "GPU001",
                        "RTX 4070",
                        new BigDecimal("699.99"),
                        HardwareType.GPU,
                        5));

        hardwareList.add(
                new Hardware(
                        "RAM001",
                        "Kingston Fury 32GB",
                        new BigDecimal("129.99"),
                        HardwareType.RAM,
                        15));
    }

    @Override
    public List<Hardware> findAll() {
        return hardwareList;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return hardwareList.stream()
                .filter(h -> h.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    @Override
    public Hardware save(Hardware hardware) {
        hardwareList.add(hardware);
        return hardware;
    }

    @Override
    public Hardware update(String code, Hardware updated) {
        Hardware existing = findByCode(code)
                .orElseThrow(() -> new RuntimeException("Hardware not found"));

        hardwareList.remove(existing);
        hardwareList.add(updated);
        return updated;
    }

    @Override
    public void delete(String code) {
        Hardware existing = findByCode(code)
                .orElseThrow(() -> new RuntimeException("Hardware not found"));

        hardwareList.remove(existing);
    }
}