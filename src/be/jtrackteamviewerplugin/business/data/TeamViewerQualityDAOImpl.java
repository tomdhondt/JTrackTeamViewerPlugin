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
import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;


/**
 * Class TeamViewerQualityDAOImpl
 * @author tom.dhondt - created at : 2-dec.-2013
 *
 */
public class TeamViewerQualityDAOImpl extends AbstractDAOImpl<TeamViewerQuality> {
	/* Instance members */
	private static Logger logger = Logger.getLogger(TeamViewerQualityDAOImpl.class);
	/**
	 * Default constructor for the class
	 * @param sessionFactory
	 */
	public TeamViewerQualityDAOImpl(SessionFactory sessionFactory){
		super.setType(TeamViewerQuality.class);
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * Method will persist TeamViewerQuality object in the database
	 * @param object as TeamViewerQuality
	 * @return object as TeamViewerQuality
	 */
	@Override
	public TeamViewerQuality persist(TeamViewerQuality object) {
		TeamViewerQuality teamViewerQuantity = null;
		if(null != object){
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().persist(object);
				super.getTransaction().commit();
			}catch(Exception eXp){
				logger.error("Could not persist the object " + TeamViewerQuality.class.getName() + " in the database!");
				logger.error(eXp.getMessage());
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Could not rollback the attempt to persist the "+ TeamViewerQuality.class.getName() + " object in the database");
				}
			}
			/* check weather the object is in the database to return to the fronted */
			List<TeamViewerQuality> list = this.findByCriteria(object);
			/* check weather the object is persisted correct in the database */
			if(null != list){
				if(-1 < list.size()){
					for(TeamViewerQuality prtn : list){
						if(object.equals(prtn)){
							teamViewerQuantity = prtn;
						}
					}
				}
			}
		}else{
			logger.error("Could not persist the object " + TeamViewerMode.class.getName() + " in the database because the object passed as a parameter equals null!");
		}
		return teamViewerQuantity;
	}
	/**
	 * Method will return a list of TeamViewerQuality objects based on criteria
	 * @return List<TeamViewerQuality>
	 * @param object as TeamViewerQuality 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamViewerQuality> findByCriteria(TeamViewerQuality object) {
		/* create a TeamViewerList as result */
		List<TeamViewerQuality> listTeamViewer = null;
		if(null != object){
			super.getTransaction().begin();
			Criteria criteria = super.getSessionFactory().getCurrentSession().createCriteria(TeamViewerQuality.class);
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
	 * Method will update TeamViewerQuality object
	 * @param object as TeamViewerQuality
	 * @return object as TeamViewerQuality
	 */
	@Override
	public TeamViewerQuality update(TeamViewerQuality object) {
		TeamViewerQuality teamViewerQuality = null;
		/* Check the object isn't null */
		if(null != object){
			/* set the values of the object to update*/
			TeamViewerQuality teamViewerQualityFound = super.findByID(object.getId());
			teamViewerQualityFound.setName(object.getName());
			teamViewerQualityFound.setNotes(object.getNotes());
			teamViewerQualityFound.setSamName(object.getSamName());
			teamViewerQualityFound.setUniqueID(object.getUniqueID());
			/* update the object in the database */
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().update(object);
				super.getTransaction().commit();
				logger.info("TeamViewerQuality successfull updated in the database!");
				/* search the partner in the database to return */
				TeamViewerQuality teamViewerQualityB = super.findByID(object.getId());
				if(object.equals(teamViewerQualityB)){
					teamViewerQuality = teamViewerQualityB;
				}
			}catch(Exception eXp){
				logger.error("TeamViewerQuality could not be updated in the database!");
				logger.error(eXp.getMessage());
				/* try rollback */
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Rollback of the TeamViewerQuality update in the database wasn't successfull");
					logger.error(hEx.getMessage());
				}
			}
		}
		return teamViewerQuality;
	}
	@Override
	public List<TeamViewerQuality> findByNamedQuery(List<NameQueryParam> list, String namedQuery){
		return null;
	}
}
