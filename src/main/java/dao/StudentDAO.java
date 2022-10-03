package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Program;
import bean.School;
import bean.Student;
import bean.University;
import database.Database;

public class StudentDAO {

	private Database db = null;
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private List<Student> studentTable;
	private int row = 0;
	
	public List<Student> selectAll() {

		studentTable = new ArrayList<Student>();

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id,student_aname,student_ename,mobile, BEARTHDATE, sex, email, university_id, school_id, program_id, final_average, MAX_AVERAGE, rate, graduate_year, graduate_sem from student");
			rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setaName(rs.getString("student_aname"));
				student.seteName(rs.getString("student_ename"));
				student.setMobile(rs.getString("mobile"));
				student.setBirthDate(rs.getDate("BEARTHDATE"));
				student.setSex(rs.getString("sex"));
				student.setEmail(rs.getString("email"));
				
				UniversityDAO universityDAO = new UniversityDAO();
				University university = universityDAO.selectById(rs.getInt("university_id"));
				student.setUniversity(university);
				
				SchoolDAO schoolDAO = new SchoolDAO();
				School school = schoolDAO.selectById(rs.getInt("school_id"));
				student.setSchool(school);
				
				ProgramDAO programDAO = new ProgramDAO();
				Program program = programDAO.selectById(rs.getInt("program_id"));
				student.setProgram(program);
				
				student.setFinalAverage(rs.getDouble("final_average"));
				student.setMaxAverage(rs.getDouble("MAX_AVERAGE"));
				student.setRate(rs.getString("rate"));
				student.setGraduateYear(rs.getInt("graduate_year"));
				student.setGraduateSem(rs.getInt("graduate_sem"));
						
				studentTable.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return studentTable;
	}
	
	public List<String> selectNameUniversity() {
		List<String> nameUniversityTable = new ArrayList<String>();
		try {
			db = new Database();
			studentTable = new ArrayList<Student>();
			connection = db.getConnection();
			ps = connection.prepareStatement("select distinct university_ename from university where university_ename is not null order by university_ename");
			rs = ps.executeQuery();

			while (rs.next()) {
				nameUniversityTable.add(rs.getString("university_ename"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return nameUniversityTable;

	}
	
	public List<String> selectNameSchool() {
		List<String> nameSchoolTable = new ArrayList<String>();
		try {
			db = new Database();
			studentTable = new ArrayList<Student>();
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
	
	public List<String> selectNameProgram() {
		List<String> nameProgramTable = new ArrayList<String>();
		try {
			db = new Database();
			studentTable = new ArrayList<Student>();
			connection = db.getConnection();
			ps = connection.prepareStatement("select distinct program_ename from program where program_ename is not null order by program_ename");
			rs = ps.executeQuery();

			while (rs.next()) {
				nameProgramTable.add(rs.getString("program_ename"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return nameProgramTable;

	}
	
	public Student selectById(int id) {
		 
		Student student = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id,student_aname,student_ename,mobile, BEARTHDATE, sex, email, university_id, school_id, program_id, final_average, MAX_AVERAGE, rate, graduate_year, graduate_sem from student where student_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				student = new Student(rs.getInt("student_id"), rs.getString("student_aname"),
						rs.getString("student_ename"), rs.getString("mobile"), rs.getDate("BEARTHDATE"),
						rs.getString("sex"), rs.getString("email"), rs.getInt("university_id"), rs.getInt("school_id"),
						rs.getInt("program_id"), rs.getDouble("final_average"), rs.getDouble("MAX_AVERAGE"),
						rs.getString("rate"), rs.getInt("graduate_year"), rs.getInt("graduate_sem"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return student;
	}

	
	private int selectMaxId() {
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select nvl(max(student_id),0) AS STUDENT_ID from student");
			rs = ps.executeQuery();
 
			if (rs.next()) {
				return rs.getInt("student_id");
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
	
	public int insert(Student student) {
		int maxId= selectMaxId();

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student(student_id,student_aname,student_ename, mobile, bearthdate, sex, email, university_id, school_id, program_id, final_average, max_average, rate, graduate_year, graduate_sem) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, maxId+1);
			ps.setString(counter++, student.getaName());
			ps.setString(counter++, student.geteName());
			ps.setString(counter++, student.getMobile());
			ps.setDate(counter++, new Date(student.getBirthDate().getTime()));
			ps.setString(counter++, student.getSex());
			ps.setString(counter++, student.getEmail());
			ps.setInt(counter++, student.getUniversity().getUniverstyId());
			ps.setInt(counter++, student.getSchool().getSchoolId());
			ps.setInt(counter++, student.getProgram().getProgramlId());
			ps.setDouble(counter++, student.getFinalAverage());
			ps.setDouble(counter++, student.getMaxAverage());
			ps.setString(counter++, student.getRate());
			ps.setInt(counter++, student.getGraduateYear());
			ps.setInt(counter++, student.getGraduateSem());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}

	public int update(Student student) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update student set student_aname = ?, student_ename = ?, "
					+ "mobile = ?, bearthdate = ?, sex = ?, email = ?, final_average = ?,"
					+ " max_average = ?, rate = ?, graduate_year = ?, graduate_sem = ?"
					+ " where student_id = ?");
			int counter = 1;

			ps.setString(counter++, student.getaName());
			ps.setString(counter++, student.geteName());
			ps.setString(counter++, student.getMobile());
			ps.setDate(counter++, new Date(student.getBirthDate().getTime()));
			ps.setString(counter++, student.getSex());
			ps.setString(counter++, student.getEmail());
//			ps.setInt(counter++, student.getUniversityId());
//			ps.setInt(counter++, student.getSchoolId());
//			ps.setInt(counter++, student.getProgramId());
			ps.setDouble(counter++, student.getFinalAverage());
			ps.setDouble(counter++, student.getMaxAverage());
			ps.setString(counter++, student.getRate());
			ps.setInt(counter++, student.getGraduateYear());
			ps.setInt(counter++, student.getGraduateSem());
			ps.setInt(counter++, student.getStudentId());
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
			ps = connection.prepareStatement("delete from student where student_id =?");
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
