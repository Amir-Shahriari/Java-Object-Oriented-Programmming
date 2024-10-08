package questions;

import java.util.ArrayList;

import other_classes.Comment;
import other_classes.User;

public class SubReddit {
	private ArrayList<Topic> topics;
	private String name;

	/**
	 * 2 marks
	 * 
	 * This method should print the name of the SubReddit object follow by 
	 * each of the Topics within the SubReddit and all their messages. 
	 * 
	 * (printTopic will be helpful here)
	 */
	public void printSubReddit() {
		//going through all the topics and printing all the comments inside them
		int i =0;
		System.out.println(name);
		while(i < topics.size()) {
			System.out.println(topics.get(i).getTitle());
			int o =0 ;
			while( o<topics.get(i).getComments().size()) {
		System.out.println(topics.get(i).getComments().get(o));
		o++;}
			i++;
		}
	}
	
	/**
	 * 2 marks
	 * 
	 * @return the sum of all likes to the comments posted within the 
	 * Topics of this SubReddit. 
	 * 
	 * Only positive likes should be considered here
	 */
	public int allLikes() {
		int sum =0;
		// going through all topics and their comments and adding up all likes
		for(int i = 0 ; i<topics.size() ; i++) {
			for(int j =0 ; j<topics.get(i).getComments().size() ; j++) {
				if(topics.get(i).getComments().get(j).getLikes()>0)
		sum+= topics.get(i).getComments().get(j).getLikes() ;}
		}
		return sum;
	}
	
	/**
	 * 5 marks
	 * 
	 * @return the title of the Topic object which has the most likes.
	 * 
	 * (sumLikes will be helpful here)
	 * 
	 */
	public String mostPopularTopic() {
		int topicsLikes[] = new int[topics.size()];
		int idx=0;
		int max =topicsLikes[0];
		for(int i = 0 ; i<topics.size() ; i++) {
			for(int j =0 ; j<topics.get(i).getComments().size() ; j++) {
				if(topics.get(i).getComments().get(j).getLikes()>0)
			topicsLikes[i]+= topics.get(i).getComments().get(j).getLikes() ;}
		}
		for(int i =0 ; i<topicsLikes.length ; i++) {
			if(topicsLikes[i]> max)
				max = topicsLikes[i];
			idx = i;
		}
		return topics.get(idx).getTitle();
	}
	
	/**
	 * 5 marks
	 * 
	 * @return the return message associated to the most disliked 
	 * Comment within the Topics of the SubReddit.
	 * 
	 */
	public String mostDisliked() {
	Comment min = topics.get(0).getComments().get(0);
		for(int i= 0 ; i<topics.size(); i++) {
			for( int j = 0 ; j <topics.get(i).getComments().size(); j++) {
				if(topics.get(i).getComments().get(j).getLikes()<min.getLikes()) {
					min = topics.get(i).getComments().get(j);
				}
			}
		}
	
		
		return min.getMessage();
		
		
	}
	
	/**
	 * 5 marks
	 * 
	 * This method should remove all the Comment objects within the 
	 * Topics of the SubReddit which have a negative number of likes.
	 * 
	 * @return the number of Comment objects which were removed.
	 */
	public int cleanUp() {
		int count =0;
		for(int i = 0 ; i<topics.size();i++) {
			for(int j =0 ; j< topics.get(i).getComments().size() ; j++) {
				if(topics.get(i).getComments().get(j).getLikes() < 0) {
					topics.get(i).getComments().remove(j);
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * 5 marks
	 * 
	 * @return the Comment object within the Topics of the 
	 * Subreddit which has the most likes.
	 * 
	 */
	public Comment mostLikedComment() {
		Comment max = topics.get(0).getComments().get(0);
		for(int i= 0 ; i<topics.size(); i++) {
			for( int j = 0 ; j <topics.get(i).getComments().size(); j++) {
				if(topics.get(i).getComments().get(j).getLikes()> max.getLikes()) {
					max = topics.get(i).getComments().get(j);
				}
			}
		}
	
		
		return max;
	
	}
	
	/**
	 * 5 marks
	 * 
	 * @return the User object within the Topics of the Subreddit 
	 * which has the most likes on their comments.
	 * 
	 */
	public User mostLikedUser() {
		
		int idx= 0;
		User maxUsr = topics.get(0).getComments().get(0).getPoster();
		int likes = 0;
		int max = 0;
		
		ArrayList<Comment> cms = new ArrayList<Comment>();
		for(int i=0 ; i<topics.size(); i++) {
			for(int j = 0 ; j< topics.get(i).getComments().size() ; j++) {
				cms.add(topics.get(i).getComments().get(j));
			}
		}
			
		for(int j = 0 ; j<cms.size(); j++) {
		User usr = cms.get(j).getPoster();
		for(int i =0 ; i<cms.size();i++) {
			if(cms.get(i).getPoster() == usr && i != j) {
				likes += cms.get(i).getLikes();
				idx = i;
			}
		}
		if(likes > max) {
			max = likes;
			maxUsr = cms.get(idx).getPoster();
		}
		likes =0;
		}
		
		return maxUsr;
//		for(int i =0 ; i< topics.size() ; i++) {
//		for(int j = 0 ; j< topics.get(i).getComments().size() ; j++) {
//			if(topics.get(i).getComments().get(j).getPoster() == usr){
//			likes += topics.get(i).getComments().get(j).getLikes();
//			idx = j;
//			}
//		}
//		if(likes > max) {
//			max = likes;
//			usr = topics.get(i).getComments().get(idx).getPoster();
//		}
//	}
	}
	
	/**
	 * 
	 * DO NOT EDIT THE BELOW CODE
	 * 
	 */
	public SubReddit(String name) {
		this.name = name;
		topics = new ArrayList<Topic>();
	}
	public ArrayList<Topic> getTopics() {
		return topics;
	}
	public String getName() {
		return name;
	}
	
}
