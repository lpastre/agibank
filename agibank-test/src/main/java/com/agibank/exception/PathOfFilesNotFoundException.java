package com.agibank.exception;

public class PathOfFilesNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4436129385185303784L;

	public PathOfFilesNotFoundException() {
		super();
	}
	
	public PathOfFilesNotFoundException(Exception ex) {
		super(ex);
	}
	
	public PathOfFilesNotFoundException(String message) {
		super(message);
	}
	
	public PathOfFilesNotFoundException(String message, Exception ex) {
		super(message, ex);
	}
	
}
