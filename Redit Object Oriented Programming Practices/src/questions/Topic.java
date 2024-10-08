package questions;

import java.util.ArrayList;

import other_classes.Comment;
import other_classes.User;

public class Topic {
	
	private ArrayList<Comment> comments; // An ArrayList which stores all the comments made within the Topic
	private String title; // The title of the Topic
	private int lastID;
	
	/**
	 * 2 marks
	 * This method should print the title of the Topic followed by 
	 * all the comments made within it.
	 * 
	 * The title of the Topic should be printed first then each comment should be printed 
	 * on a new line.
	 * 
	 */
	public void printTopic() {
		// To be completed
		System.out.println(title);
		for(Comment cm : comments) {
			System.out.println(cm);
		}
	}
	
	/**
	 * 4 marks
	 * @param redditor - The User to search for
	 * @return the total number of likes for all comments posted by the parameter User object
	 * 
	 */
	public int sumLikes(User redditor) {
		// To be completed
		int sum=0;
		for(int i =0; i < comments.size() ;i++) {
			if(comments.get(i).getPoster() == redditor)
			sum += comments.get(i).getLikes();
		}
		return sum;
	}
	
	/**
	 * 4 marks
	 * This method overwrite the message within the Comment object
	 * whose commentId matches the parameter commentId
	 * 
	 * @param commentId - the commentId of the comment to edit
	 * @param message - the new message to save
	 * 
	 */
	public void editMessage(int commentId, String message) {
		// To be completed
		for (Comment cm: comments) {
			if(cm.getId()== commentId)
		cm.setMessage(message);}
	}
	
	/**
	 * 4 marks
	 * This method should remove the Comment object from comments
	 * whose commentId equals to the parameter commentId.
	 * 
	 * It should return the Comment object which was removed.
	 * 
	 * @param commentId - the commentId of the Comment object to remove
	 * @return the Comment object that was removed from comments
	 * 		   return null if no post was removed
	 */
	public Comment deleteComment(int commentId) {
		// To be completed
		Comment result = null;
		for(int i =0; i<comments.size(); i++) {
			if(comments.get(i).getId() == commentId) {
				result=comments.get(i);
				comments.remove(i);
			}
		}
		return result;
	}
	
	/**
	 * 4 marks
	 * @param redditor - the User object to search for
	 * 
	 * @return an ArrayList of all Comment objects which were
	 * posted by to the Topic by the parameter User object
	 * called redditor
	 * 
	 */
	public ArrayList<Comment> findCommentsBy(User redditor) {
		// To be completed
		ArrayList<Comment> cms = new ArrayList<Comment>();
		//going through all the comments and adding target comments to cms
		for(int i =0 ; i<comments.size() ; i++) {
		if (comments.get(i).getPoster() == redditor) {
			cms.add(comments.get(i));
		}
		}
		
		return cms;
	}
	
	/**
	 * 4 marks
	 * This method should find all Comment objects within the comments ArrayList
	 * which contain the search term within their message.
	 * 
	 * @param term
	 * @return an ArrayList of Comment objects whose message contains the parameter term.
	 * 
	 * If no Comment objects can be found then the method an empty ArrayList.
	 * 
	 */
	public ArrayList<Comment> findComments(String term) {
		// To be completed
		ArrayList<Comment> cms = new ArrayList<Comment>();
		// going through all the comments and adding them to the ArrayList cms
		for(int i =0 ; i<comments.size() ; i++) {
		if (comments.get(i).getMessage().contains(term)) {
			cms.add(comments.get(i));
		}
		}
		return cms;
		
	}
	

	/**
	 * 8 marks
	 * This method should return an ArrayList which contains the unique User objects
	 * which have posted a comment within the Topic
	 * 
	 * @return an ArrayList of User objects who have posted within the Topic
	 * 
	 * Note that there should be no duplicates within the returned ArrayList
	 */
	public ArrayList<User> getUniqueUsers() {
		// To be completed
		ArrayList<User> users = new ArrayList<User>();
		// going through all the comments and checking for duplicates
		for(int i =0 ;i<comments.size() ; i++) {
			boolean unique = true;
			for(int j=i+1 ; j<comments.size() ;j++) {
				if(comments.get(i).getPoster()== comments.get(j).getPoster()) {
					unique = false;
					
				}
				
			}
			if(unique == true) {
				users.add(comments.get(i).getPoster());
				}
		}
		
	
		return users;
	}
	
	/**
	 * 
	 * DO NOT EDIT THE BELOW CODE
	 * 
	 */
	public Topic(String title){
		comments = new ArrayList<Comment>();
		this.title = title;
		lastID=0;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<Comment> getComments(){
		return comments;
	}
	public void addComment(User commentor, String message, int likes) {
		// To be completed
		comments.add(new Comment(commentor,message,lastID,likes));
		lastID++;
	}
}
