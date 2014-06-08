package be.jtrackteamviewerplugin.service.testdata;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.business.bean.TeamViewer;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnection;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;
import be.jtrackteamviewerplugin.business.bean.TeamViewerMode;
import be.jtrackteamviewerplugin.business.bean.TeamViewerQuality;
import be.jtrackteamviewerplugin.business.data.TeamViewerDAOImpl;

public class CreateTestData {
	/*
	 * instance members
	 */
	private static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	private static TeamViewerDAOImpl teamViewerDAOImpl = (TeamViewerDAOImpl) context.getBean("teamViewerDAOImpl");
	
	@Test
	public void testCreateTeamViewer() {
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
		/* create TeamViewerConnection */
		TeamViewerConnection tvc = new TeamViewerConnection();
		Date date = Calendar.getInstance().getTime();
		tvc.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		tvc.setStart(date);
		tvc.setFinish(date);
		tvc.setNotes("Notes to the connection");
		tvc.setIsDeleted(false);
		tvc.setWindowsUser("tom.dhondt");
		tvc.setPrice(new BigDecimal(50.0000));
		tvc.setHash(12345);
		tvc.setBill(true);
		tvc.getTeamViewerConnectionMetaDataList().add(tvMd01);
		tvc.getTeamViewerConnectionMetaDataList().add(tvMd02);
		tvc.getTeamViewerConnectionMetaDataList().add(tvMd03);
		tvc.getTeamViewerConnectionMetaDataList().add(tvMd04);
		/* create Partner */
		Partner partner = new Partner();
		partner.setUniqueID("{8az885a9-cf1d-4168-xx15-896bffd7812}");
		partner.setName("Tom D'hondt");
		partner.setNotes("No extre info needed");
		partner.setInherit(false);
		partner.setIsDeleted(false);
		partner.setIsFavorite(false);
		partner.setDateModified(Calendar.getInstance().getTime());
		partner.setBasicChargeTime(5);
		/* Create TeamViewerMode */
		TeamViewerMode teamViewerMode = new TeamViewerMode();
		teamViewerMode.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7845}");
		teamViewerMode.setName("Windows RDP");
		teamViewerMode.setNotes("notes Windows RDP");
		teamViewerMode.setSamName("WindowsRDP");
		/* Create TeamViewerQuality */
		TeamViewerQuality teamViewerQuality = new TeamViewerQuality();
		teamViewerQuality.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7896}");
		teamViewerQuality.setName("Highest");
		teamViewerQuality.setNotes("Sky is the limit");
		teamViewerQuality.setSamName("Sky");
		/* create TeamViewer*/
		TeamViewer teamViewer = new TeamViewer();
		teamViewer.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7812}");
		teamViewer.setAddress("145963251");
		teamViewer.setPassword("6326f4d646sd4g6f46sd4ghf64h654dfg64h6d4fg");
		teamViewer.setTeamViewerMode(teamViewerMode);
		teamViewer.setTeamViewerQuality(teamViewerQuality);
		teamViewer.setPartner(partner);
		teamViewer.getTeamViewerConnectionList().add(tvc);
		teamViewerDAOImpl.persist(teamViewer);
	}
//	@After
//	public void testDeleteTeamViewer() {
//	 	/* delete the TeamViewerConnection */
//		for(TeamViewerConnection con : object.getTeamViewerConnectionList()){
//			teamViewerConnectionDAOImpl.remove(con.getId());
//		}
//		teamViewerDAOImpl.remove(object.getId());
//		/* delete partner */
//		partnerDAOImpl.remove(object.getPartner().getId());
//		/* delete TeamViewerMode */
//		teamViewerModeDAOImpl.remove(object.getTeamViewerMode().getId());	
//		/* delete TeamViewerQuality */
//		teamViewerQualityDAOImpl.remove(object.getTeamViewerQuality().getId());
//		/* check the figures */
//		assertEquals(new ArrayList<TeamViewer>(), teamViewerDAOImpl.findAll());
//		assertEquals(new ArrayList<Partner>(), partnerDAOImpl.findAll());
//		assertEquals(new ArrayList<TeamViewerMode>(), teamViewerModeDAOImpl.findAll());
//		assertEquals(new ArrayList<TeamViewerQuality>(), teamViewerQualityDAOImpl.findAll());
//	}
}
