package bean;

import java.util.Date;

public class Users {
	
	private int userId;
	private String fName;
	private String lName;
	private String sex;
	private Date date;
	private String country;
	private String email;
	private String password;

	
	
	public Users() {
		super();
	}


	public Users(int userId, String fName, String lName, String sex, Date date, String country, String email,
			String password) {
		this.userId = userId;
		this.fName = fName;
		this.lName = lName;
		this.sex = sex;
		this.date = date;
		this.country = country;
		this.email = email;
		this.password = password;
	}


	public Users(String email, String password) {
		this.email = email;
		this.password = password;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", fName=" + fName + ", lName=" + lName + ", sex=" + sex + ", date=" + date
				+ ", country=" + country + ", email=" + email + ", password=" + password + "]";
	}





	
	

}
