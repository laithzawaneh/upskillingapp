package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.School;
import dao.SchoolDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbSchool")
public class MBSchool {
	private List<School> schoolTable;
	private SchoolDAO schoolDAO;
	private School selectedSchool;
	private List<School> multipleSelectedSchool;
	
	@PostConstruct
	public void init() {
		schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		selectedSchool = new School();
	}
	
	public String updateSchool() {
		schoolDAO.update(selectedSchool);
		schoolTable = schoolDAO.selectAll();
		Message.addMessage("INFO", "Edit School","School Updated Successfully");
		return null;
	}
	
	public String removeSchool() {
		schoolDAO.delete(selectedSchool.getSchoolId());
		schoolTable = schoolDAO.selectAll();
		Message.addMessage("INFO", "Remove School","School Remove Successfully");

		return null;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public SchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	public void setSchoolDAO(SchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	public School getSelectedSchool() {
		return selectedSchool;
	}

	public void setSelectedSchool(School selectedSchool) {
		this.selectedSchool = selectedSchool;
	}

	public List<School> getMultipleSelectedSchool() {
		return multipleSelectedSchool;
	}

	public void setMultipleSelectedSchool(List<School> multipleSelectedSchool) {
		this.multipleSelectedSchool = multipleSelectedSchool;
	}
	
	
}
