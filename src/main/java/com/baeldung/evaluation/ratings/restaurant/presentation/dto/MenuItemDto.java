package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewableDto;
import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;

public class MenuItemDto extends ReviewableDto<MenuItem> {

	private Long id;
	private String code;
	private String name;
	private Double price;

	public MenuItemDto(MenuItem menuItem) {
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
}