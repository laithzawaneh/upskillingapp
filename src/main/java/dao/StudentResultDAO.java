package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.StudentResult;
import bean.TrainingCourse;
import database.Database;

public class StudentResultDAO {

	private Database db = null;
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private int row = 0;
	private List<StudentResult> studentResultTable;

	public List<StudentResult> selectAll() {

		studentResultTable = new ArrayList<StudentResult>();

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"select student_id,course_id,english_mark,interview_mark,accepted_flag,notes from student_Result");
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentResult studentResult = new StudentResult();
				
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.selectById(rs.getInt("student_id"));
				studentResult.setStudent(student);
				
				TriningCourseDAO triningCourseDAO = new TriningCourseDAO();
				TrainingCourse trainingCourse = triningCourseDAO.selectById(rs.getInt("course_id"));
				studentResult.setTrainingCourse(trainingCourse);
				
				studentResult.setEnglishMark(rs.getInt("english_mark"));
				studentResult.setInterviewMark(rs.getInt("interview_mark"));
				studentResult.setAcceptedFlag(rs.getInt("accepted_flag"));
				studentResult.setNotes(rs.getString("notes"));
				
				
				studentResultTable.add(studentResult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return studentResultTable;
	}
	
	public StudentResult selectById(int id) {
		 
		StudentResult studentResult = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id,course_id,english_mark,interview_mark,accepted_flag,notes from student_Result where student_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				studentResult = new StudentResult(rs.getInt("student_id"), rs.getInt("course_id"),rs.getInt("english_mark"), rs.getInt("interview_mark"),rs.getInt("accepted_flag"),rs.getString("notes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return studentResult;
	}
	
	public List<String> selectNameStudent() {
		List<String> nameStudentTable = new ArrayList<String>();
		try {
			db = new Database();
			studentResultTable = new ArrayList<StudentResult>();
			connection = db.getConnection();
			ps = connection.prepareStatement("select distinct student_ename from student where student_ename is not null order by student_ename");
			rs = ps.executeQuery();

			while (rs.next()) {
				nameStudentTable.add(rs.getString("student_ename"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return nameStudentTable;

	}
	
	public List<String> selectNameCourse() {
		List<String> nameCourseTable = new ArrayList<String>();
		try {
			db = new Database();
			studentResultTable = new ArrayList<StudentResult>();
			connection = db.getConnection();//COURSE_ENAME
			ps = connection.prepareStatement("select distinct course_ename from training_course where course_ename is not null order by course_ename");
			rs = ps.executeQuery();

			while (rs.next()) {
				nameCourseTable.add(rs.getString("course_ename"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return nameCourseTable;

	}

	public int insert(StudentResult studentResult) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student_Result(student_id,course_id,english_mark,interview_mark,accepted_flag,notes) values(?,?,?,?,?,?)");
			int counter = 1;
			ps.setInt(counter++, studentResult.getStudent().getStudentId());
			ps.setInt(counter++, studentResult.getTrainingCourse().getCourseId());
			ps.setInt(counter++, studentResult.getEnglishMark());
			ps.setInt(counter++, studentResult.getInterviewMark());
			ps.setInt(counter++, studentResult.getAcceptedFlag());
			ps.setString(counter++, studentResult.getNotes());

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}

	public int update(StudentResult studentResult) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update student_Result set course_id = ?,english_mark = ?,interview_mark = ?,accepted_flag = ?,notes = ? where student_id=?");
			int counter = 1;
			
			ps.setInt(counter++, studentResult.getTrainingCourse().getCourseId());
			ps.setInt(counter++, studentResult.getEnglishMark());
			ps.setInt(counter++, studentResult.getInterviewMark());
			ps.setInt(counter++, studentResult.getAcceptedFlag());
			ps.setString(counter++, studentResult.getNotes());
			ps.setInt(counter++, studentResult.getStudent().getStudentId());
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
			ps = connection.prepareStatement("delete from student_Result where student_id = ?");
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
