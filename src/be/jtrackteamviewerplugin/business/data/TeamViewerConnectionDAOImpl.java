package be.jtrackteamviewerplugin.business.data;

import org.hibernate.SessionFactory;

import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
/**
 * Class TeamViewerConnectionDAOImpl is responsible to create a implementation to manage the TeamViewerConnection to the database
 * @author Tom Dhondt
 */
public class TeamViewerConnectionDAOImpl extends AbstractDAOImpl<TeamViewerConnection> implements IPersistenceDAOImpl<TeamViewerConnection>{
	/**
	 * Default constructor for the class
	 */
	public TeamViewerConnectionDAOImpl(){
		super.type = TeamViewerConnection.class;
	}
	/**
	 * Default constructor for the class
	 */
	public TeamViewerConnectionDAOImpl(SessionFactory sessionFactory){
		super.sessionFactory = sessionFactory;
		super.type = TeamViewerConnection.class;
	}
}
