package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Emp;
import dao.EmpDAO;

@ViewScoped
@ManagedBean(name = "mbEmp")
public class MBEmp {

	private List<Emp> empTable;
	private List<Emp> filterdEmpTable;
	private Emp selectedEmp;
	private EmpDAO empDAO;
	

	@PostConstruct
	public void init() {
		empDAO = new EmpDAO();
		empTable = empDAO.selectAll();
		selectedEmp = new Emp();
	}
	

	public String updateEmp() {
		empDAO.update(selectedEmp);
		empTable = empDAO.selectAll();
		return null;
	}

	public String removeEmo() {
		empDAO.delete(selectedEmp.getId());
		empTable = empDAO.selectAll();
		return null;
	}

	public List<Emp> getEmpTable() {
		return empTable;
	}

	public void setEmpTable(List<Emp> empTable) {
		this.empTable = empTable;
	}

	public Emp getSelectedEmp() {
		return selectedEmp;
	}

	public void setSelectedEmp(Emp selectedEmp) {
		this.selectedEmp = selectedEmp;
	}


	public List<Emp> getFilterdEmpTable() {
		return filterdEmpTable;
	}


	public void setFilterdEmpTable(List<Emp> filterdEmpTable) {
		this.filterdEmpTable = filterdEmpTable;
	}
	
}
