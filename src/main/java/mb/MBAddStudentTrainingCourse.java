package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Student;
import bean.StudentTrainingCourse;
import bean.TrainingCourse;
import dao.StudentDAO;
import dao.StudentTrainingCourseDAO;
import dao.TriningCourseDAO;
import util.Message;

@ManagedBean(name = "mbAddstudentTC")
public class MBAddStudentTrainingCourse {

	private StudentTrainingCourse studentTrainingCourse;
	private List<Student> studentTable;
	private List<TrainingCourse> courseTable;
	private List<String> nameStudentTable;
	private List<String> nameCourseTable;
	private StudentTrainingCourseDAO studentTCDAO;

	@PostConstruct
	public void init() {
		studentTCDAO = new StudentTrainingCourseDAO();

		nameStudentTable = studentTCDAO.selectNameStudent();
		nameCourseTable = studentTCDAO.selectNameCourse();

		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectAll();

		TriningCourseDAO courseDAO = new TriningCourseDAO();
		courseTable = courseDAO.selectAll();
	}

	public String save() {
		studentTCDAO = new StudentTrainingCourseDAO();
		studentTCDAO.insert(studentTrainingCourse);
		Message.addMessage("INFO", "student training course", "Student Training Course Added Successfully");

		studentTrainingCourse = new StudentTrainingCourse();
		studentTrainingCourse.setStudent(new Student());
		studentTrainingCourse.setTrainingCourse(new TrainingCourse());
		return null;
	}

	public StudentTrainingCourse getStudentTrainingCourse() {
		if (studentTrainingCourse == null) {
			studentTrainingCourse = new StudentTrainingCourse();
			studentTrainingCourse.setStudent(new Student());
			studentTrainingCourse.setTrainingCourse(new TrainingCourse());
		}
		return studentTrainingCourse;
	}

	public void setStudentTrainingCourse(StudentTrainingCourse studentTrainingCourse) {
		this.studentTrainingCourse = studentTrainingCourse;
	}

	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public List<TrainingCourse> getCourseTable() {
		return courseTable;
	}

	public void setCourseTable(List<TrainingCourse> courseTable) {
		this.courseTable = courseTable;
	}

	public List<String> getNameStudentTable() {
		return nameStudentTable;
	}

	public void setNameStudentTable(List<String> nameStudentTable) {
		this.nameStudentTable = nameStudentTable;
	}

	public List<String> getNameCourseTable() {
		return nameCourseTable;
	}

	public void setNameCourseTable(List<String> nameCourseTable) {
		this.nameCourseTable = nameCourseTable;
	}

	public StudentTrainingCourseDAO getStudentTCDAO() {
		return studentTCDAO;
	}

	public void setStudentTCDAO(StudentTrainingCourseDAO studentTCDAO) {
		this.studentTCDAO = studentTCDAO;
	}
	
	

}
