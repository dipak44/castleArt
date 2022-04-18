package com.castleArt.exception;

public class UserNotFoundException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
//	public UserNotFoundException (String message) {
//		super(message);
//	}


String resourceName;
String fieldName;
long fieldvalue;
public UserNotFoundException(String resourceName, String fieldName, long fieldvalue) {
	super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldvalue));
	this.resourceName = resourceName; 
	this.fieldName = fieldName;
	this.fieldvalue = fieldvalue;
}



}
