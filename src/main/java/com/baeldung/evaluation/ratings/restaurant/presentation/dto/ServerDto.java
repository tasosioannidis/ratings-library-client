package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import java.util.Objects;

import com.baeldung.evaluation.ratings.lib.presentation.dto.RatingView;
import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewableDto;
import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewsOrder;
import com.baeldung.evaluation.ratings.restaurant.domain.Server;

/**
 * @author rozagerardo
 */
public class ServerDto extends ReviewableDto<Server> {

    private Long id;
    private String firstName;
    private String lastName;

    private ServerDto() {
        super(null);
    }

    private ServerDto(Server server) {
        super(server);
        applyServerAttributes(server);
    }

    private ServerDto(Server server, ReviewsOrder reviewsOrder, RatingView ratingView) {
        super(server, reviewsOrder, ratingView);
        applyServerAttributes(server);
    }

    private ServerDto(Server server, RatingView ratingView) {
        super(server, ratingView);
        applyServerAttributes(server);
    }

    private ServerDto(Server server, ReviewsOrder reviewsOrder) {
        super(server, reviewsOrder);
        applyServerAttributes(server);
    }

    private void applyServerAttributes(Server server) {
        this.id = server.getId();
        this.firstName = server.getFirstName();
        this.lastName = server.getLastName();
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Mapper {
        public static Server toModel(ServerDto dto) {
            Server model = new Server(dto.firstName, dto.lastName);
            if (Objects.nonNull(dto.id)) {
                model.setId(dto.id);
            }
            return model;
        }

        public static ServerDto toDto(Server model) {
            if (model == null)
                return null;
            return new ServerDto(model);
        }

        public static ServerDto toConfigurableDto(Server model, String reviewsOrder, String ratingView) {
            if (model == null)
                return null;
            if (reviewsOrder != null && ratingView != null) {
                return new ServerDto(model, ReviewsOrder.valueOf(reviewsOrder), RatingView.valueOf(ratingView));
            }
            else if (reviewsOrder == null && ratingView == null) {
                return new ServerDto(model);
            }
            else if (reviewsOrder != null && ratingView == null) {
                return new ServerDto(model, ReviewsOrder.valueOf(reviewsOrder));
            }
            else  {
                return new ServerDto(model, RatingView.valueOf(ratingView));
            }
        }
    }
}
