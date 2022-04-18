package com.castleArt.exception;

@SuppressWarnings("serial")
public class NotRegistredException extends RuntimeException {
	public NotRegistredException(String mesg) {
		super(mesg);
	}

}
