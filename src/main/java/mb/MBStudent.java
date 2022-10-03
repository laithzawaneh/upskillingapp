package mb;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Student;
import dao.StudentDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStudent")
public class MBStudent {

	private List<Student> studentTable;
	private StudentDAO studentDAO;
	private Student selectedStudent;
	private List<Student> multipleSelectedStudent;
	HashMap<String, String> gender = new HashMap<String, String>();
	
	
	
	@PostConstruct
	public void init() {
		studentDAO = new StudentDAO();
		studentTable = studentDAO.selectAll();
		selectedStudent = new Student();
	}
	
	public String updateStudent() {
		studentDAO.update(selectedStudent);
		studentTable = studentDAO.selectAll();
		Message.addMessage("INFO", "Edit Student","Student Updated Successfully");
		return null;
	}
	
	public String removeStudent() {
		studentDAO.delete(selectedStudent.getStudentId());
		studentTable = studentDAO.selectAll();
		Message.addMessage("INFO", "Remove Student","Student Remove Successfully");
		return null;
	}

	public List<Student> getStudentTable() {
		return studentTable;
	}

	public void setStudentTable(List<Student> studentTable) {
		this.studentTable = studentTable;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public List<Student> getMultipleSelectedStudent() {
		return multipleSelectedStudent;
	}

	public void setMultipleSelectedStudent(List<Student> multipleSelectedStudent) {
		this.multipleSelectedStudent = multipleSelectedStudent;
	}
	
	
}
