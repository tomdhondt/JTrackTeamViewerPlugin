package be.jtrackteamviewerplugin.business.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.NameQueryParam;

public class CustomFieldDAOImpl extends AbstractDAOImpl<CustomField> {
	/*
	 * instance members
	 */
	private static Logger logger = Logger.getLogger(CustomFieldDAOImpl.class);
	/**
	 * Default Constructor CustomFieldDAOImpl
	 */
	public CustomFieldDAOImpl(SessionFactory sessionFactory){
		super.setType(CustomField.class);
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * Method will persist the object to the database
	 * @param object as CustomField
	 * @return object as CustomField
	 */
	@Override
	public CustomField persist(CustomField object) {
		CustomField customField = null;
		if(null != object){
			/* check if it is already in the database */
			if(this.findAll().contains(object)){
				/* update the object */
				customField = this.update(object);
			}else{
				/* persist the object */
				try{
					/* Persist the object to the database */
					super.getTransaction().begin();
					super.getSession().persist(object);
					super.getTransaction().commit();
				}catch(Exception eXp){
					logger.error("Could not persist the object " + CustomField.class.getName() + " in the database!");
					logger.error(eXp.getMessage());
					try{
						super.getTransaction().rollback();
					}catch(HibernateException hEx){
						logger.error("Could not rollback the attempt to persist the "+ CustomField.class.getName() + " object in the database");
					}
				}
				/* check weather the object is in the database to return to the fronted */
				List<CustomField> list = this.findByCriteria(object);
				/* check weather the object is persisted correct in the database */
				if(null != list){
					if(-1 < list.size()){
						for(CustomField prtn : list){
							if(object.equals(prtn)){
								customField = prtn;
							}
						}
					}
				}
			}
		}else{
			logger.error("Could not persist the object " + CustomField.class.getName() + " in the database because the object passed as a parameter equals null!");
		}
		return customField;
	}
	/**
	 * Method will search a CustomField based on criteria of the object given as a parameter
	 * @param CustomField as object
	 * @return result as List<CustomField> 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomField> findByCriteria(CustomField object) {
		/* create a TeamViewerList as result */
		List<CustomField> listCustomField = null;
		if(null != object){
			super.getTransaction().begin();
			Criteria criteria = super.getSessionFactory().getCurrentSession().createCriteria(CustomField.class);
			criteria.add(Restrictions.or(
				Restrictions.like("value",object.getValue()),
				Restrictions.eq("type", object.getType()),
				Restrictions.like("uniqueID","%" + object.getUniqueID() + "%")));
			/* create the list */
			listCustomField = criteria.list();
			super.getTransaction().commit();
		}
		return listCustomField;
	}
	/**
	 * Method will update the properties of the object in the database
	 * @return object as CustomField
	 * @param object as CustomField
	 */
	@Override
	public CustomField update(CustomField object) {
		CustomField customField = null;
		/* Check the object isn't null */
		if(null != object){
			/* set the values of the object to update*/
			CustomField customFieldFound = super.findByID(object.getId());
			customFieldFound.setPartnerID(object.getPartnerID());
			customFieldFound.setType(object.getType());
			customFieldFound.setValue(object.getValue());			
			/* update the object in the database */
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().update(object);
				super.getTransaction().commit();
				logger.info("CustomField successfull updated in the database!");
				/* search the partner in the database to return */
				CustomField customFielddb = super.findByID(object.getId());
				if(object.equals(customFielddb)){
					customField = customFielddb;
				}
			}catch(Exception eXp){
				logger.error("CustomField could not be updated in the database!");
				logger.error(eXp.getMessage());
				/* try rollback */
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Rollback of the CustomField update in the database wasn't successfull");
					logger.error(hEx.getMessage());
				}
			}
		}
		return customField;
	}
	@Override
	public List<CustomField> findByNamedQuery(List<NameQueryParam> list, String namedQuery){
		return null;
	}
	
}
