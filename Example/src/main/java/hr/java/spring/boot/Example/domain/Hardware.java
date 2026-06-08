package hr.java.spring.boot.Example.domain;

import java.math.BigDecimal;

public class Hardware {

    private String code;
    private String name;
    private BigDecimal price;
    private HardwareType type;
    private Integer stock;

    public Hardware(String code, String name, BigDecimal price,
                    HardwareType type, Integer stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public HardwareType getType() {
        return type;
    }

    public Integer getStock() {
        return stock;
    }
}