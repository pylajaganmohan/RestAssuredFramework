package api.payload;

public class GoRestUser {

	int id;
	String name;
	String email;
	Gender gener;
	Status status;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGener() {
		return gener;
	}

	public void setGener(Gender gener) {
		this.gener = gener;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public enum Gender {
		male, female
	}

	public enum Status {
		active, inactive
	}
}
