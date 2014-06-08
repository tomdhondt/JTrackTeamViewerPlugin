package be.jtrackteamviewerplugin.business.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.NameQueryParam;
import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.business.bean.TeamViewer;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;

public class TeamViewerDAOImpl extends AbstractDAOImpl<TeamViewer> {
	/*
	 * instance members
	 */
	private static Logger logger = Logger.getLogger(TeamViewerDAOImpl.class);
	private PartnerDAOImpl partnerDAOImpl;
	private TeamViewerModeDAOImpl teamViewerModeDAOImpl;
	private TeamViewerQualityDAOImpl teamViewerQualityDAOImpl;
	/** 
	 * Default constructor for the Class
	 */
	public TeamViewerDAOImpl(SessionFactory sessionFactory){
		super.setType(TeamViewer.class);
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * @return the partnerDAOImpl
	 */
	public PartnerDAOImpl getPartnerDAOImpl() {
		return partnerDAOImpl;
	}

	/**
	 * @return the teamViewerModeDAOImpl
	 */
	public TeamViewerModeDAOImpl getTeamViewerModeDAOImpl() {
		return teamViewerModeDAOImpl;
	}

	/**
	 * @return the teamViewerQualityDAOImpl
	 */
	public TeamViewerQualityDAOImpl getTeamViewerQualityDAOImpl() {
		return teamViewerQualityDAOImpl;
	}

	/**
	 * @param partnerDAOImpl the partnerDAOImpl to set
	 */
	public void setPartnerDAOImpl(PartnerDAOImpl partnerDAOImpl) {
		this.partnerDAOImpl = partnerDAOImpl;
	}

	/**
	 * @param teamViewerModeDAOImpl the teamViewerModeDAOImpl to set
	 */
	public void setTeamViewerModeDAOImpl(TeamViewerModeDAOImpl teamViewerModeDAOImpl) {
		this.teamViewerModeDAOImpl = teamViewerModeDAOImpl;
	}

	/**
	 * @param teamViewerQualityDAOImpl the teamViewerQualityDAOImpl to set
	 */
	public void setTeamViewerQualityDAOImpl(TeamViewerQualityDAOImpl teamViewerQualityDAOImpl) {
		this.teamViewerQualityDAOImpl = teamViewerQualityDAOImpl;
	}
	/**
	 * Method will persist the object in the database
	 * @param object as TeamViewer
	 * @return TeamViewer as object 
	 */
	public TeamViewer persist(TeamViewer object){
		TeamViewer teamViewer = null;
		/* Save the partner in the database */
		if(null != object){
			/* check weather the person is already in the database */
			if(null != object.getPartner()){
				/* check partner is already in the database */
				Partner partner = (Partner) super.findByID(object.getPartner().getId(),Partner.class);
				if(null == partner){
					/* save the Partner in the database */
					this.getPartnerDAOImpl().persist(object.getPartner());
				}else{
					/* update the Partner */
					this.partnerDAOImpl.update(object.getPartner());
				}
			}
			/* Save the TeamViewerMode in the database */ 
			if(null != object.getTeamViewerMode()){
				/* check if the TeamViewerMode is already in the database */
				TeamViewerMode teamViewerMode = (TeamViewerMode) super.findByID(object.getTeamViewerMode().getId(), TeamViewerMode.class);
				/* save the TeamViewerMode in the database */
				if(null == teamViewerMode){
					this.getTeamViewerModeDAOImpl().persist(object.getTeamViewerMode());
				}else{
					/* update the TeamViewerMode in the database */	
					logger.debug("TeamViewerMode " + object.getTeamViewerMode().toString() + " will be updated in the database!");
					this.getTeamViewerModeDAOImpl().update(object.getTeamViewerMode());
				}	
			}
			/* Save the TeamViewerQuality in the database */ 
			if(null != object.getTeamViewerQuality()){
				/* check if the TeamViewerQuality is already in the database */
				TeamViewerQuality teamViewerQuality = (TeamViewerQuality) super.findByID(object.getTeamViewerQuality().getId(), TeamViewerQuality.class);
				/* save the TeamViewerQuality in the database */
				if(null == teamViewerQuality){
					this.getTeamViewerQualityDAOImpl().persist(object.getTeamViewerQuality());
				}else{
					/* update the TeamViewerQuality in the database */	
					logger.debug("TeamViewerQuality " + object.getTeamViewerMode().toString() + " will be updated in the database!");
					this.getTeamViewerQualityDAOImpl().update(object.getTeamViewerQuality());
				}	
			}
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().persist(object);
				super.getTransaction().commit();
			}catch(Exception eXp){
				logger.error("Could not persist the object " + TeamViewer.class.getName() + " in the database!");
				logger.error(eXp.getMessage());
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Could not rollback the attempt to persist the "+ TeamViewer.class.getName() + " object in the database");
				}
			}
			List<TeamViewer> list2 = this.findByCriteria(object);
			TeamViewer tvNew = null;
			for(TeamViewer tv : list2){
				if(tv.equals(object)){
					tvNew = tv;
				}
			}
			
			/* Save the TeamViewerConnection in the database */ 
			if(null != object.getTeamViewerConnectionList()){
				ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
				TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl) context.getBean("teamViewerConnectionDAOImpl");
				/* check if the TeamViewerQuality is already in the database */
				for(TeamViewerConnection tvc : object.getTeamViewerConnectionList()){
					TeamViewerConnection teamViewerConnection = (TeamViewerConnection) super.findByID(tvc.getId(), TeamViewerConnection.class);
					if(null == teamViewerConnection){
						tvc.setTeamViewer(tvNew);
						teamViewerConnectionDAOImpl.persist(tvc);
					}else{
						/* update the TeamViewerQuality in the database */	
						logger.debug("TeamViewerConnection " + tvc.toString() + " will be updated in the database!");
						teamViewerConnectionDAOImpl.update(tvc);
					}	
				}
			}
			/* check weather the object is in the database to return to the fronted */
			List<TeamViewer> list = this.findByCriteria(object);
			/* check weather the object is persisted correct in the database */
			if(null != list){
				if(-1 < list.size()){
					for(TeamViewer team : list){
						if(object.equals(team)){
							teamViewer = team;	
						}
					}
				}
			}
		}else{
			logger.error("Could not persist the object " + TeamViewer.class.getName() + " in the database because the object passed as a parameter equals null!");
		}
		return teamViewer;
	}
	/**
	 * Method will try to find a TeamViewer based on criteria
	 * @param object as TeamViewer
	 * @return List<TeamViewer> teamViewer objects
	 */
	@SuppressWarnings("unchecked")
	public List<TeamViewer> findByCriteria(TeamViewer object){
		/* create a TeamViewerList as result */
		List<TeamViewer> listTeamViewer = null;
		if(null != object){
			super.getTransaction().begin();
			Criteria criteria = super.getSessionFactory().getCurrentSession().createCriteria(TeamViewer.class);
			/* check weather the object has a uniqueID */
			if(null != object.getUniqueID()){
				criteria.add(Restrictions.or(
						Restrictions.like("address","%" + object.getAddress() + "%"),
						Restrictions.like("uniqueID","%" + object.getUniqueID() + "%")));
			}else{
				criteria.add(Restrictions.like("address","%" + object.getAddress() + "%"));
			}
			/* create the list */
			listTeamViewer = criteria.list();
			super.getTransaction().commit();
		}
		return listTeamViewer;
	}

	@Override
	public TeamViewer update(TeamViewer object) {
		TeamViewer teamViewer = null;
		/* Check the object isn't null */
		if(null != object){
			/* set the values of the object to update*/
			TeamViewer teamViewerFound = super.findByID(object.getId());
			teamViewerFound.setAddress(object.getAddress());
			teamViewerFound.setTeamViewerMode(object.getTeamViewerMode());
			teamViewerFound.setPartner(object.getPartner());
			teamViewerFound.setPassword(object.getPassword());
			teamViewerFound.setUniqueID(object.getUniqueID());
			/* update the object in the database */
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().update(object);
				super.getTransaction().commit();
				logger.info("TeamViewer successfull updated in the database!");
				/* search the partner in the database to return */
				TeamViewer teamViewerdb = super.findByID(object.getId());
				if(object.equals(teamViewerdb)){
					teamViewer = teamViewerdb;
				}
			}catch(Exception eXp){
				logger.error("TeamViewer could not be updated in the database!");
				logger.error(eXp.getMessage());
				/* try rollback */
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Rollback of the TeamViewer update in the database wasn't successfull");
					logger.error(hEx.getMessage());
				}
			}
		}
		return teamViewer;
	}
	@Override
	public List<TeamViewer> findByNamedQuery(List<NameQueryParam> list, String namedQuery){
		return null;
	}
}
