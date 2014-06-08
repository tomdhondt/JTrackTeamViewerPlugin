package be.jtrackteamviewerplugin.service.manager;

import java.util.List;

import be.jtrackteamviewerplugin.util.exception.PropertyValueException;

public interface IManagerDTO<T> {
	/**
	 * Method will save the object in the database
	 * @param object as T
	 * @return object as T
	 * @throws PropertyValueException 
	 */
	public T persist(T object);
	/**
	 * Method will update the object in the database
	 * @param object as T
	 * @return object as T
	 */
	public T update(T object);
	/**
	 * Method will remove the object in the database
	 * @param object as T
	 * @return object as T
	 */
	public boolean remove(T object);
	/**
	 * Method will find the object by ID in the database
	 * @param id as int 
	 * @return object as java.util.List<T>
	 */
	public T findByID(String ID);
	/**
	 * Method will find the object by criteria in the database
	 * @param object as T 
	 * @return object as java.util.List<T>
	 */
	public List<T> findByCriteria(T object);
	/**
	 * Method will find all the objects in the database
	 * @param object as T 
	 * @return object as java.util.List<T>
	 */
	public List<T> findAll();
}

