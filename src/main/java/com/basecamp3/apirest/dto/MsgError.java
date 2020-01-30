package com.basecamp3.apirest.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MsgError {

	private List<Error> errors;

	public MsgError() {
		this.errors = Arrays.asList();
	}

	public MsgError(String... msgs) {
		this.errors = Arrays.asList(msgs)
				.stream()
				.map((msg) -> new Error(msg))
				.collect(Collectors.toList());
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public MsgError addError(String... msgs) {
		errors
		.addAll(Arrays.asList(msgs)
				.stream()
				.map((msg) -> new Error(msg))
				.collect(Collectors.toList())
				);
		return this;
	}

}
