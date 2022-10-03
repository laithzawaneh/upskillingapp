package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.StudentTrainingCourse;
import dao.StudentTrainingCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStudentTC")
public class MBStudentTrainingCourse {
	
	private List<StudentTrainingCourse> studentTCTable;
	private StudentTrainingCourseDAO studentTCDAO;
	private StudentTrainingCourse SelectedStudentTC;
	private List<StudentTrainingCourse> multipleSelectedStudentTC;
	
	
	@PostConstruct
	public void init() {
		studentTCDAO = new StudentTrainingCourseDAO();
		studentTCTable = studentTCDAO.selectAll();
		SelectedStudentTC = new StudentTrainingCourse();
	}
	
	public String updateStudentTC() {
		studentTCDAO.update(SelectedStudentTC);
		studentTCTable = studentTCDAO.selectAll();
		Message.addMessage("INFO", "Edit Student Training Course","Student Training Course Updated Successfully");
		return null;
	}
	
	public String removeStudentTC() {
		studentTCDAO.delete(SelectedStudentTC.getCourseId());
		studentTCTable = studentTCDAO.selectAll();
		Message.addMessage("INFO", "Remove Student Training Course","Student Training Course Remove Successfully");
		return null;
	}
	
	
	
	
	public List<StudentTrainingCourse> getStudentTCTable() {
		return studentTCTable;
	}
	public void setStudentTCTable(List<StudentTrainingCourse> studentTCTable) {
		this.studentTCTable = studentTCTable;
	}
	public StudentTrainingCourseDAO getStudentTCDAO() {
		return studentTCDAO;
	}
	public void setStudentTCDAO(StudentTrainingCourseDAO studentTCDAO) {
		this.studentTCDAO = studentTCDAO;
	}
	public StudentTrainingCourse getSelectedStudentTC() {
		return SelectedStudentTC;
	}
	public void setSelectedStudentTC(StudentTrainingCourse selectedStudentTC) {
		SelectedStudentTC = selectedStudentTC;
	}
	public List<StudentTrainingCourse> getMultipleSelectedStudentTC() {
		return multipleSelectedStudentTC;
	}
	public void setMultipleSelectedStudentTC(List<StudentTrainingCourse> multipleSelectedStudentTC) {
		this.multipleSelectedStudentTC = multipleSelectedStudentTC;
	}

	
	
}
