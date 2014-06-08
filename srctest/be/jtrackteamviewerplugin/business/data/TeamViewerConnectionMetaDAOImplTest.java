package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;

public class TeamViewerConnectionMetaDAOImplTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	TeamViewerConnectionMetaDataDAOImpl teamViewerConnectionMetaDataDAOImpl = (TeamViewerConnectionMetaDataDAOImpl)context.getBean("teamViewerConnectionMetaDataDAOImpl");
	CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl)context.getBean("customFieldDAOImpl");
	Calendar cal = new GregorianCalendar();
	
	@Before
	public void testBefore(){
		/* remove all the objects in the database */
		List<TeamViewerConnectionMetaData> listTvMd = this.teamViewerConnectionMetaDataDAOImpl.findAll();
		List<CustomField> listCf = this.customFieldDAOImpl.findAll();
		int counterTvmd = 0; 
		for(TeamViewerConnectionMetaData tvMd : listTvMd){
			boolean success = this.teamViewerConnectionMetaDataDAOImpl.remove(tvMd.getId());
			if(success == true){
				counterTvmd++;
			}
		}
		int counterCf = 0; 
		for(CustomField cF : listCf){
			boolean success = this.customFieldDAOImpl.remove(cF.getId());
			if(success == true){
				counterCf++;
			}
		}
		/* check that all the found items are removed*/
		assertTrue(counterTvmd == listTvMd.size());
		assertTrue(counterCf == listCf.size());
		assertEquals(this.teamViewerConnectionMetaDataDAOImpl.findAll().size(), 0);
		assertEquals(this.customFieldDAOImpl.findAll().size(), 0);	
	}
	@Test
	public void testPersist() {
		/* create CustomField */
		CustomField cf01 = new CustomField();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7896}");
		cf01.setValue("eigen veld 01 beschrijving");
		cf01.setType(23);
		cf01.setPartnerID(321);
		/* Create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaData tvMd = new TeamViewerConnectionMetaData();
		tvMd.setCustomField(cf01);
		tvMd.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7896}");
		tvMd.setValue("Content for the customField");
		/* persist the object to the database */
		TeamViewerConnectionMetaData tvMdNull = this.teamViewerConnectionMetaDataDAOImpl.persist(null);
		TeamViewerConnectionMetaData tvMdNew = this.teamViewerConnectionMetaDataDAOImpl.persist(tvMd);
		TeamViewerConnectionMetaData tvMdNew02 = this.teamViewerConnectionMetaDataDAOImpl.persist(tvMd);
		assertEquals(tvMdNew.getId(), tvMdNew02.getId());
		/* check weather the objects are in the database */
		assertNull(tvMdNull);
		assertEquals(cf01, tvMdNew.getCustomField());
		assertEquals("{2ff485a9-cf1d-4168-xx15-896bffd7896}",tvMdNew.getUniqueID());
		assertEquals("Content for the customField",tvMdNew.getValue());
		assertTrue(this.customFieldDAOImpl.findAll().contains(cf01));
	}
	@Test
	public void testUpdate(){
		/* create CustomField */
		CustomField cf01 = new CustomField();
		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7896}");
		cf01.setValue("eigen veld beschrijving");
		cf01.setType(23);
		cf01.setPartnerID(321);
		/* Create TeamViewerConnectionMetaData */
		TeamViewerConnectionMetaData tvMd = new TeamViewerConnectionMetaData();
		tvMd.setCustomField(cf01);
		tvMd.setUniqueID("{2ff485a9-cf1d-4168-xx15-896bffd7896}");
		tvMd.setValue("Content for the customField");
		/* persist the object to the database */
		TeamViewerConnectionMetaData tvMdNew = this.teamViewerConnectionMetaDataDAOImpl.persist(tvMd);
		/* Check the content */
		assertNotNull(tvMdNew);
		assertNotNull(tvMdNew.getCustomField().getId());
		/* set changed values for the TeamViewerMetaData */
		tvMdNew.setValue("Changed Value at :" + cal.getTime().toString());
		/* update the value */
		TeamViewerConnectionMetaData tvMdUpdate = this.teamViewerConnectionMetaDataDAOImpl.update(tvMdNew);
		/* check the value */
		assertNotNull(tvMdUpdate);
		assertNotNull(tvMdUpdate.getValue());
		assertTrue(tvMdUpdate.getValue().length() > 0);
		assertEquals(tvMdUpdate.getValue(), tvMdNew.getValue());
	}	
}
