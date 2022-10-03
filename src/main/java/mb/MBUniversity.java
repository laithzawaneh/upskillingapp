package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.University;
import dao.UniversityDAO;
import util.Message;
@ViewScoped
@ManagedBean(name = "mbUniversity")
public class MBUniversity {

	private List<University> universityTable;
	private UniversityDAO universityDAO;
	private University SelectedUniversity;
	private List<University> multipleSelectedUniversity;
	
	@PostConstruct
	public void init() {
		universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();
		SelectedUniversity = new University();
	}
	
	public String updateUniversity() {
		universityDAO.update(SelectedUniversity);
		universityTable = universityDAO.selectAll();
		Message.addMessage("INFO", "Edit University","University Updated Successfully");
		return null;
	}
	
	public String removeUniversity() {
		universityDAO.delete(SelectedUniversity.getUniverstyId());
		universityTable = universityDAO.selectAll();
		Message.addMessage("INFO", "Remove University","University Remove Successfully");
		return null;
	}
	
	
	public List<University> getUniversityTable() {
		return universityTable;
	}
	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}
	public UniversityDAO getUniversityDAO() {
		return universityDAO;
	}
	public void setUniversityDAO(UniversityDAO universityDAO) {
		this.universityDAO = universityDAO;
	}
	public University getSelectedUniversity() {
		return SelectedUniversity;
	}
	public void setSelectedUniversity(University selectedUniversity) {
		SelectedUniversity = selectedUniversity;
	}
	public List<University> getMultipleSelectedUniversity() {
		return multipleSelectedUniversity;
	}
	public void setMultipleSelectedUniversity(List<University> multipleSelectedUniversity) {
		this.multipleSelectedUniversity = multipleSelectedUniversity;
	}
	
	
}
