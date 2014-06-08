package be.jtrackteamviewerplugin.business.data;

import java.util.List;
import be.jtrackteamviewerplugin.business.bean.NameQueryParam;

public interface IPersistenceDAO <T>{
	/**
	 * Method will find the object T by id
	 * @param id as int
	 * @return T as found object
	 */
	public T findByID(int id);
	/**
	 * Method will return all the objects<T>
	 * @param type as Class<T>
	 * @return objects as List<T>
	 */
	public List<T> findAll();
	/**
	 * Method will remove the object out the database
	 * @param entity as T
	 * @return boolean as success rate
	 */
	public boolean remove(int id);
	/**
	 * Method will return the referenced object based on the ID
 	 * @param type as Class<T>
	 * @param id as int
	 * @return object T
	 */
	public T getReference(Class<T> type, int id);
	/**
	 * Method will persist the object in the database
	 * @param object as T
	 * @return T as object
	 */
	public T persist(T object);
	/**
	 * Method will find a object based on the critearia of the object
	 * @param Object as T
	 * @return T as result
	 */
	public List<T> findByCriteria(T Object);
	/**
	 * Method will update the object in the database
	 * @param object as T
	 * @return T as updated object
	 */
	public T update(T object);
	/**
	 * Will get a resultList based on a NamedQuery
	 * @param list as List<NameQueryParam>
	 * @param namedQuery as String 
	 * @return List<T> as result
	 */
	public List<T> findByNamedQuery(List<NameQueryParam> list, String namedQuery);
}
