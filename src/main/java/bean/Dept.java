package bean;

public class Dept {

	private int id;
	private String name;
	private String location;

	public Dept() {

	}

	public Dept(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

//	getters and setters///////////////

	public Dept(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

//	End getters and setters///////////////

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", location=" + location + "]\n";
	}

}
