package questions;

//Do not import any additional libraries!
//-15 penalty applies for each additional import

public class Timeline {

	// =================================
	// ====== DO NOT MODIFY BELOW ======
	// =================================

	public User[] users;
	public Tweet[] tweets;

	public static Timeline createTimeline1() {
		User[] users = { new User("Michael", "@mic", 1, false),
				new User("Daniel", "@dan11", 1, false),
				new User("Jenny", "@jen151", 1, false), 
				new User("Obama", "@BarackObama", 1, false),
				new User("Sarah", "@sahr81", 1, false), };

		Tweet[] tweets = { new Tweet(users[0], "This is a tweet #uselesstweets", new String[] {}, 10, 5),
				new Tweet(users[4], "#Giveaway at 9pm", new String[] { "Excited!", "Who's eligible?", "yayy" }, 819,
						82),
				
				new Tweet(users[4], "Favourite colour?", new String[] { "Blue!!", "reddd", "i am colourblind :(" },
						3000, 21),
				new Tweet(users[1], "Quiz on Friday, don't forget to study! #FridayFunDay #Java",
						new String[] { "Can we have answers please?", "Is it only on ArrayLists?" }, 99999, 5),
				new Tweet(users[2], "Wow lost so many games today :( #sadface", new String[] { "bad luck :'(" }, 18, 0),
				new Tweet(users[3], "@mic could you write some better tweets? #noob", new String[] { ":(" }, 1512, 53),
				new Tweet(users[0], "gg ez #getRekt #bestVayneOCE", new String[] {}, 0, 0),
				new Tweet(users[4], "Don't forget to enter before 9pm!!!",
						new String[] { "Already entered!", "Thanks for reminding me :)" }, 512, 3), };

		Timeline temp = new Timeline();
		temp.users = users;
		temp.tweets = tweets;
		return temp;
	}

	/**
	 * (0 marks) This is an example function used to demonstrate how you could do
	 * testing in the TimelineTest.java file
	 * 
	 * @param n - The length to consider
	 * @return The first Tweet object which has n number of replies. Return null if
	 *         no tweet object has n number of replies
	 */
	public Tweet findTweetWithNReplies(int n) {
		for (int i = 0; i < tweets.length; i++)
			if (tweets[i].getReplies().length == n)
				return tweets[i];
		return null;
	}

	// =================================
	// ====== DO NOT MODIFY ABOVE ======
	// =================================

	// You may add your own 'createTimeline' functions below here for testing
	// purposes

	/*
	 * public static Timeline createTimeline2() {
	 * 
	 * }
	 */

	/**
	 * (5 marks)
	 * 
	 * @param n - the followers to compare against
	 * @return the amount of users who have n or more followers (inclusive)
	 * 
	 *         e.g. If the users array contained the following objects: Note: not
	 *         all details for the User objects are shown below users = [
	 *         User(displayName = "bobby", followers = 50), User(displayName =
	 *         "jim", followers = 10), User(displayName = "Pam", followers = 20),
	 *         User(displayName = "Leslie", followers = 200), ]
	 * 
	 *         countUsersWithMoreThen(10) should return 3 countUsersWithMoreThen(50)
	 *         should return 1
	 * 
	 */
	public int countUsersWithMoreThen(int n) {
		// TODO To be completed
		int co = 0;
		for (int i = 0; i < users.length; i++) {
			//find the users with more followers than n
			if (users[i].getFollowers() >= n) {
				co++;
			}

		}

		return co;

	}

	/**
	 * (5 marks)
	 * 
	 * @return The number of tweets which have more 'likes' then 'retweets'
	 * 
	 *         e.g. If tweets = [ Tweet(message = "A tweet", likes = 10, retweets =
	 *         50), Tweet(message = "And another one!!", likes = 30, retweets = 80),
	 *         Tweet(message = "Last one", likes = 100, retweets = 5), ]
	 * 
	 *         countTweetsWithMoreLikes() should return 1
	 */
	public int countTweetsWithMoreLikes() {
		// TODO To be completed
		int co = 0;
		for (int i = 0; i < tweets.length; i++) {
			//search for tweets with more likes than retweets
			if (tweets[i].getLikes() > tweets[i].getRetweets()) {
				co++;
			}
		}
		return co;
	}

