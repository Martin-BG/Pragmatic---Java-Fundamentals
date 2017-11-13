package register.model;

public class Entry {
	
	private String date;
	private String color;
	private String breed;
	private String sex;
	private String state;
	private String name;
	private String dateCreated;
	
	public Entry(String date, String color, String breed, 
			String sex, String state, String name, String dateCreated) {
		super();
		this.date = date;
		this.color = color;
		this.breed = breed;
		this.sex = sex;
		this.state = state;
		this.name = name;
		this.dateCreated = dateCreated;
	}

	public String getDate() {
		return date;
	}

	public String getColor() {
		return color;
	}

	public String getBreed() {
		return breed;
	}

	public String getSex() {
		return sex;
	}

	public String getState() {
		return state;
	}

	public String getName() {
		return name;
	}

	public String getDateCreated() {
		return dateCreated;
	}
}