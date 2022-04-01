package com.finalproject.tcc.service.exceptions;

public class ResourceNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFound(String msg) {
		super(msg);
	}
}
