package com.admin.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundexception extends RuntimeException {

	public UserNotFoundexception(String exception) {
		super(exception);
	}
}
