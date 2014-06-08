package be.jtrackteamviewerplugin.business.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="TeamViewerConnectionMetaData")
public class TeamViewerConnectionMetaData {
	/*
	 * Instance members
	 */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "UniqueID", nullable=false)
	private String uniqueID;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CustomField_ID")
	private CustomField customField;
	@Column(name="Value")
	private String value;
//	@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne()
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "TeamViewerConnection_ID")
	private TeamViewerConnection teamViewerConnection;
	/**
	 * Default constructor for the Class
	 */
	public TeamViewerConnectionMetaData(){
		this.id = 0;
	}
	/**
	 * Constructor for the Class 
	 * @param teamViewerConnection as TeamViewerConnectionMetaData
	 * @param customField as CustomField
	 * @param value as String
	 */
	public TeamViewerConnectionMetaData(TeamViewerConnection teamViewerConnection,CustomField customField, String value){
		this.customField = customField;
		this.value = value;
		this.teamViewerConnection = teamViewerConnection;
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
	 * @return the customField
	 */
	public CustomField getCustomField() {
		return customField;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
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
	 * @param customField the customField to set
	 */
	public void setCustomField(CustomField customField) {
		this.customField = customField;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * @return the teamViewerConnection
	 */
	public TeamViewerConnection getTeamViewerConnection() {
		return teamViewerConnection;
	}
	/**
	 * @param teamViewerConnection the teamViewerConnection to set
	 */
	public void setTeamViewerConnection(TeamViewerConnection teamViewerConnection) {
		this.teamViewerConnection = teamViewerConnection;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((customField == null) ? 0 : customField.hashCode());
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
		TeamViewerConnectionMetaData other = (TeamViewerConnectionMetaData) obj;
		if (customField == null) {
			if (other.customField != null)
				return false;
		} else if (!customField.equals(other.customField))
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
		output.append(this.customField);
		output.append(sepa);
		output.append(this.value);
		return output.toString();
	}
	
}
