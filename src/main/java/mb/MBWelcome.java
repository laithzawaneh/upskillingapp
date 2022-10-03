package mb;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "mbWelcome")
public class MBWelcome {

	private String name;
	
	public String sayHello(){
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
