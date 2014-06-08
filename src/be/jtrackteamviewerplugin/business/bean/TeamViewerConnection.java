/**
 * 
 */
package be.jtrackteamviewerplugin.business.bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Class TeamViewerConnection
 * 
 * @author tom.dhondt - created at : 2-dec.-2013
 * 
 */
@Entity
@Table(name = "TeamViewerConnection")
@NamedQueries(
	{
		@NamedQuery(
			name = "TeamViewerConnection.findby.startdate",
			query = "FROM TeamViewerConnection tc WHERE tc.start BETWEEN :start AND :finish"
		)
	}
)
public class TeamViewerConnection {
	/* Instance members */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "UniqueID", nullable=false)
	private String uniqueID;
	@Column(name="start")
	@DateTimeFormat(pattern="yyyy-mm-dd hh:MM:ss.SSS")
	private Date start;
	@Column(name="finish")
	@DateTimeFormat(pattern="yyyy-mm-dd hh:MM:ss.SSS")
	private Date finish;
	@Column(name="notes")
	private String notes;
	@Column(name="isDeleted")
	private boolean isDeleted;
	@Column(name="windowsUser")
	private String windowsUser;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="hash")
	private int hash;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TeamViewer_ID")
	private TeamViewer teamViewer;
	@Column(name="bill")
	private boolean bill;
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "teamViewerConnection")
	@OneToMany(mappedBy = "teamViewerConnection")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<TeamViewerConnectionMetaData> teamViewerConnectionMetaDataList;
	@Transient
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:MM:ss");
	/**
	 * Default constructor
	 */
	public TeamViewerConnection(){
		this.teamViewerConnectionMetaDataList = new ArrayList<TeamViewerConnectionMetaData>();
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
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @return the finish
	 */
	public Date getFinish() {
		return finish;
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
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @return the hash
	 */
	public int getHash() {
		return hash;
	}

	/**
	 * @return the teamViewer
	 */
	public TeamViewer getTeamViewer() {
		return teamViewer;
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
	public List<TeamViewerConnectionMetaData> getTeamViewerConnectionMetaDataList() {
		return teamViewerConnectionMetaDataList;
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
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @param finish the finish to set
	 */
	public void setFinish(Date finish) {
		this.finish = finish;
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
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * @param teamViewer the teamViewer to set
	 */
	public void setTeamViewer(TeamViewer teamViewer) {
		this.teamViewer = teamViewer;
	}
	
	/**
	 * @param bill the bill to set
	 */
	public void setBill(boolean bill) {
		this.bill = bill;
	}
	/**
	 * Method
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
		state.append(sdf.format(this.start));
		state.append(sep);
		state.append(sdf.format(this.finish));
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (bill ? 1231 : 1237);
		result = prime * result + ((finish == null) ? 0 : finish.hashCode());
		result = prime * result + hash;
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result
				+ ((teamViewer == null) ? 0 : teamViewer.hashCode());
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
		TeamViewerConnection other = (TeamViewerConnection) obj;
		if (bill != other.bill)
			return false;
		if (finish == null) {
			if (other.finish != null)
				return false;
		} else if (!sdf.format(finish).equals(sdf.format(other.finish)))
			return false;
		if (hash != other.hash)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!sdf.format(start).equals(sdf.format(other.start)))
			return false;
		if (teamViewer == null) {
			if (other.teamViewer != null)
				return false;
		} else if (!teamViewer.equals(other.teamViewer))
			return false;
		if (windowsUser == null) {
			if (other.windowsUser != null)
				return false;
		} else if (!windowsUser.equals(other.windowsUser))
			return false;
		return true;
	}
}
