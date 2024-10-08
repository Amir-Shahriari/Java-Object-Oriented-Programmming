package questions;

import java.util.ArrayList;

import other_classes.Comment;
import other_classes.User;

public class Reddit {
	
	private ArrayList<SubReddit> subreddits;
	
	/**
	 * 3 marks
	 * 
	 * This method should print out every SubReddit within the Reddit object.
	 */
	public void printReddit() {
		for(int i =0 ; i<subreddits.size() ; i++) {
			System.out.println(subreddits.get(i));
		}
		
	}
	
	/**
	 * 8 marks
	 * 
	 * @param target
	 * 
	 * @return an ArrayList which contains User object�s who posted a Comment
	 * which contains the parameter target within the message.
	 * 
	 * The ArrayList returned should not contain any duplicates, 
	 * it should only contain unique User objects.
	 * 
	 */
	public ArrayList<User> userPosted(String target){
		ArrayList<User> users = new ArrayList<User>();
		//going through all comments and storing the targer users inside users arraylist
		for(int i =0; i< subreddits.size();i++) {
			for(int j = 0 ; j<subreddits.get(i).getTopics().size();j++) {
				for(int k =0 ; k< subreddits.get(i).getTopics().get(j).getComments().size(); k++) {
					
					if(subreddits.get(i).getTopics().get(j).getComments().get(k).getMessage().contains(target)) {
						users.add(subreddits.get(i).getTopics().get(j).getComments().get(k).getPoster());
						
						}
					
				}			}
		}
		
		
		for (int i =0 ; i<users.size() ;i++) {
			for(int p =i+1 ; p<users.size()-i-1 ;p++ ) {
				if(users.get(i)==users.get(p)) {
					users.remove(i);
				}
			}
		}
		return users;
	}
	
	/**
	 * 10 marks
	 * 
	 * @return an ArrayList which contains the top three User objects 
	 * which have the most likes on their comments
	 */
	public ArrayList<User> topThreeUsers(){
		int [] usrslikes = new int[10];
		String [] usrsNames = new String[10];
		String [] usrsNames3 = new String[3];
		ArrayList<User> usrs = new ArrayList<User>();
		ArrayList<User> usrs2 = new ArrayList<User>();
		ArrayList<User> top3 = new ArrayList<User>();
		ArrayList<User> topThree = new ArrayList<User>();
		ArrayList<User> topThreelast = new ArrayList<User>();
		ArrayList<Comment> cms = new ArrayList<Comment>();
		
		// storing all the users inside usrs arraylist
		for(int i = 0 ; i<subreddits.size();i++) {
			for(int j = 0 ; j<subreddits.get(i).getTopics().size();j++) {
				for(int k =0 ; k< subreddits.get(i).getTopics().get(j).getComments().size(); k++) {
					
					usrs.add(subreddits.get(i).getTopics().get(j).getComments().get(k).getPoster());
				}
			}
		}
		// storing unique users inside usrs2 arraylist
		for(int i =0 ;i<usrs.size() ; i++) {
			boolean unique = true;
			for(int j=i+1 ; j<usrs.size() ;j++) {
				if(usrs.get(i)== usrs.get(j)) {
					unique = false;
					
				}
				
			}
			if(unique == true) {
				usrs2.add(usrs.get(i));
				}
		}
		// storing all the comments inside cms arraylist
		for(int i = 0 ; i<subreddits.size();i++) {
			for(int j = 0 ; j<subreddits.get(i).getTopics().size();j++) {
				for(int k =0 ; k< subreddits.get(i).getTopics().get(j).getComments().size(); k++) {
					cms.add(subreddits.get(i).getTopics().get(j).getComments().get(k));
				}
			}
		}
		// adding up all the likes for each user and storing them inside a separate array and storing their 
		// usernames inside another array
		for(int i = 0 ; i<10 ; i++) {
			for(int j =0 ; j<cms.size() ; j++) {
				if(cms.get(j).getPoster()== usrs2.get(i)) {
					usrslikes[i]+= cms.get(j).getLikes();
					usrsNames[i]= cms.get(j).getPoster().getUsername();
					
				}
			}
			
		}
		// sorting the likes in descending order and also sorting the usernames to the correct order regarding 
		// the likes so the idx of each element inside the likes array will be for the same username inside the usrsnames array
		int tempint =0;
		String tempstr ="";
		for(int i =0 ; i<usrslikes.length; i++) {
			for(int j =i ; j<usrslikes.length; j++) {
				if(usrslikes[i]<usrslikes[j]) {
					tempstr = usrsNames[i];
					tempint = usrslikes[i];
					usrslikes[i]=usrslikes[j];
					usrsNames[i]= usrsNames[j];
					usrslikes[j]=tempint;
					usrsNames[j]= tempstr;
					
				}
			}
		}
		// getting the users regarding the usernames and storing the first three users inside the topThreelast arraylist
		for(int i =0 ; i<usrsNames3.length ;i++ ) {
			usrsNames3[i] = usrsNames[i];
		}
		for(int i = 0 ; i<cms.size() ; i++) {
			for(int p =0 ; p<usrsNames3.length; p++) {
				if(cms.get(i).getPoster().getUsername().equals(usrsNames3[p])) {
					top3.add(cms.get(i).getPoster());
				}
			}
			
		}
		for(int i =0 ;i<top3.size() ; i++) {
			boolean unique = true;
			for(int j=i+1 ; j<top3.size() ;j++) {
				if(top3.get(i)== top3.get(j)) {
					unique = false;
					
				}
				
			}
			if(unique == true) {
				topThree.add(top3.get(i));
				}
		}
		
		for(int i =0 ;i<3 ; i++) {
			topThreelast.add(topThree.get(i));
		}
		return topThreelast;
	}
	
	/**
	 * 10 marks
	 * 
	 * @return n an ArrayList which contains the five Comment 
	 * objects which have the most likes.
	 * 
	 */
	public ArrayList<Comment> topFiveComments(){
		ArrayList<Comment> topFive = new ArrayList<Comment>();
		ArrayList<Comment> cms = new ArrayList<Comment>();
		// storing all the comments inside cms ArrayList
for(int i = 0 ; i<subreddits.size();i++) {
	for(int j = 0 ; j<subreddits.get(i).getTopics().size();j++) {
		for(int k =0 ; k< subreddits.get(i).getTopics().get(j).getComments().size(); k++) {
			cms.add(subreddits.get(i).getTopics().get(j).getComments().get(k));
		}
	}
}
// sorting them in descending order
Comment temp = subreddits.get(0).getTopics().get(0).getComments().get(0);
for(int i =0 ; i<cms.size(); i++) {
	for(int j =i ; j<cms.size(); j++) {
		if(cms.get(i).getLikes()<cms.get(j).getLikes()) {
			temp= cms.get(i);
			cms.set(i, cms.get(j));
			cms.set(j, temp);
		}
	}
}
// adding first 5 comment to topFive arraylist
for(int i =0 ; i<5 ; i++) {
	topFive.add(cms.get(i));
}
return topFive;
	}

	/**
	 * 
	 * DO NOT EDIT THE BELOW CODE
	 * 
	 */
	public ArrayList<SubReddit> getSubReddits(){
		return subreddits;
	}
	public SubReddit getSubReddits(int idx){
		return subreddits.get(idx);
	}
	public Reddit() {
		subreddits = new ArrayList<SubReddit>();
	}
}
