package be.jtrackteamviewerplugin.service.state;
/**
 * Class StateChecked will set the state of the Object from Inserted to Checked
 * @author tom.dhondt - created at : 18-dec.-2013
 *
 */
public class StateInserted implements StateStatus {
	/**
	 * Method will set the state of the object as Checked
	 * @param contect as StateContext
	 */
	@Override
	public void setStateStatus(StateContext context) {
		context.setStateStatus(new StateChecked());
	}

}
