package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import questions.Tweet;
import questions.User;

public class TweetTest {
	private static int score = 0;
	
	@AfterAll
	public static void wrapUp() throws IOException {
		System.out.println("Score = "+score+" (out of 15)");
	}
	
	@Test
	void testSetUser() {
		User a = new User("Daniel", "@1337G4M3R", 581, true);
		User b = new User("Jenny", "@jnyyy", 10000, false);
		User c = new User("Twitter Account", "@twitter_handle", 10, true);
		Tweet t = new Tweet();
		
		t.setUser(a);
		assertTrue(t.getUser() != null);
		assertTrue(t.getUser().equals(a));
		assertFalse(t.getUser().equals(b));
		
		t.setUser(b);
		assertTrue(t.getUser() != null);
		assertTrue(t.getUser().equals(b));
		assertFalse(t.getUser().equals(c));
		
		score += 2;
	}
	
	@Test
	void testSetMessage() {
		Tweet t = new Tweet();
		
		t.setMessage(null);
		assertEquals("no message", t.getMessage());
		
		t.setMessage("");
		assertEquals("no message", t.getMessage());
		
		t.setMessage("trains have been suspended btwn north sydney and gordon due to a report of a person injured by a train at artarmon. please consider utilising #northernline & metro services where possible");
		assertEquals("trains have been suspended btwn north sydney and gordon due to a report of a person injured by a train at artarmon. please consider utilisin", t.getMessage());
		
		t.setMessage("THIS IS THE MESSAGE");
		assertEquals("this is the message", t.getMessage());
		
		score += 3;
	}
	
	@Test
	void testSetReplies() {
		Tweet t = new Tweet();
		String[] replies = {"This is reply 1", "This is reply 2", "And another"};
		
		t.setReplies(replies);
		assertFalse(t.getReplies() == replies); //Check that they do not have the same reference/memory location
		
		assertEquals(replies.length, t.getReplies().length);
		assertTrue(replies[0].equals(t.getReplies()[0]));
		assertTrue(replies[1].equals(t.getReplies()[1]));
		assertTrue(replies[2].equals(t.getReplies()[2]));
		
		score += 3;
	}
	
	@Test
	void testSetLikes() {
		Tweet t = new Tweet();
		
		t.setLikes(15);
		assertEquals(15, t.getLikes());
		
		t.setLikes(0);
		assertEquals(0, t.getLikes());
		
		t.setLikes(-5);
		assertEquals(0, t.getLikes());
		
		t.setLikes(-10);
		assertEquals(0, t.getLikes());
		
		score += 2;
	}
	
	@Test
	void testSetRetweets() {
		Tweet t = new Tweet();
		
		t.setRetweets(15);
		assertEquals(15, t.getRetweets());
		
		t.setRetweets(0);
		assertEquals(0, t.getRetweets());
		
		t.setRetweets(-5);
		assertEquals(0, t.getRetweets());
		
		t.setLikes(-10);
		assertEquals(0, t.getRetweets());
		
		score += 2;
	}
	
	@Test
	void testTweet() {
		User a = new User("Daniel", "@1337G4M3R", 581, true);
		String[] replies = {"One reply"};
		Tweet t = new Tweet(a, "This is a message!", replies, 10, 20);
		
		assertTrue(t.getUser() == a);
		assertEquals("this is a message!", t.getMessage());
		
		assertFalse(t.getReplies() == replies);
		assertEquals(10, t.getLikes());
		assertEquals(20, t.getRetweets());
		
		score += 3;
	}
}
