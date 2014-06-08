package be.jtrackteamviewerplugin.service.mapper;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.data.TeamViewerConnectionDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionDTO;

public class TeamViewerConnectionMapperTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerConnection teamViewerConnectionObject01 = (TeamViewerConnection)context.getBean("teamViewerConnectionObject01");
	TeamViewerConnectionDTO teamViewerConnectionDTO01 = (TeamViewerConnectionDTO)context.getBean("teamViewerConnectionDTO01");
	TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper)context.getBean("teamViewerConnectionMapper");
	TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl= (TeamViewerConnectionDAOImpl)context.getBean("teamViewerConnectionDAOImpl");
	TeamViewerDAOImpl teamViewerDAOImpl= (TeamViewerDAOImpl)context.getBean("teamViewerDAOImpl");
	
	
	@Test
	public void testMapToObject() {
		TeamViewerConnection teamViewerConnection = teamViewerConnectionDAOImpl.persist(teamViewerConnectionObject01);
		assertNotNull(teamViewerConnection);
		TeamViewerConnectionDTO dto = this.teamViewerConnectionMapper.mapToDTO(this.teamViewerConnectionObject01);
		assertEquals("{2ff485a9-cf1d-4168-be45-211bffd7854}",dto.getUniqueID());;
		assertEquals("notes",dto.getNotes());
		assertEquals(false,dto.getIsDeleted());
		assertEquals("10.0000",dto.getPrice());
		assertEquals("19530964",dto.getHash());
		assertEquals(true,dto.getBill());
		assertEquals("123135143", dto.getTeamViewerAddress());
		assertEquals(Integer.toString(teamViewerConnection.getTeamViewer().getId()), dto.getTeamViewerID());
		TeamViewerConnection object = teamViewerConnectionMapper.mapToObject(dto);
		assertEquals("{2ff485a9-cf1d-4168-be45-211bffd7854}",object.getUniqueID());;
		assertEquals("notes",object.getNotes());
		assertEquals(false,object.getIsDeleted());
//		assertEquals(10.0000,object.getPrice());
		assertEquals(19530964,object.getHash());
		assertEquals(true,dto.getBill());
		assertEquals("123135143", object.getTeamViewer().getAddress());
		assertEquals(teamViewerConnection.getTeamViewer().getId(), object.getTeamViewer().getId());
		/* check that the both TeamViewerConnections are the same */
		assertEquals(teamViewerConnection, teamViewerConnectionObject01);
		/* check that the both TeamViewer objects are the same */
		assertEquals(this.teamViewerConnectionObject01.getTeamViewer(), object.getTeamViewer());
		/* Remove the teamViewerConnection */
		assertTrue(this.teamViewerConnectionDAOImpl.remove(object.getId()));
	}
//	@Test
//	public void testMapToDTO() {
//		/* check before */
//		assertNotNull(teamViewerConnectionDTO01);
//		TeamViewerConnection object = this.teamViewerConnectionMapper.mapToObject(teamViewerConnectionDTO01);
//		assertNotNull(object.getTeamViewer());
//		TeamViewerConnectionDTO dto = this.teamViewerConnectionMapper.mapToDTO(object);
//		assertNotNull(dto.getTeamViewer());
//		assertNotNull(object);
//		assertNotNull(dto);
//		assertEquals(teamViewerConnectionDTO01, dto);
//		assertNotNull(teamViewerConnectionDTO01.getTeamViewer());
//		assertNotNull(dto.getTeamViewer());
//		assertEquals(this.teamViewerConnectionDTO01.getTeamViewer(), dto.getTeamViewer());
//	}
//	@Test
//	public void testMappingDates(){
//		TeamViewerConnection tVc = new TeamViewerConnection();
//		tVc.setStart(Calendar.getInstance().getTime());
//		tVc.setFinish(DateUtil.dateCalcMilliseconds(tVc.getStart(), 360000));
//		DateTimeFormatter fmt = DateTimeFormat.forPattern("d MMMM, yyyy hh:mm:ss.SSS");
//		DateTime date2 = new DateTime(Calendar.getInstance().getTime());
//		DateTime date = new DateTime(DateUtil.dateCalcMilliseconds(tVc.getStart(), 360000).getTime());
//	}

}
