package be.jtrackteamviewerplugin.service.state;
/**
 * Class StateChecked will set the state of the Object from Checked to Booked
 * @author tom.dhondt - created at : 18-dec.-2013
 *
 */
public class StateChecked implements StateStatus  {
	/**
	 * Method will set the state of the object as booked
	 * @param contect as StateContext
	 */
	@Override
	public void setStateStatus(StateContext context) {
		context.setStateStatus(new StateBooked());
	}
}
