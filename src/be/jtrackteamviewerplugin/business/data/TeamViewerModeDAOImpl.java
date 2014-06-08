package be.jtrackteamviewerplugin.business.data;

import org.hibernate.SessionFactory;

import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
/**
 * Class TeamViewerDAOImpl is responsible to create a implementation to manage the TeamViewer to the database
 * @author Tom Dhondt
 */
public class TeamViewerModeDAOImpl extends AbstractDAOImpl<TeamViewerMode> implements IPersistenceDAOImpl<TeamViewerMode>{
	/**
	 * Default constructor for the class
	 */
	public TeamViewerModeDAOImpl(){
		super.type = TeamViewerMode.class;
	}
	/**
	 * Default constructor for the class
	 */
	public TeamViewerModeDAOImpl(SessionFactory sessionFactory){
		super.sessionFactory = sessionFactory;
		super.type = TeamViewerMode.class;
	}
}
