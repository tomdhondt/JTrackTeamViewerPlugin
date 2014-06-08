package be.jtrackteamviewerplugin.exception;
/**
 * Class JTrackException is the global error for the project
 * @author tom.dhondt - created at : 16-feb.-2014
 *
 */
public class TeamViewerException extends Exception {
	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = -3010047753494097940L;
	/*
	 * Instance members 
	 */
	private String caption; 
	private StackTraceElement[] stackTraceElements;
	/**
	 * Default constructor for the Class
	 * @param caption
	 */
	public TeamViewerException(){
	}
	/**
	 * Constructor for the Class
	 * @param caption as String
	 * @param stackTraceElements as StackTraceElements[]
	 */
	public TeamViewerException(String caption, StackTraceElement[] stackTraceElements){
		this.caption = caption;
		this.stackTraceElements = stackTraceElements;
	}
	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * @return the stackTraceElements
	 */
	public StackTraceElement[] getStackTraceElements() {
		return stackTraceElements;
	}
	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * @param stackTraceElements the stackTraceElements to set
	 */
	public void setStackTraceElements(StackTraceElement[] stackTraceElements) {
		this.stackTraceElements = stackTraceElements;
	}
}
