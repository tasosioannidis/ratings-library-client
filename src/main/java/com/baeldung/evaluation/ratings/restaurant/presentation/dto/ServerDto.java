package com.baeldung.evaluation.ratings.restaurant.presentation.dto;

import com.baeldung.evaluation.ratings.lib.presentation.dto.ReviewableDto;
import com.baeldung.evaluation.ratings.restaurant.domain.Server;

public class ServerDto extends ReviewableDto<Server> {

	private final Long id;
	private final String firstName;
	private final String lastName;

	public ServerDto(Server server) {
		super(server);
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
}
