package mini.project;

public class MemberLogin {
	private String Id;
	private String Password;
	private String Name;

	public MemberLogin(String Id, String Password, String Name) {
		super();
		this.Id = Id;
		this.Password = Password;
		this.Name = Name;
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

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	@Override
	public String toString() {
		return "ID : " + Id + " Password : " + Password + " Name : " + Name;
	}

	public void add() {
		MemberLogin m = new MemberLogin(Id, Password, Name);
		m.Id = Prompt.inputString("Id : ");
		m.Password = Prompt.inputString("Password : ");
		m.Name = Prompt.inputString("Name : ");
	}


}
