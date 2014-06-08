package be.jtrackteamviewerplugin.service.state;
/**
 * Class StateBooked will set the state of the Object from Checked to Inserted
 * @author tom.dhondt - created at : 18-dec.-2013
 */
public class StateBooked implements StateStatus {
	/**
	 * Method will set the state of the object as Inserted
	 * @param contect as StateContext
	 */
	@Override
	public void setStateStatus(StateContext context) {
		context.setStateStatus(new StateInserted());
	}
}
