package bean;

public class StudentTrainingCourse {
	
	private int studentId;
	private int courseId;
	private int priority;
	private TrainingCourse trainingCourse;
	private Student student;

	public StudentTrainingCourse() {
		
	}
	
	public StudentTrainingCourse(int studentId, int courseId, int priority) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.priority = priority;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
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
		return "StudentTrainingCourse [studentId=" + studentId + ", courseId=" + courseId + ", priority=" + priority
				+ "]";
	}
	
	

}
