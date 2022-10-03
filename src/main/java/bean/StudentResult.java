package bean;

public class StudentResult {
	
	private int studentId;
	private int courseId;
	private int englishMark;
	private int interviewMark;
	private int acceptedFlag;
	private String notes;
	private TrainingCourse trainingCourse;
	private Student student;
	
	public StudentResult() {
		
	}
	
	public StudentResult(int studentId, int courseId, int englishMark, int interviewMark, int acceptedFlag,
			String notes) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.englishMark = englishMark;
		this.interviewMark = interviewMark;
		this.acceptedFlag = acceptedFlag;
		this.notes = notes;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getEnglishMark() {
		return englishMark;
	}
	public void setEnglishMark(int englishMark) {
		this.englishMark = englishMark;
	}
	public int getInterviewMark() {
		return interviewMark;
	}
	public void setInterviewMark(int interviewMark) {
		this.interviewMark = interviewMark;
	}
	public int getAcceptedFlag() {
		return acceptedFlag;
	}
	public void setAcceptedFlag(int acceptedFlag) {
		this.acceptedFlag = acceptedFlag;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	public TrainingCourse getTrainingCourse() {
		return trainingCourse;
	}

	public void setTrainingCourse(TrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentResult [studentId=" + studentId + ", courseId=" + courseId + ", englishMark=" + englishMark
				+ ", interviewMark=" + interviewMark + ", acceptedFlag=" + acceptedFlag + ", notes=" + notes + "]";
	}
	
	

}
