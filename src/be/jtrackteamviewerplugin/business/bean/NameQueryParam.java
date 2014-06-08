package be.jtrackteamviewerplugin.business.bean;

public class NameQueryParam implements Comparable<NameQueryParam>{
	/*
	 * instance members
	 */
	private int index;
	private String varName;
	private Object value;
	/**
	 * Default constructor for the Class
	 */
	public NameQueryParam(){}
	/**
	 * Constructor for the Class
	 * @param index as int
	 * @param value as String
	 */
	public NameQueryParam(int index, String varName, Object value){
		this.index = index;
		this.varName = varName;
		this.value = value;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @return the index
	 */
	public String getVarName() {
		return varName;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * @param varName the varName to set
	 */
	public void setVarName(String varName) {
		this.varName = varName;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		StringBuilder state = new StringBuilder();
		String sep = " - ";
		state.append(this.index);
		state.append(sep);
		state.append(this.value);
		state.append(sep);
		state.append(this.varName);
		return state.toString();
	}
	@Override
	public int compareTo(NameQueryParam o) {
		return this.index - o.index;
	}
}
