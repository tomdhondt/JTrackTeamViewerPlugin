package be.jtrackteamviewerplugin.business.enu;

public enum FieldDataType {
	number ("number.name","^[0-9]+",20),
	decimal("decimal.name", "^[0-9]+[.][0-9]+",21),
	date("date.name", "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$",22),
    string("string.name", "",23),
    email("email.name","[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",24),
    state("state.name", "",25),;
	/* instance members */
    private final String name;
    private final String regex;
    private final int type;
    /**
     * Default constructor for the Class 
     */
    FieldDataType(String name, String regex, int type) {
        this.name = name;
        this.regex = regex;
        this.type = type;
    }
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
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
	public static FieldDataType searchEnumValue(String name){
		FieldDataType fieldType = FieldDataType.string;
		FieldDataType[] array = FieldDataType.values();
		for(FieldDataType type : array){
			if(null != name){
				if(name.equals(type.getName().substring(0, type.getName().indexOf(".")))){
					fieldType = type;
				}
			}
		}
		return fieldType;
	}
}
