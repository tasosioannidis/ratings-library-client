package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import java.util.Objects;

import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewableDto;
import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;

public class MenuItemDto extends ReviewableDto<MenuItem> {

	private Long id;
	private String code;
	private String name;
	private Double price;

	public MenuItemDto() {
		super(null);
	}

	private MenuItemDto(MenuItem menuItem) {
		super(menuItem);
		this.id = menuItem.getId();
		this.code = menuItem.getCode();
		this.name = menuItem.getName();
		this.price = menuItem.getPrice();
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
			return new MenuItemDto(model);
		}
	}
}