package bean;

public class TrainingCourse {

	private int courseId;
	private String aName;
	private String eName;
	private int maxStudent;
	private String shortdesc;
	private String detailedDesc;
	public TrainingCourse() {
	}
	public TrainingCourse(int courseId, String aName, String eName, int maxStudent, String shortdesc,
			String detailedDesc) {
		this.courseId = courseId;
		this.aName = aName;
		this.eName = eName;
		this.maxStudent = maxStudent;
		this.shortdesc = shortdesc;
		this.detailedDesc = detailedDesc;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	public int getMaxStudent() {
		return maxStudent;
	}
	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}
	public String getShortdesc() {
		return shortdesc;
	}
	public void setShortdesc(String shortdesc) {
		this.shortdesc = shortdesc;
	}
	public String getDetailedDesc() {
		return detailedDesc;
	}
	public void setDetailedDesc(String detailedDesc) {
		this.detailedDesc = detailedDesc;
	}
	@Override
	public String toString() {
		return "TrainingCourse [courseId=" + courseId + ", aName=" + aName + ", eName=" + eName + ", maxStudent="
				+ maxStudent + ", shortdesc=" + shortdesc + ", detailedDesc=" + detailedDesc + "]\n";
	}
	
	
}
