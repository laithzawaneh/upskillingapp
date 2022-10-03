package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import bean.Users;
import database.Database;

public class UsersDAO {
	private Database db = null;
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private CallableStatement cs;
	private int row = 0;
	
	private int selectMaxId() {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select nvl(max(user_id),0) AS USER_ID from user_tbl");
			rs = ps.executeQuery();
 
			if (rs.next()) {
				return rs.getInt("user_id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return 0;
	}
	
	public int insert(Users user) {
		int maxId= selectMaxId();
		System.out.println(maxId);

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into user_tbl(user_id,first_name,last_name,sex,birthdate,country,email,pwd) values(?,?,?,?,?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, maxId+1);
			ps.setString(counter++, user.getfName());
			ps.setString(counter++, user.getlName());
			ps.setString(counter++, user.getSex());
			ps.setDate(counter++, new Date (user.getDate().getTime()));
			ps.setString(counter++, user.getCountry());
			ps.setString(counter++, user.getEmail());
			ps.setString(counter++, user.getPassword());

			

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}
	
	public Users selectByEmail(String email , String password) {
		 
		Users user=null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select email,pwd from user_tbl where email=? and pwd=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new Users(rs.getString("email"), rs.getString("pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return user;
	}
	
	public boolean isAuthenticated(String email, String password) {

		String result = null;
		try {
			connection = db.getConnection();
			cs = connection.prepareCall("{call ? := CHECK_USER(?, ?)}");

			cs.registerOutParameter(1, Types.CHAR);
			cs.setString(2, email);
			cs.setString(3, password);

			cs.execute();
			result = cs.getString(1);
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(cs);
			Database.close(connection);
		}
		System.out.println("2 --> " + result.equalsIgnoreCase("true"));
		return result.equalsIgnoreCase("true");
	}
}
