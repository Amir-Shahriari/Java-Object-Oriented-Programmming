package other_classes;

public class User {
	
	private String username;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String u) {
		// To be completed
		if(u.length()<1) {
			u = "Tweeeter";
		}
		username = Character.toUpperCase(u.charAt(0))+u.substring(1);
	}
	
	
	public User(String username) {
		// To be completed
		setUsername(username);

	}
	
	public boolean equals(Object u) {
		// To be completed
		User other = (User) u;
		return other.getUsername().equals(username);
	}
	
	public String toString() {
		// To be completed
		return "Username: "+username;
	}
	
	/**
	 * DO NOT EDIT THE BELOW CODE
	 */
	public User() {}
}
