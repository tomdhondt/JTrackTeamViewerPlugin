package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;

public class TeamViewerQualityDAOImplTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerQualityDAOImpl teamViewerQualityDAOImpl = (TeamViewerQualityDAOImpl)context.getBean("teamViewerQualityDAOImpl");
	TeamViewerQuality teamViewerQualityObject01 = (TeamViewerQuality)context.getBean("teamViewerQualityObject01");
	
	@Test
	public void testPersist() {
		/* check the size of the table */
		assertTrue(0 == this.teamViewerQualityDAOImpl.findAll().size());
		/* Try to persist a null object */
		assertNull(this.teamViewerQualityDAOImpl.persist(null));
		TeamViewerQuality tvQuality01 = new TeamViewerQuality();
		TeamViewerQuality tvQuality01New = this.teamViewerQualityDAOImpl.persist(tvQuality01);
		assertNotNull(tvQuality01New);
		assertTrue(1 == this.teamViewerQualityDAOImpl.findAll().size());	
		/* persist a new object to the database */
		TeamViewerQuality tvQuality02 = this.teamViewerQualityDAOImpl.persist(this.teamViewerQualityObject01);
		assertNotNull(tvQuality02);
		assertTrue(2 == this.teamViewerQualityDAOImpl.findAll().size());
		assertTrue(this.teamViewerQualityDAOImpl.remove(tvQuality01.getId()));
		assertTrue(1 == this.teamViewerQualityDAOImpl.findAll().size());
		assertTrue(this.teamViewerQualityDAOImpl.remove(tvQuality02.getId()));
		assertTrue(0 == this.teamViewerQualityDAOImpl.findAll().size());
	}

	@Test
	public void testFindByCriteria() {
		/* Persist a TeamViewerMode in the database */
		TeamViewerQuality tvQuality01 = new TeamViewerQuality();
		tvQuality01.setNotes("Notes TeamViewerQuality 01");
		tvQuality01.setSamName("SamName TeamViewerQuality 01");
		tvQuality01.setName("tvMode01");
		TeamViewerQuality tvqSaved = this.teamViewerQualityDAOImpl.persist(tvQuality01);
		assertNotNull(tvqSaved);
		/* create a new TeamViewerMode with the same criteria to look on*/
		TeamViewerQuality tvmCriteria = new TeamViewerQuality();
		tvmCriteria.setName("tvMode01");
		List<TeamViewerQuality> listFound = this.teamViewerQualityDAOImpl.findByCriteria(tvmCriteria);
		assertNotNull(listFound);
		boolean found = false;
		for(TeamViewerQuality tvm : listFound){
			if(tvm.equals(tvQuality01)){
				found = true;
			}
		}
		assertTrue(found);
		assertTrue(this.teamViewerQualityDAOImpl.remove(tvqSaved.getId()));
	}

	@Test
	public void testUpdate() {
		/* Persist the object in the database */
		TeamViewerQuality tvQuality01Persist = this.teamViewerQualityDAOImpl.persist(this.teamViewerQualityObject01);
		assertNotNull(tvQuality01Persist);
		tvQuality01Persist.setName("New Name");
		tvQuality01Persist.setNotes("New Notes");
		tvQuality01Persist.setSamName("New SamName");
		TeamViewerQuality tvQuality01Update = this.teamViewerQualityDAOImpl.update(tvQuality01Persist);
		assertNotNull(tvQuality01Update);
		assertEquals(tvQuality01Update, tvQuality01Persist);
		System.out.println(tvQuality01Update);
		assertEquals("New Name",tvQuality01Update.getName());
		assertEquals("New Notes",tvQuality01Update.getNotes());
		assertEquals("New SamName",tvQuality01Update.getSamName());
		assertTrue(this.teamViewerQualityDAOImpl.remove(tvQuality01Update.getId()));
		
	}

}
