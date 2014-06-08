package be.jtrackteamviewerplugin.service.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;
import be.jtrackteamviewerplugin.business.data.TeamViewerConnectionMetaDataDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionMetaDataDTO;
import be.jtrackteamviewerplugin.service.mapper.TeamViewerConnectionMetaDataMapper;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerConnectionMetaDataManager implements IManagerDTO<TeamViewerConnectionMetaDataDTO>{
	/**
	 * Method will persist the object to the database 
	 * @param object as TeamViewerConnectionMetaDataDTO
	 * @return object as TeamViewerConnectionMetaDataDTO, null if not persisted
	 */
	@Override
	public TeamViewerConnectionMetaDataDTO persist(TeamViewerConnectionMetaDataDTO object) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl) context.getBean("teamViewerConnectionMetaDataDAOImpl");
		TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
		/* TeamViewerConnectionMetaDataDTO - create object to return */
		TeamViewerConnectionMetaDataDTO teamViewerConnectionMetaDataDTO = null;
		/* TeamViewerConnectionMetaDataDTO - check if the object isn't null */
		if(null != object){
			TeamViewerConnectionMetaData obj = teamViewerConnectionMetaDataMapper.mapToObject(object);
			TeamViewerConnectionMetaData objNew = teamViewerConnectionMetaDataDAOImpl.persist(obj);
			teamViewerConnectionMetaDataDTO = teamViewerConnectionMetaDataMapper.mapToDTO(objNew);
		}
		return teamViewerConnectionMetaDataDTO;
	}
	/**
	 * Method will update the object to the database 
	 * @param object as TeamViewerConnectionMetaDataDTO
	 * @return object as TeamViewerConnectionMetaDataDTO, null if not updated
	 */
	@Override
	public TeamViewerConnectionMetaDataDTO update(TeamViewerConnectionMetaDataDTO object) {
		return this.persist(object);
	}
	/**
	 * Method will remove the object out the database.
	 * @param object as TeamViewerConnectionMetaDataDTO
	 * @return success as boolean
	 */
	@Override
	public boolean remove(TeamViewerConnectionMetaDataDTO object) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl) context.getBean("teamViewerConnectionMetaDataDAOImpl");
		TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
		TeamViewerConnectionMetaData mappedObject = teamViewerConnectionMetaDataMapper.mapToObject(object);
		return teamViewerConnectionMetaDataDAOImpl.remove(mappedObject.getId());
	}
	/**
	 * Method will find a object in the database based on the id of the object we need to get
	 * @param ID as String
	 * @return object as TeamViewerConnectionMetaDataDTO
	 */
	@Override
	public TeamViewerConnectionMetaDataDTO findByID(String ID) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl) context.getBean("teamViewerConnectionMetaDataDAOImpl");
		TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
		/* TeamViewerConnectionMetaDataDTO - map id to Integer */
		int id = MappingUtil.mapStringToInt(ID);
		TeamViewerConnectionMetaDataDTO dto = null;
		/* TeamViewerConnectionMetaDataDTO - get the object out the database */
		if(-1 < id){
			TeamViewerConnectionMetaData tvMd = teamViewerConnectionMetaDataDAOImpl.findByID(id);
			dto = teamViewerConnectionMetaDataMapper.mapToDTO(tvMd);
		}
		return dto;
	}

	@Override
	public List<TeamViewerConnectionMetaDataDTO> findByCriteria(
			TeamViewerConnectionMetaDataDTO object) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Method will return all the TeamViewerConnectionMetaData objects in the database
	 * @return list as List<TeamViewerConnectionMetaDataDTO>
	 */
	@Override
	public List<TeamViewerConnectionMetaDataDTO> findAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl) context.getBean("teamViewerConnectionMetaDataDAOImpl");
		TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
		/* TeamViewerConnectionMetaData - get all the objects out the database */
		List<TeamViewerConnectionMetaData> listObject = teamViewerConnectionMetaDataDAOImpl.findAll();
		/* TeamViewerConnectionMetaData - map the found objects to dto */
		List<TeamViewerConnectionMetaDataDTO> listDTO = new ArrayList<TeamViewerConnectionMetaDataDTO>();
		for(TeamViewerConnectionMetaData object : listObject){
			listDTO.add(teamViewerConnectionMetaDataMapper.mapToDTO(object));
		}
		return listDTO;
	}
}
