package be.jtrackteamviewerplugin.service.dto;

import static org.junit.Assert.*;
import nl.knowlogy.validation.Message;
import nl.knowlogy.validation.MessagesImpl;
import nl.knowlogy.validation.ValidationEngine;

import org.junit.Test;

public class CustomFieldDTOTest {

	@Test
	public void testValidateId(){
		/* Create a customfieldDTO */
		CustomFieldDTO dto = new CustomFieldDTO();
		/* validate the emty object */
		MessagesImpl messages01 = new MessagesImpl();
		ValidationEngine.validate(dto, messages01);
		Message valueMessage = messages01.getMessage(dto, "value");
		assertNotNull("value of the customField can't be null",valueMessage);
		/* set the value of the customFieldDTO */
		dto.setValue("CustomField 02");
		MessagesImpl messages02 = new MessagesImpl();
		ValidationEngine.validate(dto, messages02);
		Message valueMessage02 = messages02.getMessage(dto, "value");
		assertNull("value of the customField is null",valueMessage02);
		/* set the value of the customFieldDTO */
		MessagesImpl messages03 = new MessagesImpl();
		ValidationEngine.validate(dto, messages03);
		Message valueMessage03 = messages03.getMessage(dto, "type");
		assertNotNull("type of the customField can't be null",valueMessage03);
		/* set the value of the customFieldDTO */
		dto.setType("123");
		MessagesImpl messages04 = new MessagesImpl();
		ValidationEngine.validate(dto, messages04);
		Message valueMessage04 = messages04.getMessage(dto, "type");
		assertNull("type of the customField is null",valueMessage04);
	}
}
