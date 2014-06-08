package be.jtrackteamviewerplugin.service.mapper;

import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.service.dto.PartnerDTO;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class PartnerMapper extends AbstractMapper<Partner, PartnerDTO> {
	/**
	 * Method will map a DTO to a Object
	 * @param dto as PartnerDTO
	 * @return object as Partner
	 */
	@Override
	public Partner mapToObject(PartnerDTO dto) {
		Partner partner = new Partner();
		if(null != dto){
			partner.setId(MappingUtil.mapStringToInt(dto.getId()));
			partner.setUniqueID(dto.getUniqueID());
			try {
				partner.setDateModified(MappingUtil.mapStringToDate(dto.getDateModified(), null));
			} catch (NullPointerException e) {
				partner.setDateModified(null);
			} catch (UnsupportedOperationException e) {
				partner.setDateModified(null);
			} catch (IllegalArgumentException e) {
				partner.setDateModified(null);
			}
			partner.setName(dto.getName());
			partner.setNotes(dto.getNotes());
			partner.setIsDeleted(dto.getIsDeleted());
			partner.setIsFavorite(dto.getIsFavorite());
			try{
				partner.setPartnerGroup_ID(MappingUtil.mapStringToInt(dto.getPartnerGroup_ID()));
			}catch(Exception eXp){
				partner.setPartnerGroup_ID(0);
			}
			try{
				partner.setBasicCharge(MappingUtil.mapStringToBigDecimal(dto.getBasicCharge()));
			}catch(Exception eXp){
				partner.setBasicCharge(null);	
			}
			try{
				partner.setBasicChargeTime(MappingUtil.mapStringToInt(dto.getBasicChargeTime()));	
			}catch(Exception eXp){
				partner.setBasicChargeTime(0);
			}
			try{
				partner.setCurrency(MappingUtil.mapStringToInt(dto.getCurrency()));
			}catch(Exception eXp){
				partner.setCurrency(0);
			}
			try{
				partner.setHourlyRate(MappingUtil.mapStringToBigDecimal(dto.getHourlyRate()));	
			}catch(Exception eXp){
				partner.setHourlyRate(null);
			}
			partner.setInherit(dto.getInherit());
		}else{
			partner = null; 
		}
		return partner;
	}
	/**
	 * Method will map a DTO to a Object
	 * @return dto as PartnerDTO
	 * @param object as Partner
	 */
	@Override
	public PartnerDTO mapToDTO(Partner object) {
		PartnerDTO partnerDTO = new PartnerDTO();
		if(null != object){
			partnerDTO.setId(MappingUtil.mapIntToString(object.getId()));
			partnerDTO.setUniqueID(object.getUniqueID());
			partnerDTO.setDateModified(MappingUtil.mapDateToString(object.getDateModified(),null));
			partnerDTO.setName(object.getName());
			partnerDTO.setNotes(object.getNotes());
			partnerDTO.setIsDeleted(object.getIsDeleted());
			partnerDTO.setIsFavorite(object.getIsFavorite());
			partnerDTO.setPartnerGroup_ID(MappingUtil.mapIntToString(object.getPartnerGroup_ID()));
			try {
				partnerDTO.setBasicCharge(MappingUtil.mapBigDecimalToString(object.getBasicCharge()));
			} catch (Exception e) {
				partnerDTO.setBasicCharge(null);
			}
			partnerDTO.setBasicChargeTime(MappingUtil.mapIntToString(object.getBasicChargeTime()));
			partnerDTO.setCurrency(MappingUtil.mapIntToString(object.getCurrency()));
			try {
				partnerDTO.setHourlyRate(MappingUtil.mapBigDecimalToString(object.getHourlyRate()));
			} catch (Exception e) {
				partnerDTO.setHourlyRate(null);
			}
			partnerDTO.setInherit(object.getInherit());
		}else{
			partnerDTO = null;
		}
		return partnerDTO;
	}

	
}
