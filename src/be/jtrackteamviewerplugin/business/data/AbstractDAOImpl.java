package be.jtrackteamviewerplugin.business.data;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// extends Hibernatetemplate
public abstract class AbstractDAOImpl<T> implements IPersistenceDAO<T>{
	/* 
	 * Instance Members
	 */
	protected Class<T> type;
	protected SessionFactory sessionFactory;
	private static Logger logger = Logger.getLogger(AbstractDAOImpl.class);
    /**
	 * Default constructor for the Class
	 */
	public AbstractDAOImpl(){
	}
	/**
	 * @return the type
	 */
	public Class<T> getType() {
		return type;
	}
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/**
	 * @return the transactionManager
	 */
	public Transaction getTransaction() {
		return this.sessionFactory.getCurrentSession().getTransaction();
	}
	/**
	 * @return the session
	 */
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Method will find the object by ID
	 * @param id as int
	 * @return object of type T
	 */
	@Override
	@SuppressWarnings("unchecked")
    public T findByID(int id) {
		/* create a object to pointer the object */
		T object = null;
		try{
			this.getSessionFactory().getCurrentSession().getTransaction().begin();
			object = (T) this.getSessionFactory().getCurrentSession().get(this.getType(),id);
			this.getSessionFactory().getCurrentSession().getTransaction().commit();
		}catch(Exception eXp){
			try{
				this.getSessionFactory().getCurrentSession().getTransaction().rollback();
				logger.error("Rollback of the findById of the object type : " + this.getType().getName() + "!");
			}catch(HibernateException hEx){
				logger.error("Rollback of the findById could not be performed!");
			}
		}
		return object;
    }
	/**
	 * Method will find the object by ID
	 * @param id as int
	 * @return object of type T
	 */
    @SuppressWarnings("rawtypes")
	public Object findByID(int id, Class type) {
		/* create a object to pointer the object */
		Object object = null;
		try{
			this.getSessionFactory().getCurrentSession().getTransaction().begin();
			this.getSessionFactory().getCurrentSession().createQuery("FROM " + type.getName() + " WHERE id = " + id);
			this.getSessionFactory().getCurrentSession().getTransaction().commit();
		}catch(Exception eXp){
			try{
				this.getSessionFactory().getCurrentSession().getTransaction().rollback();
				logger.error("Rollback of the findById of the object type : " + type.getName() + "!");
			}catch(HibernateException hEx){
				logger.error("Rollback of the findById could not be performed!");
			}
		}
		return object;
    }
	/**
	 * Method will return the referenced object based on the ID
 	 * @param type as Class<T>
	 * @param id as int
	 * @return object T
	 */
	@Override
	public T getReference(Class<T> type, int id){
		return this.findByID(id);
	}
	/**
	 * Method will remove the object out the database
	 * @param entity as T
	 * @return boolean as success rate
	 */
	public boolean remove(int id){
		boolean success = false;
		/* check if the object exists */
		T object = this.findByID(id);
		/* delete the object in the database */
		if(null != object){
			this.getTransaction().begin();
			Query q = this.getSession().createQuery("DELETE " + this.getType().getName() + " WHERE id = " + id);
			logger.info("Remove query for the object " + this.getType().getName() + " : " + q.getQueryString());
			int count = q.executeUpdate();
			this.getTransaction().commit();
			if(-1 < count){
				success = true;
				logger.info(this.getType().getName() + " with id " + id + " was successful removed in the database!");
			}
		}else{
			logger.info("Object " + this.getType().getName() + " could not be removed." + this.getType().getName() + " wasn't found in the database.");
		}
		
		return success;
	}
	/**
	 * Method will remove the object out the database
	 * @param id as int
	 * @param type as Class
	 * @return boolean as success rate
	 */
	@SuppressWarnings("rawtypes")
	public boolean remove(int id, Class type){
		boolean success = false;
		/* check if the object exists */
		Object object = this.findByID(id, type);
		/* delete the object in the database */
		if(null != object){
			this.getTransaction().begin();
			Query q = this.getSession().createQuery("DELETE " + type.getName() + " WHERE id = " + id);
			logger.info("Remove query for the object " + type.getName() + " : " + q.getQueryString());
			int count = q.executeUpdate();
			this.getTransaction().commit();
			if(-1 < count){
				success = true;
				logger.info(type.getName() + " with id " + id + " was successful removed in the database!");
			}
		}else{
			logger.info("Object " + type.getName() + " could not be removed." + type.getName() + " wasn't found in the database.");
		}
		
		return success;
	}
	/**
	 * Method will return all the objects<T>
	 * @param type as Class<T>
	 * @return objects as List<T>
	 */
	@Override
	public List<T> findAll(){
		this.getTransaction().begin();
		Query query = this.getSession().createQuery("FROM " + this.getType().getName());
		@SuppressWarnings("unchecked")
		List<T> listObject = (List<T>) query.list(); 
		this.getTransaction().commit();
		return listObject;
	}
}
