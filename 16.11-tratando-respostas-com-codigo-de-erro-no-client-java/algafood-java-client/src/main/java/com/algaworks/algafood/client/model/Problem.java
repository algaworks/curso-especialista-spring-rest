package com.algaworks.algafood.client.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class Problem {

	private Integer status;
	private OffsetDateTime timestamp;
	private String userMessage;
	
}
