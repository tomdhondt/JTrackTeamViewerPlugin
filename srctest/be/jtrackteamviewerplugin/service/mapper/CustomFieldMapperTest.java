package be.jtrackteamviewerplugin.service.mapper;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.service.dto.CustomFieldDTO;

public class CustomFieldMapperTest {
	@Test
	public void testMapToObject() {
		CustomField customField = new CustomField();
		customField.setId(1234);
		customField.setPartnerID(10);
		customField.setType(12);
		customField.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		customField.setValue("CustomFIeldName");
		CustomFieldMapper customFieldMapper = new CustomFieldMapper();
		CustomFieldDTO dto = customFieldMapper.mapToDTO(customField);
		CustomField object = customFieldMapper.mapToObject(dto);
		assertNotNull(customField);
		assertNotNull(object);
		assertNotNull(dto);
		assertEquals(customField, object);
	}
	@Test
	public void testMapToDTO() {
		CustomFieldDTO customFieldDTO = new CustomFieldDTO();
		customFieldDTO.setId("1234");
		customFieldDTO.setPartnerID("10");
		customFieldDTO.setType("12");
		customFieldDTO.setUniqueID("{" + UUID.randomUUID().toString() + "}");
		customFieldDTO.setValue("CustomFIeldName");
		CustomFieldMapper customFieldMapper = new CustomFieldMapper();
		CustomField object = customFieldMapper.mapToObject(customFieldDTO);
		CustomFieldDTO dto = customFieldMapper.mapToDTO(object);
		assertNotNull(customFieldDTO);
		assertNotNull(object);
		assertNotNull(dto);
		assertEquals(customFieldDTO, dto);
	}
}
