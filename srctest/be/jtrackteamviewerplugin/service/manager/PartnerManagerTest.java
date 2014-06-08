package be.jtrackteamviewerplugin.service.manager;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.business.data.PartnerDAOImpl;
import be.jtrackteamviewerplugin.service.dto.PartnerDTO;

public class PartnerManagerTest {
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	/**
	 * Method will remove the different objects out the database
	 */
	@Before
	public void testBefore(){ 
		PartnerDAOImpl partnerDAOImpl = (PartnerDAOImpl) context.getBean("partnerDAOImpl");
		List<Partner> listObject = partnerDAOImpl.findAll();
		for(Partner object : listObject){
			partnerDAOImpl.remove(object.getId());
		}
	}
	@Test
	public void testFindByID() {
		PartnerDAOImpl partnerDAOImpl = (PartnerDAOImpl) context.getBean("partnerDAOImpl");
		Partner partner = (Partner) context.getBean("partnerObject01");
		PartnerManager partnerManager = (PartnerManager) context.getBean("partnerManager");
		Partner partnerNew = partnerDAOImpl.persist(partner);
		/* is the object persisted */
		assertNotNull(partnerNew);
		/* find the object trough the manager */
		PartnerDTO partnerDTO = partnerManager.findByID(Integer.toString(partnerNew.getId()));
		assertNotNull(partnerDTO);
		assertEquals("{0a1b5230-533a-4777-9f5f-efdf02d5735n}",partnerDTO.getUniqueID());
		assertEquals("tom d'hondt",partnerDTO.getName());
		assertEquals("notes",partnerDTO.getNotes());
		assertEquals(false,partnerDTO.getIsDeleted());
		assertEquals(false,partnerDTO.getIsFavorite());
	}

}
