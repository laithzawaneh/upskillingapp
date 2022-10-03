package mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import bean.Users;
import dao.UsersDAO;

@ManagedBean(name = "mbreg")
public class MBRegestrationForm {

	private Users user=new Users();
	private UsersDAO dao = new UsersDAO();
	public boolean accept;

	public String submit() {
		if (accept == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Terms & Condtion","Please accept terms and condition"));
		}else {
		System.out.println(user.toString());
		dao.insert(user);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sccsess","User added Sccsessfuly"));
		}

		return null;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public boolean isAccept() {
		return accept;
	}

	public void setAccept(boolean accept) {
		this.accept = accept;
	}
}
