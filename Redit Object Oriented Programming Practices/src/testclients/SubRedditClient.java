package testclients;

import java.util.ArrayList;

import other_classes.Comment;
import other_classes.User;
import questions.Topic;
import questions.SubReddit;

public class SubRedditClient {

	public static void main(String[] args) {
		
		// Create a SubReddit object
		SubReddit s = getMUIC();
		
		System.out.println("\n\n--- Testing printSubReddit ---");
		s.printSubReddit();
		
		System.out.println("--- Testing allLikes ---");
		System.out.println(s.allLikes());
		
		// Test the mostPopularTopic method below
		System.out.println("--- mostPopularTopic ---");
		System.out.println(s.mostPopularTopic());
		
		
		// Test the mostDisliked method below
		System.out.println("--- mostDisliked ---");
		System.out.println(s.mostDisliked());
		
		
		// Test the cleanUp method below
		// Hint: Print the SubReddit object before and after the cleanUp method
		// is called to see what was removed. (use s.printSubReddit())
		System.out.println("--- cleanUp ---");
		s.printSubReddit();
		System.out.println(s.cleanUp());
		s.printSubReddit();
		
		
		// Test the mostLikedComment method below
		System.out.println("--- mostLikedComment ---");
		System.out.println(s.mostLikedComment());
		
		// Test the mostLikedUser method below
		System.out.println("--- mostLikedUser ---");
		System.out.println(s.mostLikedUser());
		
		
	}

	public static SubReddit getMUIC() {
		SubReddit s = new SubReddit("MUIC");
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("kyly"));
		users.add(new User("HavanaBanana"));
		users.add(new User("WavyGrainz"));
		users.add(new User("aka_andie"));
		users.add(new User("CrushingDonuts"));
		users.add(new User("Obie"));
		users.add(new User("lucidbb"));
		users.add(new User("K-T-LO"));
		users.add(new User("FlapJak"));
		users.add(new User("edobusy"));

		// Now lets make some channels and add some posts
		Topic c1 = new Topic("WCOM1010");
		TopicClient.addWCOM1010Posts(users, c1);
		s.getTopics().add(c1);
		Topic c2 = new Topic("General");
		TopicClient.addGeneralPosts(users, c2);
		s.getTopics().add(c2);
		Topic c3 = new Topic("Football");
		TopicClient.addFootballPosts(users, c3);
		s.getTopics().add(c3);

		return s;
	}

	public static SubReddit getGamers() {
		SubReddit s = new SubReddit("Gamers");
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("kyly"));
		users.add(new User("CrushingDonuts"));
		users.add(new User("Obie"));
		users.add(new User("K-T-LO"));
		users.add(new User("FlapJak"));
		users.add(new User("edobusy"));

		// Now lets make some channels and add some posts
		Topic c2 = new Topic("Valorant");
		TopicClient.addValorantPosts(users, c2);
		s.getTopics().add(c2);
		Topic c3 = new Topic("COD");
		TopicClient.addCODPosts(users, c3);
		s.getTopics().add(c3);

		return s;
	}

	public static SubReddit getHackers() {
		SubReddit s = new SubReddit("Hackers");
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("kyly"));
		users.add(new User("Obie"));
		users.add(new User("lucidbb"));

		// Now lets make some channels and add some posts
		Topic c1 = new Topic("Targets");
		TopicClient.addTargetsPosts(users, c1);
		s.getTopics().add(c1);

		return s;
	}

}
