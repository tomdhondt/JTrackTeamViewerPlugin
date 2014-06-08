package be.jtrackteamviewerplugin.service.mapper;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Test;

import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.service.dto.PartnerDTO;
import be.jtrackteamviewerplugin.util.DateUtil;

public class PartnerMapperTest {

	@Test
	public void testMapToObject() {
		Partner partner = new Partner();
		PartnerMapper partnerMapper = new PartnerMapper(); 
		partner.setId(1);
		partner.setUniqueID("{"+ UUID.randomUUID().toString()+"}");
		partner.setDateModified(DateUtil.getCurentDate());
		partner.setName("Partner 01");
		partner.setNotes("Notes belonging to the partner 01");
		partner.setIsDeleted(false);
		partner.setIsFavorite(true);
		partner.setPartnerGroup_ID(1234);
		partner.setBasicCharge(new BigDecimal(50));
		partner.setBasicChargeTime(10);
		partner.setCurrency(1);
		partner.setHourlyRate(new BigDecimal(120));
		partner.setInherit(false);
		PartnerDTO dto = partnerMapper.mapToDTO(partner);
		Partner partnerObj = partnerMapper.mapToObject(dto);
		assertNotNull(dto);
		assertNotNull(partnerObj);
		assertEquals(partnerObj, partner);
		assertEquals(partner.getId(), partnerObj.getId());
		assertEquals(partner.getUniqueID(), partnerObj.getUniqueID());
	}
	@Test
	public void testMapToDTO() {
		PartnerDTO partnerDTO = new PartnerDTO();
		PartnerMapper partnerMapper = new PartnerMapper(); 
		partnerDTO.setId("1");
		partnerDTO.setUniqueID("{"+ UUID.randomUUID().toString()+"}");
		partnerDTO.setDateModified(DateUtil.getCurentDateAsString(null));
		partnerDTO.setName("Partner 01");
		partnerDTO.setNotes("Notes belonging to the partner 01");
		partnerDTO.setIsDeleted(false);
		partnerDTO.setIsFavorite(true);
		partnerDTO.setPartnerGroup_ID("1234");
		partnerDTO.setBasicCharge("50");
		partnerDTO.setBasicChargeTime("10");
		partnerDTO.setCurrency("1");
		partnerDTO.setHourlyRate("120");
		partnerDTO.setInherit(false);
		Partner partnerObj = partnerMapper.mapToObject(partnerDTO);
		PartnerDTO dto = partnerMapper.mapToDTO(partnerObj);
		assertNotNull(dto);
		assertNotNull(partnerObj);
		assertEquals(dto, partnerDTO);
		assertEquals(dto.getId(), partnerDTO.getId());
		assertEquals(dto.getUniqueID(), partnerDTO.getUniqueID());
	}

}
