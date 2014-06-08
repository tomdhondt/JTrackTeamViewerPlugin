package be.jtrackteamviewerplugin.service.manager;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;
import be.jtrackteamviewerplugin.business.data.CustomFieldDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerConnectionDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerConnectionMetaDataDAOImpl;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionDTO;
import be.jtrackteamviewerplugin.service.mapper.TeamViewerConnectionMapper;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class TeamViewerConnectionManagerTest {
	/*
	 * instance members
	 */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerConnectionDAOImpl teamViewerConnectionDAOImpl = (TeamViewerConnectionDAOImpl)context.getBean("teamViewerConnectionDAOImpl");
	TeamViewerConnectionMapper teamViewerConnectionMapper = (TeamViewerConnectionMapper)context.getBean("teamViewerConnectionMapper");
	TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl)context.getBean("teamViewerConnectionMetaDataDAOImpl");
	CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl)context.getBean("customFieldDAOImpl");
	TeamViewerConnectionManager teamViewerConnectionManager = (TeamViewerConnectionManager)context.getBean("teamViewerConnectionManager");
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:MM:ss");
	
	@Before
	public void testBefore(){
		/* check that the database is empty */
		/* delete the TeamViewerConnectionMetaData */
		int counterTvMd = 0; 
		List<TeamViewerConnectionMetaData> listTvMd = this.teamViewerConnectionMetaDataDAOImpl.findAll();
		for(TeamViewerConnectionMetaData tObject : listTvMd){
			boolean success = this.teamViewerConnectionMetaDataDAOImpl.remove(tObject.getId());
			if(success){
				counterTvMd++;
			}
		}
		/* delete the customField */
		int counterCf = 0; 
		List<CustomField> listCf = this.customFieldDAOImpl.findAll();
		for(CustomField tObject : listCf){
			boolean success = this.customFieldDAOImpl.remove(tObject.getId());
			if(success){
				counterCf++;
			}
		}
		/* delete the TeamViewerConnection */
		int counterTv = 0; 
		List<TeamViewerConnection> listTv = this.teamViewerConnectionDAOImpl.findAll();
		for(TeamViewerConnection tObject : listTv){
			boolean success = this.teamViewerConnectionDAOImpl.remove(tObject.getId());
			if(success){
				counterTv++;
			}
		}
		/* check that all the found items are removed*/
		assertTrue(counterTv == listTv.size());
		assertTrue(counterTvMd == listTvMd.size());
		assertTrue(counterCf == listCf.size());
		assertEquals(this.teamViewerConnectionDAOImpl.findAll().size(), 0);
		assertEquals(this.teamViewerConnectionMetaDataDAOImpl.findAll().size(), 0);
		assertEquals(this.customFieldDAOImpl.findAll().size(), 0);
	}
	@Test
	public void testRemove(){
		/* save the TeamViewerConnection in the database */
		/* create CustomField */
		CustomField cf01 = new CustomField();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType(23);
		cf01.setPartnerID(0);
		CustomField cf02 = new CustomField();
		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
		cf02.setValue("Personal e-mail");
		cf02.setType(24);
		cf02.setPartnerID(0);
		CustomField cf03 = new CustomField();
		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
		cf03.setValue("Business e-mail");
		cf03.setType(24);
		cf03.setPartnerID(0);
		CustomField cf04 = new CustomField();
		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
		cf04.setValue("Age");
		cf04.setType(21);
		cf04.setPartnerID(0);
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaData tvMd01 = new TeamViewerConnectionMetaData();
		tvMd01.setCustomField(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		TeamViewerConnectionMetaData tvMd02 = new TeamViewerConnectionMetaData();
		tvMd02.setCustomField(cf02);
		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd02.setValue("tom.dhondt@hotmail.com");
		TeamViewerConnectionMetaData tvMd03 = new TeamViewerConnectionMetaData();
		tvMd03.setCustomField(cf03);
		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd03.setValue("tom.dhondt@business.com");
		TeamViewerConnectionMetaData tvMd04 = new TeamViewerConnectionMetaData();
		tvMd04.setCustomField(cf04);
		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd04.setValue("30");
		/* create TeamViewerConnection 01 */
		TeamViewerConnection teamViewerConnection01 = new TeamViewerConnection();
		Date date = Calendar.getInstance().getTime();
		teamViewerConnection01.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerConnection01.setStart(date);
		teamViewerConnection01.setFinish(date);
		teamViewerConnection01.setNotes("Notes to the connection");
		teamViewerConnection01.setIsDeleted(false);
		teamViewerConnection01.setWindowsUser("tom.dhondt");
		teamViewerConnection01.setPrice(new BigDecimal(50.0000));
		teamViewerConnection01.setHash(5678);
		teamViewerConnection01.setBill(true);
		teamViewerConnection01.getTeamViewerConnectionMetaDataList().add(tvMd01);
		teamViewerConnection01.getTeamViewerConnectionMetaDataList().add(tvMd02);
		/* Persist the objects in the database */
		TeamViewerConnection teamViewerConnection02 = new TeamViewerConnection();
		Date date2 = Calendar.getInstance().getTime();
		teamViewerConnection02.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerConnection02.setStart(date2);
		teamViewerConnection02.setFinish(date2);
		teamViewerConnection02.setNotes("Notes to the connection");
		teamViewerConnection02.setIsDeleted(false);
		teamViewerConnection02.setWindowsUser("voorbeeld");
		teamViewerConnection02.setPrice(new BigDecimal(50.0000));
		teamViewerConnection02.setHash(1234);
		teamViewerConnection02.setBill(true);
		teamViewerConnection02.getTeamViewerConnectionMetaDataList().add(tvMd03);
		teamViewerConnection02.getTeamViewerConnectionMetaDataList().add(tvMd04);
		/* Persist the objects to the database */
		TeamViewerConnection objectTvc01 = this.teamViewerConnectionDAOImpl.persist(teamViewerConnection01);
		TeamViewerConnection objectTvc02 = this.teamViewerConnectionDAOImpl.persist(teamViewerConnection02);
		objectTvc01.setIsDeleted(true);
		assertTrue(teamViewerConnectionManager.remove(teamViewerConnectionMapper.mapToDTO(objectTvc01)));
		TeamViewerConnection object = teamViewerConnectionDAOImpl.findByID(objectTvc01.getId());
		assertTrue(object.getIsDeleted());
		assertTrue(teamViewerConnectionDAOImpl.findAll().contains(objectTvc02));
		assertFalse(teamViewerConnectionDAOImpl.findAll().contains(objectTvc01));
	}
	@Test
	public void testFindAll(){
		/* save the TeamViewerConnection in the database */
		/* create CustomField */
		CustomField cf01 = new CustomField();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType(23);
		cf01.setPartnerID(0);
		CustomField cf02 = new CustomField();
		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
		cf02.setValue("Personal e-mail");
		cf02.setType(24);
		cf02.setPartnerID(0);
		CustomField cf03 = new CustomField();
		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
		cf03.setValue("Business e-mail");
		cf03.setType(24);
		cf03.setPartnerID(0);
		CustomField cf04 = new CustomField();
		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
		cf04.setValue("Age");
		cf04.setType(21);
		cf04.setPartnerID(0);
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaData tvMd01 = new TeamViewerConnectionMetaData();
		tvMd01.setCustomField(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		TeamViewerConnectionMetaData tvMd02 = new TeamViewerConnectionMetaData();
		tvMd02.setCustomField(cf02);
		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd02.setValue("tom.dhondt@hotmail.com");
		TeamViewerConnectionMetaData tvMd03 = new TeamViewerConnectionMetaData();
		tvMd03.setCustomField(cf03);
		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd03.setValue("tom.dhondt@business.com");
		TeamViewerConnectionMetaData tvMd04 = new TeamViewerConnectionMetaData();
		tvMd04.setCustomField(cf04);
		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd04.setValue("30");
		/* create TeamViewerConnection 01 */
		TeamViewerConnection teamViewerConnection01 = new TeamViewerConnection();
		Date date = Calendar.getInstance().getTime();
		teamViewerConnection01.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerConnection01.setStart(date);
		teamViewerConnection01.setFinish(date);
		teamViewerConnection01.setNotes("Notes to the connection");
		teamViewerConnection01.setIsDeleted(false);
		teamViewerConnection01.setWindowsUser("tom.dhondt");
		teamViewerConnection01.setPrice(new BigDecimal(50.0000));
		teamViewerConnection01.setHash(5678);
		teamViewerConnection01.setBill(true);
		teamViewerConnection01.getTeamViewerConnectionMetaDataList().add(tvMd01);
		teamViewerConnection01.getTeamViewerConnectionMetaDataList().add(tvMd02);
		/* Persist the objects in the database */
		TeamViewerConnection teamViewerConnection02 = new TeamViewerConnection();
		Date date2 = Calendar.getInstance().getTime();
		teamViewerConnection02.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerConnection02.setStart(date2);
		teamViewerConnection02.setFinish(date2);
		teamViewerConnection02.setNotes("Notes to the connection");
		teamViewerConnection02.setIsDeleted(false);
		teamViewerConnection02.setWindowsUser("voorbeeld");
		teamViewerConnection02.setPrice(new BigDecimal(50.0000));
		teamViewerConnection02.setHash(1234);
		teamViewerConnection02.setBill(true);
		teamViewerConnection02.getTeamViewerConnectionMetaDataList().add(tvMd03);
		teamViewerConnection02.getTeamViewerConnectionMetaDataList().add(tvMd04);
		/* Persist the objects to the database */
		TeamViewerConnection objectTvc01 = this.teamViewerConnectionDAOImpl.persist(teamViewerConnection01);
		TeamViewerConnection objectTvc02 = this.teamViewerConnectionDAOImpl.persist(teamViewerConnection02);
		/* check the returned object */
		assertNotNull(objectTvc01);
		assertEquals(sdf.format(teamViewerConnection01.getStart()),sdf.format(date));
		assertEquals(sdf.format(teamViewerConnection01.getFinish()),sdf.format(date));
		assertEquals(teamViewerConnection01.getNotes(),"Notes to the connection");
		assertEquals(teamViewerConnection01.getIsDeleted(),false);
		assertEquals(teamViewerConnection01.getWindowsUser(),"tom.dhondt");
		assertEquals(teamViewerConnection01.getHash(),5678);
		assertEquals(teamViewerConnection01.getBill(),true);
		assertNotNull(objectTvc02);
		assertEquals(sdf.format(teamViewerConnection02.getStart()),sdf.format(date2));
		assertEquals(sdf.format(teamViewerConnection02.getFinish()),sdf.format(date2));
		assertEquals(teamViewerConnection02.getNotes(),"Notes to the connection");
		assertEquals(teamViewerConnection02.getIsDeleted(),false);
		assertEquals(teamViewerConnection02.getWindowsUser(),"voorbeeld");
		assertEquals(teamViewerConnection02.getHash(),1234);
		assertEquals(teamViewerConnection02.getBill(),true);
		/* FindAll() */
		List<TeamViewerConnectionDTO> listDTO = new TeamViewerConnectionManager().findAll();
		assertNotNull(listDTO);
		assertEquals(2, listDTO.size());
		for(TeamViewerConnectionDTO dto : listDTO){
			if(dto.getHash().equals("1234")){
				assertEquals(dto.getNotes(),"Notes to the connection");
				assertEquals(dto.getIsDeleted(),false);
				assertEquals(dto.getWindowsUser(),"voorbeeld");
				assertEquals(dto.getHash(),"1234");
				assertEquals(dto.getBill(),true);
				assertEquals(2, dto.getTeamViewerConnectionMetaDataList().size());
			}
			if(dto.getHash().equals("5678")){
				assertEquals(dto.getNotes(),"Notes to the connection");
				assertEquals(dto.getIsDeleted(),false);
				assertEquals(dto.getWindowsUser(),"tom.dhondt");
				assertEquals(dto.getHash(),"5678");
				assertEquals(dto.getBill(),true);
				assertEquals(2, dto.getTeamViewerConnectionMetaDataList().size());
			}
		}
	}
	@Test
	public void findByID(){
		/* save the TeamViewerConnection in the database */
		/* create CustomField */
		CustomField cf01 = new CustomField();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType(23);
		cf01.setPartnerID(0);
		CustomField cf02 = new CustomField();
		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
		cf02.setValue("Personal e-mail");
		cf02.setType(24);
		cf02.setPartnerID(0);
		CustomField cf03 = new CustomField();
		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
		cf03.setValue("Business e-mail");
		cf03.setType(24);
		cf03.setPartnerID(0);
		CustomField cf04 = new CustomField();
		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
		cf04.setValue("Age");
		cf04.setType(21);
		cf04.setPartnerID(0);
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaData tvMd01 = new TeamViewerConnectionMetaData();
		tvMd01.setCustomField(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		TeamViewerConnectionMetaData tvMd02 = new TeamViewerConnectionMetaData();
		tvMd02.setCustomField(cf02);
		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd02.setValue("tom.dhondt@hotmail.com");
		TeamViewerConnectionMetaData tvMd03 = new TeamViewerConnectionMetaData();
		tvMd03.setCustomField(cf03);
		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd03.setValue("tom.dhondt@business.com");
		TeamViewerConnectionMetaData tvMd04 = new TeamViewerConnectionMetaData();
		tvMd04.setCustomField(cf04);
		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd04.setValue("30");
		/* create TeamViewerConnection 01 */
		TeamViewerConnection teamViewerConnection01 = new TeamViewerConnection();
		Date date = Calendar.getInstance().getTime();
		teamViewerConnection01.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerConnection01.setStart(date);
		teamViewerConnection01.setFinish(date);
		teamViewerConnection01.setNotes("Notes to the connection");
		teamViewerConnection01.setIsDeleted(false);
		teamViewerConnection01.setWindowsUser("tom.dhondt");
		teamViewerConnection01.setPrice(new BigDecimal(50.0000));
		teamViewerConnection01.setHash(5678);
		teamViewerConnection01.setBill(true);
		teamViewerConnection01.getTeamViewerConnectionMetaDataList().add(tvMd01);
		teamViewerConnection01.getTeamViewerConnectionMetaDataList().add(tvMd02);
		/* Persist the objects in the database */
		TeamViewerConnection teamViewerConnection02 = new TeamViewerConnection();
		Date date2 = Calendar.getInstance().getTime();
		teamViewerConnection02.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		teamViewerConnection02.setStart(date2);
		teamViewerConnection02.setFinish(date2);
		teamViewerConnection02.setNotes("Notes to the connection");
		teamViewerConnection02.setIsDeleted(false);
		teamViewerConnection02.setWindowsUser("voorbeeld");
		teamViewerConnection02.setPrice(new BigDecimal(50.0000));
		teamViewerConnection02.setHash(1234);
		teamViewerConnection02.setBill(true);
		teamViewerConnection02.getTeamViewerConnectionMetaDataList().add(tvMd03);
		teamViewerConnection02.getTeamViewerConnectionMetaDataList().add(tvMd04);
		/* Persist the objects to the database */
		TeamViewerConnection objectTvc01 = this.teamViewerConnectionDAOImpl.persist(teamViewerConnection01);
		TeamViewerConnection objectTvc02 = this.teamViewerConnectionDAOImpl.persist(teamViewerConnection02);
		/* check the returned object */
		assertNotNull(objectTvc01);
		assertEquals(sdf.format(teamViewerConnection01.getStart()),sdf.format(date));
		assertEquals(sdf.format(teamViewerConnection01.getFinish()),sdf.format(date));
		assertEquals(teamViewerConnection01.getNotes(),"Notes to the connection");
		assertEquals(teamViewerConnection01.getIsDeleted(),false);
		assertEquals(teamViewerConnection01.getWindowsUser(),"tom.dhondt");
		assertEquals(teamViewerConnection01.getHash(),5678);
		assertEquals(teamViewerConnection01.getBill(),true);
		assertNotNull(objectTvc02);
		assertEquals(sdf.format(teamViewerConnection02.getStart()),sdf.format(date2));
		assertEquals(sdf.format(teamViewerConnection02.getFinish()),sdf.format(date2));
		assertEquals(teamViewerConnection02.getNotes(),"Notes to the connection");
		assertEquals(teamViewerConnection02.getIsDeleted(),false);
		assertEquals(teamViewerConnection02.getWindowsUser(),"voorbeeld");
		assertEquals(teamViewerConnection02.getHash(),1234);
		assertEquals(teamViewerConnection02.getBill(),true);
		/* FindByID */
		TeamViewerConnectionDTO tvc01 = new TeamViewerConnectionManager().findByID(MappingUtil.mapIntToString(objectTvc01.getId()));
		TeamViewerConnectionDTO tvc02 = new TeamViewerConnectionManager().findByID(MappingUtil.mapIntToString(objectTvc02.getId()));
		TeamViewerConnectionDTO tvc03 = new TeamViewerConnectionManager().findByID("1");
		assertNotNull(tvc01);
		assertNotNull(tvc02);
		assertNull(tvc03);
		assertEquals(tvc01, new TeamViewerConnectionMapper().mapToDTO(objectTvc01));
		assertEquals(tvc02, new TeamViewerConnectionMapper().mapToDTO(objectTvc02));
		assertEquals(tvc03, null);
	}
	@Test
	public void testFindByCriteria(){
		/* Create a criteria Bean */
		TeamViewerConnectionDTO dto = new TeamViewerConnectionDTO();
		dto.setStart("10-12-2013 01:00:00.000");
		TeamViewerConnection object = teamViewerConnectionMapper.mapToObject(dto);
		assertNotNull(object);
		System.out.println(object.getStart().toString());
		assertEquals(object.getStart().toString(),"Tue Dec 10 01:00:00 CET 2013");
		System.out.println(object.getStart().toString());
		List<TeamViewerConnectionDTO> list = teamViewerConnectionManager.findByCriteria(dto);
		for(TeamViewerConnectionDTO dtoT : list){
			System.out.println(dtoT.toString());
		}
		System.out.println(list.size());
	}
}
