package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import bean.Dept;
import database.Database;

public class DeptDAO {
	private Database db = null;
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private int row = 0;
	private List<Dept> deptTable;

	public List<Dept> selectAll() {

		deptTable = new ArrayList<Dept>();

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select deptno,dname,loc from dept order by deptno");
			rs = ps.executeQuery();
			while (rs.next()) {
				Dept dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
				deptTable.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return deptTable;
	}
	
	public Dept selectById(int id) {
		 
		Dept dept = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select deptno,dname,loc from dept where deptno=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				dept = new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return dept;
	}

	public int insert(Dept dept) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("insert into dept(deptno,dname,loc) values(?,?,?)");
			int counter = 1;
			ps.setInt(counter++, dept.getId());
			ps.setString(counter++, dept.getName());
			ps.setString(counter++, dept.getLocation());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}

	public int update(Dept dept) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update dept set dname = ?, loc=? where deptno=?");
			int counter = 1;
			ps.setString(counter++, dept.getName());
			ps.setString(counter++, dept.getLocation());
			ps.setInt(counter++, dept.getId());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}

	public int delete(int id) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from dept where deptno =?");
			ps.setInt(1, id);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}
		return row;

	}
}
