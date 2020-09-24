package com.edto.cursomc.services.exceptions;

public class DataIntegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(Object id) {
		super("Bad Request. " + id);
	}
}
