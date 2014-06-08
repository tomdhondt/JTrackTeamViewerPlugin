package be.jtrackteamviewerplugin.service.mapper;

/**
 * IMapper Interface will allow you to push to each Mapper the right methods
 */
public interface IMapper<O, D>{
	/**
	 * Map a DTO to a Object of a certain object type
	 * @param d as DTO
	 * @return o as Object
	 */
	public O mapToObject(D dto);
	/**
	 * Map a Object to a DTO of a certain DTO type
	 * @param o as Object
	 * @return d as DTO
	 */
	public D mapToDTO(O object);

}
