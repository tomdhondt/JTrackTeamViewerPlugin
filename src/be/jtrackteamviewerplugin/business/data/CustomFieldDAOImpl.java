package be.jtrackteamviewerplugin.business.data;

import org.hibernate.SessionFactory;

import be.jtrackteamviewerplugin.business.bean.CustomField;
/**
 * Class CustomFieldDAOImpl is responsible to create a implementation to manage the CustomField to the database
 * @author Tom Dhondt
 */
public class CustomFieldDAOImpl extends AbstractDAOImpl<CustomField> implements IPersistenceDAOImpl<CustomField>{
	/**
	 * Default constructor for the class
	 */
	public CustomFieldDAOImpl(){
		super.type = CustomField.class;
	}
	/**
	 * Default constructor for the class
	 */
	public CustomFieldDAOImpl(SessionFactory sessionFactory){
		super.sessionFactory = sessionFactory;
		super.type = CustomField.class;
	}
}
