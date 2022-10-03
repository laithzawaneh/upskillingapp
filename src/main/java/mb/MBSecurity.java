package mb;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import bean.Users;
import dao.UsersDAO;
import util.Message;

@ManagedBean(name = "mbSec")
@SessionScoped
public class MBSecurity {

//	private String username;
//	private String password;
	private boolean logon;
	private Users user;
	private UsersDAO usersDAO;

	private String lang = "en";
	private Locale locale = Locale.ENGLISH;
	private String dir = "ltr";
	private static Map<String, Object> countries;
	


	static {
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("عربي", new Locale("ar"));

	}
	
	

	public String checkUser() {
//		
//		UsersDAO userDAO = new UsersDAO();
//		userDAO.isAuthenticated(users.getEmail(), users.getPassword())
//		username.equalsIgnoreCase("java") && password.equals("Java@2022")
		
		usersDAO = new UsersDAO();
		user = usersDAO.selectByEmail(user.getEmail(), user.getPassword());

		if (user != null) {
			logon = true;
			return "/home.xhtml";
		} else {
			logon = false;
			Message.addMessage("ERROR", " ", "Please check username or password");
			return null;
		}
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/home.xhtml?faces-redirect=true";
	}
	
	public void localeChanged(ValueChangeEvent e) {
        lang = e.getNewValue().toString();
        for (Map.Entry<String, Object> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(lang)) {
                locale = lang.equals("en") ? Locale.ENGLISH : new Locale(lang);
                FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
                dir = lang.equals("ar") ? "rtl" : "ltr";
            }
        }
    }

	
	public Users getUser() {
		if(user == null) {
			user = new Users();
		}
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public boolean isLogon() {
		return logon;
	}

	public void setLogon(boolean logon) {
		this.logon = logon;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Map<String, Object> getCountries() {
		return countries;
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}


//	public String getUsername() {
//	return username;
//}
//
//public void setUsername(String username) {
//	this.username = username;
//}
//
//public String getPassword() {
//	return password;
//}
//
//public void setPassword(String password) {
//	this.password = password;
//}


}
