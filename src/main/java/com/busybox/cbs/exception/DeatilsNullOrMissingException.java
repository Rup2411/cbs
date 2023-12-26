package com.busybox.cbs.exception;

public class DeatilsNullOrMissingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DeatilsNullOrMissingException(String message) {
        super(message);
    }
}