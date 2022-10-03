package mb;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Program;
import dao.ProgramDAO;
import report.Report;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbProgram")
public class MPProgrames {
	private List<Program> programTable;
	private ProgramDAO programDAO;
	private Program SelectedProgram;
	private List<Program> multipleSelectedProgram;

	@PostConstruct
	public void init() {
		programDAO = new ProgramDAO();
		programTable = programDAO.selectAll();
		SelectedProgram = new Program();
	}

	public String updateProgram() {
		programDAO.update(SelectedProgram);
		programTable = programDAO.selectAll();
		Message.addMessage("INFO", "Edit Program","Program Updated Successfully");
		return null;
	}

	public String removeProgram() {
		programDAO.delete(SelectedProgram.getProgramlId());
		programTable = programDAO.selectAll();
		Message.addMessage("INFO", "Remove Program","Program Remove Successfully");
		return null;
	}

	public String runProgramReport() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("p_id", new BigDecimal(99));
		Report report = new Report();
		report.runPdf("program.jasper", param);
		return null;
	}

	public List<Program> getProgramTable() {
		return programTable;
	}

	public void setProgramTable(List<Program> programTable) {
		this.programTable = programTable;
	}

	public ProgramDAO getProgramDAO() {
		return programDAO;
	}

	public void setProgramDAO(ProgramDAO programDAO) {
		this.programDAO = programDAO;
	}

	public Program getSelectedProgram() {
		return SelectedProgram;
	}

	public void setSelectedProgram(Program selectedProgram) {
		SelectedProgram = selectedProgram;
	}

	public List<Program> getMultipleSelectedProgram() {
		return multipleSelectedProgram;
	}

	public void setMultipleSelectedProgram(List<Program> multipleSelectedProgram) {
		this.multipleSelectedProgram = multipleSelectedProgram;
	}

}
