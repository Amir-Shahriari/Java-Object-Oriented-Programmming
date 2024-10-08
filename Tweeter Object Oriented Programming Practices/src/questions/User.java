package questions;

//Do not import any additional libraries!
//-15 penalty applies for each additional import

public class User {
	
	private String displayName;
	private String handle;
	private int followers;
	private boolean verifiedStatus;
	
	public String getDisplayName() {
		return displayName;
	}
	
	public String getHandle() {
		return handle;
	}
	
	public int getFollowers() {
		return followers;
	}
	
	public boolean getVerifiedStatus() {
		return verifiedStatus;
	}
	
	/**
	 * (2 marks)
	 * @param v - The value to set the current verified status to
	 */
	public void setVerifiedStatus(boolean status) {
		//TODO To be completed
		verifiedStatus = status;
	}
	
	/**
	 * (2 marks)
	 * @param dN - the name to use when setting the instance variable
	 * 
	 * The function should check for these edge cases:
	 *  - The maximum length of a display name should be 50 characters, if the 
	 *    passed parameter is longer then 50 characters, only the first 50
	 *    characters should be used
	 *    e.g. if dN = "this is my really awesome display name that is over 50 characters!!!"
	 *  	   then displayName should be set to:
	 *  	   displayName = "this is my really awesome display name that is ove"
	 */
	public void setDisplayName(String dN) {
		//TODO To be completed
		if (dN.length()>50) {
			displayName = dN.substring(0,50);
		}
		else {
			displayName =dN;
		}
		
	}
	
	/**
	 * (4 marks)
	 * @param hnd - the string to use when setting the instance variable
	 * 
	 * The function should check for these edge cases:
	 * - The handle should have an "@" character at the start, if there is no
	 * 	 "@" character, then the "@" character should be prepended to the start
	 * 	 e.g. hnd = "wcom1010SoCool"
	 * 	      then handle should be set to:
	 * 		  handle = "@wcom1010SoCool"
	 * 
	 * - The minimum length of a handle should be 5 characters, if the passed
	 *   parameter is shorter then 5 characters, then the string '_invalid" should
	 *   be appended to the end of the string
	 *   e.g. hnd = "@sml"
	 *   	  then handle should be set to:
	 *   	  handle = "@sml_invalid"
	 *   
	 * - The maximum length of a handle should be 15 characters, if the passed
	 * 	 parameter is longer then 15 characters, only the first 15 characters
	 * 	 should be used
	 *   e.g. if hnd = "@wow_really_cool_handle"
	 *        then handle should be set to:
	 *        handle = "@wow_really_coo"
	 *   
	 *   Some further examples:
	 *   If hnd = "" 		 -> handle = "@_invalid"
	 *      hnd = "@" 		 -> handle = "@_invalid"
	 *      hnd = "a"		 -> handle = "@a_invalid"
	 *      hnd = "@we_good" -> handle = "@we_good"
	 * 	  
	 * 	 Hint: Perform the validation in the listed order
	 */
	public void setHandle(String hnd) {
		//TODO To be completed

		if(hnd.length() < 5) {
			hnd = hnd+"_invalid";
		}
		if (hnd.length()>15) {
			hnd = hnd.substring(0,15);
		}

		if (!hnd.startsWith("@")) {
			hnd = "@"+hnd;
		}
		
		handle=hnd;
		
	}
	
	
	/**
	 * (2 marks)
	 * @param flw - the int to use when setting the instance variable
	 * 
	 * The function should check for these edge cases:
	 * - The number of followers cannot be a negative value. If passed a negative 
	 * 	 number, then followers should be set to 0
	 *   e.g. if flw = -10
	 *   	  then followers should be set to:
	 *   	  followers = 0
	 */
	public void setFollowers(int flw) {
		//TODO To be completed
		if (flw < 0) {
			followers = 0;
		}
		else {
			followers =flw;
		}
	}
	
	/**
	 * (3 marks)
	 * @param displayName
	 * @param handle
	 * @param followers
	 * @param verifiedStatus
	 * 
	 * This constructor must perform the following:
	 * - Use the passed parameter variables to set the appropriate instance variables
	 * - Use the setters above when setting the instance variables. No marks will be
	 * 	 given unless ALL the setters above are used.
	 * 
	 * Full marks will be awarded if the constructor is defined correctly even if some
	 * or all of the setters above are not passing. The JUnit tests may not reflect 
	 * this as it will be manually applied.
	 * 
	 */
	public User(String displayName, String handle, int followers, boolean verifiedStatus) {
		//TODO To be completed
		this.setDisplayName(displayName);
		this.setHandle(handle);
		this.setFollowers(followers);
		this.setVerifiedStatus(verifiedStatus);
	}
	
	/**
	 * (3 marks)
	 * @param u - the passed user to compare against
	 * @return true if the calling object and passed object have the same
	 * 		   displayName, handle, followers and verifiedStatus.
	 */
	public boolean equals(User u) {
		//TODO To be completed
		if(this.displayName == u.displayName && this.handle == u.handle && this.followers == u.followers && this.verifiedStatus == u.verifiedStatus)
			return true;
		return false;
	}
	
	/**
	 * (4 marks)
	 * This function should return a string representing the calling object
	 * 
	 * Example 1
	 * If the calling object contained the following values:
	 * - displayName = "Daniel"
	 * - handle = "@1337G4M3R"
	 * - followers = 581
	 * - verifiedStatus = true
	 * 
	 * then toString() should return the following string:
	 * "Daniel (@1337G4M3R) has 581 followers and is verified"
	 * 
	 * Example 2
	 * If the calling object contained the following values:
	 * - displayName = "Jenny"
	 * - handle = "@jnyyy"
	 * - followers = 10000
	 * - verifiedStatus = false
	 * 
	 * then toString() should return the following string:
	 * "Jenny (@jnyyy) has 10000 followers and is not verified"
	 * 
	 * Note: the second example has 'not' in the string
	 * 
	 */
	public String toString() {
		//TODO To be completed
		String vStat;
		if(getVerifiedStatus()== true) {
			vStat = "is verified";
		}else {
			vStat = "is not verified";
		}
	 return displayName + " "+"("+handle +")"+" "+"has"+" "+followers+" followers"+" and " + vStat;
	 
		
	}
	
	/**
	 * DO NOT MODIFY ANYTHING BELOW!!!
	 */
	public User() {}
}
