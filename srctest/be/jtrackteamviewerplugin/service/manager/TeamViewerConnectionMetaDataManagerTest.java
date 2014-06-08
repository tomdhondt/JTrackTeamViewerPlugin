package be.jtrackteamviewerplugin.service.manager;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;
import be.jtrackteamviewerplugin.business.data.CustomFieldDAOImpl;
import be.jtrackteamviewerplugin.business.data.TeamViewerConnectionMetaDataDAOImpl;
import be.jtrackteamviewerplugin.service.dto.CustomFieldDTO;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionMetaDataDTO;
import be.jtrackteamviewerplugin.service.mapper.TeamViewerConnectionMetaDataMapper;

public class TeamViewerConnectionMetaDataManagerTest {
	/*
	 * instance members
	 */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl) context.getBean("teamViewerConnectionMetaDataDAOImpl");
	CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl) context.getBean("customFieldDAOImpl");
	TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
	TeamViewerConnectionMetaDataManager teamViewerConnectionMetaDataManager = (TeamViewerConnectionMetaDataManager) context.getBean("teamViewerConnectionMetaDataManager");
	@Before
	public void testBefore(){
		/* TeamViewerConnectionMetaData - remove all the objects out the database */
		int counter = 0;
		List<TeamViewerConnectionMetaData> listObject = teamViewerConnectionMetaDataDAOImpl.findAll();
		for(TeamViewerConnectionMetaData object : listObject){
			teamViewerConnectionMetaDataDAOImpl.remove(object.getId());
			counter++;
		}
		assertEquals(counter, listObject.size());
		assertTrue(0 == teamViewerConnectionMetaDataDAOImpl.findAll().size());
		/* CustomField - remove all the objects out the database */
		int counterCf = 0;
		List<CustomField> listObjectCf = customFieldDAOImpl.findAll();
		for(CustomField object : listObjectCf){
			customFieldDAOImpl.remove(object.getId());
			counterCf++;
		}
		assertEquals(counterCf, listObjectCf.size());
		assertTrue(0 == customFieldDAOImpl.findAll().size());
	}
	@Test
	public void testPersist() {
		/* create CustomField */
		CustomFieldDTO cf01 = new CustomFieldDTO();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType("23");
		cf01.setPartnerID("0");
		CustomFieldDTO cf02 = new CustomFieldDTO();
		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
		cf02.setValue("Personal e-mail");
		cf02.setType("24");
		cf02.setPartnerID("0");
		CustomFieldDTO cf03 = new CustomFieldDTO();
		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
		cf03.setValue("Business e-mail");
		cf03.setType("24");
		cf03.setPartnerID("0");
		CustomFieldDTO cf04 = new CustomFieldDTO();
		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
		cf04.setValue("Age");
		cf04.setType("21");
		cf04.setPartnerID("0");
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaDataDTO tvMd01 = new TeamViewerConnectionMetaDataDTO();
		tvMd01.setCustomFieldDTO(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		TeamViewerConnectionMetaDataDTO tvMd02 = new TeamViewerConnectionMetaDataDTO();
		tvMd02.setCustomFieldDTO(cf02);
		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd02.setValue("tom.dhondt@hotmail.com");
		TeamViewerConnectionMetaDataDTO tvMd03 = new TeamViewerConnectionMetaDataDTO();
		tvMd03.setCustomFieldDTO(cf03);
		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7813}");
		tvMd03.setValue("tom.dhondt@business.com");
		TeamViewerConnectionMetaDataDTO tvMd04 = new TeamViewerConnectionMetaDataDTO();
		tvMd04.setCustomFieldDTO(cf04);
		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7814}");
		tvMd04.setValue("30");
		TeamViewerConnectionMetaDataDTO tvMdtoNew01 = teamViewerConnectionMetaDataManager.persist(tvMd01);
		TeamViewerConnectionMetaDataDTO tvMdtoNew02 = teamViewerConnectionMetaDataManager.persist(tvMd02);
		TeamViewerConnectionMetaDataDTO tvMdtoNew03 = teamViewerConnectionMetaDataManager.persist(tvMd03);
		TeamViewerConnectionMetaDataDTO tvMdtoNew04 = teamViewerConnectionMetaDataManager.persist(tvMd04);
		assertNotNull(tvMdtoNew01);
		assertNotNull(tvMdtoNew02);
		assertNotNull(tvMdtoNew03);
		assertNotNull(tvMdtoNew04);
		assertEquals(tvMdtoNew01, tvMd01);
		assertEquals(tvMdtoNew02, tvMd02);
		assertEquals(tvMdtoNew03, tvMd03);
		assertEquals(tvMdtoNew04, tvMd04);
		assertNotNull(tvMdtoNew01.getCustomFieldDTO());
		assertNotNull(tvMdtoNew02.getCustomFieldDTO());
		assertNotNull(tvMdtoNew03.getCustomFieldDTO());
		assertNotNull(tvMdtoNew04.getCustomFieldDTO());
		assertEquals(tvMdtoNew01.getCustomFieldDTO(),cf01);
		assertEquals(tvMdtoNew02.getCustomFieldDTO(),cf02);
		assertEquals(tvMdtoNew03.getCustomFieldDTO(),cf03);
		assertEquals(tvMdtoNew04.getCustomFieldDTO(),cf04);
	}

	@Test
	public void testFindByID() {
		/* create CustomField */
		CustomFieldDTO cf01 = new CustomFieldDTO();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType("23");
		cf01.setPartnerID("0");
		CustomFieldDTO cf02 = new CustomFieldDTO();
		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
		cf02.setValue("Personal e-mail");
		cf02.setType("24");
		cf02.setPartnerID("0");
		CustomFieldDTO cf03 = new CustomFieldDTO();
		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
		cf03.setValue("Business e-mail");
		cf03.setType("24");
		cf03.setPartnerID("0");
		CustomFieldDTO cf04 = new CustomFieldDTO();
		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
		cf04.setValue("Age");
		cf04.setType("21");
		cf04.setPartnerID("0");
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaDataDTO tvMd01 = new TeamViewerConnectionMetaDataDTO();
		tvMd01.setCustomFieldDTO(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		TeamViewerConnectionMetaDataDTO tvMd02 = new TeamViewerConnectionMetaDataDTO();
		tvMd02.setCustomFieldDTO(cf02);
		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd02.setValue("tom.dhondt@hotmail.com");
		TeamViewerConnectionMetaDataDTO tvMd03 = new TeamViewerConnectionMetaDataDTO();
		tvMd03.setCustomFieldDTO(cf03);
		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7813}");
		tvMd03.setValue("tom.dhondt@business.com");
		TeamViewerConnectionMetaDataDTO tvMd04 = new TeamViewerConnectionMetaDataDTO();
		tvMd04.setCustomFieldDTO(cf04);
		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7814}");
		tvMd04.setValue("30");
		TeamViewerConnectionMetaDataDTO tvMdtoNew01 = teamViewerConnectionMetaDataManager.persist(tvMd01);
		TeamViewerConnectionMetaDataDTO tvMdtoNew02 = teamViewerConnectionMetaDataManager.persist(tvMd02);
		TeamViewerConnectionMetaDataDTO tvMdtoNew03 = teamViewerConnectionMetaDataManager.persist(tvMd03);
		TeamViewerConnectionMetaDataDTO tvMdtoNew04 = teamViewerConnectionMetaDataManager.persist(tvMd04);
		TeamViewerConnectionMetaDataDTO dtoFound01 = teamViewerConnectionMetaDataManager.findByID(tvMdtoNew01.getId());
		TeamViewerConnectionMetaDataDTO dtoFound02 = teamViewerConnectionMetaDataManager.findByID(tvMdtoNew02.getId());
		TeamViewerConnectionMetaDataDTO dtoFound03 = teamViewerConnectionMetaDataManager.findByID(tvMdtoNew03.getId());
		TeamViewerConnectionMetaDataDTO dtoFound04 = teamViewerConnectionMetaDataManager.findByID(tvMdtoNew04.getId());
		assertEquals(dtoFound01,tvMd01);
		assertEquals(dtoFound02,tvMd02);
		assertEquals(dtoFound03,tvMd03);
		assertEquals(dtoFound04,tvMd04);
		assertEquals(dtoFound01.getCustomFieldDTO(),cf01);
		assertEquals(dtoFound02.getCustomFieldDTO(),cf02);
		assertEquals(dtoFound03.getCustomFieldDTO(),cf03);
		assertEquals(dtoFound04.getCustomFieldDTO(),cf04);
	}

	@Test
	public void testFindAll() {
		/* create CustomField */
		CustomFieldDTO cf01 = new CustomFieldDTO();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType("23");
		cf01.setPartnerID("0");
		CustomFieldDTO cf02 = new CustomFieldDTO();
		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
		cf02.setValue("Personal e-mail");
		cf02.setType("24");
		cf02.setPartnerID("0");
		CustomFieldDTO cf03 = new CustomFieldDTO();
		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
		cf03.setValue("Business e-mail");
		cf03.setType("24");
		cf03.setPartnerID("0");
		CustomFieldDTO cf04 = new CustomFieldDTO();
		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
		cf04.setValue("Age");
		cf04.setType("21");
		cf04.setPartnerID("0");
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaDataDTO tvMd01 = new TeamViewerConnectionMetaDataDTO();
		tvMd01.setCustomFieldDTO(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		TeamViewerConnectionMetaDataDTO tvMd02 = new TeamViewerConnectionMetaDataDTO();
		tvMd02.setCustomFieldDTO(cf02);
		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd02.setValue("tom.dhondt@hotmail.com");
		TeamViewerConnectionMetaDataDTO tvMd03 = new TeamViewerConnectionMetaDataDTO();
		tvMd03.setCustomFieldDTO(cf03);
		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7813}");
		tvMd03.setValue("tom.dhondt@business.com");
		TeamViewerConnectionMetaDataDTO tvMd04 = new TeamViewerConnectionMetaDataDTO();
		tvMd04.setCustomFieldDTO(cf04);
		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7814}");
		tvMd04.setValue("30");
		TeamViewerConnectionMetaDataDTO tvMdtoNew01 = teamViewerConnectionMetaDataManager.persist(tvMd01);
		TeamViewerConnectionMetaDataDTO tvMdtoNew02 = teamViewerConnectionMetaDataManager.persist(tvMd02);
		TeamViewerConnectionMetaDataDTO tvMdtoNew03 = teamViewerConnectionMetaDataManager.persist(tvMd03);
		TeamViewerConnectionMetaDataDTO tvMdtoNew04 = teamViewerConnectionMetaDataManager.persist(tvMd04);
		assertNotNull(teamViewerConnectionMetaDataManager.findByID(tvMdtoNew01.getId()));
		assertNotNull(teamViewerConnectionMetaDataManager.findByID(tvMdtoNew02.getId()));
		assertNotNull(teamViewerConnectionMetaDataManager.findByID(tvMdtoNew03.getId()));
		assertNotNull(teamViewerConnectionMetaDataManager.findByID(tvMdtoNew04.getId()));
		assertEquals(4,teamViewerConnectionMetaDataManager.findAll().size());
	}
	@Test
	public void testUpdate(){
		/* create CustomField */
		CustomFieldDTO cf01 = new CustomFieldDTO();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType("23");
		cf01.setPartnerID("0");
		CustomFieldDTO cf02 = new CustomFieldDTO();
		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7892}");
		cf02.setValue("Personal e-mail");
		cf02.setType("24");
		cf02.setPartnerID("0");
		CustomFieldDTO cf03 = new CustomFieldDTO();
		cf03.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7893}");
		cf03.setValue("Business e-mail");
		cf03.setType("24");
		cf03.setPartnerID("0");
		CustomFieldDTO cf04 = new CustomFieldDTO();
		cf04.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7894}");
		cf04.setValue("Age");
		cf04.setType("21");
		cf04.setPartnerID("0");
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaDataDTO tvMd01 = new TeamViewerConnectionMetaDataDTO();
		tvMd01.setCustomFieldDTO(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		TeamViewerConnectionMetaDataDTO tvMd02 = new TeamViewerConnectionMetaDataDTO();
		tvMd02.setCustomFieldDTO(cf02);
		tvMd02.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		tvMd02.setValue("tom.dhondt@hotmail.com");
		TeamViewerConnectionMetaDataDTO tvMd03 = new TeamViewerConnectionMetaDataDTO();
		tvMd03.setCustomFieldDTO(cf03);
		tvMd03.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7813}");
		tvMd03.setValue("tom.dhondt@business.com");
		TeamViewerConnectionMetaDataDTO tvMd04 = new TeamViewerConnectionMetaDataDTO();
		tvMd04.setCustomFieldDTO(cf04);
		tvMd04.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7814}");
		tvMd04.setValue("30");
		TeamViewerConnectionMetaDataDTO tvMdtoNew01 = teamViewerConnectionMetaDataManager.persist(tvMd01);
		TeamViewerConnectionMetaDataDTO tvMdtoNew02 = teamViewerConnectionMetaDataManager.persist(tvMd02);
		TeamViewerConnectionMetaDataDTO tvMdtoNew03 = teamViewerConnectionMetaDataManager.persist(tvMd03);
		TeamViewerConnectionMetaDataDTO tvMdtoNew04 = teamViewerConnectionMetaDataManager.persist(tvMd04);
		/* TeamViewerConnectionMetaDataDTO - change the state */
		tvMdtoNew01.setValue("changed state 01");
		tvMdtoNew02.setValue("changed state 02");
		tvMdtoNew03.setValue("changed state 03");
		tvMdtoNew04.setValue("changed state 04");
		TeamViewerConnectionMetaDataDTO tvMdtoUpdate01 = teamViewerConnectionMetaDataManager.update(tvMdtoNew01);
		TeamViewerConnectionMetaDataDTO tvMdtoUpdate02 = teamViewerConnectionMetaDataManager.update(tvMdtoNew02);
		TeamViewerConnectionMetaDataDTO tvMdtoUpdate03 = teamViewerConnectionMetaDataManager.update(tvMdtoNew03);
		TeamViewerConnectionMetaDataDTO tvMdtoUpdate04 = teamViewerConnectionMetaDataManager.update(tvMdtoNew04);
		assertEquals(tvMdtoUpdate01.getValue(), tvMdtoNew01.getValue());
		assertEquals(tvMdtoUpdate02.getTeamViewerConnectionWindowsUser(), tvMdtoNew02.getTeamViewerConnectionWindowsUser());
		assertEquals(tvMdtoUpdate03.getValue(), tvMdtoNew03.getValue());
		assertEquals(tvMdtoUpdate04.getValue(), tvMdtoNew04.getValue());
	}

}
