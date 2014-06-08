package be.jtrackteamviewerplugin.business.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import be.jtrackteamviewerplugin.business.bean.NameQueryParam;
import be.jtrackteamviewerplugin.business.bean.Partner;


public class PartnerDAOImpl extends AbstractDAOImpl<Partner> {
	/*
	 * instance members
	 */
	private static Logger logger = Logger.getLogger(PartnerDAOImpl.class);
	/**
	 * Default constructor for the Class
	 */
	public PartnerDAOImpl(SessionFactory sessionFactory){
		super.setType(Partner.class);
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * Method will persist the object in the database
	 * @param object as Partner
	 * @return Partner as object
	 */
	@Override
	public Partner persist(Partner object) {
		Partner partner = null;
		if(null != object){
			if(null != object.getUniqueID()){
				try{
					/* Persist the object to the database */
					super.getTransaction().begin();
					super.getSession().persist(object);
					super.getTransaction().commit();
				}catch(Exception eXp){
					logger.error("Could not persist the object " + Partner.class.getName() + " in the database!");
					logger.error(eXp.getMessage());
					try{
						super.getTransaction().rollback();
					}catch(HibernateException hEx){
						logger.error("Could not rollback the attempt to persist the "+ Partner.class.getName() + " object in the database");
					}
				}
				/* check weather the object is in the database to return to the fronted */
				List<Partner> list = this.findByCriteria(object);
				/* check weather the object is persisted correct in the database */
				if(null != list){
					if(-1 < list.size()){
						for(Partner prtn : list){
							if(object.equals(prtn)){
								partner = prtn;
								logger.info(Partner.class.getName() + " with id : " + partner.getId() + " was successful saved in the database!" );
							}
						}
					}
				}
			}else{
				logger.error("Could not persist the object " + Partner.class.getName() + " in the database because the object passed as a parameter equals null!");
			}
		}
		return partner;
	}
	/**
	 * Method will find a object based on the criteria of the object
	 * @param object as Partner
	 * @return Partner as result
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Partner> findByCriteria(Partner object) {
		/* create a TeamViewerList as result */
		List<Partner> listPartner = null;
		if(null != object){
			super.getTransaction().begin();
			Criteria criteria = super.getSessionFactory().getCurrentSession().createCriteria(Partner.class);
			criteria.add(Restrictions.or(
				Restrictions.eq("basicCharge",object.getBasicCharge()),
				Restrictions.eq("basicChargeTime", object.getBasicChargeTime()),
				Restrictions.eq("currency",object.getCurrency()),
				Restrictions.like("name","%" + object.getName() + "%"),
				Restrictions.like("notes","%" + object.getNotes() + "%"),
				Restrictions.like("uniqueID","%" + object.getUniqueID() + "%"),
				Restrictions.eq("id",object.getId()),
				Restrictions.eq("partnerGroup_ID",object.getPartnerGroup_ID() ),
				Restrictions.eq("dateModified",object.getDateModified()),
				Restrictions.eq("hourlyRate",object.getHourlyRate()),
				Restrictions.eq("inherit",object.getInherit())));
			/* create the list */
			listPartner = criteria.list();
			super.getTransaction().commit();
		}
		return listPartner;
	}
	/**
	 * Method will update the Partner in the database
	 * @param object as Partner
	 * @return partner as Partner, null if the update wasn't successfull
	 */
	@Override
	public Partner update(Partner object) {
		Partner partner = null;
		/* Check the object isn't null */
		if(null != object){
			/* set the values of the object to update*/
			Partner partnerFound = super.findByID(object.getId());
			partnerFound.setBasicCharge(object.getBasicCharge());
			partnerFound.setBasicChargeTime(object.getBasicChargeTime());
			partnerFound.setCurrency(object.getCurrency());
			partnerFound.setDateModified(object.getDateModified());
			partnerFound.setHourlyRate(object.getHourlyRate());
			partnerFound.setInherit(object.getInherit());
			partnerFound.setIsDeleted(object.getIsDeleted());
			partnerFound.setIsFavorite(object.getIsFavorite());
			partnerFound.setName(object.getName());
			partnerFound.setNotes(object.getNotes());
			partnerFound.setPartnerGroup_ID(object.getPartnerGroup_ID());
			partnerFound.setUniqueID(object.getUniqueID());
			/* update the object in the database */
			try{
				/* Persist the object to the database */
				super.getTransaction().begin();
				super.getSession().update(object);
				super.getTransaction().commit();
				logger.info("Partner successful updated in the database!");
				/* search the partner in the database to return */
				Partner partnerdb = super.findByID(object.getId());
				if(object.equals(partnerdb)){
					partner = partnerdb;
				}
			}catch(Exception eXp){
				logger.error("Partner could not be updated in the database!");
				logger.error(eXp.getMessage());
				/* try rollback */
				try{
					super.getTransaction().rollback();
				}catch(HibernateException hEx){
					logger.error("Rollback of the Partner update in the database wasn't successfull");
					logger.error(hEx.getMessage());
				}
			}
		}
		return partner;
	}
	@Override
	public List<Partner> findByNamedQuery(List<NameQueryParam> list, String namedQuery){
		return null;
	}
}
