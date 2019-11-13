package com.algaworks.algafood.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class Problem {

	private Integer status;
	private OffsetDateTime timestamp;
	private String type;
	private String title;
	private String detail;
	private String userMessage;
	private List<Object> objects;
	
	@Getter
	@Builder
	public static class Object {
		
		private String name;
		private String userMessage;
		
	}
	
}
