/**
 * 
 */
package edu.homework08.exceptions.custom;

public class InvalidStudentDataException extends Exception {

	private static final long serialVersionUID = 1126333868701157188L;
	
	private static final String ERROR_MESSAGE = "Invalid student data";

	private void printError(String error) {
		System.out.println(error);
	}

	public InvalidStudentDataException() {
		super();
		printError(ERROR_MESSAGE);
		this.printStackTrace();
	}

	/**
	 * @param message
	 */
	public InvalidStudentDataException(String message) {
		super(message);
		printError(ERROR_MESSAGE + message);
		this.printStackTrace();
	}

	/**
	 * @param cause
	 */
	public InvalidStudentDataException(Throwable cause) {
		super(cause);
		printError(ERROR_MESSAGE);
		this.printStackTrace();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidStudentDataException(String message, Throwable cause) {
		super(message, cause);
		printError(ERROR_MESSAGE + message);
		this.printStackTrace();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidStudentDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		printError(ERROR_MESSAGE + message);
		this.printStackTrace();
	}

}
