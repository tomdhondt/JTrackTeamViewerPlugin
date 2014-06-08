package be.jtrackteamviewerplugin.service.mapper;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.business.bean.TeamViewer;
import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;
import be.jtrackteamviewerplugin.business.data.PartnerDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerModeDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerQualityDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerDTO;

public class TeamViewerMapperTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewer teamViewerObject01 = (TeamViewer)context.getBean("teamViewerObject01");
	TeamViewerDTO teamViewerDTO01 = (TeamViewerDTO)context.getBean("teamViewerDTO01");
	TeamViewerMapper teamViewerMapper = (TeamViewerMapper)context.getBean("teamViewerMapper");
	TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
	TeamViewerModeDAOImpl teamViewerModeDAOImpl = (TeamViewerModeDAOImpl) context.getBean("teamViewerModeDAOImpl");
	TeamViewerQualityDAOImpl teamViewerQualityDAOImpl = (TeamViewerQualityDAOImpl) context.getBean("teamViewerQualityDAOImpl");
	PartnerDAOImpl partnerDAOImpl = (PartnerDAOImpl) context.getBean("partnerDAOImpl");
	Calendar calendar = new GregorianCalendar();
	
	@Before
	public void testBefore(){
		List<TeamViewer> listTeamViewer = teamViewerDAOImpl.findAll();
		List<Partner> listPartner = partnerDAOImpl.findAll();
		List<TeamViewerMode> listTeamViewerMode = teamViewerModeDAOImpl.findAll();
		List<TeamViewerQuality> listTeamViewerQuality = teamViewerQualityDAOImpl.findAll();
		/* remove the teamViewer */
		for(TeamViewer teamViewer : listTeamViewer){
			teamViewerDAOImpl.remove(teamViewer.getId());
		}
		/* remove the partner */
		for(Partner partner : listPartner){
			teamViewerDAOImpl.remove(partner.getId());
		}
		/* remove the teamViewerMode */
		for(TeamViewerMode mode : listTeamViewerMode){
			teamViewerModeDAOImpl.remove(mode.getId());
		}
		/* remove the teamViewerMode */
		for(TeamViewerQuality quality : listTeamViewerQuality){
			teamViewerQualityDAOImpl.remove(quality.getId());
		}
	}
	@Test
	public void testMapToObject() {
		/* check the basic settings */
		assertEquals("{2ff485a9-cf1d-4168-be45-211bffd5896}", teamViewerObject01.getUniqueID());
		assertEquals("123135143", teamViewerObject01.getAddress());
		assertEquals("7BD2E2544581638A1A0CD541AA97AE0F5DA88B8539234535430CAC2FD84AFADE15CC632699E6F361",teamViewerObject01.getPassword());
		assertNotNull(teamViewerObject01.getPartner());
		assertNotNull(teamViewerObject01.getTeamViewerMode());
		assertNotNull(teamViewerObject01.getTeamViewerQuality());
		/* persist the object to the database */
		teamViewerDAOImpl.persist(teamViewerObject01);
		assertTrue(0 < teamViewerDAOImpl.findAll().size());
		/* map to DTO */
		TeamViewerDTO teamViewerDTO = teamViewerMapper.mapToDTO(teamViewerObject01);
		assertEquals("123135143", teamViewerDTO.getAddress());
		assertEquals("{2ff485a9-cf1d-4168-be45-211bffd5896}", teamViewerDTO.getUniqueID());
		assertEquals(teamViewerDTO.getPartnerDTO().getName(), "tom d'hondt");
		assertEquals(teamViewerDTO.getPartnerDTO().getNotes(), "notes");
		assertEquals(teamViewerDTO.getPartnerDTO().getIsDeleted(),false);
		assertEquals(teamViewerDTO.getPartnerDTO().getIsFavorite(),false);
		/* map to Object */
		TeamViewer teamViewer = teamViewerMapper.mapToObject(teamViewerDTO);
		/* check equals */
		assertEquals(teamViewerObject01, teamViewer);
		assertEquals(teamViewerObject01.getPartner(), teamViewer.getPartner());
		assertEquals(teamViewerObject01.getTeamViewerMode(), teamViewer.getTeamViewerMode());
		assertEquals(teamViewerObject01.getTeamViewerQuality(), teamViewer.getTeamViewerQuality());
	}
}
