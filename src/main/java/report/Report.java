package report;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Database;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class Report {
	public void runPdf(String repPath, Map<String, Object> param) throws Exception {
		Connection conn = null;
		try {
			HttpServletResponse response = getResponse();
			ServletOutputStream out = response.getOutputStream();
			// response.setHeader("Cache-Control", "max-age=0");
			// response.setContentType("application/pdf");
			response.addHeader("Content-disposition", "attachment; filename=report.pdf");
			ServletContext context = getContext();
			InputStream fs = context.getResourceAsStream("/secured/reports/" + repPath);
			JasperReport template = (JasperReport) JRLoader.loadObject(fs);
			/*
			 * template.setProperty("net.sf.jasperreports.query.executer.factory.plsql",
			 * "com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
			 */
			// template.setWhenNoDataType(WhenNoDataTypeEnum.ALL_SECTIONS_NO_DETAIL);

			Database database = new Database();
			conn = database.getConnection();

			JasperPrint print = JasperFillManager.fillReport(template, param, conn);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(print, baos);
			out.write(baos.toByteArray());
			out.flush();
			out.close();
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			Database.close(conn);
		}
	}

	public static ServletContext getContext() {
		return (ServletContext) getFacesContext().getExternalContext().getContext();
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getFacesContext().getExternalContext().getResponse();
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
	}

	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
}