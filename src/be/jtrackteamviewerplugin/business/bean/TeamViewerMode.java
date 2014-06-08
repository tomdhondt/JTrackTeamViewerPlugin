package be.jtrackteamviewerplugin.business.bean;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;


/**
 * The persistent class for the TeamViewerMode database table.
 * 
 */
@Entity
@Table(name="TeamViewerMode")
public class TeamViewerMode implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="UniqueID",nullable=false)
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
	public TeamViewerMode() {
		this.uniqueID = "{" + UUID.randomUUID().toString() + "}";
	}
	/**
	 * Method getId will return the id of the Object
	 * @return id as int
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * Method getUniqueID will return the uniqueID of the Object
	 * @return uniqueID as String
	 */
	public String getUniqueID() {
		return this.uniqueID;
	}
	/**
	 * Method getName will return the name of the Object
	 * @return name as String
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Method getNotes will return the notes of the Object
	 * @return notes as String
	 */
	public String getNotes() {
		return this.notes;
	}
	/**
	 * Method getSamName will return the samName of the Object
	 * @return samName as String
	 */
	public String getSamName() {
		return this.samName;
	}
	/**
	 * Method setId will set the id of the Object
	 * @param id as int
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Method setUniqueID will set the uniqueID of the Object
	 * @param uniqueID as String
	 */
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	/**
	 * Method setName will set the name of the Object
	 * @param name as String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Method setNotes will set the notes of the Object
	 * @param notes as String
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	/**
	 * Method setSamName will set the samName of the Object
	 * @param samName as String
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
		TeamViewerMode other = (TeamViewerMode) obj;
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
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		String sepa = " - ";
		output.append(this.id);
		output.append(sepa);
		output.append(this.uniqueID);
		output.append(sepa);
		output.append(this.name);
		output.append(sepa);
		output.append(this.notes);
		output.append(sepa);
		output.append(this.samName);
		return output.toString();
	}
}