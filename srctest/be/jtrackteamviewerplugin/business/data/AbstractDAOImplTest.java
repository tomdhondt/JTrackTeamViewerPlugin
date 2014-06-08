package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;

public class AbstractDAOImplTest {
	/*
	 * instance members
	 */
	private static ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	private static CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl) context.getBean("customFieldDAOImpl");
	private static TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl) context.getBean("teamViewerConnectionMetaDataDAOImpl");
	@Before
	public void testBefore(){
		List<CustomField> listCustomField = customFieldDAOImpl.findAll();
		List<TeamViewerConnectionMetaData> listTeamViewerConnectionMetaData = teamViewerConnectionMetaDataDAOImpl.findAll();
		/* delete the objects out the database */
		for(TeamViewerConnectionMetaData cMetaData: listTeamViewerConnectionMetaData){
			customFieldDAOImpl.remove(cMetaData.getId());
		}
		/* Delete the objects out the database */
		for(CustomField cField : listCustomField){
			customFieldDAOImpl.remove(cField.getId());
		}
	}
	
	@Test
	public void testRemove() {
		/* create CustomField */
		CustomField cf01 = new CustomField();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7891}");
		cf01.setValue("Remark 1");
		cf01.setType(23);
		cf01.setPartnerID(0);
		customFieldDAOImpl.persist(cf01);
		assertTrue(customFieldDAOImpl.findAll().contains(cf01));
		/* create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaData tvMd01 = new TeamViewerConnectionMetaData();
		tvMd01.setCustomField(cf01);
		tvMd01.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7811}");
		tvMd01.setValue("Do not bill extra diag nessessary");
		teamViewerConnectionMetaDataDAOImpl.persist(tvMd01);
		assertTrue(teamViewerConnectionMetaDataDAOImpl.findAll().contains(tvMd01));
	}

}
