package http;

import java.util.concurrent.Future;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Request;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.Response;

public class FutureClientTest {
	public static void main(String[] args) {
		AsyncHttpClient client = new AsyncHttpClient(
				new AsyncHttpClientConfig.Builder().setAcceptAnyCertificate(true).build());
		RequestBuilder builder = new RequestBuilder("GET");
		builder.setUrl("http://localhost:6666/myApp");
		builder.addQueryParam("a", "45");
		builder.addQueryParam("b", "30");
		Request request = builder.build();
		Future<Response> future = client.executeRequest(request);
		System.out.println(new HttpInvokeFuture(future).get().getStatusCode());
		client.close();
	}
}
