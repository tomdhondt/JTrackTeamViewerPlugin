package be.jtrackteamviewerplugin.business.data;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.Partner;

public class PartnerDAOImplTest {
	/* instance member */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	PartnerDAOImpl partnerDAOImpl = (PartnerDAOImpl)context.getBean("partnerDAOImpl");
	Partner partnerObject01 = (Partner)context.getBean("partnerObject01");
	
	@Test
	public void testPersist() {
		int tableSize = this.partnerDAOImpl.findAll().size();
		/* check the object Partner */
		assertTrue(0 == tableSize);
		assertNotNull(this.partnerObject01);
		assertTrue(0 == this.partnerObject01.getId());
		/* Persist the object to the database */
		Partner partnerTest = new Partner();
		/* persist object without the UniqueID */
		assertNull(this.partnerDAOImpl.persist(partnerTest));
		/* persist object in the database */
		Partner partner = this.partnerDAOImpl.persist(this.partnerObject01);
		assertNotNull(partner.getId());
		int tableSizeNew = this.partnerDAOImpl.findAll().size();
		assertTrue(0 < tableSizeNew);
		assertTrue(tableSize < tableSizeNew);
		assertEquals(this.partnerObject01, partner);
		assertTrue(this.partnerDAOImpl.remove(partner.getId()));
	}

	@Test
	public void testFindByCriteria() {
		Partner partner = this.partnerDAOImpl.persist(this.partnerObject01);
		assertTrue(null != partner);
		List<Partner> listPartner = this.partnerDAOImpl.findByCriteria(partner);
		assertTrue(1 == listPartner.size());
		assertTrue(this.partnerDAOImpl.remove(partner.getId()));
	}
	@Test
	public void testUpdate(){
		Partner partner = this.partnerDAOImpl.persist(this.partnerObject01);
		partner.setName("changed");
		partner.setNotes("Update of the object!");
		Partner newPartner = partnerDAOImpl.update(partner);
		assertTrue(newPartner.equals(partner));
		assertEquals(partner.getName(), newPartner.getName());
		assertEquals(partner.getNotes(), newPartner.getNotes());
		assertTrue(this.partnerDAOImpl.remove(partner.getId()));
	}

}
