package mb;

import javax.faces.bean.ManagedBean;

import bean.University;
import dao.UniversityDAO;
import util.Message;

@ManagedBean(name = "mbAddUniversity")
public class MBAddUniversity {

	private University university;
	
	public String save() {
		UniversityDAO universityDAO= new UniversityDAO();
		universityDAO.insert(university);
		Message.addMessage("INFO", "Adding University","University Added Successfully");
		
		university = new University();
		return null;
	}

	public University getUniversity() {
		if (university == null) {
			university = new University();
		}
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

}
