package be.jtrackteamviewerplugin.service.manager;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.jtrackteamviewerplugin.business.bean.Partner;
import be.jtrackteamviewerplugin.business.data.PartnerDAOImpl;
import be.jtrackteamviewerplugin.service.dto.PartnerDTO;
import be.jtrackteamviewerplugin.service.mapper.PartnerMapper;
import be.jtrackteamviewerplugin.util.MappingUtil;

public class PartnerManager implements IManagerDTO<PartnerDTO> {

	@Override
	public PartnerDTO persist(PartnerDTO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartnerDTO update(PartnerDTO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(PartnerDTO object) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Method will find a object based on the id.
	 * @return object as PartnerDTO
	 * @param id as String
	 */
	@Override
	public PartnerDTO findByID(String ID) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContent.xml"});
		PartnerDAOImpl partnerDAOImpl = (PartnerDAOImpl) context.getBean("partnerDAOImpl");
		PartnerMapper partnerMapper = (PartnerMapper) context.getBean("partnerMapper");
		PartnerDTO dto = null;
		/* map the id to Integer */
		int id = MappingUtil.mapStringToInt(ID);
		if(id > -1){
			Partner object = partnerDAOImpl.findByID(id);
			dto = partnerMapper.mapToDTO(object);
		}
		return dto;
	}

	@Override
	public List<PartnerDTO> findByCriteria(PartnerDTO object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PartnerDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
