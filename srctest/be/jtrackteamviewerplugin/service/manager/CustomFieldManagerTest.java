package be.jtrackteamviewerplugin.service.manager;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.service.dto.CustomFieldDTO;
import be.jtrackteamviewerplugin.service.mapper.CustomFieldMapper;

public class CustomFieldManagerTest {
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	CustomFieldManager customFieldManager = (CustomFieldManager) context.getBean("customFieldManager");
	CustomFieldMapper customFieldMapper = (CustomFieldMapper) context.getBean("customFieldMapper");
	
	@Before
	public void testBefore(){
		/* delete the data out the database */
		List<CustomFieldDTO> list = customFieldManager.findAll();
		int counter = 0;
		if(null != list){
			for(CustomFieldDTO c : list){
				customFieldManager.remove(c);
				counter++;
			}
		}
		/* check the size and removed objects */
		assertEquals(counter, list.size());
		assertEquals(0,customFieldManager.findAll().size());
	}
	@Test
	public void testFindAll() {
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
		CustomField cf05 = new CustomField();
		cf05.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7785}");
		cf05.setValue("TeamViewerConnectionState");
		cf05.setType(25);
		cf05.setPartnerID(0);
		/* persist the different CustomField in the database */
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf01));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf02));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf03));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf04));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf05));
		/* check the persisted objects */
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf01)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf02)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf03)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf04)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf05)));
		assertEquals(5,this.customFieldManager.findAll().size());
	}
	@Test
	public void findByCriteria(){
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
		CustomField cf05 = new CustomField();
		cf05.setUniqueID("{2ff485a9-cf1d-4168-be45-211bffd7785}");
		cf05.setValue("TeamViewerConnectionState");
		cf05.setType(25);
		cf05.setPartnerID(0);
		/* persist the different CustomField in the database */
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf01));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf02));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf03));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf04));
		this.customFieldManager.persist(customFieldMapper.mapToDTO(cf05));
		/* check the persisted objects */
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf01)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf02)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf03)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf04)));
		assertTrue(this.customFieldManager.findAll().contains(customFieldMapper.mapToDTO(cf05)));
		assertEquals(5,this.customFieldManager.findAll().size());
		/* findBy Criteria */
		/* based on the type */
		/* create CustomField Criteria 01 */
		CustomField searchCriteria01 = new CustomField();
		searchCriteria01.setUniqueID(null);
		searchCriteria01.setValue(null);
		searchCriteria01.setType(24);
		searchCriteria01.setPartnerID(0);
		/* search based on criteria */
		List<CustomFieldDTO> listSearchCriteria01 = this.customFieldManager.findByCriteria(customFieldMapper.mapToDTO(searchCriteria01));
		/* check the result */
		assertTrue(listSearchCriteria01.contains(customFieldMapper.mapToDTO(cf02)));
		assertTrue(listSearchCriteria01.contains(customFieldMapper.mapToDTO(cf03)));
		/* create CustomField Criteria 02 */
		CustomField searchCriteria02 = new CustomField();
		searchCriteria02.setUniqueID(null);
		searchCriteria02.setValue("TeamViewerConnectionState");
		searchCriteria02.setType(0);
		searchCriteria02.setPartnerID(0);
		/* search based on criteria */
		List<CustomFieldDTO> listSearchCriteria02 = this.customFieldManager.findByCriteria(customFieldMapper.mapToDTO(searchCriteria02));
		/* check the result */
		assertTrue(listSearchCriteria02.contains(customFieldMapper.mapToDTO(cf05)));		
	}
	@Test
	public void testPrsist(){
		CustomFieldDTO customFieldState = new CustomFieldDTO();
		customFieldState.setId("0");
		customFieldState.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		customFieldState.setValue("Customfield TeamViewerState");
		customFieldState.setType("25");
		customFieldState.setPartnerID("0");
		/* persist to the database */
		CustomFieldDTO customStateField = customFieldManager.persist(customFieldState);
		System.out.println(customStateField.toString());
	}
}
