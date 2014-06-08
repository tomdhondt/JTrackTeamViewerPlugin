package be.jtrackteamviewerplugin.business.data;

import org.hibernate.SessionFactory;

import be.jtrackteamviewerplugin.business.bean.TeamViewer;
/**
 * Class TeamViewerDAOImpl is responsible to create a implementation to manage the TeamViewer to the database
 * @author Tom Dhondt
 */
public class TeamViewerDAOImpl extends AbstractDAOImpl<TeamViewer> implements IPersistenceDAOImpl<TeamViewer>{
	/**
	 * Default constructor for the class
	 */
	public TeamViewerDAOImpl(){
		super.type = TeamViewer.class;
	}
	/**
	 * Default constructor for the class
	 */
	public TeamViewerDAOImpl(SessionFactory sessionFactory){
		super.sessionFactory = sessionFactory;
		super.type = TeamViewer.class;
	}
}
