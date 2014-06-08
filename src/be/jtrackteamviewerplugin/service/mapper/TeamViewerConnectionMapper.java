/**
 * 
 */
package be.jtrackteamviewerplugin.service.mapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;
import be.jtrackteamviewerplugin.business.data.TeamViewerDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionDTO;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionMetaDataDTO;
import be.jtrackteamviewerplugin.util.DateUtil;
import be.jtrackteamviewerplugin.util.MappingUtil;

/**
 * Class TeamViewerConnectionMapper
 * @author tom.dhondt - created at : 16-dec.-2013
 *
 */
public class TeamViewerConnectionMapper extends AbstractMapper<TeamViewerConnection, TeamViewerConnectionDTO> {
	/* instance members */
	/**
	 * Method will map a DTO to a Object
	 * @param dto as TeamViewerConnectionDTO
	 * @return object as TeamViewerConnection
	 */
	@Override
	public TeamViewerConnection mapToObject(TeamViewerConnectionDTO dto) {
		TeamViewerConnection teamViewerConnection = new TeamViewerConnection();
		if(null != dto){
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
			TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
			/* set the id */
			try{
				teamViewerConnection.setId(MappingUtil.mapStringToInt(dto.getId()));
			}catch(NumberFormatException nFe){
				teamViewerConnection.setId(0);
			}
			/* set the unique id */
			teamViewerConnection.setUniqueID(dto.getUniqueID());
			/* set the start date */
			try {
				teamViewerConnection.setStart(MappingUtil.mapStringToDate(dto.getStart(), null));
			} catch (NullPointerException e) {
				if(null == teamViewerConnection.getStart()){
					teamViewerConnection.setStart(null);
				}
			} catch (UnsupportedOperationException e) {
				if(null == teamViewerConnection.getStart()){
					teamViewerConnection.setStart(null);
				}
			} catch (IllegalArgumentException e) {
				if(null == teamViewerConnection.getStart()){
					teamViewerConnection.setStart(null);
				}
			}
			/* Calculate the date depending on the hour, minute, second in the DTO */
			if(null != teamViewerConnection.getStart()){
				int hour = MappingUtil.mapStringToInt(dto.getHour());
				int minutes = MappingUtil.mapStringToInt(dto.getMinutes());
				int seconds = MappingUtil.mapStringToInt(dto.getSeconds());
				long hourInMilSec = hour * 60 * 60 * 1000;
				long minutesInMilSec = minutes * 60 * 1000;
				long secondsInMilSec = seconds * 1000;
				long total = hourInMilSec + minutesInMilSec + secondsInMilSec;
				teamViewerConnection.setFinish(DateUtil.dateCalcMilliseconds(teamViewerConnection.getStart(),total));
			}else{
				teamViewerConnection.setFinish(null);
			}
			/* set the notes */
			teamViewerConnection.setNotes(dto.getNotes());
			/* set the IsDeleted */
			teamViewerConnection.setIsDeleted(dto.getIsDeleted());
			/* set the WindowsUser */
			teamViewerConnection.setWindowsUser(dto.getWindowsUser());
			/* set the Price */
			try{
				teamViewerConnection.setPrice(MappingUtil.mapStringToBigDecimal(dto.getPrice()));
			}catch(NumberFormatException nFe){
				teamViewerConnection.setPrice(null);
			}
			try{
				teamViewerConnection.setHash(MappingUtil.mapStringToInt(dto.getHash()));
			}catch(NumberFormatException nFe){
				teamViewerConnection.setHash(0);
			}
			/* get the TeamViewer Object out the database */
			try{
				int teamViewerID = MappingUtil.mapStringToInt(dto.getTeamViewerID());
				teamViewerConnection.setTeamViewer(teamViewerDAOImpl.findByID(teamViewerID));
			}catch(NumberFormatException nFe){
				teamViewerConnection.setTeamViewer(null);
			}
			/* Set the bill */
			teamViewerConnection.setBill(dto.getBill());
			/* Set the TeamViewerMetaData */
			for(TeamViewerConnectionMetaDataDTO tvcmdDTO : dto.getTeamViewerConnectionMetaDataList()){
				teamViewerConnection.getTeamViewerConnectionMetaDataList().add(teamViewerConnectionMetaDataMapper.mapToObject(tvcmdDTO));
			}
			/* start - end date */
			if(null != dto.getStartDate()){
				teamViewerConnection.setStart(dto.getStartDate());
			}
			if(null != dto.getEndDate()){
				teamViewerConnection.setStart(dto.getEndDate());
			}
		}else{
			teamViewerConnection = null;
		}
		return teamViewerConnection;
	}
	/**
	 * Method will map a Object to a DTO
	 * @param object as TeamViewerConnection
	 * @return dto as TeamViewerConnectionDTO
	 */
	@Override
	public TeamViewerConnectionDTO mapToDTO(TeamViewerConnection object) {
		TeamViewerConnectionDTO teamViewerConnectionDTO = new TeamViewerConnectionDTO();
		if(null != object){
			ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
			teamViewerConnectionDTO.setUniqueID(object.getUniqueID());
			teamViewerConnectionDTO.setStart(MappingUtil.mapDateToString(object.getStart(),null));
			teamViewerConnectionDTO.setFinish(MappingUtil.mapDateToString(object.getFinish(),null));
			teamViewerConnectionDTO.setNotes(object.getNotes());
			teamViewerConnectionDTO.setIsDeleted(object.getIsDeleted());
			teamViewerConnectionDTO.setWindowsUser(object.getWindowsUser());
			teamViewerConnectionDTO.setBill(object.getBill());
			/* Set the Id */
			try{
				String test = MappingUtil.mapIntToString(object.getId());
				teamViewerConnectionDTO.setId(test);	
			}catch(Exception eXp){
				teamViewerConnectionDTO.setId("0");
			}
			/* calculate the hour, minute, second */
			if(null !=object.getStart()){
				if(null!=object.getFinish()){
					/* calculate hour, minutes, seconds */
					long hour = DateUtil.getStandardHours(DateUtil.calcDuration(object.getStart(), object.getFinish()));
					long minutes = DateUtil.getStandardMinutes(DateUtil.calcDuration(object.getStart(), object.getFinish()));
					long seconds = DateUtil.getStandardSeconds(DateUtil.calcDuration(object.getStart(), object.getFinish()));
					teamViewerConnectionDTO.setHour(Long.toString(hour));
					teamViewerConnectionDTO.setMinutes(Long.toString(minutes - (hour * 60)));
					teamViewerConnectionDTO.setSeconds(Long.toString(seconds - (minutes * 3600)));
				}else{
					teamViewerConnectionDTO.setHour("0");
					teamViewerConnectionDTO.setMinutes("0");
					teamViewerConnectionDTO.setSeconds("0");
				}
			}else{
				teamViewerConnectionDTO.setHour("0");
				teamViewerConnectionDTO.setMinutes("0");
				teamViewerConnectionDTO.setSeconds("0");
			}
			/* set the price */
			try {
				teamViewerConnectionDTO.setPrice(MappingUtil.mapBigDecimalToString(object.getPrice()));
			} catch (Exception e) {
				teamViewerConnectionDTO.setPrice(null);
			}
			/* set the hash */
			try{
				teamViewerConnectionDTO.setHash(MappingUtil.mapIntToString(object.getHash()));
			}catch(Exception eXp){
				teamViewerConnectionDTO.setId("0");
			}
			/* Set the TeamViewer properties */
			if(null != object.getTeamViewer()){
				try{
					teamViewerConnectionDTO.setTeamViewerAddress(object.getTeamViewer().getAddress());
				}catch(Exception eXp){
					teamViewerConnectionDTO.setTeamViewerAddress("");
				}
				try{
					teamViewerConnectionDTO.setTeamViewerID(MappingUtil.mapIntToString(object.getTeamViewer().getId()));
				}catch(Exception eXp){
					teamViewerConnectionDTO.setTeamViewerID("");
				}
			}
			try{
				/* convert TeamviewerConnectionMetaData to TeamviewerConnectionMetaDataDTO */
				TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
				for(TeamViewerConnectionMetaData teamViewerConnectionMetaData : object.getTeamViewerConnectionMetaDataList()){
					TeamViewerConnectionMetaDataDTO dto = teamViewerConnectionMetaDataMapper.mapToDTO(teamViewerConnectionMetaData);
					teamViewerConnectionDTO.getTeamViewerConnectionMetaDataList().add(dto);
				}
			}catch(Exception eXp){
				/* there isn't any meta data in the database */
			}
			/* start - end date */
			if(null != object.getStart()){
				teamViewerConnectionDTO.setStartDate(object.getStart());
			}
			if(null != object.getFinish()){
				teamViewerConnectionDTO.setStartDate(object.getFinish());
			}
		}else{
			teamViewerConnectionDTO = null;
		}
		return teamViewerConnectionDTO;
	}

}
