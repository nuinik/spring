package hr.java.spring.boot.Example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class HardwareDTO {

    @NotBlank(message = "Code must not be empty")
    private String code;

    @NotBlank(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    public HardwareDTO(String code, String name, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
}