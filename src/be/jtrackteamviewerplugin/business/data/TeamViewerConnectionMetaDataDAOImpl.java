package be.jtrackteamviewerplugin.business.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.NameQueryParam;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;


public class TeamViewerConnectionMetaDataDAOImpl extends AbstractDAOImpl<TeamViewerConnectionMetaData> {
	/*
	 * instance members
	 */
	private static Logger logger = Logger.getLogger(TeamViewerConnectionMetaDataDAOImpl.class);
	private CustomFieldDAOImpl customFieldDAOImpl;
	private TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl;
	/**
	 * Default Constructor CustomFieldDAOImpl
	 */
	public TeamViewerConnectionMetaDataDAOImpl(SessionFactory sessionFactory){
		super.setType(TeamViewerConnectionMetaData.class);
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * @return the customFieldDAOImpl
	 */
	public CustomFieldDAOImpl getCustomFieldDAOImpl() {
		return customFieldDAOImpl;
	}

	/**
	 * @param customFieldDAOImpl the customFieldDAOImpl to set
	 */
	public void setCustomFieldDAOImpl(CustomFieldDAOImpl customFieldDAOImpl) {
		this.customFieldDAOImpl = customFieldDAOImpl;
	}
	/**
	 * @return the teamViewerConnectionDAOImpl
	 */
	public TeamViewerConnectionDAOImpl getTeamViewerConnectionDAOImpl() {
		return teamViewerConnectionDAOImpl;
	}
	/**
	 * @param teamViewerConnectionDAOImpl the teamViewerConnectionDAOImpl to set
	 */
	public void setTeamViewerConnectionDAOImpl(
			TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl) {
		this.teamViewerConnectionDAOImpl = teamViewerConnectionDAOImpl;
	}
	/**
	 * Method will persist the object to the database
	 * @param object as TeamViewerConnectionMetaData
	 * @return object as TeamViewerConnectionMetaData
	 */
	@Override
	public TeamViewerConnectionMetaData persist(TeamViewerConnectionMetaData object) {
		TeamViewerConnectionMetaData teamViewerConnectionMetaData = null;
		/* check object in the database */
		if(null !=this.findByID(object.getId())){
			/* update the object in the database */
			teamViewerConnectionMetaData = this.update(object);
		}else{
			/* Save the partner in the database */
			if(null != object){
				/* Save the TeamViewerMode in the database */
				if(null != object.getCustomField()){
					this.getCustomFieldDAOImpl().persist(object.getCustomField());
				}
				try{
					/* Persist the object to the database */
					super.getTransaction().begin();
					super.getSession().persist(object);
					super.getTransaction().commit();
				}catch(Exception eXp){
					logger.error("Could not persist the object " + TeamViewerConnectionMetaData.class.getName() + " in the database!");
					logger.error(eXp.getMessage());
					try{
						super.getTransaction().rollback();
					}catch(HibernateException hEx){
						logger.error("Could not rollback the attempt to persist the "+ TeamViewerConnectionMetaData.class.getName() + " object in the database");
					}
				}
				/* check weather the object is in the database to return to the fronted */
				List<TeamViewerConnectionMetaData> list = this.findAll();
				/* check weather the object is persisted correct in the database */
				if(null != list){
					if(-1 < list.size()){
						for(TeamViewerConnectionMetaData tvcmd : list){
							if(object.equals(tvcmd)){
								teamViewerConnectionMetaData = tvcmd;	
							}
						}
					}
				}
			}
		}
		return teamViewerConnectionMetaData;
	}
	/**
	 * Method will find a TeamViewerConnectionMetaData base on the object given a as object in the parameter
	 * @param object as TeamViewerConnectionMetaData
	 * @return object as TeamViewerConnectionMetaData
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamViewerConnectionMetaData> findByCriteria(TeamViewerConnectionMetaData object) {
		/* create a TeamViewerList as result */
		List<TeamViewerConnectionMetaData> listTeamViewerConnectionMetaData = null;
		if(null != object){
			super.getTransaction().begin();
			Criteria criteria = super.getSessionFactory().getCurrentSession().createCriteria(TeamViewerConnectionMetaData.class);
			criteria.add(Restrictions.or(
				Restrictions.like("uniqueID","%" + object.getUniqueID() + "%"),
				Restrictions.like("value","%" + object.getValue() + "%"),
				Restrictions.eq("teamViewerConnection", object.getTeamViewerConnection())));
			/* create the list */
			listTeamViewerConnectionMetaData = criteria.list();
			super.getTransaction().commit();
		}
		return listTeamViewerConnectionMetaData;
	}
	/**
	 * Method will update the object TeamViewerConnectionMetaData
	 * @param object as TeamViewerConnectionMetaData
	 * @return object as TeamViewerConnectionMetaData
	 */
	@Override
	public TeamViewerConnectionMetaData update(TeamViewerConnectionMetaData object) {
		TeamViewerConnectionMetaData teamViewerConnectionMetaData = null;
		/* Check the object isn't null */
		if(null != object){
			/* set the values of the object to update*/
			TeamViewerConnectionMetaData teamViewerConnectionMetaDataFound = super.findByID(object.getId());
			teamViewerConnectionMetaDataFound.setValue(object.getValue());
			teamViewerConnectionMetaDataFound.setCustomField(object.getCustomField());
			teamViewerConnectionMetaDataFound.setTeamViewerConnection(object.getTeamViewerConnection());
			/* persist the CustomField object */
			if(null != object.getCustomField()){
				CustomField cF = this.customFieldDAOImpl.persist(object.getCustomField());
				object.setCustomField(cF);
			}
			/* update the object in the database */
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().update(object);
				super.getTransaction().commit();
				logger.info("TeamViewerConnectionMetaData successfull updated in the database!");
				/* search the partner in the database to return */
				TeamViewerConnectionMetaData teamViewerConnectionMetaDatadb = super.findByID(object.getId());
				if(object.equals(teamViewerConnectionMetaDatadb)){
					teamViewerConnectionMetaData = teamViewerConnectionMetaDatadb;
				}
			}catch(Exception eXp){
				logger.error("TeamViewerConnectionMetaData could not be updated in the database!");
				logger.error(eXp.getMessage());
				/* try rollback */
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Rollback of the TeamViewerConnectionMetaData update in the database wasn't successfull");
					logger.error(hEx.getMessage());
				}
			}
		}
		return teamViewerConnectionMetaData;
	}
	@Override
	public List<TeamViewerConnectionMetaData> findByNamedQuery(List<NameQueryParam> list, String namedQuery){
		return null;
	}
}
