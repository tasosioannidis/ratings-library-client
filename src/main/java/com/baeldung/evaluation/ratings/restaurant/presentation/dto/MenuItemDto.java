package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import java.util.Objects;

import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;

/**
 *
 * @author rozagerardo
 */
public class MenuItemDto {

    private Long id;
    private String code;
    private String name;
    private Double price;

    public MenuItemDto() {
    }

    public MenuItemDto(Long id, String code, String name, Double price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public static class Mapper {
        public static MenuItem toModel(MenuItemDto dto) {
            MenuItem model = new MenuItem(dto.code, dto.name, dto.price);
            if (Objects.nonNull(dto.id)) {
                model.setId(dto.id);
            }
            return model;
        }

        public static MenuItemDto toDto(MenuItem model) {
            if (model == null)
                return null;
            return new MenuItemDto(model.getId(), model.getCode(), model.getName(), model.getPrice());
        }
    }
}