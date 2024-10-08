package questions;

//Do not import any additional libraries!
//-15 penalty applies for each additional import

public class Tweet {
	private User user;
	private String message;
	private String[] replies;
	private int likes;
	private int retweets;
	static String[] bannedWords = {"ez", "noob", "getRekt"};
	
	public User getUser() {
		return user;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String[] getReplies() {
		return replies;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public int getRetweets() {
		return retweets;
	}
	
	/**
	 * (2 marks) 
	 * @param user - the value to set the instance variable with
	 * This function should set the 'user' instance variable to the 'user'
	 * parameter passed. This should use a shallow copy/reference copy.
	 * 
	 * Hint: this
	 * 
	 */
	public void setUser(User user) {
		//TODO To be completed
		this.user = user;
	}
	
	/**
	 * (3 marks)
	 * @param message - the String to consider when setting the instance variable
	 * 
	 * The function should check for these edge cases:
	 * - If the parameter message is empty (null OR containing no characters), then
	 *   the instance parameter message should be set to "no message"
	 *   
	 * - If the parameter message has more then 140 characters, then only the first 
	 *   140 should be kept
	 * 	 e.g. if the parameter variable message was:
	 * 	 "trains have been suspended btwn north sydney and gordon due to a report of a person injured by a train at artarmon. please consider utilising #northernline & metro services where possible"
	 *   then the instance variable message should be set to:
	 *   "trains have been suspended btwn north sydney and gordon due to a report of a person injured by a train at artarmon. please consider utilisin"
	 *   
	 * - The message should be in all lower case characters
	 * 	 e.g. if the parameter variable message was:
	 * 	 "THIS IS THE MESSAGE"
	 *   then the instance variable message should be set to:
	 *   "this is a message"
	 */
	public void setMessage(String message) {
		//TODO To be completed
		if(message == null || message.isEmpty()) {
		  message = "no message";
		}
		if(message.length()>140) {
			message = message.substring(0,140);
		}
		this.message = message.toLowerCase();
	}
	
	/**
	 * (3 marks)
	 * DEEP COPY
	 * @param replies - an array of replies
	 * 
	 * This function should create a deep copy (or instance copy) of the parameter
	 * variable 'rpls'. The deep copy should be placed in the instance variable
	 * replies
	 * 
	 * No marks will be awarded for a shallow copy (or reference copy)
	 * 
	 */
	public void setReplies(String[] replies) {
		//TODO To be completed
	String [] rpls = new String[replies.length];
	for(int i = 0 ;i<replies.length;i++) {
		rpls[i]= replies[i];
	}
	this.replies=rpls;
	}
	
	/**
	 * (2 marks)
	 * @param likes - the amount of likes to consider
	 * 
	 * This function should check for these edge cases:
	 * - The number of likes cannot be negative. If negative the instance variable
	 *   'likes' should be set to 0
	 */
	public void setLikes(int likes) {
		//TODO To be completed
		if (likes < 0) {
		likes =0;
		}
		this.likes= likes;
	}
	
	/**
	 * (2 marks)
	 * @param retweets - the amount of retweets to consider
	 * 
	 * This function should check for these edge cases:
	 * - The number of retweets cannot be negative. If negative the instance variable
	 *   'retweets' should be set to 0
	 */
	public void setRetweets(int retweets) {
		//TODO To be completed
		if (retweets < 0) {
			retweets =0;
		}
		this.retweets = retweets;
	}
	
	/**
	 * (3 marks)
	 * @param user
	 * @param message
	 * @param replies
	 * @param likes
	 * @param retweets
	 * 
	 * This constructor must perform the following:
	 * - Use the passed parameter variables to set the appropriate instance variables
	 * - Use the setters above when setting the instance variables. No marks will be
	 * 	 given unless ALL the setters above are used.
	 * 
	 * Full marks will be awarded if the constructor is defined correctly even if some
	 * or all of the setters above are not passing. The JUnit tests may not reflect 
	 * this as it will be manually applied.
	 */
	public Tweet(User user, String message, String[] replies, int likes, int retweets) {
		//TODO To be completed
		this.setUser(user);
		this.setMessage(message);
		this.setReplies(replies);
		this.setLikes(likes);
		this.setRetweets(retweets);
	}
	
	/**
	 * DO NOT MODIFY ANYTHING BELOW!!!
	 */
	public Tweet() {}
}
