package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Message {

	public static void addMessage(String severity, String summary, String detail) {

		FacesMessage.Severity messageSeverity = null;

		switch (severity.toUpperCase()) {
		case "INFO":
			messageSeverity = FacesMessage.SEVERITY_INFO;
			break;
		case "WARN":
			messageSeverity = FacesMessage.SEVERITY_WARN;
			break;
		case "ERROR":
			messageSeverity = FacesMessage.SEVERITY_ERROR;
			break;
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageSeverity, summary, detail));
	}
}
