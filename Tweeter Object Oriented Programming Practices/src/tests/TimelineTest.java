package tests;

//Do not import any additional libraries!
//-20 penalty applies for each additional import

import static org.junit.jupiter.api.Assertions.*;

import java.awt.desktop.UserSessionEvent;

import org.junit.jupiter.api.Test;
import questions.User;
import questions.Tweet;
import questions.Timeline;

//Do not import any additional libraries!
//-20 penalty applies for each additional import

public class TimelineTest {
	
	//Review the test function below
	
	@Test
	void testFindTweetWithNReplies() {
		/*
		 * This test is an example of how you might approach testing for this assignment
		 */
		
		/*
		 * Generate data using the provided createTimeLine1() function
		 * Note: You can make your own createTimeline function for testing
		 */
		Timeline tl = Timeline.createTimeline1();
		//tl now contains all the data produced inside of createTimeline1() i.e. 5 users and 8 Tweets
		
		/*
		 * findTweetWithReplies() returns back the Tweet object that had n number of replies.
		 * The first tweet in the tweets array is what findTweetWithNReplies(0) should return back
		 * as it has 0 replies.
		 * 
		 * Therefore t1.tweets[0] should be equal to t1.findTweetWithNReplies(0)
		*/
		assertEquals(tl.tweets[0], tl.findTweetWithNReplies(0)); //The first tweet has 0 replies
		assertEquals(tl.tweets[3], tl.findTweetWithNReplies(2)); //The fourth tweet has 2 replies
		assertEquals(null, tl.findTweetWithNReplies(100)); //No tweets have 100 replies
	}
	
	//==================================
	//== Place your tests below here! ==
	//==================================
	
	//TODO To be completed
	@Test
	void TestCountUsersWithMoreThen() {
		Timeline t = Timeline.createTimeline1();
		assertEquals(5, t.countUsersWithMoreThen(0));
		t.users[0].setFollowers(874);
		t.users[2].setFollowers(875);
		t.users[1].setFollowers(44);
		assertEquals(2, t.countUsersWithMoreThen(874));
		assertEquals(0, t.countUsersWithMoreThen(347456));
		assertEquals(3, t.countUsersWithMoreThen(44));
		assertEquals(1, t.countUsersWithMoreThen(875));
		
	}
	


	@Test
	void TestCountTweetsWithMoreLikes() {
		Timeline t = Timeline.createTimeline1();
		assertEquals(7, t.countTweetsWithMoreLikes());
		t.tweets[0].setLikes(2);
		assertEquals(6, t.countTweetsWithMoreLikes());
		t.tweets[1].setLikes(10);
		assertEquals(5, t.countTweetsWithMoreLikes());
	}

 	@Test
 	void TestFindUserWithHandle() {
 		Timeline t = Timeline.createTimeline1();
 		assertEquals("@sahr81",t.findUserWithHandle("@sahr81").getHandle());
 		assertEquals(t.users[0],t.findUserWithHandle("@mic_invalid"));
 		assertTrue("@sahr81".equals(t.findUserWithHandle("@sahr81").getHandle()));
 		assertEquals("@BarackObama",t.findUserWithHandle("@BarackObama").getHandle());
 		assertEquals("@jen151",t.findUserWithHandle("@jen151").getHandle());
 		assertEquals(null,t.findUserWithHandle(null));
 		assertEquals(null,t.findUserWithHandle(""));
 		
 	}
 		
 	
 		
 	@Test
 	void TestRemoveFromTimeline() {
 		Timeline t = Timeline.createTimeline1();
 		Timeline t2 = Timeline.createTimeline1();
 		Timeline t3 = Timeline.createTimeline1();
		t.removeFromTimeline(t.users[4]);
		assertTrue(t.users[4] == null);
		assertTrue(t.tweets[1] == null);
		assertTrue(t.tweets[2] == null);
		assertTrue(t.tweets[7] == null);
		
		t2.removeFromTimeline(t2.users[0]);
		assertTrue(t2.users[0] == null);
		assertTrue(t2.tweets[0] == null);
		assertTrue(t2.tweets[6] == null);
		

		t3.removeFromTimeline(t3.users[2]);
		assertTrue(t3.users[2] == null);
		assertTrue(t3.tweets[4] == null);
	
		
	
 		
	
 	}
 


 		
 	}
 	