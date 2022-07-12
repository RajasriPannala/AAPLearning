package com.bourntec.aaplearning.modules.jwtsecurity.v1.response;
/**
 * @author Jeena Thomas
 *
 */
public class MessageResponse {
	  private String message;
	 
	  /**
	   * Getters and Setters
	   * 
	   * */

	  public MessageResponse(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }
	}