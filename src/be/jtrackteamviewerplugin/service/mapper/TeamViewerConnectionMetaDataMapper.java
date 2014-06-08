package be.jtrackteamviewerplugin.service.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;
import be.jtrackteamviewerplugin.business.data.TeamViewerConnectionDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionMetaDataDTO;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerConnectionMetaDataMapper extends AbstractMapper<TeamViewerConnectionMetaData, TeamViewerConnectionMetaDataDTO> {
	/**
	 * Method will map a DTO to object
	 * @param dto as TeamViewerConnectionMetaDataDTO
	 * @return object as TeamViewerConnectionMetaData
	 */	
	@Override
	public TeamViewerConnectionMetaData mapToObject(TeamViewerConnectionMetaDataDTO dto) {
		TeamViewerConnectionMetaData teamViewerConnectionMetaData = new TeamViewerConnectionMetaData();
		if(null != dto){
			/* get the CustomFieldMapper */
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			CustomFieldMapper customFieldMapper = (CustomFieldMapper) context.getBean("customFieldMapper");
			TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl) context.getBean("teamViewerConnectionDAOImpl");
			/* set the id */
			teamViewerConnectionMetaData.setId(MappingUtil.mapStringToInt(dto.getId()));
			/* set the UniqueID */
			teamViewerConnectionMetaData.setUniqueID(dto.getUniqueID());
			/* set the CustomField */
			teamViewerConnectionMetaData.setCustomField(customFieldMapper.mapToObject(dto.getCustomFieldDTO()));
			/* set the value */
			teamViewerConnectionMetaData.setValue(dto.getValue());
			/* Set the TeamViewerConnection */
			TeamViewerConnection teamViewerConnection = teamViewerConnectionDAOImpl.findByID(MappingUtil.mapStringToInt(dto.getTeamViewerConnectionID()));
			teamViewerConnectionMetaData.setTeamViewerConnection(teamViewerConnection);
		}else{
			teamViewerConnectionMetaData = null;
		}
		return teamViewerConnectionMetaData;
	}
	/**
	 * Method will map a object to a DTO
	 * @param object as TeamViewerConnectionMetaData
	 * @return dto as TeamViewerConnectionMetaDataDTO
	 */
	@Override
	public TeamViewerConnectionMetaDataDTO mapToDTO(TeamViewerConnectionMetaData object) {
		TeamViewerConnectionMetaDataDTO teamViewerConnectionMetaDataDTO = new TeamViewerConnectionMetaDataDTO();
		if(null != object){
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			CustomFieldMapper customFieldMapper = (CustomFieldMapper) context.getBean("customFieldMapper");
			/* set the id */
			teamViewerConnectionMetaDataDTO.setId(MappingUtil.mapIntToString(object.getId()));
			/* set the uniqueID */
			teamViewerConnectionMetaDataDTO.setUniqueID(object.getUniqueID());
			/* Map the Customfield to CustomFieldDTO */
			teamViewerConnectionMetaDataDTO.setCustomFieldDTO(customFieldMapper.mapToDTO(object.getCustomField()));
			/*set the TeamViewerMetaDataOTO value */
			teamViewerConnectionMetaDataDTO.setValue(object.getValue());
			/* Set the TeamViewerConnectionID */
			if(null != object.getTeamViewerConnection()){
				teamViewerConnectionMetaDataDTO.setTeamViewerConnectionID(MappingUtil.mapIntToString(object.getTeamViewerConnection().getId()));
				/* Set the TeamViewerConnection Windows User */
				if(null != object.getTeamViewerConnection().getWindowsUser()){
					teamViewerConnectionMetaDataDTO.setTeamViewerConnectionWindowsUser(object.getTeamViewerConnection().getWindowsUser());
				}
			}

		}else{
			teamViewerConnectionMetaDataDTO = null;
		}
		return teamViewerConnectionMetaDataDTO;
	}

}
