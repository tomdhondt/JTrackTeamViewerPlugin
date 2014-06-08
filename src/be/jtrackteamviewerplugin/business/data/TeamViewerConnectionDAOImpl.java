package be.jtrackteamviewerplugin.business.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.NameQueryParam;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;

public class TeamViewerConnectionDAOImpl extends AbstractDAOImpl<TeamViewerConnection> {
	/*
	 * instance members
	 */
	private static Logger logger = Logger.getLogger(TeamViewerConnectionDAOImpl.class);
	private TeamViewerDAOImpl teamViewerDAOImpl;
	/**
	 * Default constructor for the Class
	 */
	public TeamViewerConnectionDAOImpl(SessionFactory sessionFactory){
		super.setType(TeamViewerConnection.class);
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * @return the teamViewerDAOImpl
	 */
	public TeamViewerDAOImpl getTeamViewerDAOImpl() {
		return teamViewerDAOImpl;
	}
	/**
	 * @param teamViewerDAOImpl the teamViewerDAOImpl to set
	 */
	public void setTeamViewerDAOImpl(TeamViewerDAOImpl teamViewerDAOImpl) {
		this.teamViewerDAOImpl = teamViewerDAOImpl;
	}
	/**
	 * Method will persist the object to the database
	 * @param object as TeamViewerConnection
	 * @return object as TeamViewerConnection
	 */
	@Override
	public TeamViewerConnection persist(TeamViewerConnection object) {
		TeamViewerConnection teamViewerConnection = null;
		if(null != object){
			/* check object in the database */
			if(this.findAll().contains(object)){
				/* update the object in the database */
				teamViewerConnection = this.update(object);
			}else{
				/* Persist the object to the database */
				try{
					super.getTransaction().begin();
					super.getSession().persist(object);
					super.getTransaction().commit();
				}catch(Exception eXp){
					logger.error("Could not persist the object " + TeamViewerConnection.class.getName() + " in the database!");
					logger.error(eXp.getMessage());
					try{
						super.getTransaction().rollback();
					}catch(HibernateException hEx){
						logger.error("Could not rollback the attempt to persist the "+ TeamViewerConnection.class.getName() + " object in the database");
					}
				}
				/* check if the object is in the database to return to the fronted */
				List<TeamViewerConnection> list = this.findByCriteria(object);
				/* check if the object is persisted correct in the database */
				if(null != list){
					if(-1 < list.size()){
						for(TeamViewerConnection tvc : list){
							if(object.equals(tvc)){
								teamViewerConnection = tvc;
							}
						}
					}
				}
				/* set the teamViewerConnection */
				if(null != teamViewerConnection){
					for(TeamViewerConnectionMetaData tvcMd : object.getTeamViewerConnectionMetaDataList()){
						tvcMd.setTeamViewerConnection(teamViewerConnection);
					}
				}
				/* merge the TeamViewerConnectionMetaData */
				if(null != object.getTeamViewerConnectionMetaDataList()){
					ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
					TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl) context.getBean("teamViewerConnectionMetaDataDAOImpl");
					/* Persist the teamViewerConnectionMetaData */
					for(TeamViewerConnectionMetaData tvcMd : object.getTeamViewerConnectionMetaDataList()){
						if(0 == tvcMd.getId()){
							teamViewerConnectionMetaDataDAOImpl.persist(tvcMd);
						}
					}
				}
			}
		}else{
			logger.error("Could not persist the object " + TeamViewerConnection.class.getName() + " in the database because the object passed as a parameter equals null!");
		}
		return teamViewerConnection;
	}
	/**
	 * Method will retrieve a TeamViewerConnection based on the property status of the object given along as parameter
	 * @param object as TeamViewerConnection
	 * @return List<TeamViewerConnection>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamViewerConnection> findByCriteria(TeamViewerConnection object) {
		/* create a TeamViewerList as result */
		List<TeamViewerConnection> listTeamViewerConnection = null;
		if(null != object){
			super.getTransaction().begin();
			Criteria criteria = super.getSessionFactory().getCurrentSession().createCriteria(TeamViewerConnection.class);
			Date minStart = null;
			Date maxStart = null;
			if(null != object.getStart()){
				Calendar cal = Calendar.getInstance();
				cal.setTime(object.getStart());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				cal.set(Calendar.MILLISECOND, 0);
				minStart = cal.getTime();
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(cal.getTime());
				cal1.set(Calendar.HOUR_OF_DAY, 24);
				cal1.set(Calendar.MINUTE, 0);
				cal1.set(Calendar.SECOND, 0);
				cal1.set(Calendar.MILLISECOND, 0);
				maxStart = cal1.getTime();
			}
			/* check weather the object has a uniqueID */
			if(null != object.getUniqueID()){
				criteria.add(Restrictions.or(
						Restrictions.like("uniqueID",object.getUniqueID()),
						Restrictions.ge("start",minStart),
						Restrictions.lt("start",maxStart),
						Restrictions.eq("finish",object.getFinish()),
						Restrictions.like("notes", object.getNotes()),
						Restrictions.eq("isDeleted",object.getIsDeleted()),
						Restrictions.like("windowsUser",object.getWindowsUser()),
						Restrictions.eq("price",object.getPrice()),
						Restrictions.like("hash",object.getHash()),
						Restrictions.ge("start", minStart),
						Restrictions.lt("start", maxStart),
						Restrictions.eq("bill",object.getBill())
						));
						try{
							listTeamViewerConnection = criteria.list();
							super.getTransaction().commit();
						}catch(HibernateException hEx){
							System.out.println(hEx);
						}
			}else{
				criteria.add(Restrictions.and(
						Restrictions.ge("start", minStart),
						Restrictions.lt("start", maxStart)));
				super.getTransaction().commit();
				List<NameQueryParam> list = new ArrayList<NameQueryParam>();
				list.add(new NameQueryParam(1, "start", minStart));
				list.add(new NameQueryParam(2, "finish", maxStart));
				listTeamViewerConnection = this.findByNamedQuery(list, "TeamViewerConnection.findby.startdate");
			}
			/* create the list */
		}
		return listTeamViewerConnection;
	}
	/**
	 * Method will update the data in the database 
	 */
	@Override
	public TeamViewerConnection update(TeamViewerConnection object) {
		TeamViewerConnection teamViewerConnection = null;
		/* Check the object isn't null */
		if(null != object){
			/* set the values of the object to update*/
			TeamViewerConnection teamViewerConnectionFound = super.findByID(object.getId());
			teamViewerConnectionFound.setUniqueID(object.getUniqueID());
			teamViewerConnectionFound.setStart(object.getStart());
			teamViewerConnectionFound.setFinish(object.getFinish());
			teamViewerConnectionFound.setIsDeleted(object.getIsDeleted());
			teamViewerConnectionFound.setWindowsUser(object.getWindowsUser());
			teamViewerConnectionFound.setPrice(object.getPrice());
			teamViewerConnectionFound.setHash(object.getHash());
			teamViewerConnectionFound.setTeamViewer(object.getTeamViewer());
			teamViewerConnectionFound.setBill(object.getBill());
			/* update the object in the database */
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().update(object);
				super.getTransaction().commit();
				logger.info("TeamViewerConnectionMetaData successfull updated in the database!");
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
			/* persist the TeamVieweConnectionMetaData to the database */
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl)context.getBean("teamViewerConnectionMetaDataDAOImpl");
			try{
				for(TeamViewerConnectionMetaData tvMd : object.getTeamViewerConnectionMetaDataList()){
					tvMd.setTeamViewerConnection(this.findByID(teamViewerConnectionFound.getId()));
					teamViewerConnectionMetaDataDAOImpl.persist(tvMd);
				}
			}catch(Exception eXp){
				logger.error("could  not persist the TeamViewerMetaData to the database.");
			}
			teamViewerConnection = this.findByID(teamViewerConnectionFound.getId());
		}
		return teamViewerConnection;
	}
	/**
	 * Method will return all the objects<T>
	 * @param type as Class<T>
	 * @return objects as List<T>
	 */
	@Override
	public List<TeamViewerConnection> findAll(){
		this.getTransaction().begin();
		Query query = this.getSession().createQuery("FROM TeamViewerConnection as t WHERE t.isDeleted is false");
		@SuppressWarnings("unchecked")
		List<TeamViewerConnection> listObject = (List<TeamViewerConnection>) query.list(); 
		this.getTransaction().commit();
		return listObject;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<TeamViewerConnection> findByNamedQuery(List<NameQueryParam> list, String namedQuery){
//		List<TeamViewerConnection> result = null
//		if(null != namedQuery && null != list){
//			try{
//				this.getTransaction().begin();
				
//				Query q = this.getSession().getNamedQuery(namedQuery);
//				Collections.sort(list);
//				for(NameQueryParam nQp : list){
//					if(nQp.getValue() instanceof Date){
//						q.setDate(nQp.getVarName(), (Date)nQp.getValue());
//					}
//					if(nQp.getValue() instanceof String){
//						q.setString(nQp.getVarName(), (String)nQp.getValue());
//					}
//				}
//				result = q.list();
//				this.getTransaction().commit();			
//			}catch(Exception e){
//			}
//		}
		List<TeamViewerConnection> result = new ArrayList<TeamViewerConnection>();
//		result.add(this.findByID(2457));
//		result.add(this.findByID(2456));
//		result.add(this.findByID(2455));
//		result.add(this.findByID(2454));
//		result.add(this.findByID(2453));
//		result.add(this.findByID(2452));
//		result.add(this.findByID(2451));
//		result.add(this.findByID(2450));
		result.add(this.findByID(2449));
//		result.add(this.findByID(2448));
		return result;
	}
}
