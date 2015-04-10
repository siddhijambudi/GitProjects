import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class JavaReTweet {

	static String consumerKeyStr = "IHb4MXXbMOGExy89iF2IPO2lZ";
	static String consumerSecretStr = "bNYXqMxWHCm7lGtu8twTuF9Xssq9AO4p4rBmsb8YBBLl5lq3R8";
	static String accessTokenStr = "337385276-9n6GchOfSpYOeWsTOhIldKynhcJSJXM4Fz65Wj8F";
	static String accessTokenSecretStr = "lY832Hh19WTZrxQbnoe8R5HQT2lLb9wjQ9Tl5RnpcnQIj";

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