package be.jtrackteamviewerplugin.business.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * Class TeamViewer.java will represent a TeamViewer session
 * @author tom.dhondt - Created at :  19-nov.-2013
 */
@Entity
@Table(name="TeamViewer")
public class TeamViewer implements Serializable{
	/**
	 * Serial version ID
	 */
	private static final long serialVersionUID = -2542342947415832302L;
	/* Instance members */
	@Id
	@GeneratedValue
	@Column(name="ID",nullable=false)
	private int id;
	@Column(name="UniqueID")
	private String uniqueID;
	@Column(name="Address")
	private String address;
	@Column(name="Password")
	private String password;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Partner_ID", nullable=false)
	private Partner partner;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="m_ID", nullable=false)
	private TeamViewerMode teamViewerMode;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="q_ID", nullable=false)
	private TeamViewerQuality teamViewerQuality;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "teamViewer")
	private List<TeamViewerConnection> teamViewerConnectionList;
	/**
	 * Default constructor for the Class
	 */
	public TeamViewer(){
		this.teamViewerConnectionList = new ArrayList<TeamViewerConnection>();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the teamViewerConnectionList
	 */
	public List<TeamViewerConnection> getTeamViewerConnectionList() {
		return this.teamViewerConnectionList;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the uniqueID
	 */
	public String getUniqueID() {
		return uniqueID;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the partner
	 */
	public Partner getPartner() {
		return partner;
	}
	/**
	 * @return the teamVieuwerMode
	 */
	public TeamViewerMode getTeamViewerMode() {
		return teamViewerMode;
	}
	/**
	 * @return the teamVieuwerQuality
	 */
	public TeamViewerQuality getTeamViewerQuality() {
		return teamViewerQuality;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @param uniqueID the uniqueID to set
	 */
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	
	/**
	 * @param partner the partner to set
	 */
	public void setPartner(Partner partner) {
		this.partner = partner;
	}	
	/**
	 * @param teamVieuwerMode the teamVieuwerMode to set
	 */
	public void setTeamViewerMode(TeamViewerMode teamVieuwerMode) {
		this.teamViewerMode = teamVieuwerMode;
	}
	
	/**
	 * @param teamViewerQuality the teamVieuwerQuality to set
	 */
	public void setTeamViewerQuality(TeamViewerQuality teamViewerQuality) {
		this.teamViewerQuality = teamViewerQuality;
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
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((uniqueID == null) ? 0 : uniqueID.hashCode());
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
		TeamViewer other = (TeamViewer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
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
		output.append(this.address);
		output.append(sepa);
		output.append(this.password);
		return output.toString();
	}
}