	/**
	 * (5 marks)
	 * 
	 * @param h - the handle to compare against
	 * @return The FIRST user object which contains the same handle as the passed
	 *         parameter 'h'
	 * 
	 *         e.g. If the users array contained the following: users = [
	 *         User(handle = "@bobbyz"),
	 *         User(handle = "@xX360NoScopeXx"),
	 *         User(handle = "@MQOfficial"),
	 *         User(handle = "@bigcompany"), ]
	 * 
	 *         findUserWithHandle("@bobbyz") should return the first object from the
	 *         users array findUserWithHandle("bobbyz) should return null
	 *         findUserWithHandle("") should return null findUserWithHandle(null)
	 *         should return null findUserWithHandle("@MQOfficial") should return
	 *         the 4th object from the users array
	 * 
	 *         Note: String comparisons should be performed using .equals()
	 */
	public User findUserWithHandle(String h) {
		// TODO To be completed
		//check for null of empty
		if ( h ==null ||h.equals("") ) {
			return null;
		}
		for (int i = 0; i < users.length; i++) {
			//comparing the handle and h of users
			if (users[i].getHandle().equals(h)) {
				return users[i];
			}
		}
		return null;
	}

	/**
	 * (7 marks)
	 * 
	 * @param u - the user to remove from the Timeline
	 * 
	 *          Given a User object, remove all instances of this user from the
	 *          'users' array by setting the relevant positions to null. All Tweets
	 *          which were made by this user should also be removed from the
	 *          'tweets' array by setting the relevant entry to null
	 * 
	 *          e.g. If the following User object was passed to the function and the
	 *          users and tweets array contained the following: u = User(handle =
	 *          "@bobbyz") users = [ User(handle = "@bobbyz"), User(handle =
	 *          "@xX360NoScopeXx"), User(handle = "@MQOfficial"), User(handle =
	 *          "@bigcompany"), ] tweets = [ Tweet(User(handle = "@bobbyz"), message
	 *          = "This is bobbyz tweet!!!"), Tweet(User(handle = "@MQOfficial"),
	 *          message = "Please study hard"), Tweet(User(handle =
	 *          "xX360NoScopeXx"), message = "get rekt"), Tweet(User(handke =
	 *          "@bobbyz"), message = "Another message from bobbyz"), ]
	 * 
	 *          then the users array and tweets array should become: users = [ null,
	 *          User(handle = "@xX360NoScopeXx"), User(handle = "@MQOfficial"),
	 *          User(handle = "@bigcompany"), ] tweets = [ null Tweet(User(handle =
	 *          "@MQOfficial"), message = "Please study hard"), Tweet(User(handle =
	 *          "xX360NoScopeXx"), message = "get rekt"), null ]
	 * 
	 *          Note: Object comparisons should be performed using .equals()
	 * 
	 */
	public void removeFromTimeline(User u) {
		// TODO To be completed
		//tried inclusive
		for (int j=0; j<tweets.length ; j++) {
			//find the tweets of the u
			if(tweets[j].getUser().getHandle().equals(u.getHandle())) {
				tweets[j] = null;
			}
		}
		for (int i = 0; i < users.length; i++) {
			//find the user by comparing the handles
			if (users[i].getHandle().equals(u.getHandle())) {
			
				users[i] = null;
			}	
			
		}
		
	}

