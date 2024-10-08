package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import questions.User;

public class UserTest {
	private static int score = 0;
	
	@AfterAll
	public static void wrapUp() throws IOException {
		System.out.println("Score = "+score+" (out of 20)"); //TODO ==================================
	}
	
	@Test
	void testSetVerifiedStatus() {
		User u = new User();
		
		u.setVerifiedStatus(true);
		assertTrue(u.getVerifiedStatus());
		
		u.setVerifiedStatus(false);
		assertFalse(u.getVerifiedStatus());
		
		score += 2;
	}
	
	@Test 
	void testSetDisplayName() {
		User u = new User();
		
		u.setDisplayName("George");
		assertEquals("George", u.getDisplayName());
		
		u.setDisplayName("this is my really awesome display name that is over 50 characters!!!");
		assertEquals("this is my really awesome display name that is ove", u.getDisplayName());
		
		u.setDisplayName("And another reallllly long display name for a user");
		assertEquals("And another reallllly long display name for a user", u.getDisplayName());
		
		u.setDisplayName("And another reallllly long display name for a user :O");
		assertEquals("And another reallllly long display name for a user", u.getDisplayName());
		
		score += 2;
	}
	
	@Test
	void testSetHandle() {
		User u = new User();
		
		u.setHandle("wcom1010SoCool");
		assertEquals("@wcom1010SoCool", u.getHandle());
		
		u.setHandle("@sml");
		assertEquals("@sml_invalid", u.getHandle());
		
		u.setHandle("@sml");
		assertEquals("@sml_invalid", u.getHandle());

		u.setHandle("@wow_really_cool_handle");
		assertEquals("@wow_really_coo", u.getHandle());
		
		u.setHandle("");
		assertEquals("@_invalid", u.getHandle());
		
		u.setHandle("@");
		assertEquals("@_invalid", u.getHandle());
		
		u.setHandle("a");
		assertEquals("@a_invalid", u.getHandle());
		
		u.setHandle("@we_good");
		assertEquals("@we_good", u.getHandle());
		
		score += 4;
	}
	
	@Test
	void testSetFollowers() {
		User u = new User();
		
		u.setFollowers(15);
		assertEquals(15, u.getFollowers());
		
		u.setFollowers(-10);
		assertEquals(0, u.getFollowers());
		
		u.setFollowers(-817);
		assertEquals(0, u.getFollowers());
		
		u.setFollowers(0);
		assertEquals(0, u.getFollowers());
		
		score += 2;
	}
	
	@Test
	void testUser() {
		
		User u = new User("", "", 0, true);
		assertEquals("", u.getDisplayName());
		assertEquals("@_invalid", u.getHandle());
		assertEquals(0, u.getFollowers());
		assertTrue(u.getVerifiedStatus());
		
		u = new User("Bob", "@bobbby", 1512, false);
		assertEquals("Bob", u.getDisplayName());
		assertEquals("@bobbby", u.getHandle());
		assertEquals(1512, u.getFollowers());
		assertFalse(u.getVerifiedStatus());
		
		u = new User("Bob with a much longer display name that exceeds fifty characters", "l", -200, true);
		assertEquals("Bob with a much longer display name that exceeds f", u.getDisplayName());
		assertEquals("@l_invalid", u.getHandle());
		assertEquals(0, u.getFollowers());
		assertTrue(u.getVerifiedStatus());
		
		u = new User("Bob with a much longer display name that exceeds fifty characters", "@aHandleThatIsTooLong", 5, false);
		assertEquals("Bob with a much longer display name that exceeds f", u.getDisplayName());
		assertEquals("@aHandleThatIsT", u.getHandle());
		assertEquals(5, u.getFollowers());
		assertFalse(u.getVerifiedStatus());
		
		score += 3;
	}
	
	@Test
	void testEquals() {
		User a = new User("Twitter Account", "@twitter_handle", 10, true);
		User b = new User("Differnet Account", "@different", 8, false);
		
		assertFalse(a.equals(b));
		assertFalse(b.equals(a));
		
		b = new User("Twitter Account", "@twitter_handle", 10, true);
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
		
		b = new User("Twitter Accoun", "@twitter_handle", 10, true);
		assertFalse(a.equals(b));
		assertFalse(b.equals(a));
		
		b = new User("Twitter Account", "@twitter_handl", 10, true);
		assertFalse(a.equals(b));
		assertFalse(b.equals(a));
		
		b = new User("Twitter Account", "@twitter_handle", 11, true);
		assertFalse(a.equals(b));
		assertFalse(b.equals(a));
		
		b = new User("Twitter Account", "@twitter_handle", 11, false);
		assertFalse(a.equals(b));
		assertFalse(b.equals(a));
		
		score += 3;
	}
	
	@Test
	void testToString() {
		User u = new User("Daniel", "@1337G4M3R", 581, true);
		assertEquals("Daniel (@1337G4M3R) has 581 followers and is verified", u.toString());
		
		u = new User("Jenny", "@jnyyy", 10000, false);
		assertEquals("Jenny (@jnyyy) has 10000 followers and is not verified", u.toString());
		
		score += 4;
	}
}
