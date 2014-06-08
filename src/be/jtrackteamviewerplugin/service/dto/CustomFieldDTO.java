package be.jtrackteamviewerplugin.service.dto;

import nl.knowlogy.validation.annotations.ValidateClass;
import nl.knowlogy.validation.annotations.ValidateIsNotBlank;
import nl.knowlogy.validation.annotations.ValidatePattern;

/**
 * Class represents a CustomFieldDTO
 * @author tom.dhondt
 * 08-dec.-2013 - 12:23:15
 */
@ValidateClass
public class CustomFieldDTO {
	/* Instance members */
	private String id;
	private String uniqueID;
	private String value;
	private String type;
	private String partnerID;
	
	/**
	 * Default constructor for the Class
	 */
	public CustomFieldDTO(){
		this.id = "0";
	}
	/**
	 * Constructor for the Class
	 * @param id as String
	 * @param uniqueID as String
	 * @param value as String
	 * @param type as String
	 * @param partnerID as String
	 */
	public CustomFieldDTO(String id, String uniqueID, String value, String type, String partnerID){
		this.id = id;
		this.uniqueID = uniqueID;
		this.value = value;
		this.type = type;
		this.partnerID = partnerID;
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
	 * @return the value
	 */
	@ValidateIsNotBlank(errorCode="value.isrequired")
	public String getValue() {
		return value;
	}

	/**
	 * @return the type
	 */
	@ValidateIsNotBlank(errorCode="type.isrequired")
	@ValidatePattern(pattern="^[0-9]+$",errorCode="type.enterInt")
	public String getType() {
		return type;
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
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the partnerID
	 */
	public String getPartnerID() {
		return partnerID;
	}

	/**
	 * @param partnerID the partnerID to set
	 */
	public void setPartnerID(String partnerID) {
		this.partnerID = partnerID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((partnerID == null) ? 0 : partnerID.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		CustomFieldDTO other = (CustomFieldDTO) obj;
		if (partnerID == null) {
			if (other.partnerID != null)
				return false;
		} else if (!partnerID.equals(other.partnerID))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/**
	 * Method will return the state of the object as a String
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		String sep = " - ";
		out.append(this.id);
		out.append(sep);
		out.append(this.uniqueID);
		out.append(sep);
		out.append(this.value);
		out.append(sep);
		out.append(this.type);
		out.append(sep);
		out.append(this.partnerID);
		return out.toString();
	}

    
}
