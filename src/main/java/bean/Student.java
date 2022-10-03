package bean;

import java.util.Date;

public class Student {
	
	private int studentId;
	private String aName;
	private String eName;
	private String mobile;
	private Date birthDate;
	private String sex;
	private String email;
	private int universityId;
	private int schoolId;
	private int programId;
	private double finalAverage;
	private double maxAverage;
	private String rate;
	private int graduateYear;
	private int graduateSem;
	private School school;
	private University university;
	private Program program;
	
	
	public Student () {
		
	}
	
	public Student(int studentId, String aName, String eName, String mobile, Date birthDate, String sex, String email,
			int universityId, int schoolId, int programId, double finalAverage, double maxAverage, String rate,
			int graduateYear, int graduateSem) {
		super();
		this.studentId = studentId;
		this.aName = aName;
		this.eName = eName;
		this.mobile = mobile;
		this.birthDate = birthDate;
		this.sex = sex;
		this.email = email;
		this.universityId = universityId;
		this.schoolId = schoolId;
		this.programId = programId;
		this.finalAverage = finalAverage;
		this.maxAverage = maxAverage;
		this.rate = rate;
		this.graduateYear = graduateYear;
		this.graduateSem = graduateSem;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public double getFinalAverage() {
		return finalAverage;
	}
	public void setFinalAverage(double finalAverage) {
		this.finalAverage = finalAverage;
	}
	public double getMaxAverage() {
		return maxAverage;
	}
	public void setMaxAverage(double maxAverage) {
		this.maxAverage = maxAverage;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public int getGraduateYear() {
		return graduateYear;
	}
	public void setGraduateYear(int graduateYear) {
		this.graduateYear = graduateYear;
	}
	public int getGraduateSem() {
		return graduateSem;
	}
	public void setGraduateSem(int graduateSem) {
		this.graduateSem = graduateSem;
	}
	
	

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", aName=" + aName + ", eName=" + eName + ", mobile=" + mobile
				+ ", birthDate=" + birthDate + ", sex=" + sex + ", email=" + email + ", universityId=" + universityId
				+ ", schoolId=" + schoolId + ", programId=" + programId + ", finalAverage=" + finalAverage
				+ ", maxAverage=" + maxAverage + ", rate=" + rate + ", graduateYear=" + graduateYear + ", graduateSem="
				+ graduateSem + "]";
	}
	
	
	

}
