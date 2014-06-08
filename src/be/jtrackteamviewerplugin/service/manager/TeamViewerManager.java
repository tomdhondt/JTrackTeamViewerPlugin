package be.jtrackteamviewerplugin.service.manager;

import java.util.ArrayList;
import java.util.List;

import nl.knowlogy.validation.ValidationEngine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewer;
import be.jtrackteamviewerplugin.business.data.TeamViewerDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerDTO;
import be.jtrackteamviewerplugin.service.mapper.TeamViewerMapper;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerManager extends AbstractManager<TeamViewerDTO> {
	/**
	 * Method will persist a TeamViewerDTO to the database
	 * @return TeamViewerDTO as persisted object
	 * @param object as TeamViewerDTO
	 */
	@Override
	public TeamViewerDTO persist(TeamViewerDTO object) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
		TeamViewerMapper teamViewerMapper = (TeamViewerMapper) context.getBean("teamViewerMapper");
		/* Validate the object */
		ValidationEngine.validate(object);
		/* Map the DTO to a Object */
		TeamViewer teamViewer = teamViewerMapper.mapToObject(object);
		/* Persist the object to the database */
		TeamViewer teamViewerNew = teamViewerDAOImpl.persist(teamViewer);
		return teamViewerMapper.mapToDTO(teamViewerNew);
	}

	@Override
	public TeamViewerDTO update(TeamViewerDTO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(TeamViewerDTO object) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Method will return a DTO based on the id given as a String
	 * @param id as String
	 * @return object as TeamViewerDTO 
	 */
	@Override
	public TeamViewerDTO findByID(String ID) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
		TeamViewerMapper teamViewerMapper = (TeamViewerMapper) context.getBean("teamViewerMapper");
		TeamViewerDTO tvDTO = null;
		/* map the id to a Integer */
		int id = MappingUtil.mapStringToInt(ID);
		/* try to find the TeamViewerConnectionDTO */
		if(-1 < id){
			TeamViewer con = teamViewerDAOImpl.findByID(id);
			tvDTO = teamViewerMapper.mapToDTO(con);
		}
		return tvDTO;
	}

	@Override
	public List<TeamViewerDTO> findByCriteria(TeamViewerDTO object) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Method will get all the TeamViewer objects out the database
	 * @return list as List<TeamViewerDTO>
	 */
	@Override
	public List<TeamViewerDTO> findAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
		TeamViewerMapper teamViewerMapper = (TeamViewerMapper) context.getBean("teamViewerMapper");
		/* get the different CustomFields out the database */
		List<TeamViewer> teamViewerdList = teamViewerDAOImpl.findAll();
		/* Create a List of CustomFieldDTO objects */
		List<TeamViewerDTO> teamViewerDTOList = new ArrayList<TeamViewerDTO>();
		/* check weather there are objects in the customFieldList */
		if(null != teamViewerdList){
			/* iterate the CustomField objects in the list and map the to DTO */ 
			for(TeamViewer teamViewer : teamViewerdList){
				teamViewerDTOList.add(teamViewerMapper.mapToDTO(teamViewer));
			}
		}else{
			teamViewerDTOList = null;
		}
		return teamViewerDTOList;
	}

}
