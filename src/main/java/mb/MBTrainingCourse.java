package mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import bean.TrainingCourse;
import dao.TriningCourseDAO;
import util.Message;

@ViewScoped
@ManagedBean(name = "mbTrainingCourse")
public class MBTrainingCourse {
	private List<TrainingCourse> trainingCourseTable;
	private TriningCourseDAO courseDAO;
	private TrainingCourse SelectedTrainingCourse;
	private List<TrainingCourse> multipleSelectedTrainingCourse;

	@PostConstruct
	public void init() {
		courseDAO = new TriningCourseDAO();
		trainingCourseTable = courseDAO.selectAll();
		SelectedTrainingCourse = new TrainingCourse();
	}

	public String updateTrainingCourse() {
		courseDAO.update(SelectedTrainingCourse);
		trainingCourseTable = courseDAO.selectAll();
		Message.addMessage("INFO", "Edit Training Course","Training Course Updated Successfully");
		return null;
	}

	public String removeTrainingCourse() {
		courseDAO.delete(SelectedTrainingCourse.getCourseId());
		trainingCourseTable = courseDAO.selectAll();
		Message.addMessage("INFO", "Remove Training Course","Training Course Remove Successfully");
		return null;
	}

	public List<TrainingCourse> getTrainingCourseTable() {
		return trainingCourseTable;
	}

	public void setTrainingCourseTable(List<TrainingCourse> trainingCourseTable) {
		this.trainingCourseTable = trainingCourseTable;
	}

	public TriningCourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(TriningCourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public TrainingCourse getSelectedTrainingCourse() {
		return SelectedTrainingCourse;
	}

	public void setSelectedTrainingCourse(TrainingCourse selectedTrainingCourse) {
		SelectedTrainingCourse = selectedTrainingCourse;
	}

	public List<TrainingCourse> getMultipleSelectedTrainingCourse() {
		return multipleSelectedTrainingCourse;
	}

	public void setMultipleSelectedTrainingCourse(List<TrainingCourse> multipleSelectedTrainingCourse) {
		this.multipleSelectedTrainingCourse = multipleSelectedTrainingCourse;
	}

}
