package com.baeldung.evaluation.ratings.restaurant.presentation.controller;

import java.util.List;

import com.baeldung.evaluation.ratings.restaurant.presentation.dto.ServerDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.baeldung.evaluation.ratings.lib.domain.Review;
import com.baeldung.evaluation.ratings.restaurant.application.MenuItemService;
import com.baeldung.evaluation.ratings.restaurant.domain.MenuItem;
import com.baeldung.evaluation.ratings.restaurant.presentation.dto.MenuItemDto;

/**
 *
 * @author rozagerardo
 */
@RestController
@RequestMapping(value = "/menu-items")
public class MenuItemController {

    private MenuItemService service;

    public MenuItemController(MenuItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<MenuItemDto> getList() {
        return service.fetchAll()
            .stream()
            .map(MenuItemDto.Mapper::toDto)
            .toList();
    }

    @GetMapping("/{id}")
    public MenuItemDto getById(@PathVariable Long id, @RequestParam(required = false) String reviewsOrder, @RequestParam(required = false)  String ratingView) {
        return service.fetchMenuItem(id)
                .map(menuItem -> MenuItemDto.Mapper.toConfigurableDto(menuItem, reviewsOrder, ratingView))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public MenuItemDto create(@RequestBody MenuItemDto newServer) {
        MenuItem model = MenuItemDto.Mapper.toModel(newServer);
        MenuItem createdModel = this.service.createServer(model);
        return MenuItemDto.Mapper.toDto(createdModel);
    }

    @PostMapping("/{id}/reviews")
    public MenuItemDto addReview(@PathVariable Long id, @RequestBody Review review) {
        return service.addReview(id, review)
            .map(MenuItemDto.Mapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
