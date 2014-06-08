package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;

public class CustomFieldDAOImplTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	CustomFieldDAOImpl customFieldDAOImpl = (CustomFieldDAOImpl)context.getBean("customFieldDAOImpl");
	CustomField customFieldObject01 = (CustomField)context.getBean("customFieldObject01");
	
//	@Before
//	public void testBefore(){
//		/* check that the database is empty */
//		int counter = 0; 
//		List<CustomField> list = customFieldDAOImpl.findAll();
//		for(CustomField cField : list){
//			boolean success = customFieldDAOImpl.remove(cField.getId());
//			if(success){
//				counter++;
//			}
//		}
//		/* check that all the found items are removed*/
//		assertTrue(counter == list.size());
//		assertEquals(customFieldDAOImpl.findAll().size(), 0);
//	}
	@Test
	public void testPersist() {
		assertNotNull(this.customFieldObject01);
//		assertEquals(this.customFieldObject01.getUniqueID(),"{2ff485a9-cf1d-4168-be45-211bffd7896}");
//		assertEquals(this.customFieldObject01.getValue(), "CustomField Value");
//		assertEquals(this.customFieldObject01.getType(),23);
//		assertEquals(this.customFieldObject01.getPartnerID(),321);
//		/* persist the object in the database */
//		assertNull(this.customFieldDAOImpl.persist(null));
//		CustomField cf01 = this.customFieldDAOImpl.persist(this.customFieldObject01);
//		CustomField cf02 = this.customFieldDAOImpl.persist(this.customFieldObject01);
//		assertEquals(cf01.getId(),cf02.getId());
//		/* check the properties of the retrieved object */
//		assertNotNull(cf01);
//		assertTrue(cf01.getId() > 0);
//		assertEquals(cf01.getUniqueID(),"{2ff485a9-cf1d-4168-be45-211bffd7896}");
//		assertEquals(cf01.getValue(), "CustomField Value");
//		assertEquals(cf01.getType(),23);
//		assertEquals(cf01.getPartnerID(),321);
	}
//	@Test
//	public void testUpdate(){
//		assertNotNull(this.customFieldObject01);
//		assertEquals(this.customFieldObject01.getUniqueID(),"{2ff485a9-cf1d-4168-be45-211bffd7896}");
//		assertEquals(this.customFieldObject01.getValue(), "CustomField Value");
//		assertEquals(this.customFieldObject01.getType(),23);
//		assertEquals(this.customFieldObject01.getPartnerID(),321);
//		/* persist the object in the database */
//		assertNull(this.customFieldDAOImpl.persist(null));
//		CustomField costumFieldNew = this.customFieldDAOImpl.persist(this.customFieldObject01);
//		/* check the properties of the retrieved object */
//		assertNotNull(costumFieldNew);
//		assertTrue(costumFieldNew.getId() > 0);
//		assertEquals(costumFieldNew.getUniqueID(),"{2ff485a9-cf1d-4168-be45-211bffd7896}");
//		assertEquals(costumFieldNew.getValue(), "CustomField Value");
//		assertEquals(costumFieldNew.getType(),23);
//		assertEquals(costumFieldNew.getPartnerID(),321);
//		/* change the properties */
//		costumFieldNew.setType(24);
//		costumFieldNew.setValue("New Content for the customField");
//		costumFieldNew.setPartnerID(356);
//		/* update the state in the database */
//		CustomField costumFieldUpdate = this.customFieldDAOImpl.update(costumFieldNew);
//		/* check the state in the database */
//		assertNotNull(costumFieldNew);
//		assertTrue(costumFieldNew.getId() > 0);
//		assertEquals(costumFieldUpdate.getUniqueID(),"{2ff485a9-cf1d-4168-be45-211bffd7896}");
//		assertEquals(costumFieldUpdate.getValue(), "New Content for the customField");
//		assertEquals(costumFieldUpdate.getType(),24);
//		assertEquals(costumFieldUpdate.getPartnerID(),356);
//	}
//	@Test
//	public void testFindByCriteria(){
//		/* create CustomField */
//		CustomField cf01 = new CustomField();
//		cf01.setUniqueID("{2ff485a9-cf1d-4168-be45-896bffd7896}");
//		cf01.setValue("eigen veld beschrijving");
//		cf01.setType(23);
//		cf01.setPartnerID(321);
//		CustomField cf02 = new CustomField();
//		cf02.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7896}");
//		cf02.setValue("Totaal van een aantal velden");
//		cf02.setType(24);
//		cf02.setPartnerID(356);
//		/* persist the objects to the database */
//		this.customFieldDAOImpl.persist(cf01);
//		this.customFieldDAOImpl.persist(cf02);
//		/* check the objects to the database */
//		List<CustomField> listCf = this.customFieldDAOImpl.findAll();
//		assertTrue(listCf.contains(cf01));
//		assertTrue(listCf.contains(cf02));
//		/* find objects by criteria */
//		List<CustomField> listCf01 = this.customFieldDAOImpl.findByCriteria(cf01);
//		List<CustomField> listCf02 = this.customFieldDAOImpl.findByCriteria(cf02);
//		List<CustomField> listCf03 = this.customFieldDAOImpl.findByCriteria(null);
//		/* check the result */
//		assertEquals(1,listCf01.size());
//		assertEquals(1,listCf02.size());
//		assertEquals(listCf01.get(0), cf01);
//		assertEquals(listCf02.get(0), cf02);
//		assertEquals(listCf03, null);
//	}
	
}
