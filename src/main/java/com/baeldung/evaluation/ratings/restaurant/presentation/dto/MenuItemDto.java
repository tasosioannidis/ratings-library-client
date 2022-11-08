package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import java.util.Objects;

import com.baeldung.evaluation.ratings.lib.presentation.dto.RatingView;
import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewableDto;
import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewsOrder;
import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;
import com.baeldung.evaluation.ratings.restaurant.domain.Server;

/**
 *
 * @author rozagerardo
 */
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
        applyMenuItemAttributes(menuItem);
    }

    private MenuItemDto(MenuItem menuItem, ReviewsOrder reviewsOrder, RatingView ratingView) {
        super(menuItem, reviewsOrder, ratingView);
        applyMenuItemAttributes(menuItem);
    }

    private MenuItemDto(MenuItem menuItem, RatingView ratingView) {
        super(menuItem, ratingView);
        applyMenuItemAttributes(menuItem);
    }

    private MenuItemDto(MenuItem menuItem, ReviewsOrder reviewsOrder) {
        super(menuItem, reviewsOrder);
        applyMenuItemAttributes(menuItem);
    }

    private void applyMenuItemAttributes(MenuItem menuItem) {
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

        public static MenuItemDto toConfigurableDto(MenuItem model, String reviewsOrder, String ratingView) {
            if (model == null)
                return null;
            if (reviewsOrder != null && ratingView != null) {
                return new MenuItemDto(model, ReviewsOrder.valueOf(reviewsOrder), RatingView.valueOf(ratingView));
            }
            else if (reviewsOrder == null && ratingView == null) {
                return new MenuItemDto(model);
            }
            else if (reviewsOrder != null && ratingView == null) {
                return new MenuItemDto(model, ReviewsOrder.valueOf(reviewsOrder));
            }
            else  {
                return new MenuItemDto(model, RatingView.valueOf(ratingView));
            }
        }
    }
}