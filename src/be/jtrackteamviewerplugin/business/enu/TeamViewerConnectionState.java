package be.jtrackteamviewerplugin.business.enu;

public enum TeamViewerConnectionState {
	open ("open.teamviewerconnectionstate","yellow",1),
	checked("checked.teamviewerconnectionstate", "blue",2),
	booked("booked.teamviewerconnectionstate", "green",3);
	/* instance members */
    private final String name;
    private final String color;
    private final int type;
    /**
     * Default constructor for the Class 
     */
    TeamViewerConnectionState(String name, String color, int type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * Method will return the FieldType based on the FielDataType.name
	 * @param name as String
	 * @return fieldDataType as FieldDataType
	 */
	public static TeamViewerConnectionState searchEnumValue(String name){
		TeamViewerConnectionState fieldType = TeamViewerConnectionState.open;
		TeamViewerConnectionState[] array = TeamViewerConnectionState.values();
		for(TeamViewerConnectionState type : array){
			if(null != name){
				if(name.equals(type.getName().substring(0, type.getName().indexOf(".")))){
					fieldType = type;
				}
			}
		}
		return fieldType;
	}
}
