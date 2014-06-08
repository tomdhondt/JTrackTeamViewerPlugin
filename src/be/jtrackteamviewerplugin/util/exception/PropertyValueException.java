package be.jtrackteamviewerplugin.util.exception;

public class PropertyValueException extends Exception {
	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 4782281399153096522L;
	/**
	 * Dafault constructor for the Class
	 */
	public PropertyValueException() {
		super();
	}
	/**
	 * Method will set the message of the PropertyValueException
	 * @param message as String
	 */
	public PropertyValueException(String message) {
		super(message);
	}
	/**
	 * Method will set the message an the cause
	 * @param message as String
	 * @param cause as Throwable
	 */
	public PropertyValueException(String message, Throwable cause) {
		super(message, cause);
	}
	/**
	 * Method will set the message an the cause
	 * @param cause as Throwable
	 */
	public PropertyValueException(Throwable cause) { 
		super(cause); 
	}

}
