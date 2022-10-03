package mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import bean.Users;
import dao.UsersDAO;

@ManagedBean(name = "mblogin")
public class MBLogin {
	private Users user = new Users();
	private UsersDAO dao = new UsersDAO();

	public String logIn() {
		user = dao.selectByEmail(user.getEmail(),user.getPassword());
		if (user != null) {
			return "/secured/Welcome.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Invalid","Username or Password Not correct"));
			return null;
		}
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public UsersDAO getDao() {
		return dao;
	}

	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}
	
	

}
