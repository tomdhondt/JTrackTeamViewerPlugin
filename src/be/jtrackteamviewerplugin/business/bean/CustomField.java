package be.jtrackteamviewerplugin.business.bean;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CustomField")
public class CustomField {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="UniqueID")
	private String uniqueID;
	@Column(name="Value")
	private String value;
	@Column(name="Type")
	private int type;
	@Column(name="PartnerID")
	private int partnerID;
	/**
	 * Default constructor for the Class
	 */
	public CustomField(){
		this.uniqueID = "{" + UUID.randomUUID().toString() + "}";
		this.partnerID = 0;
		this.type = 0;
	}
	/**
	 * Constructor for the Class
	 * @param value as String
	 * @param type as int
	 * @param partner_ID as int
	 */
	public CustomField(String value, int type, int partner_ID){
		this.value = value;
		this.type = type;
		this.partnerID = partner_ID;
	}
	/**
	 * @return the id
	 */
	public int getId() {
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
	public String getValue() {
		return value;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @return the partnerID
	 */
	public int getPartnerID() {
		return partnerID;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @param partnerID the partnerID to set
	 */
	public void setPartnerID(int partnerID) {
		this.partnerID = partnerID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partnerID;
		result = prime * result + type;
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
		CustomField other = (CustomField) obj;
		if (partnerID != other.partnerID)
			return false;
		if (type != other.type)
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
	 * @return String as State
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		String sepa = " - ";
		output.append(this.id);
		output.append(sepa);
		output.append(this.uniqueID);
		output.append(sepa);
		output.append(this.value);
		output.append(sepa);
		output.append(this.type);
		output.append(sepa);
		output.append(this.partnerID);
		return output.toString();
	}
	
}
