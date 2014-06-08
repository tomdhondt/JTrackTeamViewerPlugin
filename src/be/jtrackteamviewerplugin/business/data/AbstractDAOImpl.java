package be.jtrackteamviewerplugin.business.data;

import java.util.Collections;
import java.util.List;

import main.java.info.jtrac.exception.JTrackException;
import main.java.info.jtrac.exception.data.DataDAOException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public abstract class AbstractDAOImpl<T> implements IPersistenceDAOImpl<T>{
	/* 
	 * Instance Members
	 */
	protected SessionFactory sessionFactory;
	protected Class<T> type;
	private Logger logger = Logger.getLogger(JTrackException.class);
    /**
	 * Default constructor for the Class
	 */
	public AbstractDAOImpl(){
	}
	/**
	 * @return the type
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}
	/**
	 * @return the type
	 */
	public Class<T> getType() {
		return type;
	}
	/**
	 * Method will find a object in the database based on the criteria of the object.
	 * @param Object as T
	 * @return Set<T> as resultSet
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(List<NameQueryParam> list , String namedQuery) throws DataDAOException {
		List<T> result = null;
		if(null != namedQuery && null != list){
			try{
				this.sessionFactory.getCurrentSession().getTransaction().begin();
				Query q = this.sessionFactory.getCurrentSession().getNamedQuery(namedQuery);
				Collections.sort(list);
				for(NameQueryParam nQp : list){
					q.setString(nQp.getVarName(), nQp.getValue());
				}
				result = q.list();
				this.sessionFactory.getCurrentSession().getTransaction().commit();			
			}catch(Exception e){
				throw new DataDAOException("object.findAll.error",e.getStackTrace());
			}
		}
		return result;
	}
	/**
	 * Method will find a object in the database based on the criteria of the object.
	 * @param Object as T
	 * @return Set<T> as resultSet
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> findByCriteria(String namedQuery) throws DataDAOException {
		List<Object> result = null;
		if(null != namedQuery){
			try{
				this.sessionFactory.getCurrentSession().getTransaction().begin();
				Query q = this.sessionFactory.getCurrentSession().getNamedQuery(namedQuery);
				result = q.list();
				this.sessionFactory.getCurrentSession().getTransaction().commit();			
			}catch(Exception e){
				throw new DataDAOException("object.findAll.error",e.getStackTrace());
			}
		}
		return result;
	}
	/**
	 * Method will find a object in the database based on the criteria of the object.
	 * @param Object as T
	 * @param count as int
	 * @return Set<T> as resultSet
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(List<NameQueryParam> list , String namedQuery, int count) throws DataDAOException {
		List<T> result = null;
		if(null != namedQuery && null != list){
			try{
				this.sessionFactory.getCurrentSession().getTransaction().begin();
				Query q = this.sessionFactory.getCurrentSession().getNamedQuery(namedQuery);
				Collections.sort(list);
				for(NameQueryParam nQp : list){
					q.setString(nQp.getVarName(), nQp.getValue());
				}
				if(count <= 0){
					q.setMaxResults(1);
				}else{
					q.setMaxResults(count);
				}
				result = q.list();
				this.sessionFactory.getCurrentSession().getTransaction().commit();			
			}catch(Exception e){
				throw new DataDAOException("object.findAll.error",e.getStackTrace());
			}
		}
		return result;
	}
	/**
	 * Method will persist the object in the database
	 */
	@Override
	public void persist(T object) throws DataDAOException {
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
			this.sessionFactory.getCurrentSession().persist(object);
			this.sessionFactory.getCurrentSession().getTransaction().commit();			
		}catch(Exception eXe){
			throw new DataDAOException("object.persist.couldNotPersist", eXe.getStackTrace());
		}
	}
	/**
	 * Method will find the object by ID
	 * @param id as int
	 * @return object of type T
	 */
	@SuppressWarnings("unchecked")
	@Override
    public T findByID(long id) throws DataDAOException{
		/* create a object to pointer the object */
		T object = null;
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = this.sessionFactory.getCurrentSession().createQuery("FROM " + this.getType().getName() + " WHERE ID = "+ id);
			List<T> resultList = query.list();
			/* set the return object */
			for(T ob : resultList){
				object = ob;
			}
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception eXe){
			try{
				this.sessionFactory.getCurrentSession().getTransaction().rollback();
				throw new DataDAOException("Object.findByID.notObjectFound", eXe.getStackTrace());
			}catch(HibernateException hEx){
				throw new DataDAOException("Object.findByID.notObjectFound", hEx.getStackTrace());
			}
		}
		return object;
    }
	/**
	 * Method will return all the objects<T>
	 * @param type as Class<T>
	 * @return objects as List<T>
	 * <li>the list equals null when there could not found a result</li>
	 * @throws DataDAOException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws DataDAOException{
		List<T> resultList = null;
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = this.sessionFactory.getCurrentSession().createQuery("FROM " + this.getType().getName());
			resultList = query.list();
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(HibernateException hEx){
			logger.error(hEx.getMessage());
			throw new DataDAOException("object.findAll.error",hEx.getStackTrace());
		}
		return resultList;
	}
	/**
	 * Method will return all the objects<T>
	 * @param type as Class<T>
	 * @return objects as List<T>
	 * <li>the list equals null when there could not found a result</li>
	 * @throws DataDAOException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(int count) throws DataDAOException{
		List<T> resultList = null;
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = this.sessionFactory.getCurrentSession().createQuery("FROM " + this.getType().getName());
			if(count <=0){
				query.setMaxResults(1);
			}else{
				query.setMaxResults(count);	
			}
			resultList = query.list();
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(HibernateException hEx){
			logger.error(hEx.getMessage());
			throw new DataDAOException("object.findAll.error",hEx.getStackTrace());
		}
		return resultList;
	}
	/**
	 * Method will delete the object out the database
	 * @param id as String
	 * @return boolean as success rate
	 * @throws DataDAOException as Exception
	 */
	public boolean delete(long id)throws DataDAOException{
		boolean success = false;
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
			Query query = this.sessionFactory.getCurrentSession().createQuery("DELETE " + this.getType().getName() + " WHERE ID = "+ id );
			if(0 < query.executeUpdate()){
				success = true;
			}
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception eXe){
			logger.error(eXe.getMessage());
			throw new DataDAOException("object.delete.error", eXe.getStackTrace());
		}
		return success;
	}
	/**
	 * Method will update the PropertyGroup in the database
	 * @param object as PropertyGroup
	 * @return PropertyGroup as object
	 * <li>null : when the object could not be updated </li>
	 * @exception DataDAOException when the object that we try to update isn't in the database
	 * @exception HibernateException when there is a problem communicate with the database
	 * @exception Exception when there is a global exception
	 */
	@Override
	public boolean remove(long id) throws DataDAOException {
		/* method variable */
		boolean success = false;
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
		    String hql = "UPDATE " + this.getType().getName() + " SET active = :active WHERE ID = :ID";
		    Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		    query.setBoolean("active",false);
		    query.setLong("ID",id);
			if(0 < query.executeUpdate()){
				success = true;
			}
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception eXe){
			logger.error(eXe.getMessage());
			throw new DataDAOException("object.remove.couldNotPersist", eXe.getStackTrace());
		}
		/* return the success rate */
		return success;
	}
	/**
	 * Method will update the object in de database.
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T update(T object) throws DataDAOException{
		T updatedObject = null;
		/* Update the object in the database */
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
			this.sessionFactory.getCurrentSession().saveOrUpdate(object);
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception eXe){
			logger.error(eXe.getMessage());
			eXe.printStackTrace();
			throw new DataDAOException("object.update.couldNotUpdate", eXe.getStackTrace());
			
		}
		/* merge the object */
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
			updatedObject = (T) this.sessionFactory.getCurrentSession().merge(object);
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception eXe){
			logger.error(eXe.getMessage());
			throw new DataDAOException("object.merge.couldNotMerge", eXe.getStackTrace());
		}
		return updatedObject;
	}
	/**
	 * Method will drop the table out the database
	 * @return boolean as success rate
	 */
	@Override
	public boolean dropTable() throws DataDAOException{
		boolean success = false;
		try{
			this.sessionFactory.getCurrentSession().getTransaction().begin();
		    String hql = "DELETE FROM " + this.getType().getName();
		    Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
			if(0 < query.executeUpdate()){
				success = true;
			}
			this.sessionFactory.getCurrentSession().getTransaction().commit();
		}catch(Exception eXe){
			logger.error(eXe.getMessage());
			throw new DataDAOException("drop.table.error", eXe.getStackTrace());
		}
		return success;
	}
}
