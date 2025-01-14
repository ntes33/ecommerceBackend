 package it.ntesConsulting.wearU.exception;

public class NotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//costructor
  public NotFoundException (String message) {
	  super(message);
  }
  
}
