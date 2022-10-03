package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.StudentResult;
import dao.StudentResultDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbStudentResult")
public class MBStudentResult {

	private List<StudentResult> studentResultTable;
	private StudentResultDAO studentResultDAO;
	private StudentResult selectedStudentResult;
	private List<StudentResult> multipleSelectedStudentResult;

	@PostConstruct
	public void init() {
		studentResultDAO = new StudentResultDAO();
		studentResultTable = studentResultDAO.selectAll();
		selectedStudentResult = new StudentResult();
	}

	public String updateStudentResult() {
		studentResultDAO.update(selectedStudentResult);
		studentResultTable = studentResultDAO.selectAll();
		Message.addMessage("INFO", "Edit Student Result","Student Result Updated Successfully");
		return null;
	}

	public String removeStudentResult() {
		studentResultDAO.delete(selectedStudentResult.getStudentId());
		studentResultTable = studentResultDAO.selectAll();
		Message.addMessage("INFO", "Remove Student Result","Student Result Remove Successfully");
		return null;
	}

	public List<StudentResult> getStudentResultTable() {
		return studentResultTable;
	}

	public void setStudentResultTable(List<StudentResult> studentResultTable) {
		this.studentResultTable = studentResultTable;
	}

	public StudentResultDAO getStudentResultDAO() {
		return studentResultDAO;
	}

	public void setStudentResultDAO(StudentResultDAO studentResultDAO) {
		this.studentResultDAO = studentResultDAO;
	}

	public StudentResult getSelectedStudentResult() {
		return selectedStudentResult;
	}

	public void setSelectedStudentResult(StudentResult selectedStudentResult) {
		this.selectedStudentResult = selectedStudentResult;
	}

	public List<StudentResult> getMultipleSelectedStudentResult() {
		return multipleSelectedStudentResult;
	}

	public void setMultipleSelectedStudentResult(List<StudentResult> multipleSelectedStudentResult) {
		this.multipleSelectedStudentResult = multipleSelectedStudentResult;
	}

}
