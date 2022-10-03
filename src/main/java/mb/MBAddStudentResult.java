package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Student;
import bean.StudentResult;
import bean.TrainingCourse;
import dao.StudentDAO;
import dao.StudentResultDAO;
import dao.TriningCourseDAO;
import util.Message;

@ManagedBean(name = "mbAddStudentResult")
public class MBAddStudentResult {

	private StudentResult studentResult;
	private List<Student> studentTable;
	private List<TrainingCourse> courseTable;
	private List<String> nameStudentTable;
	private List<String> nameCourseTable;
	private StudentResultDAO studentResultDAO;
	
	@PostConstruct
	public void init() {
		studentResultDAO = new StudentResultDAO();
		
		nameStudentTable = studentResultDAO.selectNameStudent();
		nameCourseTable = studentResultDAO.selectNameCourse();

		StudentDAO studentDAO = new StudentDAO();
		studentTable = studentDAO.selectAll();

		TriningCourseDAO courseDAO = new TriningCourseDAO();
		courseTable = courseDAO.selectAll();
	}
	
	public String save() {
		studentResultDAO = new StudentResultDAO();
		studentResultDAO.insert(studentResult);
		Message.addMessage("INFO", "Adding Student Result", "Student Result Added Successfully");

		studentResult = new StudentResult();
		studentResult.setStudent(new Student());
		studentResult.setTrainingCourse(new TrainingCourse());
		return null;
	}

	public StudentResult getStudentResult() {

		if (studentResult == null) {
			studentResult = new StudentResult();
			studentResult.setStudent(new Student());
			studentResult.setTrainingCourse(new TrainingCourse());
		}
		return studentResult;
	}

	public void setStudentResult(StudentResult studentResult) {
		this.studentResult = studentResult;
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

	public StudentResultDAO getStudentResultDAO() {
		return studentResultDAO;
	}

	public void setStudentResultDAO(StudentResultDAO studentResultDAO) {
		this.studentResultDAO = studentResultDAO;
	}
	
	

}
