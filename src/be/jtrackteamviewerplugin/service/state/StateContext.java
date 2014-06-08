package be.jtrackteamviewerplugin.service.state;

public class StateContext {
	/* Instance members */
	private StateStatus objectState;
	/**
	 * Default Constructor for the class
	 */
	public StateContext(){
		this.objectState = new StateInserted();
	}
	/**
	 * Method will return the state of the object
	 * @return the objectState
	 */
	public StateStatus getStateStatus() {
		return objectState;
	}
	/**
	 * Method will get the state of the object
	 * @param objectState the objectState to set
	 */
	public void setStateStatus(StateStatus objectState) {
		this.objectState = objectState;
	}
	
}
