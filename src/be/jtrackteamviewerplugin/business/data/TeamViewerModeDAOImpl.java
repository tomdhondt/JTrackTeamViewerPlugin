/**
 * 
 */
package be.jtrackteamviewerplugin.business.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import be.jtrackteamviewerplugin.business.bean.NameQueryParam;
import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;

/**
 * Class TeamViewerModeDAOImpl
 * @author tom.dhondt - created at : 2-dec.-2013
 *
 */
public class TeamViewerModeDAOImpl extends AbstractDAOImpl<TeamViewerMode> {
	/* Instance members */
	private static Logger logger = Logger.getLogger(TeamViewerDAOImpl.class);
	/**
	 * Default constructor for the Class
	 */
	public TeamViewerModeDAOImpl(SessionFactory sessionFactory){
		super.setType(TeamViewerMode.class);
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * Method will persist the TeamViewerMode to the database
	 * @param object as TeamViewerMode
	 * @return object as persisted TeamViewerMode
	 */
	@Override
	public TeamViewerMode persist(TeamViewerMode object) {
		TeamViewerMode teamViewerMode = null;
		if(null != object){
			/* check the content of the UniqueID can't be null*/
			if(null != object.getUniqueID()){
				try{
					/* Persist the object to the database */
					super.getTransaction().begin();
					super.getSession().persist(object);
					super.getTransaction().commit();
				}catch(Exception eXp){
					logger.error("Could not persist the object " + TeamViewerMode.class.getName() + " in the database!");
					logger.error(eXp.getMessage());
					try{
						super.getTransaction().rollback();
					}catch(HibernateException hEx){
						logger.error("Could not rollback the attempt to persist the "+ TeamViewerMode.class.getName() + " object in the database");
					}
				}
				/* check weather the object is in the database to return to the fronted */
				List<TeamViewerMode> list = this.findByCriteria(object);
				/* check weather the object is persisted correct in the database */
				if(null != list){
					if(-1 < list.size()){
						for(TeamViewerMode prtn : list){
							if(object.equals(prtn)){
								teamViewerMode = prtn;
							}
						}
					}
				}
			}else{
				logger.error("Could not persist the object " + TeamViewerMode.class.getName() + " UniqueID can't be null!");
			}
		}else{
			logger.error("Could not persist the object " + TeamViewerMode.class.getName() + " in the database because the object passed as a parameter equals null!");
		}
		return teamViewerMode;
	}
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Method will find a TeamViewerMode object by criteria found in the object give as parameter
	 * @param object as TeamViewerMode
	 * @return list of TeamViewerMode as List<TeamViewerMode>
	 */
	public List<TeamViewerMode> findByCriteria(TeamViewerMode object) {
		/* create a TeamViewerList as result */
		List<TeamViewerMode> listTeamViewer = null;
		if(null != object){
			super.getTransaction().begin();
			Criteria criteria = super.getSessionFactory().getCurrentSession().createCriteria(TeamViewerMode.class);
			/* check weather the object has a uniqueID */
			if(null != object.getUniqueID()){
				criteria.add(Restrictions.or(				
					Restrictions.like("name","%" + object.getName()  + "%"),
					Restrictions.like("notes","%" + object.getNotes() + "%"),
					Restrictions.like("samName","%" + object.getSamName() + "%"),
					Restrictions.like("uniqueID","%" + object.getUniqueID() + "%")));
			}else{
				criteria.add(Restrictions.like("name","%" + object.getName() + "%"));
			}
			/* create the list */
			listTeamViewer = criteria.list();
			super.getTransaction().commit();
		}
		return listTeamViewer;
	}
	/**
	 * Method will update the TeamViewerMode object in the database
	 * @param object as TeamViewerMode
	 * @return object as updated TeamViewerMode
	 */
	@Override
	public TeamViewerMode update(TeamViewerMode object) {
		TeamViewerMode teamViewerMode = null;
		/* Check the object isn't null */
		if(null != object){
			/* set the values of the object to update*/
			TeamViewerMode teamViewerModeFound = super.findByID(object.getId());
			teamViewerModeFound.setName(object.getName());
			teamViewerModeFound.setNotes(object.getNotes());
			teamViewerModeFound.setSamName(object.getSamName());
			teamViewerModeFound.setUniqueID(object.getUniqueID());
			/* update the object in the database */
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().update(object);
				super.getTransaction().commit();
				logger.info("TeamViewerMode successfull updated in the database!");
				/* search the partner in the database to return */
				TeamViewerMode teamViewerModedb = super.findByID(object.getId());
				if(object.equals(teamViewerModedb)){
					teamViewerMode = teamViewerModedb;
				}
			}catch(Exception eXp){
				logger.error("TeamViewerMode could not be updated in the database!");
				logger.error(eXp.getMessage());
				/* try rollback */
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Rollback of the TeamViewerMode update in the database wasn't successfull");
					logger.error(hEx.getMessage());
				}
			}
		}
		return teamViewerMode;
	}
	@Override
	public List<TeamViewerMode> findByNamedQuery(List<NameQueryParam> list, String namedQuery){
		return null;
	}

}
