package be.jtrackteamviewerplugin.business.data;

import org.hibernate.SessionFactory;

import be.jtrackteamviewerplugin.business.bean.Partner;
/**
 * Class PartnerDAOImpl is responsible to create a implementation to manage the CustomField to the database
 * @author Tom Dhondt
 */
public class PartnerDAOImpl extends AbstractDAOImpl<Partner> implements IPersistenceDAOImpl<Partner>{
	/**
	 * Default constructor for the class
	 */
	public PartnerDAOImpl(){
		super.type = Partner.class;
	}
	/**
	 * Default constructor for the class
	 */
	public PartnerDAOImpl(SessionFactory sessionFactory){
		super.sessionFactory = sessionFactory;
		super.type = Partner.class;
	}
}
