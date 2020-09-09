package mini.project;

public class Login {
	private String Id;
	private String Password;

	public Login(String Id, String Password) {
		super();
		this.Id = Id;
		this.Password = Password;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public boolean Test() {
		if (getId().equalsIgnoreCase("admin") && getPassword().equalsIgnoreCase("1234")) {
			return true;
		} else {
			return false;
		}
	}

}
