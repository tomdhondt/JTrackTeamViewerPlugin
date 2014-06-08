package be.jtrackteamviewerplugin.business.bean;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

/**
 * The persistent class for the TeamViewerQuality database table.
 * 
 */
@Entity
@Table(name="TeamViewerQuality")
public class TeamViewerQuality implements Serializable {
	/**
	 * serial version id
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * instance members
	 */
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="UniqueID")
	private String uniqueID;
	@Column(name="Name")
	private String name;
	@Column(name="Notes")
	private String notes;
	@Column(name="SamName")
	private String samName;

	/**
	 * Default constructor
	 */
	public TeamViewerQuality() {
		this.uniqueID = "{" + UUID.randomUUID().toString() + "}";
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
	 * @return the samName
	 */
	public String getSamName() {
		return samName;
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
	 * @param samName the samName to set
	 */
	public void setSamName(String samName) {
		this.samName = samName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((samName == null) ? 0 : samName.hashCode());
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
		TeamViewerQuality other = (TeamViewerQuality) obj;
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
		if (samName == null) {
			if (other.samName != null)
				return false;
		} else if (!samName.equals(other.samName))
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
		output.append(this.name);
		output.append(sepa);
		output.append(this.uniqueID);
		output.append(sepa);
		output.append(this.notes);
		output.append(sepa);
		output.append(this.samName);
		return output.toString();
	}
}