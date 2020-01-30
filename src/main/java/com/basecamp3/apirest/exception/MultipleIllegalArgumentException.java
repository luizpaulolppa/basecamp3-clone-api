package com.basecamp3.apirest.exception;

import java.io.Serializable;

import com.basecamp3.apirest.dto.MsgError;

public class MultipleIllegalArgumentException extends IllegalArgumentException implements Serializable {

	private static final long serialVersionUID = -5153278150411282387L;

	private MsgError msgError;

	public MultipleIllegalArgumentException(MsgError msgError) {
		super();
		this.msgError = msgError;
	}

	public MsgError getError() {
		return msgError;
	}
}