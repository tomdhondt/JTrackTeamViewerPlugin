package be.jtrackteamviewerplugin.service.dto;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author tom.dhondt
 */
public class TeamViewerDTO {
	/*
	 * Instance members
	 */
	private String id;
	private String uniqueID;
	private String address;
	private String password;
	private PartnerDTO partnerDTO;
	private String partnerName;
	private String partnerID;
	private String teamViewerModeName;
	private String teamViewerModeID;
	private String teamViewerQualityName;
	private String teamViewerQualityID;
	private List<TeamViewerConnectionDTO> teamViewerConnectionList;
	/**
	 * Default constructor for the class.
	 */
	public TeamViewerDTO(){
		this.teamViewerConnectionList = new ArrayList<TeamViewerConnectionDTO>();
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the uniqueID
	 */
	public String getUniqueID() {
		return uniqueID;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the partnerName
	 */
	public String getPartnerName() {
		return partnerName;
	}
	/**
	 * @return the partnerID
	 */
	public String getPartnerID() {
		return partnerID;
	}
	/**
	 * @return the teamViewerModeName
	 */
	public String getTeamViewerModeName() {
		return teamViewerModeName;
	}
	/**
	 * @return the teamViewerModeID
	 */
	public String getTeamViewerModeID() {
		return teamViewerModeID;
	}
	/**
	 * @return the teamViewerQualityName
	 */
	public String getTeamViewerQualityName() {
		return teamViewerQualityName;
	}
	/**
	 * @return the teamViewerQualityID
	 */
	public String getTeamViewerQualityID() {
		return teamViewerQualityID;
	}
	/**
	 * @return the teamViewerConnectionList
	 */
	public List<TeamViewerConnectionDTO> getTeamViewerConnectionList() {
		return teamViewerConnectionList;
	}
	/**
	 * @return the partnerDTO
	 */
	public PartnerDTO getPartnerDTO() {
		return partnerDTO;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param uniqueID the uniqueID to set
	 */
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param partnerName the partnerName to set
	 */
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	/**
	 * @param partnerID the partnerID to set
	 */
	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}
	/**
	 * @param teamViewerModeName the teamViewerModeName to set
	 */
	public void setTeamViewerModeName(String teamViewerModeName) {
		this.teamViewerModeName = teamViewerModeName;
	}
	/**
	 * @param teamViewerModeID the teamViewerModeID to set
	 */
	public void setTeamViewerModeID(String teamViewerModeID) {
		this.teamViewerModeID = teamViewerModeID;
	}
	/**
	 * @param teamViewerQualityName the teamViewerQualityName to set
	 */
	public void setTeamViewerQualityName(String teamViewerQualityName) {
		this.teamViewerQualityName = teamViewerQualityName;
	}
	/**
	 * @param teamViewerQualityID the teamViewerQualityID to set
	 */
	public void setTeamViewerQualityID(String teamViewerQualityID) {
		this.teamViewerQualityID = teamViewerQualityID;
	}
	
	/**
	 * @param partnerDTO the partnerDTO to set
	 */
	public void setPartnerDTO(PartnerDTO partnerDTO) {
		this.partnerDTO = partnerDTO;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((partnerID == null) ? 0 : partnerID.hashCode());
		result = prime * result
				+ ((partnerName == null) ? 0 : partnerName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime
				* result
				+ ((teamViewerModeID == null) ? 0 : teamViewerModeID.hashCode());
		result = prime
				* result
				+ ((teamViewerModeName == null) ? 0 : teamViewerModeName
						.hashCode());
		result = prime
				* result
				+ ((teamViewerQualityID == null) ? 0 : teamViewerQualityID
						.hashCode());
		result = prime
				* result
				+ ((teamViewerQualityName == null) ? 0 : teamViewerQualityName
						.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeamViewerDTO other = (TeamViewerDTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (partnerID == null) {
			if (other.partnerID != null)
				return false;
		} else if (!partnerID.equals(other.partnerID))
			return false;
		if (partnerName == null) {
			if (other.partnerName != null)
				return false;
		} else if (!partnerName.equals(other.partnerName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (teamViewerModeID == null) {
			if (other.teamViewerModeID != null)
				return false;
		} else if (!teamViewerModeID.equals(other.teamViewerModeID))
			return false;
		if (teamViewerModeName == null) {
			if (other.teamViewerModeName != null)
				return false;
		} else if (!teamViewerModeName.equals(other.teamViewerModeName))
			return false;
		if (teamViewerQualityID == null) {
			if (other.teamViewerQualityID != null)
				return false;
		} else if (!teamViewerQualityID.equals(other.teamViewerQualityID))
			return false;
		if (teamViewerQualityName == null) {
			if (other.teamViewerQualityName != null)
				return false;
		} else if (!teamViewerQualityName.equals(other.teamViewerQualityName))
			return false;
		return true;
	}
	/**
	 * Method will return the state of the object as a String
	 * @return state as String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		StringBuilder state = new StringBuilder();
		String sep = " - ";
		state.append(this.getId());
		state.append(sep);
		state.append(this.uniqueID);
		state.append(sep);
		state.append(this.address);
		state.append(sep);
		state.append(this.password);
		state.append(sep);
		state.append(this.partnerID);
		state.append(sep);
		state.append(this.partnerName);
		state.append(sep);
		state.append(this.teamViewerModeID);
		state.append(sep);
		state.append(this.teamViewerModeName);
		state.append(sep);
		state.append(this.teamViewerQualityID);
		state.append(sep);
		state.append(this.teamViewerQualityName);
		return state.toString();
	}	
}
