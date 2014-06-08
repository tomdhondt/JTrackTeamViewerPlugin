package be.jtrackteamviewerplugin.business.data;

import org.hibernate.SessionFactory;

import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;
/**
 * Class TeamViewerQualityDAOImpl is responsible to create a implementation to manage the TeamViewerQuality to the database
 * @author Tom Dhondt
 */
public class TeamViewerQualityDAOImpl extends AbstractDAOImpl<TeamViewerQuality> implements IPersistenceDAOImpl<TeamViewerQuality>{
	/**
	 * Default constructor for the class
	 */
	public TeamViewerQualityDAOImpl(){
		super.type = TeamViewerQuality.class;
	}
	/**
	 * Default constructor for the class
	 */
	public TeamViewerQualityDAOImpl(SessionFactory sessionFactory){
		super.sessionFactory = sessionFactory;
		super.type = TeamViewerQuality.class;
	}
}
