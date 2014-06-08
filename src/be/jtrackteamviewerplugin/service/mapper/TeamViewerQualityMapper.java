package be.jtrackteamviewerplugin.service.mapper;

import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;
import be.jtrackteamviewerplugin.service.dto.TeamViewerQualityDTO;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerQualityMapper extends AbstractMapper<TeamViewerQuality, TeamViewerQualityDTO> {
	/**
	 * Method will map a DTO to a Object
	 * @param dto as teamViewerQualityDTO
	 * @return object as TeamViewerQuality
	 */
	@Override
	public TeamViewerQuality mapToObject(TeamViewerQualityDTO dto) {
		TeamViewerQuality teamViewerQuality = new TeamViewerQuality();
		if(null != dto){
		try{
			teamViewerQuality.setId(MappingUtil.mapStringToInt(dto.getId()));
		}catch(Exception eXp){
			teamViewerQuality.setId(0);
		}
		teamViewerQuality.setUniqueID(dto.getUniqueID());
		teamViewerQuality.setName(dto.getName());
		teamViewerQuality.setSamName(dto.getSamName());
		teamViewerQuality.setNotes(dto.getNotes());
		}else{
			teamViewerQuality = null;
		}
		return teamViewerQuality;
	}
	/**
	 * Method will map a Object to a DTO
	 * @return dto as teamViewerQualityDTO
	 * @param object as TeamViewerQuality
	 */
	@Override
	public TeamViewerQualityDTO mapToDTO(TeamViewerQuality object) {
		TeamViewerQualityDTO teamViewerQualityDTO = new TeamViewerQualityDTO();
		if(null != object){
			teamViewerQualityDTO.setId(MappingUtil.mapIntToString(object.getId()));
			teamViewerQualityDTO.setUniqueID(object.getUniqueID());
			teamViewerQualityDTO.setName(object.getName());
			teamViewerQualityDTO.setSamName(object.getSamName());
			teamViewerQualityDTO.setNotes(object.getNotes());			
		}else{
			teamViewerQualityDTO = null;
		}
		return teamViewerQualityDTO;
	}
}
