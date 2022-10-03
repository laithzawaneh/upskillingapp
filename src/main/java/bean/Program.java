package bean;

public class Program {
	private int schoolId;
	private int programlId;
	private String aName;
	private String eName;
	private School school;
	
	public Program() {

	}


	public Program(int schoolId, int programlId, String aName, String eName) {
		this.schoolId = schoolId;
		this.programlId = programlId;
		this.aName = aName;
		this.eName = eName;
	}


	public int getSchoolId() {
		return schoolId;
	}


	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}


	public int getProgramlId() {
		return programlId;
	}


	public void setProgramlId(int programlId) {
		this.programlId = programlId;
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





	public School getSchool() {
		return school;
	}


	public void setSchool(School school) {
		this.school = school;
	}


	@Override
	public String toString() {
		return "Program [schoolId=" + schoolId + ", programlId=" + programlId + ", aName=" + aName + ", eName=" + eName
				+ ", school=" + school + "]";
	}



	
	

	
	
}
