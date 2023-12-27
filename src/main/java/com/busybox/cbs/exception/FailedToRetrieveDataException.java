package com.busybox.cbs.exception;

import java.io.Serializable;

public class FailedToRetrieveDataException extends CustomException implements Serializable {
	private static final long serialVersionUID = 1L;
	public FailedToRetrieveDataException(String message) {
        super(message);
    }
}

