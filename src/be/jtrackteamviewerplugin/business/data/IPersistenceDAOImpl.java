package be.jtrackteamviewerplugin.business.data;

import java.util.List;

import be.jtrackteamviewerplugin.business.bean.NameQueryParam;
import be.jtrackteamviewerplugin.exception.data.DataDAOException;

/**
 * Interface IPersistenceDAOImpl
 * @author Tom D'hondt - created at : 19-apr.-2014
 * @param <T> as 
 */
public interface IPersistenceDAOImpl <T>{
	/**
	 * Method will find the object T by id
	 * @param id as int
	 * @return T as found object
	 */
	public T findByID(long id) throws DataDAOException;
	/**
	 * Method will return all the objects<T>
	 * @param type as Class<T>
	 * @return objects as List<T>
	 */
	public List<T> findAll() throws DataDAOException;
	/**
	 * Method will return all the objects<T>
	 * @param type as Class<T>
	 * @param count as Integer
	 * @return objects as List<T>
	 */
	public List<T> findAll(int count) throws DataDAOException;
	/**
	 * Method will remove the object out the database
	 * @param entity as T
	 * @return boolean as success rate
	 */
	public boolean remove(long id) throws DataDAOException;
	/**
	 * Method will persist the object in the database
	 * @param object as T
	 * @return 
	 * @return T as object
	 */
	public void persist(T object) throws DataDAOException;
	/**
	 * Method will find a object based on the criteria of the object
	 * @param Object as T
	 * @return T as result
	 */
	public List<T> findByCriteria(List<NameQueryParam> list , String namedQuery) throws DataDAOException;
	/**
	 * Method will find a object based on the criteria of the object
	 * @param String as namedQuery
	 * @return List<Object> as result
	 */
	public List<Object> findByCriteria(String namedQuery) throws DataDAOException;
	/**
	 * Method will find a object based on the criteria of the object
	 * @param Object as T
	 * @param int as count of Objects
	 * @return T as result
	 */
	public List<T> findByCriteria(List<NameQueryParam> list , String namedQuery, int count) throws DataDAOException;
	/**
	 * Method will update the object in the database
	 * @param object as T
	 * @return T as updated object
	 */
	public T update(T object) throws DataDAOException;
	/**
	 * Method will delete a object out the database 
	 * @param id as String
	 * @return boolean as success rate
	 * @throws DataDAOException as Exception
	 */
	public boolean delete(long id) throws DataDAOException;
	/**
	 * Method will drop the Table in the database
	 * @return boolean as SuccessRate
	 * @throws DataDAOException
	 */
	public boolean dropTable() throws DataDAOException;
}
