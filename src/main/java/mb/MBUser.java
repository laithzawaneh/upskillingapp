package mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import bean.Users;
import dao.UsersDAO;

import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "mbUser")
public class MBUser {

	private Users user;
	private boolean accept;

	@PostConstruct
	public void init(){
		user = new Users();
	}

	public String signUp() {
		if (accept == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Terms & Conditions", "Please accept terms and conditions"));
		} else {
			UsersDAO usersDAO = new UsersDAO();
			usersDAO.insert(user);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User added successfully"));
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
