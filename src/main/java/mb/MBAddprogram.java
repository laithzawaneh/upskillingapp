package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Program;
import bean.School;
import dao.ProgramDAO;
import dao.SchoolDAO;
import util.Message;

@ManagedBean(name = "mbAddProgram")
public class MBAddprogram {

	private Program program;
	private List<School> schoolTable;
	private List<String> nameSchoolTable;
	private ProgramDAO programDAO; 
	
	@PostConstruct
	public void init() {
		programDAO = new ProgramDAO();
		nameSchoolTable = programDAO.selectNameSchool();
		
		SchoolDAO schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
	}

	public String save() {
		programDAO = new ProgramDAO();
		programDAO.insert(program);
		Message.addMessage("INFO", "Adding Program", "Program Added Successfully");

		program = new Program();
		program.setSchool(new School());
		return null;
	}

	public Program getProgram() {
		if (program == null) {
			program = new Program();
			program.setSchool(new School());
		}
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<String> getNameSchoolTable() {
		return nameSchoolTable;
	}

	public void setNameSchoolTable(List<String> nameSchoolTable) {
		this.nameSchoolTable = nameSchoolTable;
	}

	public ProgramDAO getProgramDAO() {
		return programDAO;
	}

	public void setProgramDAO(ProgramDAO programDAO) {
		this.programDAO = programDAO;
	}
	

}
