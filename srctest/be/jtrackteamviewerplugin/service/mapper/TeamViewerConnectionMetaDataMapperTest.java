package be.jtrackteamviewerplugin.service.mapper;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.TeamViewerConnectionMetaData;
import be.jtrackteamviewerplugin.service.dto.CustomFieldDTO;
import be.jtrackteamviewerplugin.service.dto.TeamViewerConnectionMetaDataDTO;

public class TeamViewerConnectionMetaDataMapperTest {
	/* Instance members */
	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
	
	@Test
	public void testMapToObject() {
		TeamViewerConnectionMetaDataMapper teamViewerConnectionMetaDataMapper = (TeamViewerConnectionMetaDataMapper) context.getBean("teamViewerConnectionMetaDataMapper");
		assertNull(teamViewerConnectionMetaDataMapper.mapToDTO(null));
		assertNull(teamViewerConnectionMetaDataMapper.mapToObject(null));
		/* Create a new teamViewerConnectionMetaDataDTO */
		TeamViewerConnectionMetaDataDTO teamViewerConnectionMetaDataDTO02 = new TeamViewerConnectionMetaDataDTO();
		teamViewerConnectionMetaDataDTO02.setId("1234");
		String randomDTO02 = "{" + UUID.randomUUID().toString() + "}";
		String randomCfDTO01 = "{" + UUID.randomUUID().toString() + "}";
		teamViewerConnectionMetaDataDTO02.setUniqueID(randomDTO02);
		/* Map the dto to a object */
		TeamViewerConnectionMetaData object02 = teamViewerConnectionMetaDataMapper.mapToObject(teamViewerConnectionMetaDataDTO02);
		/* check the properties */
		assertEquals(1234, object02.getId());
		assertEquals(randomDTO02, object02.getUniqueID());
		assertEquals(null, object02.getCustomField());
		assertEquals(null, object02.getTeamViewerConnection());
		assertEquals(null, object02.getValue());
		/* set the values again */
		/* create a CustomFieldDTO */
		CustomFieldDTO cfDTO01 = new CustomFieldDTO();
		cfDTO01.setId("3254");
		cfDTO01.setUniqueID(randomCfDTO01);
		cfDTO01.setPartnerID("9635");
		cfDTO01.setType("123");
		cfDTO01.setValue("Value CustomField 01");
		teamViewerConnectionMetaDataDTO02.setCustomFieldDTO(cfDTO01);
		/* Map the dto to a object */
		TeamViewerConnectionMetaData object03 = teamViewerConnectionMetaDataMapper.mapToObject(teamViewerConnectionMetaDataDTO02);
		/* check the values */
		assertNotNull(object03.getCustomField());
		assertEquals(3254, object03.getCustomField().getId());
		assertEquals(9635, object03.getCustomField().getPartnerID());
		assertEquals(123, object03.getCustomField().getType());
		assertEquals(randomCfDTO01, object03.getCustomField().getUniqueID());
		assertEquals("Value CustomField 01", object03.getCustomField().getValue());
		TeamViewerConnectionMetaDataDTO objectDTP01 = teamViewerConnectionMetaDataMapper.mapToDTO(object03);
		assertEquals(teamViewerConnectionMetaDataDTO02, objectDTP01);
	}
}
