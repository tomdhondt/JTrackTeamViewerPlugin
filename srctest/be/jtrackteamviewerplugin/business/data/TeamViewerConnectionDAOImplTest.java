package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.NameQueryParam;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;

public class TeamViewerConnectionDAOImplTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl)context.getBean("teamViewerConnectionDAOImpl");
	TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl)context.getBean("teamViewerConnectionMetaDataDAOImpl");
	CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl)context.getBean("customFieldDAOImpl");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:MM:ss");
	
	@Test
	public void test(){
		List<NameQueryParam> list = new ArrayList<NameQueryParam>();
		Long lng = new Long(1382997600);
		Calendar dateStart = new GregorianCalendar(2013, 9, 30);
		Calendar dateFinal = new GregorianCalendar(2013, 9, 31);
		Date ds = dateStart.getTime();
		Date df = dateFinal.getTime();
		list.add(new NameQueryParam(1, "start", dateStart.getTime()));
		list.add(new NameQueryParam(2, "finish", dateFinal.getTime()));
		List<TeamViewerConnection> resultList = teamViewerConnectionDAOImpl.findByNamedQuery(list, "TeamViewerConnection.findby.startdate");		
	}
//	@Before
//	public void testBefore(){
//		/* check that the database is empty */
//		/* delete the TeamViewerConnectionMetaData */
//		int counterTvMd = 0; 
//		List<TeamViewerConnectionMetaData> listTvMd = this.teamViewerConnectionMetaDataDAOImpl.findAll();
//		for(TeamViewerConnectionMetaData tObject : listTvMd){
//			boolean success = this.teamViewerConnectionMetaDataDAOImpl.remove(tObject.getId());
//			if(success){
//				counterTvMd++;
//			}
//		}
//		/* delete the customField */
//		int counterCf = 0; 
//		List<CustomField> listCf = this.customFieldDAOImpl.findAll();
//		for(CustomField tObject : listCf){
//			boolean success = this.customFieldDAOImpl.remove(tObject.getId());
//			if(success){
//				counterCf++;
//			}
//		}
//		/* delete the TeamViewerConnection */
//		int counterTv = 0; 
//		List<TeamViewerConnection> listTv = this.teamViewerConnectionDAOImpl.findAll();
//		for(TeamViewerConnection tObject : listTv){
//			boolean success = this.teamViewerConnectionDAOImpl.remove(tObject.getId());
//			if(success){
//				counterTv++;
//			}
//		}
//		/* check that all the found items are removed*/
//		assertTrue(counterTv == listTv.size());
//		assertTrue(counterTvMd == listTvMd.size());
//		assertTrue(counterCf == listCf.size());
//		assertEquals(this.teamViewerConnectionDAOImpl.findAll().size(), 0);
//		assertEquals(this.teamViewerConnectionMetaDataDAOImpl.findAll().size(), 0);
//		assertEquals(this.customFieldDAOImpl.findAll().size(), 0);
//	}
//	@Test
//	public void testPersist() {
//		/* create a TeamViewerConnection */
//		TeamViewerConnection tvc = new TeamViewerConnection();
//		Date date = Calendar.getInstance().getTime();
//		tvc.setUniqueID("{" + UUID.randomUUID().toString() + "}");
//		tvc.setStart(date);
//		tvc.setFinish(date);
//		tvc.setNotes("Notes to the connection");
//		tvc.setIsDeleted(false);
//		tvc.setWindowsUser("tom.dhondt");
//		tvc.setPrice(new BigDecimal(50.0000));
//		tvc.setHash(12345);
//		tvc.setBill(true);
//		/* create CustomField */
//		CustomField cf01 = new CustomField();
//		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
//		cf01.setValue("Remark 1");
//		cf01.setType(23);
//		cf01.setPartnerID(0);
//		CustomField cf02 = new CustomField();
//		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
//		cf02.setValue("Personal e-mail");
//		cf02.setType(24);
//		cf02.setPartnerID(0);
//		CustomField cf03 = new CustomField();
//		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
//		cf03.setValue("Business e-mail");
//		cf03.setType(24);
//		cf03.setPartnerID(0);
//		CustomField cf04 = new CustomField();
//		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
//		cf04.setValue("Age");
//		cf04.setType(21);
//		cf04.setPartnerID(0);
//		/* create TeamViewerConnectionMetaData */
//		TeamViewerConnectionMetaData tvMd01 = new TeamViewerConnectionMetaData();
//		tvMd01.setCustomField(cf01);
//		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
//		tvMd01.setValue("Do not bill extra diag nessessary");
//		TeamViewerConnectionMetaData tvMd02 = new TeamViewerConnectionMetaData();
//		tvMd02.setCustomField(cf02);
//		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
//		tvMd02.setValue("tom.dhondt@hotmail.com");
//		TeamViewerConnectionMetaData tvMd03 = new TeamViewerConnectionMetaData();
//		tvMd03.setCustomField(cf03);
//		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
//		tvMd03.setValue("tom.dhondt@business.com");
//		TeamViewerConnectionMetaData tvMd04 = new TeamViewerConnectionMetaData();
//		tvMd04.setCustomField(cf04);
//		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
//		tvMd04.setValue("30");
//		/* set the TeamViewerConnection */
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd01);
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd02);
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd03);
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd04);
//		/* persist to the database */
//		TeamViewerConnection tvcNull = this.teamViewerConnectionDAOImpl.persist(null);
//		TeamViewerConnection tvcNew = this.teamViewerConnectionDAOImpl.persist(tvc);
//		TeamViewerConnection tvcNew2 = this.teamViewerConnectionDAOImpl.persist(tvc);
//		/* check persisted objects */
//		assertNull(tvcNull);
//		assertNotNull(tvcNew);
//		assertNotNull(tvcNew2);
//		assertEquals(tvcNew.getId(), tvcNew2.getId());
//		/* check the content  */
//		assertEquals(tvcNew2.getUniqueID(),tvc.getUniqueID());
//		assertEquals(sdf.format(tvcNew2.getStart()),sdf.format(date));
//		assertEquals(sdf.format(tvcNew2.getFinish()),sdf.format(date));
//		assertEquals(tvcNew2.getNotes(),"Notes to the connection");
//		assertEquals(tvcNew2.getIsDeleted(),false);
//		assertEquals(tvcNew2.getWindowsUser(),"tom.dhondt");
//		assertEquals(tvcNew2.getHash(),12345);
//		assertEquals(tvcNew2.getBill(),true);
//		assertEquals(this.teamViewerConnectionDAOImpl.findAll().size(), 1);
//		/* check the TeamViewerConnectionMetaData */
//		assertNotNull(tvcNew2.getTeamViewerConnectionMetaDataList().size());
//		assertEquals(tvcNew2.getTeamViewerConnectionMetaDataList().size(), 4);
//		for(TeamViewerConnectionMetaData tvmd : tvcNew2.getTeamViewerConnectionMetaDataList()){
//			System.out.println(tvmd.toString());
//		}
//	}
//	@Test
//	public void testPersist2() {
//		/* create a TeamViewerConnection */
//		TeamViewerConnection tvc = new TeamViewerConnection();
//		Date date = Calendar.getInstance().getTime();
//		String uniqueId = "{" + UUID.randomUUID().toString() + "}";
//		tvc.setUniqueID(uniqueId);
//		tvc.setStart(date);
//		tvc.setFinish(date);
//		tvc.setNotes("Notes to the connection");
//		tvc.setIsDeleted(false);
//		tvc.setWindowsUser("tom.dhondt");
//		tvc.setPrice(new BigDecimal(50.0000));
//		tvc.setHash(12345);
//		tvc.setBill(true);
//		TeamViewerConnection object = this.teamViewerConnectionDAOImpl.persist(tvc);
//		/* check persisted objects */
//		assertNotNull(object);
//		assertNull(object.getTeamViewer());
//		/* create CustomField */
//		CustomField cField = new CustomField();
//		cField.setUniqueID("{2ff485a9-cf1d-4168-xx15-789fffd7896}");
//		cField.setType(24);
//		cField.setValue("customfield teamviewerconnectionmetadata");
//		cField.setPartnerID(0);
//		/* Create TeamViewerConnectionMetaData */
//		TeamViewerConnectionMetaData tvMd = new TeamViewerConnectionMetaData();
//		tvMd.setCustomField(cField);
//		tvMd.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7896}");
//		tvMd.setValue("Content for the customField");
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd);
//		assertEquals(tvMd, tvc.getTeamViewerConnectionMetaDataList().get(0));
//		/* persist the object again */
//		TeamViewerConnection tvcUpdate = this.teamViewerConnectionDAOImpl.persist(tvc);
//		/* check if the TeamViewerConnectionMetaData is saved */
//		assertNotNull(tvcUpdate);
//		assertEquals( uniqueId,tvcUpdate.getUniqueID());
//		assertEquals(sdf.format(date),sdf.format(tvcUpdate.getStart()));
//		assertEquals(sdf.format(date),sdf.format(tvcUpdate.getFinish()));
//		assertEquals("Notes to the connection",tvcUpdate.getNotes());
//		assertEquals(false,tvcUpdate.getIsDeleted());
//		assertEquals("tom.dhondt",tvcUpdate.getWindowsUser());
//		assertEquals(12345, tvcUpdate.getHash());
//		assertEquals(true,tvcUpdate.getBill());
//		TeamViewerConnectionMetaData tvmd = new TeamViewerConnectionMetaData(tvcUpdate,null,null);
//		List<TeamViewerConnectionMetaData> listTvmdTest = this.teamViewerConnectionMetaDataDAOImpl.findByCriteria(tvmd);
//		assertEquals(listTvmdTest.size(), 1);
//		assertEquals(listTvmdTest.get(0), tvMd);
//	}
//	@Test
//	public void testRemove(){
//		/* create a TeamViewerConnection */
//		TeamViewerConnection tvc = new TeamViewerConnection();
//		Date date = Calendar.getInstance().getTime();
//		tvc.setUniqueID("{" + UUID.randomUUID().toString() + "}");
//		tvc.setStart(date);
//		tvc.setFinish(date);
//		tvc.setNotes("Notes to the connection");
//		tvc.setIsDeleted(false);
//		tvc.setWindowsUser("tom.dhondt");
//		tvc.setPrice(new BigDecimal(50.0000));
//		tvc.setHash(12345);
//		tvc.setBill(true);
//		/* create CustomField */
//		CustomField cf01 = new CustomField();
//		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
//		cf01.setValue("Remark 1");
//		cf01.setType(23);
//		cf01.setPartnerID(0);
//		CustomField cf02 = new CustomField();
//		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
//		cf02.setValue("Personal e-mail");
//		cf02.setType(24);
//		cf02.setPartnerID(0);
//		CustomField cf03 = new CustomField();
//		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
//		cf03.setValue("Business e-mail");
//		cf03.setType(24);
//		cf03.setPartnerID(0);
//		CustomField cf04 = new CustomField();
//		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
//		cf04.setValue("Age");
//		cf04.setType(21);
//		cf04.setPartnerID(0);
//		/* create TeamViewerConnectionMetaData */
//		TeamViewerConnectionMetaData tvMd01 = new TeamViewerConnectionMetaData();
//		tvMd01.setCustomField(cf01);
//		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
//		tvMd01.setValue("Do not bill extra diag nessessary");
//		TeamViewerConnectionMetaData tvMd02 = new TeamViewerConnectionMetaData();
//		tvMd02.setCustomField(cf02);
//		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
//		tvMd02.setValue("tom.dhondt@hotmail.com");
//		TeamViewerConnectionMetaData tvMd03 = new TeamViewerConnectionMetaData();
//		tvMd03.setCustomField(cf03);
//		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
//		tvMd03.setValue("tom.dhondt@business.com");
//		TeamViewerConnectionMetaData tvMd04 = new TeamViewerConnectionMetaData();
//		tvMd04.setCustomField(cf04);
//		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
//		tvMd04.setValue("30");
//		/* set the TeamViewerConnection */
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd01);
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd02);
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd03);
//		tvc.getTeamViewerConnectionMetaDataList().add(tvMd04);
//		/* persist to the database */
//		TeamViewerConnection tvcNew = this.teamViewerConnectionDAOImpl.persist(tvc);
//		/* check persisted objects */
//		assertNotNull(tvcNew);
//		assertTrue(teamViewerConnectionDAOImpl.remove(tvcNew.getId()));
//		assertFalse(teamViewerConnectionDAOImpl.findAll().contains(tvcNew));
//	}
}
