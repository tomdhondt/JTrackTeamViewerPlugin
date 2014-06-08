package be.jtrackteamviewerplugin.service.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


import nl.knowlogy.validation.ValidationEngine;
import nl.knowlogy.validation.ValidationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.data.CustomFieldDAOImpl;
import be.jtrackteamviewerplugin.service.dto.CustomFieldDTO;
import be.jtrackteamviewerplugin.service.mapper.CustomFieldMapper;

public class CustomFieldManager extends Observable implements IManagerDTO<CustomFieldDTO>, Serializable{
	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 4271467718315975520L;
	/* instance members */
	public CustomFieldManager(){}
	/**
	 * Method will persist the CustomField to the database
	 * @param object as CustomFieldDTO
	 */
	@Override
	public CustomFieldDTO persist(CustomFieldDTO object) throws ValidationException{
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl) context.getBean("customFieldDAOImpl");
		CustomFieldMapper customFieldMapper = (CustomFieldMapper) context.getBean("customFieldMapper");
		/* Validate the object */
		ValidationEngine.validate(object);
		/* Map the DTO to a Object */
		CustomField cfield = customFieldMapper.mapToObject(object);
		/* Persist the object to the database */
		CustomField cFieldNew = customFieldDAOImpl.persist(cfield);
		return customFieldMapper.mapToDTO(cFieldNew);
	}

	@Override
	public CustomFieldDTO update(CustomFieldDTO object) {
		return this.persist(object);
	}
	/**
	 * Method will remove the object out the database
	 * @param object as CustomFieldDTO
	 * @return boolean as success rate 
	 */
	@Override
	public boolean remove(CustomFieldDTO object) throws ValidationException{
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl) context.getBean("customFieldDAOImpl");
		CustomFieldMapper customFieldMapper = (CustomFieldMapper) context.getBean("customFieldMapper");
		boolean success = false;
		if(null != object){
			CustomField cField = customFieldMapper.mapToObject(object);
			/* Check if the object is in the database */
			if(cField.getId() > 0){
				success = customFieldDAOImpl.remove(cField.getId());
			}
		}else{
			success = true;
		}
		return success;
	}
	@Override
	public CustomFieldDTO findByID(String ID) {
		return null;
	}
	/**
	 * Method will return a list of CustomFieldDTO objects based on criteria defined in the object given as parameter
	 * @param object as CustomFieldDTO
	 * @return list as List<CustomFieldDTO>
	 */
	@Override
	public List<CustomFieldDTO> findByCriteria(CustomFieldDTO object) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl) context.getBean("customFieldDAOImpl");
		CustomFieldMapper customFieldMapper = (CustomFieldMapper) context.getBean("customFieldMapper");
		CustomField cField =  customFieldMapper.mapToObject(object);
		List<CustomFieldDTO> listCustomFieldDTO = new ArrayList<CustomFieldDTO>();
		/* search the object in the database */		
		if(null != cField){
			/* execute the FindByCriteria */
			List<CustomField> listCustomField = customFieldDAOImpl.findByCriteria(cField);
			/* check weather the list isn't null */
			if(null != listCustomField){
				/* iterate the list and map to DTO */
				for(CustomField cFieldFound : listCustomField){
					listCustomFieldDTO.add(customFieldMapper.mapToDTO(cFieldFound));
				}
			}
		} 
		/* return the found items */
		return listCustomFieldDTO;
	}
	/**
	 * Method will return the different CustomField that are in the database
	 * @return list as List<CustomFieldDTO>
	 */
	@Override
	public List<CustomFieldDTO> findAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl) context.getBean("customFieldDAOImpl");
		CustomFieldMapper customFieldMapper = (CustomFieldMapper) context.getBean("customFieldMapper");
		/* get the different CustomFields out the database */
		List<CustomField> customFieldList = customFieldDAOImpl.findAll();
		/* Create a List of CustomFieldDTO objects */
		List<CustomFieldDTO> customFieldDTOList = new ArrayList<CustomFieldDTO>();
		/* check weather there are objects in the customFieldList */
		if(null != customFieldList){
			/* iterate the CustomField objects in the list and map the to DTO */ 
			for(CustomField customField : customFieldList){
				customFieldDTOList.add(customFieldMapper.mapToDTO(customField));
			}
		}else{
			customFieldDTOList = null;
		}
		return customFieldDTOList;
	}
}
