package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import bean.Program;
import bean.School;
import bean.Student;
import bean.University;
import dao.ProgramDAO;
import dao.SchoolDAO;
import dao.StudentDAO;
import dao.UniversityDAO;
import util.Message;
@ManagedBean(name = "mbAddStudent")
public class MBAddStudent {
	
	private Student student;
	private List<University> universityTable;
	private List<School> schoolTable;
	private List<Program> programTable;
	private List<String> nameUniversityTable;
	private List<String> nameSchoolTable;
	private List<String> nameProgramTable;
	private StudentDAO studentDAO;
	
	@PostConstruct
	public void init() {
		studentDAO = new StudentDAO();
		nameUniversityTable = studentDAO.selectNameUniversity();
		nameSchoolTable = studentDAO.selectNameSchool();
		nameSchoolTable = studentDAO.selectNameProgram();
		
		UniversityDAO universityDAO = new UniversityDAO();
		universityTable = universityDAO.selectAll();
		
		SchoolDAO schoolDAO = new SchoolDAO();
		schoolTable = schoolDAO.selectAll();
		
		ProgramDAO programDAO= new ProgramDAO();
		programTable = programDAO.selectAll();
		
	}
	
	
	
	
	public String save() {
		studentDAO = new StudentDAO();
		studentDAO.insert(student);
		Message.addMessage("INFO", "Adding Student", "Student Added Successfully");

		student = new Student();
		student.setUniversity(new University());
		student.setSchool(new School());
		student.setProgram(new Program());
		return null;
	}

	public Student getStudent() {
		if(student == null) {
			student= new Student();
			student.setUniversity(new University());
			student.setSchool(new School());
			student.setProgram(new Program());
		}
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<University> getUniversityTable() {
		return universityTable;
	}

	public void setUniversityTable(List<University> universityTable) {
		this.universityTable = universityTable;
	}

	public List<School> getSchoolTable() {
		return schoolTable;
	}

	public void setSchoolTable(List<School> schoolTable) {
		this.schoolTable = schoolTable;
	}

	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}




	public List<String> getNameUniversityTable() {
		return nameUniversityTable;
	}




	public void setNameUniversityTable(List<String> nameUniversityTable) {
		this.nameUniversityTable = nameUniversityTable;
	}




	public List<String> getNameSchoolTable() {
		return nameSchoolTable;
	}




	public void setNameSchoolTable(List<String> nameSchoolTable) {
		this.nameSchoolTable = nameSchoolTable;
	}




	public List<String> getNameProgramTable() {
		return nameProgramTable;
	}




	public void setNameProgramTable(List<String> nameProgramTable) {
		this.nameProgramTable = nameProgramTable;
	}




	public StudentDAO getStudentDAO() {
		return studentDAO;
	}




	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
	
	
}
