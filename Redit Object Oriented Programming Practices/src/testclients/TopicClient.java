package testclients;

import java.util.ArrayList;

import other_classes.Comment;
import other_classes.User;
import questions.Topic;

public class TopicClient {

	public static void main(String[] args) {

		// This file can be used to test your Topic.java solutions

		// First lets create an ArrayList to store all the potential users, this will
		// make it easier for us to create posts etc, we can just pick a user from here

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

		// Now lets make a Topic
		Topic c = new Topic("WCOM1010");

		// New lets add some posts
		// The addWCOM1010Posts method is located below
		// and uses the addComment method within the Topic class
		addWCOM1010Posts(users, c);

		// Lets test changing a comment
		c.editMessage(0, "please can i have some donuts");
		c.editMessage(10, "!!!!AYAYYAA!!!");

		// Lets test removing some comments
		c.deleteComment(3);
		c.deleteComment(8);

		// Lets print out the chat
		System.out.println("--- Testing add, change, remove and view ---");
		c.printTopic();

		System.out.println("\n\n--- Testing sumLikes ---");
		// This user has commented
		System.out.println(c.sumLikes(users.get(9)));
		// This user hasn't commented
		System.out.println(c.sumLikes(users.get(5)));
		// This user started the Topic but never commented again
		System.out.println(c.sumLikes(users.get(2)));

		System.out.println("\n\n--- Testing findPostedBy ---");
		// Lets get all the posts by kyly
		ArrayList<Comment> posts = c.findCommentsBy(users.get(0));
		if (posts != null) {
			for (Comment p : posts) {
				System.out.println(p);
			}
		}else {
			System.out.println("Method incomplete");
		}
		// Lets get all the posts by K T LO
		posts = c.findCommentsBy(users.get(7));
		if (posts != null) {
			for (Comment p : posts) {
				System.out.println(p);
			}
		}else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing findComments ---");
		// Search for all comments which contain the letter i
		posts = c.findComments("i");
		if (posts != null) {
			for (Comment p : posts) {
				System.out.println(p);
			}
		}else {
			System.out.println("Method incomplete");
		}

		System.out.println("\n\n--- Testing getUniqueUsers ---");
		System.out.println("Unique Users:");
		ArrayList<User> uniq = c.getUniqueUsers();
		for(User u : uniq) {
			System.out.println(u);
		}

	}

	public static void addWCOM1010Posts(ArrayList<User> users, Topic c) {
		c.addComment(users.get(2), "i want some donuts",10);
		c.addComment(users.get(0), "ill get you some",3);
		c.addComment(users.get(1), "do they have banana flavour?",-5);
		c.addComment(users.get(7), "call me K T LO",6);
		c.addComment(users.get(8), "you need to get some flap jaks guys!1!!1!",2);
		c.addComment(users.get(6), "DAVEED",15);
		c.addComment(users.get(3), "hey everyone",3);
		c.addComment(users.get(7), "call me K T LO",-3);
		c.addComment(users.get(4), "DELETE ME",-10);
		c.addComment(users.get(7), "call me K T LO",-5);
		c.addComment(users.get(0), "whats goin on",5);
		c.addComment(users.get(1), "ayyyyyyyy",2);
		c.addComment(users.get(7), "call me K T LO",-10);
		c.addComment(users.get(9), "benvinuto!",1);
	}

	public static void addGeneralPosts(ArrayList<User> users, Topic c) {
		c.addComment(users.get(4), "whens uni start again?",20);
		c.addComment(users.get(6), "last week",22);
		c.addComment(users.get(4), "srs?",-1);
		c.addComment(users.get(6), "haha yea",6);
		c.addComment(users.get(4), "whoops",0);
		c.addComment(users.get(0), "nice one! hahaha",1);
	}

	public static void addFootballPosts(ArrayList<User> users, Topic c) {
		c.addComment(users.get(0), "anyone keen for a game?",15);
		c.addComment(users.get(1), "im in, when and where?",3);
		c.addComment(users.get(0), "mq 9am friday?",-3);
		c.addComment(users.get(0), "anyone else keen?",5);
		c.addComment(users.get(1), "ill ask around",1);
		c.addComment(users.get(6), "DAVEED is keen",26);
		c.addComment(users.get(6), "ill be there, do you have a ball?",1);
		c.addComment(users.get(0), "i can bring mine, i dont mind though",4);
		c.addComment(users.get(6), "has anyone else responded?",40);
		c.addComment(users.get(1), "still waiting",1);
		c.addComment(users.get(0), "i got another 3 people coming",0);
		c.addComment(users.get(6), "awesome",0);
		c.addComment(users.get(7), "im keen to play guys, same time / place?",1);
		c.addComment(users.get(0), "yea we have around 6 now",6);
		c.addComment(users.get(1), "cool i have 2 more",3);
		c.addComment(users.get(1), "see you guys on friday!",-2);
		c.addComment(users.get(6), "let me know if you want me to bring a ball",0);
		c.addComment(users.get(0), "sure thing",0);
		c.addComment(users.get(1), "LETS PLAY!!",6);
		c.addComment(users.get(0), "wewwwwwwwwwwwww!",3);
	}

	public static void addCODPosts(ArrayList<User> users, Topic c) {
		c.addComment(users.get(0), "m4 is the best",10);
		c.addComment(users.get(3), "naa ak is way better",3);
		c.addComment(users.get(4), "haha i just rocket everyone from the sky",0);
		c.addComment(users.get(1), "thats sooo annoying",-6);
		c.addComment(users.get(0), "its so funny though",2);

	}

	public static void addValorantPosts(ArrayList<User> users, Topic c) {
		c.addComment(users.get(2), "did you guys see jimmy went into a comp",5);
		c.addComment(users.get(0), "yea i was watching it",1);
		c.addComment(users.get(3), "i really like this game but its so busy",2);
		c.addComment(users.get(0), "what do you mean",3);
		c.addComment(users.get(5), "i think he means so many skills etc",0);
	}

	public static void addTargetsPosts(ArrayList<User> users, Topic c) {
		c.addComment(users.get(0), "daniel",0);
		c.addComment(users.get(0), "van",0);
		c.addComment(users.get(0), "fouhad",0);
		c.addComment(users.get(2), "kyly",0);
		c.addComment(users.get(2), "levi",0);
	}

}
