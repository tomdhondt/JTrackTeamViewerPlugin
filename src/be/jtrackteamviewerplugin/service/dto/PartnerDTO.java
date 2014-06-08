package be.jtrackteamviewerplugin.service.dto;

/**
 * Class represents a PartnerDTO
 * @author tom.dhondt
 * 24-sep.-2013 - 16:04:44
 */
public class PartnerDTO {
	/*
	 * Instance members
	 */
	private String id;
	private String uniqueID;
	private String dateModified;
	private String name;
	private String notes;
	private boolean isDeleted;
	private boolean isFavorite;
	private String partnerGroup_ID;
	private String basicCharge;
	private String basicChargeTime;
	private String currency;
	private String hourlyRate;
	private boolean inherit;
	
	
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
	 * @return the dateModified
	 */
	public String getDateModified() {
		return dateModified;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @return the isFavorite
	 */
	public boolean getIsFavorite() {
		return isFavorite;
	}

	/**
	 * @return the partnerGroup_ID
	 */
	public String getPartnerGroup_ID() {
		return partnerGroup_ID;
	}

	/**
	 * @return the basicCharge
	 */
	public String getBasicCharge() {
		return basicCharge;
	}

	/**
	 * @return the basicChargeTime
	 */
	public String getBasicChargeTime() {
		return basicChargeTime;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @return the hourlyRate
	 */
	public String getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @return the inherit
	 */
	public boolean getInherit() {
		return inherit;
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
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @param isFavorite the isFavorite to set
	 */
	public void setIsFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	/**
	 * @param partnerGroup_ID the partnerGroup_ID to set
	 */
	public void setPartnerGroup_ID(String partnerGroup_ID) {
		this.partnerGroup_ID = partnerGroup_ID;
	}

	/**
	 * @param basicCharge the basicCharge to set
	 */
	public void setBasicCharge(String basicCharge) {
		this.basicCharge = basicCharge;
	}

	/**
	 * @param basicChargeTime the basicChargeTime to set
	 */
	public void setBasicChargeTime(String basicChargeTime) {
		this.basicChargeTime = basicChargeTime;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * @param inherit the inherit to set
	 */
	public void setInherit(boolean inherit) {
		this.inherit = inherit;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((basicCharge == null) ? 0 : basicCharge.hashCode());
		result = prime * result
				+ ((basicChargeTime == null) ? 0 : basicChargeTime.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((dateModified == null) ? 0 : dateModified.hashCode());
		result = prime * result
				+ ((hourlyRate == null) ? 0 : hourlyRate.hashCode());
		result = prime * result + (inherit ? 1231 : 1237);
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isFavorite ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result
				+ ((partnerGroup_ID == null) ? 0 : partnerGroup_ID.hashCode());
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
		PartnerDTO other = (PartnerDTO) obj;
		if (basicCharge == null) {
			if (other.basicCharge != null)
				return false;
		} else if (!basicCharge.equals(other.basicCharge))
			return false;
		if (basicChargeTime == null) {
			if (other.basicChargeTime != null)
				return false;
		} else if (!basicChargeTime.equals(other.basicChargeTime))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (dateModified == null) {
			if (other.dateModified != null)
				return false;
		} else if (!dateModified.equals(other.dateModified))
			return false;
		if (hourlyRate == null) {
			if (other.hourlyRate != null)
				return false;
		} else if (!hourlyRate.equals(other.hourlyRate))
			return false;
		if (inherit != other.inherit)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isFavorite != other.isFavorite)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (partnerGroup_ID == null) {
			if (other.partnerGroup_ID != null)
				return false;
		} else if (!partnerGroup_ID.equals(other.partnerGroup_ID))
			return false;
		return true;
	}

	/**
	 * Return the state of the Object as a String
	 * @return state as String
	 */
	@Override
	public String toString() {
		StringBuilder state = new StringBuilder();
		String sep = " - ";
		state.append(sep);
		state.append(this.id);
		state.append(sep);
		state.append(this.uniqueID);
		state.append(sep);
		state.append(this.dateModified);
		state.append(sep);
		state.append(this.name);
		state.append(sep);
		state.append(this.notes);
		state.append(sep);
		state.append(this.isDeleted);
		state.append(sep);
		state.append(this.isFavorite);
		state.append(sep);
		state.append(this.partnerGroup_ID);
		state.append(sep);
		state.append(this.basicCharge);
		state.append(sep);
		state.append(this.basicChargeTime);
		state.append(sep);
		state.append(this.currency);
		state.append(sep);
		state.append(this.hourlyRate);
		state.append(sep);
		state.append(this.inherit);
		return state.toString();
	}
	
}
