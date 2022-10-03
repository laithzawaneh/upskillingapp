package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.Dept;
import dao.DeptDAO;

@ViewScoped
@ManagedBean(name = "mbDept")
public class MBDept {

	private List<Dept> deptTable;
	private DeptDAO deptDAO;
	private Dept SelectedDept;
	private List<Dept> multipleSelectedDept;

	@PostConstruct
	public void init() {
		deptDAO = new DeptDAO();
		deptTable = deptDAO.selectAll();
		SelectedDept = new Dept();
	}
	
	public String updateDept() {
		deptDAO.update(SelectedDept);
		deptTable = deptDAO.selectAll();
		return null;
	}
	
	public String removeDept() {
		deptDAO.delete(SelectedDept.getId());
		deptTable = deptDAO.selectAll();
		return null;
	}

	public void checkSelection() {
		System.out.println(SelectedDept);
	}

	public Dept getSelectedDept() {
		return SelectedDept;
	}

	public void setSelectedDept(Dept SelectedDept) {
		this.SelectedDept = SelectedDept;
	}

	public List<Dept> getDeptTable() {
		return deptTable;
	}
	

	public List<Dept> getMultipleSelectedDept() {
		return multipleSelectedDept;
	}

	public void setMultipleSelectedDept(List<Dept> multipleSelectedDept) {
		this.multipleSelectedDept = multipleSelectedDept;
	}

	public void setDeptTable(List<Dept> deptTable) {
		this.deptTable = deptTable;
	}

}
