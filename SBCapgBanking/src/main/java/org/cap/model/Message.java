package org.cap.model;

public class Message {

	private String message;
	private boolean success;

	public Message() {
		super();
	}

	public Message(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", success=" + success + "]";
	}
	
}
