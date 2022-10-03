package mb;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "mbComp")
public class MBComponents {

	private String t1;
	private String t2;
	private Date t3;
	private int t4;
	private String t5;
	private boolean t6;
	private String t7;
	private int t8;
	private int t9;
	private boolean t10;
	private PieChartModel model;

	private List<String> cities;

	private String color;

//	private List<String> countryList;

//	@PostConstruct
//	public void inti() {
//		countryList(new ArrayList<String>());
//
//	}

	public List<String> getCities() {
		return cities;
	}

	public MBComponents() {
		model = new PieChartModel();
		model.set("Brand 1", 540);
		model.set("Brand 2", 325);
		model.set("Brand 3", 702);
		model.set("Brand 4", 421);
		model.setTitle("Simple Pie");
		model.setLegendPosition("w");
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public String submit() {
		return null;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getT2() {
		return t2;
	}

	public void setT2(String t2) {
		this.t2 = t2;
	}

	public Date getT3() {
		return t3;
	}

	public void setT3(Date t3) {
		this.t3 = t3;
	}

	public int getT4() {
		return t4;
	}

	public void setT4(int t4) {
		this.t4 = t4;
	}

	public String getT5() {
		return t5;
	}

	public void setT5(String t5) {
		this.t5 = t5;
	}

	public boolean isT6() {
		return t6;
	}

	public void setT6(boolean t6) {
		this.t6 = t6;
	}

	public String getT7() {
		return t7;
	}

	public void setT7(String t7) {
		this.t7 = t7;
	}

	public int getT8() {
		return t8;
	}

	public void setT8(int t8) {
		this.t8 = t8;
	}

	public int getT9() {
		return t9;
	}

	public void setT9(int t9) {
		this.t9 = t9;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isT10() {
		return t10;
	}

	public void setT10(boolean t10) {
		this.t10 = t10;
	}

	public PieChartModel getModel() {
		return model;
	}

}
