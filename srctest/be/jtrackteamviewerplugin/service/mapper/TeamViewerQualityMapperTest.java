package be.jtrackteamviewerplugin.service.mapper;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;
import be.jtrackteamviewerplugin.service.dto.TeamViewerQualityDTO;

public class TeamViewerQualityMapperTest {
	private static TeamViewerQualityMapper teamViewerQualityMapper = new TeamViewerQualityMapper();
	@Test
	public void testMapToObject() {	
		TeamViewerQualityDTO teamViewerQualityDTO = new TeamViewerQualityDTO();
		teamViewerQualityDTO.setId("5214");
		teamViewerQualityDTO.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerQualityDTO.setName("Name of the teamviewermode");
		teamViewerQualityDTO.setSamName("SameName of the teamViewerMode");
		teamViewerQualityDTO.setNotes("Notes of the teamViewerMode");
		TeamViewerQuality object = teamViewerQualityMapper.mapToObject(teamViewerQualityDTO);
		TeamViewerQualityDTO dto = teamViewerQualityMapper.mapToDTO(object);
		assertNotNull(teamViewerQualityDTO);
		assertNotNull(object);
		assertNotNull(dto);
		assertEquals(dto, teamViewerQualityDTO);
	}
	@Test
	public void testMapToDTO() {
		TeamViewerQuality teamViewerQuality = new TeamViewerQuality();
		teamViewerQuality.setId(5214);
		teamViewerQuality.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerQuality.setName("Name of the teamviewermode");
		teamViewerQuality.setSamName("SameName of the teamViewerMode");
		teamViewerQuality.setNotes("Notes of the teamViewerMode");
		TeamViewerQualityDTO dto = teamViewerQualityMapper.mapToDTO(teamViewerQuality);
		TeamViewerQuality object = teamViewerQualityMapper.mapToObject(dto);
		assertNotNull(teamViewerQuality);
		assertNotNull(object);
		assertNotNull(dto);
		assertEquals(object, teamViewerQuality);
	}

}
