package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.StudentTrainingCourse;
import bean.TrainingCourse;
import database.Database;

public class StudentTrainingCourseDAO {
	
	private Database db = null;
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private int row = 0;
	private List<StudentTrainingCourse> studentTrainingCourseTable;
	
	public List<StudentTrainingCourse> selectAll() {

		studentTrainingCourseTable = new ArrayList<StudentTrainingCourse>();

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection
					.prepareStatement("select student_id,course_id,priority from student_Training_Course");
			rs = ps.executeQuery();
			while (rs.next()) {
				StudentTrainingCourse studentTrainingCourse = new StudentTrainingCourse();
				StudentDAO studentDAO = new StudentDAO();
				Student student = studentDAO.selectById(rs.getInt("student_id"));
				studentTrainingCourse.setStudent(student);
				
				TriningCourseDAO triningCourseDAO = new TriningCourseDAO();
				TrainingCourse trainingCourse = triningCourseDAO.selectById(rs.getInt("course_id"));
				studentTrainingCourse.setTrainingCourse(trainingCourse);
				
				studentTrainingCourse.setPriority( rs.getInt("priority"));
				
				studentTrainingCourseTable.add(studentTrainingCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return studentTrainingCourseTable;
	}
	
	public StudentTrainingCourse selectById(int id) {
		 
		StudentTrainingCourse studentTrainingCourse = null;
		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("select student_id,priority from student_Training_Course where course_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				studentTrainingCourse = new StudentTrainingCourse(rs.getInt("student_id"), rs.getInt("course_id"),rs.getInt("priority"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(rs);
			Database.close(ps);
			Database.close(connection);
		}

		return studentTrainingCourse;
	}
	
	public List<String> selectNameStudent() {
		List<String> nameStudentTable = new ArrayList<String>();
		try {
			db = new Database();
			studentTrainingCourseTable = new ArrayList<StudentTrainingCourse>();
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
			studentTrainingCourseTable = new ArrayList<StudentTrainingCourse>();
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
	
	public int insert(StudentTrainingCourse studentTrainingCourse) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement(
					"insert into student_Training_Course(student_id, course_id, priority) values(?,?,?)");
			int counter = 1;
			ps.setInt(counter++, studentTrainingCourse.getStudent().getStudentId());
			ps.setInt(counter++, studentTrainingCourse.getTrainingCourse().getCourseId());
			ps.setInt(counter++, studentTrainingCourse.getPriority());

			

			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Database.close(ps);
			Database.close(connection);
		}

		return row;

	}
	
	public int update(StudentTrainingCourse studentTrainingCourse) {

		try {
			db = new Database();
			connection = db.getConnection();
			ps = connection.prepareStatement("update student_Training_Course set course_id = ?, priority = ? where student_id=?");
			int counter = 1;
			ps.setInt(counter++, studentTrainingCourse.getTrainingCourse().getCourseId());
			ps.setInt(counter++, studentTrainingCourse.getPriority());
			ps.setInt(counter++, studentTrainingCourse.getStudent().getStudentId());

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
			ps = connection.prepareStatement("delete from student_Training_Course where student_id = ?");
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
