package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Program;
import bean.School;
import database.Database;

public class ProgramDAO {
	private Database db = null;
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	List<Program> programTable;
	private int row = 0;

	public List<Program> selectAll() {
		programTable = new ArrayList<Program>();

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select school_id,program_id,program_aname,program_ename from program order by school_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				Program program = new Program();
				SchoolDAO schoolDAO = new SchoolDAO();
				School school = schoolDAO.selectById(rs.getInt("school_id"));
				program.setSchool(school);
				program.setProgramlId(rs.getInt("program_id"));
				program.setaName(rs.getString("program_aname"));
				program.seteName(rs.getString("program_ename"));

				programTable.add(program);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}
		return programTable;
	}
	
	public Program selectById(int id) {
		 
		Program program = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select school_id,program_id,program_aname,program_ename from program where program_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				program = new Program(rs.getInt("school_id"), rs.getInt("program_id"),rs.getString("program_aname"), rs.getString("program_ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return program;
	}
	
	
	public List<String> selectNameSchool() {
		List<String> nameSchoolTable = new ArrayList<String>();
		try {
			db = new Database();
			programTable = new ArrayList<Program>();
			connection = db.getConnection();
			ps = connection.prepareStatement("select distinct school_ename from school where school_ename is not null order by school_ename");
			rs = ps.executeQuery();

			while (rs.next()) {
				nameSchoolTable.add(rs.getString("school_ename"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return nameSchoolTable;

	}
	
	
	private int selectMaxId() {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select nvl(max(program_id),0) AS PROGRAM_ID from program");
			rs = ps.executeQuery();
 
			if (rs.next()) {
				return rs.getInt("program_id");
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

	public int insert(Program program) {
		int maxId= selectMaxId();
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into program(school_id,program_id,program_aname,program_ename) values(?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, program.getSchool().getSchoolId());
			ps.setInt(counter++, maxId+1);
			ps.setString(counter++, program.getaName());
			ps.setString(counter++, program.geteName());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}

	//////////////////////
	public int update(Program program) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection
					.prepareStatement("update program set program_aname = ?,program_ename = ? where program_id=?");
			int counter = 1;

			ps.setString(counter++, program.getaName());
			ps.setString(counter++, program.geteName());
			ps.setInt(counter++, program.getProgramlId());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;
	}

	////////////////////////////////

	public int delete(int id) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("delete from program where program_id = ?");
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
