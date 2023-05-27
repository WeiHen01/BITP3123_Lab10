package Exercise7;

/* This is the field class for accepting field and attributes
 * 
 * @author Ng Wei Hen
 * 
 */

public class Field {

	private boolean primaryKey;
	private String name;
	private String type;
	
	public boolean isPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
