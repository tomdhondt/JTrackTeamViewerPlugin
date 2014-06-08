package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;

public class TeamViewerModeDAOImplTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerModeDAOImpl teamViewerModeDAOImpl = (TeamViewerModeDAOImpl)context.getBean("teamViewerModeDAOImpl");
	TeamViewerMode teamViewerModeObject01 = (TeamViewerMode)context.getBean("teamViewerModeObject01");
	
	@Test
	public void testPersist() {
		/* check the size of the table */
		assertTrue(0 == this.teamViewerModeDAOImpl.findAll().size());
		/* Try to persist a null object */
		assertNull(this.teamViewerModeDAOImpl.persist(null));
		TeamViewerMode tvMode01 = new TeamViewerMode();
		TeamViewerMode tvMode01New = this.teamViewerModeDAOImpl.persist(tvMode01);
		assertNotNull(tvMode01New);
		assertTrue(1 == this.teamViewerModeDAOImpl.findAll().size());	
		/* persist a new object to the database */
		TeamViewerMode tvMode02 = this.teamViewerModeDAOImpl.persist(this.teamViewerModeObject01);
		assertNotNull(tvMode02);
		assertTrue(2 == this.teamViewerModeDAOImpl.findAll().size());
		assertTrue(this.teamViewerModeDAOImpl.remove(tvMode01.getId()));
		assertTrue(1 == this.teamViewerModeDAOImpl.findAll().size());
		assertTrue(this.teamViewerModeDAOImpl.remove(tvMode02.getId()));
		assertTrue(0 == this.teamViewerModeDAOImpl.findAll().size());
	}
	@Test
	public void testFindByCriteria() {
		/* Persist a TeamViewerMode in the database */
		TeamViewerMode tvMode01 = new TeamViewerMode();
		tvMode01.setNotes("Notes TeamViewerMode 01");
		tvMode01.setSamName("SamName TeamViewerMode 01");
		tvMode01.setName("tvMode01");
		TeamViewerMode tvmSaved = this.teamViewerModeDAOImpl.persist(tvMode01);
		assertNotNull(tvmSaved);
		/* create a new TeamViewerMode with the same criteria to look on*/
		TeamViewerMode tvmCriteria = new TeamViewerMode();
		tvmCriteria.setName("tvMode01");
		List<TeamViewerMode> listFound = this.teamViewerModeDAOImpl.findByCriteria(tvmCriteria);
		assertNotNull(listFound);
		boolean found = false;
		for(TeamViewerMode tvm : listFound){
			if(tvm.equals(tvMode01)){
				found = true;
			}
		}
		assertTrue(found);
		assertTrue(this.teamViewerModeDAOImpl.remove(tvmSaved.getId()));
	}
	@Test
	public void testUpdate() {
		/* Persist the object in the database */
		TeamViewerMode tvMode01Persist = this.teamViewerModeDAOImpl.persist(this.teamViewerModeObject01);
		assertNotNull(tvMode01Persist);
		tvMode01Persist.setName("New Name");
		tvMode01Persist.setNotes("New Notes");
		tvMode01Persist.setSamName("New SamName");
		TeamViewerMode tvMode01Update = this.teamViewerModeDAOImpl.update(tvMode01Persist);
		assertNotNull(tvMode01Update);
		assertEquals(tvMode01Update, tvMode01Persist);
		System.out.println(tvMode01Update);
		assertEquals("New Name",tvMode01Update.getName());
		assertEquals("New Notes",tvMode01Update.getNotes());
		assertEquals("New SamName",tvMode01Update.getSamName());
		assertTrue(this.teamViewerModeDAOImpl.remove(tvMode01Update.getId()));
	}

}
