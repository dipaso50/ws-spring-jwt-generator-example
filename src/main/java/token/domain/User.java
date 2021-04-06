package token.domain;

public class User extends ValueValidator{
	
	private String name;
	private String lastName;
	
	public User(String name, String lastname) throws Exception {
		
		if(isNullOrEmpty(name) || isNullOrEmpty(lastname)) {
			throw new Exception("Invalid user name or user lastname");
		}
		
		this.name = name;
		this.lastName = lastname;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

}