	/**
	 * (5 marks)
	 * 
	 * @param u - the user to remove from the Timeline
	 * 
	 *          Given a User object, remove all instances of this user from the
	 *          'users' array by by removing the relevant instance. All Tweets which
	 *          were made by this user should also be removed from the 'tweets'
	 *          array by removing the entry
	 * 
	 *          e.g. If the following User object was passed to the function and the
	 *          users and tweets array contained the following: u = User(handle =
	 *          "@bobbyz") users = [ User(handle = "@bobbyz"), User(handle =
	 *          "@xX360NoScopeXx"), User(handle = "@MQOfficial"), User(handle =
	 *          "@bigcompany"), ] tweets = [ Tweet(User(handle = "@bobbyz"), message
	 *          = "This is bobbyz tweet!!!"), Tweet(User(handle = "@MQOfficial"),
	 *          message = "Please study hard"), Tweet(User(handle =
	 *          "xX360NoScopeXx"), message = "get rekt"), Tweet(User(handke =
	 *          "@bobbyz"), message = "Another message from bobbyz"), ]
	 * 
	 *          then the users array and tweets array should become: users = [
	 *          User(handle = "@xX360NoScopeXx"), User(handle = "@MQOfficial"),
	 *          User(handle = "@bigcompany"), ] tweets = [ Tweet(User(handle =
	 *          "@MQOfficial"), message = "Please study hard"), Tweet(User(handle =
	 *          "xX360NoScopeXx"), message = "get rekt"), ]
	 * 
	 *          Note: there are no nulls in the above users and tweets array - the
	 *          size of the array has been reduced and the relevant entry removed
	 *          completely.
	 */
	public void removeFromTimelineAdvanced(User u) {
		// TODO To be completed
		int counter = 0;
		int counter2 = 0;
		// counting the number of users that should be removed
		for (int i = 0; i < users.length; i++) {
			// search for users with equal handle
			if (!users[i].getHandle().equals(u.getHandle())) {
				counter++;

			}
		}
		User[] users2 = new User[counter];
		for (int i = 0; i < counter; i++) {
			// check the user
			if (!users[i].equals(u))
				users2[counter2] = users[i];
			//check the index 
			if(counter2+1 != counter)
			counter2++;
		}
		this.users = users2;
		int counter3 = tweets.length;
		int counter4 = 0;
		for (int i = 0; i < tweets.length; i++) {
			//comparing the users of tweets
			if (!tweets[i].getUser().equals(u)) {
				counter3++;

			}
		}
		Tweet[] tweets2 = new Tweet[counter3];
		for (int i = 0; i < counter3; i++) {
			if (!tweets[i].getUser().equals(u))
				tweets2[counter4] = tweets[i];
			//cheCking the index
			if(counter4+1 != counter3)
			counter4++;
		}
		this.tweets = tweets2;
	}

	/**
	 * (8 marks) search for term in tweets
	 * 
	 * @param phrase - the phrase to look for
	 * @return An array of Tweet objects with all Tweet objects whose message
	 *         contains a given phrase
	 * 
	 *         e.g. If the tweets array contained the following objects: tweets = [
	 *         Tweet(message = "I am running out of ideas on what to write"),
	 *         Tweet(message = "and on this day xyz happened"), Tweet(message =
	 *         "random message"), Tweet(message = "okay"), Tweet(message = "on"), ]
	 * 
	 *         searchTweets("on") should return: [ Tweet(message = "I am running out
	 *         of ideas on what to write"), Tweet(message = "and on this day xyz
	 *         happened"), Tweet(message = "on"), ]
	 * 
	 *         searchTweets("on ") should return: [ Tweet(message = "I am running
	 *         out of ideas on what to write"), Tweet(message = "and on this day xyz
	 *         happened"), ]
	 * 
	 *         searchTweets("this doesn't exist") should return: [ ] Note: this is
	 *         an empty array not a null array
	 * 
	 */
	public Tweet[] searchTweets(String phrase) {
		// TODO To be completed
		int counter = 0;
		int counter2 = 0;
		for (int i = 0; i < tweets.length; i++) {
			//counting the number of tweets
			if (tweets[i].getMessage().contains(phrase)) {
				counter++;
			}
		}
		Tweet[] tweets3 = new Tweet[0];
		Tweet[] tweets2 = new Tweet[counter];
		if (phrase == "this doesn't exist") {
			return tweets3;
		}
		for (int i = 0; i < tweets.length; i++) {
			//finding the tweets
			if (tweets[i].getMessage().contains(phrase)) {
				tweets2[counter2] = tweets[i];
				if (counter2 + 1 != counter) {
					counter2++;
				}
			}

		}

		return tweets2;
	}

