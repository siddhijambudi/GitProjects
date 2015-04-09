import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class JavaRestTweet {
	static String consumerKeyStr = "IHb4MXXbMOGExy89iF2IPO2lZ";
	static String consumerSecretStr = "bNYXqMxWHCm7lGtu8twTuF9Xssq9AO4p4rBmsb8YBBLl5lq3R8";
	static String accessTokenStr = "337385276-9n6GchOfSpYOeWsTOhIldKynhcJSJXM4Fz65Wj8F";
	static String accessTokenSecretStr = "lY832Hh19WTZrxQbnoe8R5HQT2lLb9wjQ9Tl5RnpcnQIj";


	public static void main(String[] args) throws Exception {
		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,
				consumerSecretStr);
		oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);

		HttpPost httpPost = new HttpPost(
				"https://api.twitter.com/1.1/statuses/update.json?status=Hello%20Twitter%20World.");

		oAuthConsumer.sign(httpPost);

		@SuppressWarnings("deprecation")
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = httpClient.execute(httpPost);

		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println(statusCode + ':'
				+ httpResponse.getStatusLine().getReasonPhrase());
		System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));

	}
}