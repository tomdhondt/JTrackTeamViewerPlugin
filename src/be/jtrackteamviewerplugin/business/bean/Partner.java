package be.jtrackteamviewerplugin.business.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Partner")
public class Partner implements Serializable {
	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = -8911987881861825599L;
	/*
	 * Instance members
	 */
	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private int id;	
	@Column(name="uniqueID", nullable=false)
	private String uniqueID;
	@Column(name="dateModified")
	@DateTimeFormat(pattern="yyyy-mm-dd hh:MM:ss.SSS")
	private Date dateModified;
	@Column(name="name")
	private String name;
	@Column(name="notes")
	private String notes;
	@Column(name="isDeleted")
	private boolean isDeleted;
	@Column(name="isFavorite")
	private boolean isFavorite;
	@Column(name="partnerGroup_ID")
	private int partnerGroup_ID;
	@Column(name="BasicCharge")
	private BigDecimal basicCharge;
	@Column(name="basicChargeTime")
	private int basicChargeTime;
	@Column(name="currency")
	private int currency;
	@Column(name="hourlyRate")
	private BigDecimal hourlyRate;
	@Column(name="inherit")
	private Boolean inherit;
	@Transient
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:MM:ss");
	/**
	 * Default constructor for the Class
	 */
	public Partner(){
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
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
	public Date getDateModified() {
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
	 * @return the partnerGroup_ID
	 */
	public Integer getPartnerGroup_ID() {
		return partnerGroup_ID;
	}
	/**
	 * @return the basicCharge
	 */
	public BigDecimal getBasicCharge() {
		return basicCharge;
	}
	/**
	 * @return the basicChargeTime
	 */
	public int getBasicChargeTime() {
		return basicChargeTime;
	}
	/**
	 * @return the currency
	 */
	public int getCurrency() {
		return currency;
	}
	/**
	 * @return the hourlyRate
	 */
	public BigDecimal getHourlyRate() {
		return hourlyRate;
	}
	/**
	 * @return the inherit
	 */
	public Boolean getInherit() {
		return inherit;
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
	public void setDateModified(Date dateModified) {
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
	public void setPartnerGroup_ID(Integer partnerGroup_ID) {
		this.partnerGroup_ID = partnerGroup_ID;
	}
	/**
	 * @param basicCharge the basicCharge to set
	 */
	public void setBasicCharge(BigDecimal basicCharge) {
		this.basicCharge = basicCharge;
	}
	/**
	 * @param basicChargeTime the basicChargeTime to set
	 */
	public void setBasicChargeTime(int basicChargeTime) {
		this.basicChargeTime = basicChargeTime;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(int currency) {
		this.currency = currency;
	}
	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(BigDecimal hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	/**
	 * @param inherit the inherit to set
	 */
	public void setInherit(Boolean inherit) {
		this.inherit = inherit;
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
		result = prime * result + basicChargeTime;
		result = prime * result + currency;
		result = prime * result
				+ ((dateModified == null) ? 0 : dateModified.hashCode());
		result = prime * result
				+ ((hourlyRate == null) ? 0 : hourlyRate.hashCode());
		result = prime * result + ((inherit == null) ? 0 : inherit.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + (isFavorite ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
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
		Partner other = (Partner) obj;
		if (basicCharge == null) {
			if (other.basicCharge != null)
				return false;
		} else if (!basicCharge.equals(other.basicCharge))
			return false;
		if (basicChargeTime != other.basicChargeTime)
			return false;
		if (currency != other.currency)
			return false;
		if (dateModified == null) {
			if (other.dateModified != null)
				return false;
		} else if (!sdf.format(dateModified).equals(sdf.format(other.dateModified)))
			return false;
		if (hourlyRate == null) {
			if (other.hourlyRate != null)
				return false;
		} else if (!hourlyRate.equals(other.hourlyRate))
			return false;
		if (inherit == null) {
			if (other.inherit != null)
				return false;
		} else if (!inherit.equals(other.inherit))
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
		return true;
	}
	/**
	 * Method will return the state of the object as a String
	 * @return state as String
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		String sepa = " - ";
		output.append(this.id);
		output.append(sepa);
		output.append(this.uniqueID);
		output.append(sepa);
		output.append(this.dateModified);
		output.append(sepa);
		output.append(this.name);
		output.append(sepa);
		output.append(this.notes);
		output.append(sepa);
		output.append(this.isDeleted);
		output.append(sepa);
		output.append(this.isFavorite);
		output.append(sepa);
		output.append(this.partnerGroup_ID);
		output.append(sepa);
		output.append(this.basicCharge);
		output.append(sepa);
		output.append(this.basicChargeTime);
		output.append(sepa);
		output.append(this.currency);
		output.append(sepa);
		output.append(this.hourlyRate);
		output.append(sepa);
		output.append(this.inherit);
		return output.toString();
	}
}
