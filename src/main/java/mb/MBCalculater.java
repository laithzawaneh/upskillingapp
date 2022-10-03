package mb;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="mbcalc")
public class MBCalculater {

	private Double number1;
	private Double number2;
	private Double result;

	public String add() {
		result = number1 + number2;
		return null;
	}

	public String substract() {
		result = number1 - number2;
		return null;
	}

	public String multiply() {
		result = number1 * number2;
		return null;
	}

	public String divide() {
		result = number1 / number2;
		return null;
	}

	public Double getNumber1() {
		return number1;
	}

	public void setNumber1(Double number1) {
		this.number1 = number1;
	}

	public Double getNumber2() {
		return number2;
	}

	public void setNumber2(Double number2) {
		this.number2 = number2;
	}

	public Double getResult() {
		return result;
	}

	

}
