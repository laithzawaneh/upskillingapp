package mb;

import javax.faces.bean.ManagedBean;

import bean.TrainingCourse;
import dao.TriningCourseDAO;
import util.Message;

@ManagedBean(name = "mbAddTrainingCourse")
public class MBAddTrainingCourse {

	private TrainingCourse trainingCourse;

	
	public String save() {
		TriningCourseDAO courseDAO= new TriningCourseDAO();
		courseDAO.insert(trainingCourse);
		Message.addMessage("INFO", "Adding Training Course","Training Course Added Successfully");
		
		trainingCourse = new TrainingCourse();
		return null;
	}
	
	
	public TrainingCourse getTrainingCourse() {
		if (trainingCourse == null) {
			trainingCourse = new TrainingCourse();
		}
		return trainingCourse;
	}

	public void setTrainingCourse(TrainingCourse trainingCourse) {
		this.trainingCourse = trainingCourse;
	}

}
