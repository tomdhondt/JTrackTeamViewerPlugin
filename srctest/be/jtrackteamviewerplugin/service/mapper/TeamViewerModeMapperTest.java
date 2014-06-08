package be.jtrackteamviewerplugin.service.mapper;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
import be.jtrackteamviewerplugin.service.dto.TeamViewerModeDTO;

public class TeamViewerModeMapperTest {
	private static TeamViewerModeMapper teamViewerModeMapper = new TeamViewerModeMapper();
	@Test
	public void testMapToObject() {	
		TeamViewerModeDTO teamViewerModeDTO = new TeamViewerModeDTO();
		teamViewerModeDTO.setId("5214");
		teamViewerModeDTO.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerModeDTO.setName("Name of the teamviewermode");
		teamViewerModeDTO.setSamName("SameName of the teamViewerMode");
		teamViewerModeDTO.setNotes("Notes of the teamViewerMode");
		TeamViewerMode object = teamViewerModeMapper.mapToObject(teamViewerModeDTO);
		TeamViewerModeDTO dto = teamViewerModeMapper.mapToDTO(object);
		assertNotNull(teamViewerModeDTO);
		assertNotNull(object);
		assertNotNull(dto);
		assertEquals(dto, teamViewerModeDTO);
	}
	@Test
	public void testMapToDTO() {
		TeamViewerMode teamViewerMode = new TeamViewerMode();
		teamViewerMode.setId(5214);
		teamViewerMode.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerMode.setName("Name of the teamviewermode");
		teamViewerMode.setSamName("SameName of the teamViewerMode");
		teamViewerMode.setNotes("Notes of the teamViewerMode");
		TeamViewerModeDTO dto = teamViewerModeMapper.mapToDTO(teamViewerMode);
		TeamViewerMode object = teamViewerModeMapper.mapToObject(dto);
		assertNotNull(teamViewerMode);
		assertNotNull(object);
		assertNotNull(dto);
		assertEquals(object, teamViewerMode);
	}

}
