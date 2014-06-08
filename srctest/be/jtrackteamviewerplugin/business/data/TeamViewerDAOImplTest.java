package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.business.bean.TeamViewer;
import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;

public class TeamViewerDAOImplTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl)context.getBean("teamViewerDAOImpl");
	TeamViewerModeDAOImpl teamViewerModeDAOImpl = (TeamViewerModeDAOImpl)context.getBean("teamViewerModeDAOImpl");
	TeamViewerQualityDAOImpl teamViewerQualityDAOImpl = (TeamViewerQualityDAOImpl)context.getBean("teamViewerQualityDAOImpl");
	TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl)context.getBean("teamViewerConnectionDAOImpl");
	PartnerDAOImpl partnerDAOImpl = (PartnerDAOImpl)context.getBean("partnerDAOImpl");
	TeamViewer teamViewerObject01 = (TeamViewer)context.getBean("teamViewerObject01");
	Partner partnerObject01 = (Partner)context.getBean("partnerObject01");
	TeamViewerMode teamViewerModeObject01 = (TeamViewerMode)context.getBean("teamViewerModeObject01");
	TeamViewerQuality teamViewerQualityObject01 = (TeamViewerQuality) context.getBean("teamViewerQualityObject01");
	
	@Before
	public void beforeRun(){
		/* check 1 : persist a null TeamViewer */
		assertNull(this.teamViewerDAOImpl.persist(null));
		/* check 2 : persist a TeamViewer */
		int count = this.teamViewerDAOImpl.findAll().size();
		assertTrue(-1 < count);
		/* check 3 : find in the database */
		this.teamViewerDAOImpl.persist(teamViewerObject01);
		assertTrue(count < this.teamViewerDAOImpl.findAll().size());		
		/* check 4 : is it in the database */
		assertNotNull(this.teamViewerDAOImpl.findByCriteria(teamViewerObject01));
	}
	@After
	public void afterRun(){
		this.teamViewerDAOImpl.remove(teamViewerObject01.getId());
		this.teamViewerModeDAOImpl.remove(teamViewerObject01.getTeamViewerMode().getId());
		this.teamViewerQualityDAOImpl.remove(teamViewerObject01.getTeamViewerQuality().getId());
		this.partnerDAOImpl.remove(teamViewerObject01.getPartner().getId());
		assertTrue(0 == this.teamViewerDAOImpl.findAll().size());
	}
	@Test
	public void testFindByID() {
		TeamViewer teamViewer01 = teamViewerDAOImpl.findByID(teamViewerObject01.getId());
		assertNotEquals(null,teamViewer01);
		assertEquals("{2ff485a9-cf1d-4168-be45-211bffd5896}", teamViewer01.getUniqueID());
		assertEquals("123135143",teamViewer01.getAddress());
		assertEquals("7BD2E2544581638A1A0CD541AA97AE0F5DA88B8539234535430CAC2FD84AFADE15CC632699E6F361",teamViewer01.getPassword());
		assertEquals(teamViewerModeObject01, teamViewer01.getTeamViewerMode());
		assertEquals(teamViewerQualityObject01,teamViewer01.getTeamViewerQuality());
		assertEquals(partnerObject01,teamViewer01.getPartner());
	}
	@Test
	public void testFindAll(){
		List<TeamViewer> listTeamViewer = teamViewerDAOImpl.findAll();
		assertTrue( -1 < listTeamViewer.size());
		assertNotNull(listTeamViewer.get(0).getAddress());
		assertEquals("{2ff485a9-cf1d-4168-be45-211bffd5896}", listTeamViewer.get(0).getUniqueID());
		assertEquals("123135143", listTeamViewer.get(0).getAddress());
		assertEquals("7BD2E2544581638A1A0CD541AA97AE0F5DA88B8539234535430CAC2FD84AFADE15CC632699E6F361",listTeamViewer.get(0).getPassword());
		assertEquals(teamViewerModeObject01, listTeamViewer.get(0).getTeamViewerMode());
		assertEquals(teamViewerQualityObject01,listTeamViewer.get(0).getTeamViewerQuality());
		assertEquals(partnerObject01,listTeamViewer.get(0).getPartner());
	}
	@Test
	public void testFindByCriteria(){
		/* Persist the TeamViewer */
		this.teamViewerDAOImpl.persist(teamViewerObject01);
		/* check 1 */
		List<TeamViewer> list = teamViewerDAOImpl.findByCriteria(null);
		assertNull(list);
		/* check 2*/
		list = teamViewerDAOImpl.findByCriteria(teamViewerObject01);
		assertTrue(list.size() == 1);
	}
	@Test
	public void TestPersist(){
		/* check 1 : persist a null TeamViewer */
		assertNull(this.teamViewerDAOImpl.persist(null));
		/* check 2 : persist a TeamViewer */
		int count = this.teamViewerDAOImpl.findAll().size();
		assertTrue(-1 < count);
		/* check 3 : find in the database */
		this.teamViewerObject01.setPartner(this.partnerObject01);
		this.teamViewerObject01.setTeamViewerMode(this.teamViewerModeObject01);
		this.teamViewerObject01.setTeamViewerQuality(this.teamViewerQualityObject01);
		TeamViewer teamViewer = this.teamViewerDAOImpl.persist(teamViewerObject01);
		assertTrue(count == this.teamViewerDAOImpl.findAll().size());
		/* check 4 : is it in the database */
		assertNotNull(this.teamViewerDAOImpl.findByCriteria(teamViewerObject01));
		assertEquals("{2ff485a9-cf1d-4168-be45-211bffd5896}", teamViewer.getUniqueID());
		assertEquals("123135143",teamViewer.getAddress());
		assertEquals("7BD2E2544581638A1A0CD541AA97AE0F5DA88B8539234535430CAC2FD84AFADE15CC632699E6F361",teamViewer.getPassword());
		assertEquals(teamViewerModeObject01, teamViewer.getTeamViewerMode());
		assertEquals(teamViewerQualityObject01,teamViewer.getTeamViewerQuality());
		assertEquals(partnerObject01,teamViewer.getPartner());
	}
}
