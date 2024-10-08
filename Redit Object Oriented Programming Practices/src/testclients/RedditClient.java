package testclients;

import java.util.ArrayList;
import other_classes.Comment;
import other_classes.User;
import questions.Reddit;
import questions.SubReddit;

public class RedditClient {

	public static void main(String[] args) {
		
		// Create a Reddit object
		Reddit r = new Reddit();
		
		// Add some SubReddit's
		r.getSubReddits().add(SubRedditClient.getMUIC());
		r.getSubReddits().add(SubRedditClient.getGamers());
		r.getSubReddits().add(SubRedditClient.getHackers());

		System.out.println("--- Testing printReddit ---");
		r.printReddit();
		
		// Test userPosted
		System.out.println("--- Testing userPosted ---");
		System.out.println(r.userPosted("ill"));
		
		// Test topThreeUsers
		
		System.out.println("--- Testing topThreeUsers ---");
		System.out.println(r.topThreeUsers());
		
		
		// Test topFiveComments
		System.out.println("--- Testing TopFiveComments ---");
		System.out.println(r.topFiveComments());
		
		
				
		
		
	}

}