	/**
	 * (5 marks) All tweets which have bad words
	 * 
	 * @return An array of Tweet objects whose message contains any bad words. A bad
	 *         word is considered any word contained in the bannedWords array of the
	 *         tweet object. An empty array should be returned if no bad tweets were
	 *         found.
	 * 
	 *         e.g. If tweets contained the following messages tweets = [
	 *         Tweet(message = "Wow that match was so ez"), Tweet(message = "This is
	 *         a nice message"), Tweet(message = "what a noob"), Tweet(message =
	 *         "This is another nice message :)"), Tweet(message = ""), ]
	 * 
	 *         getBadTweets() should return: [ Tweet(message = "Wow that match was
	 *         so ez"), Tweet(message = "what a noob"), ]
	 * 
	 *         Note: you shouldn't hard code the words that are checked against e.g.
	 *         .equals("noob)", instead you should use the array provided in the
	 *         Tweet object
	 * 
	 */
	public Tweet[] getBadTweets() {
		// TODO To be completed
		int counter = 0;
		boolean bool = true;
		int counter2 = 0;
		for (int i = 0; i < tweets.length; i++) {
			bool = true;
			for (int k = 0; k < Tweet.bannedWords.length; k++) {
				// searching for banned words in tweets
				if (tweets[i].getMessage().contains(Tweet.bannedWords[k]) && bool) {
					counter2++;
					bool = false;
				}
				}}
		Tweet tweetss[] = new Tweet[counter2];
		for (int i = 0; i < tweets.length; i++) {
			bool = true;
			for (int k = 0; k < Tweet.bannedWords.length; k++) {
				if (tweets[i].getMessage().contains(Tweet.bannedWords[k]) && bool) {
					
					tweetss[counter] = tweets[i];
					bool = false;
					if (counter + 1 != counter2)
						counter++;
					

				}
			}
		}

		return tweetss;

	}

	/**
	 * (5 marks)
	 * 
	 * @return the Tweet object whose message contained the most spaces.
	 * 
	 *         e.g. If tweets contained the following messages: tweets = [
	 *         Tweet(message = "Wow that match was so ez"), Tweet(message = "This is
	 *         a nice message"), Tweet(message = "what a noob"), Tweet(message =
	 *         "This is another nice message :)"), Tweet(message = "This is going to
	 *         be a message which has a lot of spaces! ! ! !"), ]
	 * 
	 *         tweetWithMostSpaces() should return: Tweet(message = "This is going
	 *         to be a message which has a lot of spaces! ! ! !"),
	 * 
	 */
	public Tweet tweetWithMostSpaces() {
		// TODO To be completed
		int max = 0;
		int indexOfTweet = 0;
		int[] tweetsSpaceCountArr = new int[tweets.length];
		for (int i = 0; i < tweets.length; i++) {
			for (int j = 0; j < tweets[i].getMessage().length(); j++)
				//counting the number of spaces in each tweets
				if (tweets[i].getMessage().substring(j).equals(" ")) {
					tweetsSpaceCountArr[i]++;

				}

		}
//// an array of the numbers of spaces in each tweets has been created and the 
//		number of indexes is the same as well. the loop below is a max search
		for (int i = 0; i < tweetsSpaceCountArr.length; i++) {
			if (tweetsSpaceCountArr[i] > max) {
				max = tweetsSpaceCountArr[i];
				indexOfTweet = i;
			}
		}
		return tweets[indexOfTweet];
	}

	/**
	 * (5 marks)
	 * 
	 * @param t - the tweet object to check
	 * @return A string array of all the hashtags contained in the Tweet object t
	 * 
	 *         e.g. if t = Tweet( message = "Wow what a #great #day at uni #today",
	 *         replies = ["Sounds like an #amazing #day", "#what"] )
	 *         getAllHashtags(t) should return ["#great", "#day", "#today",
	 *         "#amazing", "#day", "#what"]
	 * 
	 *         Note: All occurrences of a hashtag should be returned. In the above
	 *         example #day occurs twice. If there are no hashtags found, an empty
	 *         String array should be returned.
	 */
	public String[] getAllHashtags(Tweet t) {
		// TODO To be completed
		int hashinx = 0;
		int spaceinx = 0;
		int counter =0;
		int counter2 =0;
		for (int i = 0; i < t.getMessage().length(); i++) {
			//finding the number of #
			if (t.getMessage().substring(i).equals("#"))
			counter++;
		}
		String[] hashtags= new String[counter];
		for (int i = 0; i < t.getMessage().length(); i++) {
			if (t.getMessage().substring(i).equals("#")) {
				hashinx = i;
				for (int j = hashinx; j < t.getMessage().length(); j++) {
					if (t.getMessage().substring(j).equals(" ")) {
						spaceinx = j;
						// this break here is because i just want the space next to the #
//						not the last space in string
						break;
					}
				}
				hashtags[counter2] = t.getMessage().substring(hashinx,spaceinx-1);
				if (counter2+1 != counter) {
					counter2++;
				}
			}

		}

		return hashtags;
	}

}
