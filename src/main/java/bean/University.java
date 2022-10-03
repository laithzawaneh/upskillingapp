package bean;

public class University {
	private int universtyId;
	private String aName;
	private String eName;
	private String website;
	
	public University() {
	}

	public University(int universtyId, String aName, String eName, String website) {
		this.universtyId = universtyId;
		this.aName = aName;
		this.eName = eName;
		this.website = website;
	}

	public int getUniverstyId() {
		return universtyId;
	}

	public void setUniverstyId(int universtyId) {
		this.universtyId = universtyId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "\nUniveraity [universtyId=" + universtyId + ", aName=" + aName + ", eName=" + eName + ", website="
				+ website + "]\n";
	}
	
	
	
	

}
