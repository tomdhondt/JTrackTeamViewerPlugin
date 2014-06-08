package be.jtrackteamviewerplugin.service.mapper;

import be.jtrackteamviewerplugin.business.bean.CustomField;
import be.jtrackteamviewerplugin.service.dto.CustomFieldDTO;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class CustomFieldMapper extends AbstractMapper<CustomField, CustomFieldDTO> {
	/**
	 * Method will map a DTO to a Object
	 * @param dto as CustomFieldDTO
	 * @return object as CustomField
	 */
	@Override
	public CustomField mapToObject(CustomFieldDTO dto) {
		CustomField customField = new CustomField();
		if(null != dto){
			/*
			 * Set the customFieldID
			 */
			try{
				customField.setId(MappingUtil.mapStringToInt(dto.getId()));
			}catch(Exception eXp){
				customField.setId(0);
			}
			customField.setUniqueID(dto.getUniqueID());
			customField.setValue(dto.getValue());
			customField.setType(MappingUtil.mapStringToInt(dto.getType()));
			/*
			 * Set the partnerID
			 */
			try{
				customField.setPartnerID(MappingUtil.mapStringToInt(dto.getPartnerID()));
			}catch(Exception eXp){
				customField.setPartnerID(0);
			}
		}else{
			customField = null;
		}
		return customField;
	}
	/**
	 * Method will map a object to a DTO
	 * @param object as CustomField
	 * @return dto as CustomFieldDTO
	 */
	@Override
	public CustomFieldDTO mapToDTO(CustomField object) {
		CustomFieldDTO customFieldDO = new CustomFieldDTO();
		if(null != object){
			customFieldDO.setId(MappingUtil.mapIntToString(object.getId()));
			customFieldDO.setUniqueID(object.getUniqueID());
			customFieldDO.setValue(object.getValue());
			customFieldDO.setType(MappingUtil.mapIntToString(object.getType()));
			customFieldDO.setPartnerID(MappingUtil.mapIntToString(object.getPartnerID()));
		}else{
			customFieldDO = null;
		}
		return customFieldDO;
	}

}
