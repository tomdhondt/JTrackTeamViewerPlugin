package be.jtrackteamviewerplugin.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class represents a TeamViewerConnectionDTO
 * @author tom.dhondt
 * 24-sep.-2013 - 16:25:56
 */
public class TeamViewerConnectionDTO {
	/*
	 * instance members
	 */
	private String id;
	private String uniqueID;
	private String start;
	private Date startDate;
	private String finish;
	private Date endDate;
	private String hour;
	private String minutes;
	private String seconds;
	private String notes;
	private boolean isDeleted;
	private String windowsUser;
	private String price;
	private String hash;
	private boolean bill;
	private String teamViewerAddress;
	private String teamViewerID;
	private List<TeamViewerConnectionMetaDataDTO> teamViewerConnectionMetaDataList;
	/**
	 * Default constructor for the Class
	 */
	public TeamViewerConnectionDTO(){
		this.teamViewerConnectionMetaDataList = new ArrayList<TeamViewerConnectionMetaDataDTO>();
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
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the finish
	 */
	public String getFinish() {
		return finish;
	}

	/**
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * @return the minutes
	 */
	public String getMinutes() {
		return minutes;
	}

	/**
	 * @return the seconds
	 */
	public String getSeconds() {
		return seconds;
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
	 * @return the windowsUser
	 */
	public String getWindowsUser() {
		return windowsUser;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @return the bill
	 */
	public boolean getBill() {
		return bill;
	}
	/**
	 * @return the teamViewerConnectionMetaDataList
	 */
	public List<TeamViewerConnectionMetaDataDTO> getTeamViewerConnectionMetaDataList() {
		return teamViewerConnectionMetaDataList;
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
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @param finish the finish to set
	 */
	public void setFinish(String finish) {
		this.finish = finish;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	/**
	 * @param seconds the seconds to set
	 */
	public void setSeconds(String seconds) {
		this.seconds = seconds;
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
	 * @param windowsUser the windowsUser to set
	 */
	public void setWindowsUser(String windowsUser) {
		this.windowsUser = windowsUser;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	/**
	 * @param bill the bill to set
	 */
	public void setBill(boolean bill) {
		this.bill = bill;
	}
	/**
	 * @param teamViewerConnectionMetaDataList the teamViewerConnectionMetaDataList to set
	 */
	public void setTeamViewerConnectionMetaDataList(
			List<TeamViewerConnectionMetaDataDTO> teamViewerConnectionMetaDataList) {
		this.teamViewerConnectionMetaDataList = teamViewerConnectionMetaDataList;
	}

	/**
	 * @return the teamViewerAddress
	 */
	public String getTeamViewerAddress() {
		return teamViewerAddress;
	}

	/**
	 * @return the teamViewerID
	 */
	public String getTeamViewerID() {
		return teamViewerID;
	}

	/**
	 * @param teamViewerAddress the teamViewerAddress to set
	 */
	public void setTeamViewerAddress(String teamViewerAddress) {
		this.teamViewerAddress = teamViewerAddress;
	}

	/**
	 * @param teamViewerID the teamViewerID to set
	 */
	public void setTeamViewerID(String teamViewerID) {
		this.teamViewerID = teamViewerID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bill ? 1231 : 1237);
		result = prime * result + ((finish == null) ? 0 : finish.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((minutes == null) ? 0 : minutes.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((seconds == null) ? 0 : seconds.hashCode());
		result = prime * result
				+ ((windowsUser == null) ? 0 : windowsUser.hashCode());
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
		TeamViewerConnectionDTO other = (TeamViewerConnectionDTO) obj;
		if (bill != other.bill)
			return false;
		if (finish == null) {
			if (other.finish != null)
				return false;
		} else if (!finish.equals(other.finish))
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (minutes == null) {
			if (other.minutes != null)
				return false;
		} else if (!minutes.equals(other.minutes))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (seconds == null) {
			if (other.seconds != null)
				return false;
		} else if (!seconds.equals(other.seconds))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (windowsUser == null) {
			if (other.windowsUser != null)
				return false;
		} else if (!windowsUser.equals(other.windowsUser))
			return false;
		return true;
	}

	/**
	 * Method will return the state of the object as a String
	 * @see java.lang.Object#toString()
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
		state.append(this.start);
		state.append(sep);
		state.append(this.finish);
		state.append(sep);
		state.append(this.notes);
		state.append(sep);
		state.append(this.isDeleted);
		state.append(sep);
		state.append(this.windowsUser);
		state.append(sep);
		state.append(this.price);
		state.append(sep);
		state.append(this.hash);
		state.append(sep);
		state.append(this.bill);
		return state.toString();
	}
    
}
