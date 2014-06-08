package be.jtrackteamviewerplugin.service.manager;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.business.bean.TeamViewer;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;
import be.jtrackteamviewerplugin.business.data.TeamViewerDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerDTO;

public class TeamViewerManagerTest {
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	@Before
	public void testBefore(){
		/* delete the TeamViewer out the database */
		TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
		List<TeamViewer> list = teamViewerDAOImpl.findAll();
		for(TeamViewer teamViewer : list){
			teamViewerDAOImpl.remove(teamViewer.getId());
		}
	}
	@Test
	public void testFindAll() {
		TeamViewerManager teamViewerManager = (TeamViewerManager) context.getBean("teamViewerManager");
		TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
		Partner partner = (Partner) context.getBean("partnerObject01");
		TeamViewerMode teamViewerMode = (TeamViewerMode) context.getBean("teamViewerModeObject01");
		TeamViewerQuality teamViewerQuality = (TeamViewerQuality) context.getBean("teamViewerQualityObject01");
		TeamViewerConnection teamViewerConnection = (TeamViewerConnection) context.getBean("teamViewerConnectionObject01");
		/* create TeamViewer */
		TeamViewer teamViewer = new TeamViewer();
		teamViewer.setAddress("258963147");
		teamViewer.setPartner(partner);
		teamViewer.setPassword("pass");
		teamViewer.setTeamViewerMode(teamViewerMode);
		teamViewer.setTeamViewerQuality(teamViewerQuality);
		teamViewer.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewer.getTeamViewerConnectionList().add(teamViewerConnection);
		/* persist TeamViewer */
		TeamViewer teamViewerNew = teamViewerDAOImpl.persist(teamViewer);
		TeamViewer teamViewerFound = teamViewerDAOImpl.findByID(teamViewerNew.getId());
		assertEquals(teamViewerNew, teamViewerFound);
		/* get the objects out the database */
		List<TeamViewerDTO> teamViewerDTOlist = teamViewerManager.findAll();
		for(TeamViewerDTO dto : teamViewerDTOlist){
			System.out.println(dto.toString());
		}
		/* check the database */
		assertNotNull(teamViewerDTOlist);
		assertTrue(teamViewerDTOlist.size() > 0);
	}
}
