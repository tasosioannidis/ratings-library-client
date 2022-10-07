package com.baeldung.evaluation.ratings.restaurant.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rozagerardo
 */
@Entity
public class MenuItem {

    @Id
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    @NotNull
    private String code;

    @NotNull
    private String name;

    @NotNull
    @Min(0)
    private Double price;

    MenuItem() {
    }

    public MenuItem(String code, String name, Double price) {
        super();
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MenuItem other = (MenuItem) obj;
        return Objects.equals(code, other.code);
    }
}
