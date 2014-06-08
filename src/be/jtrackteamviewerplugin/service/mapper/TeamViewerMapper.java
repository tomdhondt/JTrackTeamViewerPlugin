package be.jtrackteamviewerplugin.service.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewer;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.data.PartnerDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerModeDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerQualityDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionDTO;
import be.jtrackteamviewerplugin.service.dto.TeamViewerDTO;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerMapper extends AbstractMapper<TeamViewer, TeamViewerDTO> {
	/* instance members */
	
	/**
	 * Method will map a DTO to a Object
	 * @param dto as TeamViewerDTO
	 * @return object as TeamViewer
	 */
	@Override
	public TeamViewer mapToObject(TeamViewerDTO dto) {
		TeamViewer teamViewer = new TeamViewer();
		if(null != dto){
			teamViewer = new TeamViewer();
			try{
				teamViewer.setId(MappingUtil.mapStringToInt(dto.getId()));
			}catch(NumberFormatException nFe){
				teamViewer.setId(0);
			}
			teamViewer.setUniqueID(dto.getUniqueID());
			teamViewer.setPassword(dto.getPassword());
			teamViewer.setAddress(dto.getAddress());
			/* 
			 * Set the partner of the TeamViewer 
			 */
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			PartnerDAOImpl partnerDAOImpl = (PartnerDAOImpl) context.getBean("partnerDAOImpl");
			try{
				int partnerID =  MappingUtil.mapStringToInt(dto.getPartnerID());
				 teamViewer.setPartner(partnerDAOImpl.findByID(partnerID));
			}catch(Exception nFe){
				teamViewer.setPartner(null);
			}
			/*
			 * Set the TeamViewerMode
			 */
			TeamViewerModeDAOImpl teamViewerModeDAOImpl = (TeamViewerModeDAOImpl) context.getBean("teamViewerModeDAOImpl");
			try{
				int teamViewerModeID =  MappingUtil.mapStringToInt(dto.getTeamViewerModeID());
				teamViewer.setTeamViewerMode(teamViewerModeDAOImpl.findByID(teamViewerModeID));
			}catch(NumberFormatException nFe){
				teamViewer.setTeamViewerMode(null);
			}
			/* 
			 * Set the TeamViewerQuality
			 */
			TeamViewerQualityDAOImpl teamViewerQualityDAOImpl = (TeamViewerQualityDAOImpl) context.getBean("teamViewerQualityDAOImpl");
			try{
				int teamViewerQualityID =  MappingUtil.mapStringToInt(dto.getTeamViewerQualityID());
				teamViewer.setTeamViewerQuality(teamViewerQualityDAOImpl.findByID(teamViewerQualityID));
			}catch(NumberFormatException nFe){
				teamViewer.setTeamViewerQuality(null);
			}
			/*
			 * Set TeamViewerConnections 
			 */
			TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper) context.getBean("teamViewerConnectionMapper");
			for(TeamViewerConnectionDTO teamViewerConnectionDTO : dto.getTeamViewerConnectionList()){
				TeamViewerConnection tvc = teamViewerConnectionMapper.mapToObject(teamViewerConnectionDTO);
				teamViewer.getTeamViewerConnectionList().add(tvc);
			}
		}else{
			teamViewer = null;
		}
		return teamViewer;
	}
	/**
	 * Method will map a object to a DTO
	 * @param object as TeamViewer
	 * @return dto as TeamViewerDTO
	 */
	@Override
	public TeamViewerDTO mapToDTO(TeamViewer object) {
		TeamViewerDTO teamViewerDTO = new TeamViewerDTO();
		if(null != object){
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			PartnerMapper partnerMapper = (PartnerMapper) context.getBean("partnerMapper");
			teamViewerDTO.setId(MappingUtil.mapIntToString(object.getId()));
			teamViewerDTO.setUniqueID(object.getUniqueID());
			teamViewerDTO.setAddress(object.getAddress());
			teamViewerDTO.setPassword(object.getPassword());
			/*
			 * Set the Partner properties 
			 */
			if(null != object.getPartner().getName()){
				teamViewerDTO.setPartnerName(object.getPartner().getName());
			}
			if(null != object.getPartner()){
				teamViewerDTO.setPartnerDTO(partnerMapper.mapToDTO(object.getPartner()));
				teamViewerDTO.setPartnerID(MappingUtil.mapIntToString(object.getPartner().getId()));
			}
			/*
			 * Set the TeamViewerMode properties 
			 */
			if(null != object.getTeamViewerMode().getName()){
				teamViewerDTO.setTeamViewerModeName(object.getTeamViewerMode().getName());
			}
			if(null != object.getTeamViewerMode()){
				teamViewerDTO.setTeamViewerModeID(MappingUtil.mapIntToString(object.getTeamViewerMode().getId()));
			}
			/*
			 * Set the TeamViewerQuality properties 
			 */
			if(null != object.getTeamViewerQuality().getName()){
				teamViewerDTO.setTeamViewerQualityName(object.getTeamViewerQuality().getName());
			}
			if(null != object.getTeamViewerQuality()){
				teamViewerDTO.setTeamViewerQualityID(MappingUtil.mapIntToString(object.getTeamViewerQuality().getId()));
			}
			/*
			 * Set the TeamViewerConnectionDTO properties 
			 */
			TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper) context.getBean("teamViewerConnectionMapper");
			/* check that there are TeamViewerConnections */
			try{
				for(TeamViewerConnection tvc : object.getTeamViewerConnectionList()){
					teamViewerConnectionMapper.mapToDTO(tvc);
					teamViewerDTO.getTeamViewerConnectionList().add(teamViewerConnectionMapper.mapToDTO(tvc));
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return teamViewerDTO;
	}
}
