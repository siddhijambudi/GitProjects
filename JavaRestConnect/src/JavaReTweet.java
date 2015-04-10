import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class JavaReTweet {

	static String consumerKeyStr = "XXXX";
	static String consumerSecretStr = "XXXX";
	static String accessTokenStr = "XXXX";
	static String accessTokenSecretStr = "XXXXXX";

	public static void main(String[] args) {

		try {
			Twitter twitter = new TwitterFactory().getInstance();

			twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
			AccessToken accessToken = new AccessToken(accessTokenStr,
					accessTokenSecretStr);

			twitter.setOAuthAccessToken(accessToken);

			twitter.updateStatus("Post using Twitter4J Again");

			System.out.println("Successfully updated the status in Twitter.");
		} catch (TwitterException te) {
			te.printStackTrace();
		}
	}

}
