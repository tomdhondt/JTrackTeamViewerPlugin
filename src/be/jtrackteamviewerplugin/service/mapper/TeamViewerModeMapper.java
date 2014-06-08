package be.jtrackteamviewerplugin.service.mapper;

import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
import be.jtrackteamviewerplugin.service.dto.TeamViewerModeDTO;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerModeMapper extends AbstractMapper<TeamViewerMode, TeamViewerModeDTO> {
	/**
	 * Method will map a DTO to a Object
	 * @param dto as TeamViewerModeDTO
	 * @return object as TeamViewerMode
	 */
	@Override
	public TeamViewerMode mapToObject(TeamViewerModeDTO dto) {
		TeamViewerMode teamViewerMode = new TeamViewerMode();
		if(null != dto){
		try{
			teamViewerMode.setId(MappingUtil.mapStringToInt(dto.getId()));
		}catch(Exception eXp){
			teamViewerMode.setId(0);
		}
		teamViewerMode.setUniqueID(dto.getUniqueID());
		teamViewerMode.setName(dto.getName());
		teamViewerMode.setSamName(dto.getSamName());
		teamViewerMode.setNotes(dto.getNotes());
		}else{
			teamViewerMode = null;
		}
		return teamViewerMode;
	}
	/**
	 * Method will map a Object to a DTO
	 * @return dto as TeamViewerModeDTO
	 * @param object as TeamViewerMode
	 */
	@Override
	public TeamViewerModeDTO mapToDTO(TeamViewerMode object) {
		TeamViewerModeDTO teamViewerModeDTO = new TeamViewerModeDTO();
		if(null != object){
			teamViewerModeDTO.setId(MappingUtil.mapIntToString(object.getId()));
			teamViewerModeDTO.setUniqueID(object.getUniqueID());
			teamViewerModeDTO.setName(object.getName());
			teamViewerModeDTO.setSamName(object.getSamName());
			teamViewerModeDTO.setNotes(object.getNotes());			
		}else{
			teamViewerModeDTO = null;
		}
		return teamViewerModeDTO;
	}
}
