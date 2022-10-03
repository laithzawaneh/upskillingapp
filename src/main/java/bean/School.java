package bean;

public class School {

	private int schoolId;
	private String aName;
	private String eName;

	public School() {
	}

	public School(int schoolId, String aName, String eName) {
		this.schoolId = schoolId;
		this.aName = aName;
		this.eName = eName;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
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

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", aName=" + aName + ", eName=" + eName + "]\n";
	}

	
}
