package be.jtrackteamviewerplugin.service.dto;

public class TeamViewerConnectionMetaDataDTO {
	/* Instance members */
	private String id;
	private String uniqueID;
	private CustomFieldDTO customFieldDTO;
	private String value;
	private String teamViewerConnectionID;
	private String teamViewerConnectionWindowsUser;
	/**
	 * Default constructor for the Class
	 */
	public TeamViewerConnectionMetaDataDTO(){
		this.id = "0";
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
	 * @return the customFieldDTO
	 */
	public CustomFieldDTO getCustomFieldDTO() {
		return customFieldDTO;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the teamViewerConnectionID
	 */
	public String getTeamViewerConnectionID() {
		return teamViewerConnectionID;
	}

	/**
	 * @return the teamViewerConnectionWindowsUser
	 */
	public String getTeamViewerConnectionWindowsUser() {
		return teamViewerConnectionWindowsUser;
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
	 * @param customFieldDTO the customFieldDTO to set
	 */
	public void setCustomFieldDTO(CustomFieldDTO customFieldDTO) {
		this.customFieldDTO = customFieldDTO;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @param teamViewerConnectionID the teamViewerConnectionID to set
	 */
	public void setTeamViewerConnectionID(String teamViewerConnectionID) {
		this.teamViewerConnectionID = teamViewerConnectionID;
	}

	/**
	 * @param teamViewerConnectionWindowsUser the teamViewerConnectionWindowsUser to set
	 */
	public void setTeamViewerConnectionWindowsUser(
			String teamViewerConnectionWindowsUser) {
		this.teamViewerConnectionWindowsUser = teamViewerConnectionWindowsUser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customFieldDTO == null) ? 0 : customFieldDTO.hashCode());
		result = prime
				* result
				+ ((teamViewerConnectionID == null) ? 0
						: teamViewerConnectionID.hashCode());
		result = prime
				* result
				+ ((teamViewerConnectionWindowsUser == null) ? 0
						: teamViewerConnectionWindowsUser.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		TeamViewerConnectionMetaDataDTO other = (TeamViewerConnectionMetaDataDTO) obj;
		if (customFieldDTO == null) {
			if (other.customFieldDTO != null)
				return false;
		} else if (!customFieldDTO.equals(other.customFieldDTO))
			return false;
		if (teamViewerConnectionID == null) {
			if (other.teamViewerConnectionID != null)
				return false;
		} else if (!teamViewerConnectionID.equals(other.teamViewerConnectionID))
			return false;
		if (teamViewerConnectionWindowsUser == null) {
			if (other.teamViewerConnectionWindowsUser != null)
				return false;
		} else if (!teamViewerConnectionWindowsUser
				.equals(other.teamViewerConnectionWindowsUser))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		String sepa = " - ";
		output.append(this.id);
		output.append(sepa);
		output.append(this.uniqueID);
		output.append(sepa);
		output.append(this.customFieldDTO.toString());
		output.append(sepa);
		output.append(this.value);
		output.append(sepa);
		output.append(this.teamViewerConnectionWindowsUser);
		output.append(sepa);
		output.append(this.teamViewerConnectionID);
		return output.toString();
	}
	
}
