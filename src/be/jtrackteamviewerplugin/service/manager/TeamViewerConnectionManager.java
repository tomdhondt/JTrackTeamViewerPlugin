package be.jtrackteamviewerplugin.service.manager;

import java.util.ArrayList;
import java.util.List;

import nl.knowlogy.validation.ValidationEngine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.data.TeamViewerConnectionDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionDTO;
import be.jtrackteamviewerplugin.service.mapper.TeamViewerConnectionMapper;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerConnectionManager implements	IManagerDTO<TeamViewerConnectionDTO> {
	/**
	 * Method will persist the object to the database 
	 * @param object as TeamViewerConnectionDTO
	 * @return object as TeamViewerConnectionDTO
	 */
	@Override
	public TeamViewerConnectionDTO persist(TeamViewerConnectionDTO object) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl) context.getBean("teamViewerConnectionDAOImpl");
		TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper) context.getBean("teamViewerConnectionMapper");
		/* Validate the object */
		ValidationEngine.validate(object);
		/* Map the DTO to a Object */
		TeamViewerConnection dto = teamViewerConnectionMapper.mapToObject(object);
		/* Persist the object to the database */
		TeamViewerConnection dtoNew = teamViewerConnectionDAOImpl.persist(dto);
		return teamViewerConnectionMapper.mapToDTO(dtoNew);
	}
	/**
	 * Method will update the object to the database 
	 * @param object as TeamViewerConnectionDTO
	 * @return object as TeamViewerConnectionDTO
	 */
	@Override
	public TeamViewerConnectionDTO update(TeamViewerConnectionDTO object) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl) context.getBean("teamViewerConnectionDAOImpl");
		TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper) context.getBean("teamViewerConnectionMapper");
		/* Validate the object */
		ValidationEngine.validate(object);
		/* Map the DTO to a Object */
		TeamViewerConnection dto = teamViewerConnectionMapper.mapToObject(object);
		/* Persist the object to the database */
		TeamViewerConnection dtoNew = teamViewerConnectionDAOImpl.update(dto);
		return teamViewerConnectionMapper.mapToDTO(dtoNew);
	}
	/**
	 * Method will remove the object to the database 
	 * @param object as TeamViewerConnectionDTO
	 * @return success as boolean
	 */
	@Override
	public boolean remove(TeamViewerConnectionDTO object) {
		boolean success = false;
		/* start */
		if(null!= object){
			/* TeamViewerConnectionDTO - get the object out the database */
			TeamViewerConnectionDTO dto = this.findByID(object.getId());
			/* TeamViewerConnectionDTO - set the isDeleted parameter of the object */
			dto.setIsDeleted(true);
			/* TeamViewerConnectionDTO - save the state in the database */
			if(null != this.update(dto)){
				/* TeamViewerConnectionDTO - set the successrate of the action */
				success = true;
			}
		}
		return success;
	}
	/**
	 * Method will find a TeamViewerConnectionDTO based on the id
	 * @return object as TeamViewerConnectionDTO
	 * @param id as String
	 */
	@Override
	public TeamViewerConnectionDTO findByID(String ID) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl) context.getBean("teamViewerConnectionDAOImpl");
		TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper) context.getBean("teamViewerConnectionMapper");
		TeamViewerConnectionDTO tvDTOConnection = null;
		/* map the id to a Integer */
		int id = MappingUtil.mapStringToInt(ID);
		/* try to find the TeamViewerConnectionDTO */
		if(-1 < id){
			TeamViewerConnection con = teamViewerConnectionDAOImpl.findByID(id);
			tvDTOConnection = teamViewerConnectionMapper.mapToDTO(con);
		}
		return tvDTOConnection;
	}
	/**
	 * Method will return a list of TeamViewerConnectionDTO object based on criteria
	 * @param object as TeamViewerConnectionDTO
	 * @return list as List<TeamViewerConnectionDTO>
	 */	
	@Override
	public List<TeamViewerConnectionDTO> findByCriteria(TeamViewerConnectionDTO object) {
		List<TeamViewerConnectionDTO> teamViewerConnectionDTOList = null;
		if(null != object){
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl) context.getBean("teamViewerConnectionDAOImpl");
			TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper) context.getBean("teamViewerConnectionMapper");
			/* map the dto to a object */
			TeamViewerConnection objectTvc = teamViewerConnectionMapper.mapToObject(object);
			List<TeamViewerConnection> teamViewerConnectionList = teamViewerConnectionDAOImpl.findByCriteria(objectTvc);
			if(null != teamViewerConnectionList){
				teamViewerConnectionDTOList = new ArrayList<TeamViewerConnectionDTO>();
				for(TeamViewerConnection con : teamViewerConnectionList){
					teamViewerConnectionDTOList.add(teamViewerConnectionMapper.mapToDTO(con));
				}
			}
		}
		return teamViewerConnectionDTOList;
	}
	/**
	 * Method will return all the objects found in the database
	 * @return list as List<TeamViewerConnectionDTO>
	 */
	@Override
	public List<TeamViewerConnectionDTO> findAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl) context.getBean("teamViewerConnectionDAOImpl");
		TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper) context.getBean("teamViewerConnectionMapper");
		/* TeamViewerConnection - get id */
		/* get the different CustomFields out the database */
		List<TeamViewerConnection> teamViewerdConnectionList = teamViewerConnectionDAOImpl.findAll();
		/* Create a List of CustomFieldDTO objects */
		List<TeamViewerConnectionDTO> teamViewerConnectionDTOList = new ArrayList<TeamViewerConnectionDTO>();
		/* check weather there are objects in the customFieldList */
		if(null != teamViewerdConnectionList){
			/* iterate the CustomField objects in the list and map the to DTO */ 
			for(TeamViewerConnection teamViewerConnection : teamViewerdConnectionList){
				teamViewerConnectionDTOList.add(teamViewerConnectionMapper.mapToDTO(teamViewerConnection));
			}
		}else{
			teamViewerConnectionDTOList = null;
		}
		return teamViewerConnectionDTOList;
	}

}
