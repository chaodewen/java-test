package http;

import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;

public class AsyncClientHttpExchange {
    public static void main(String[] args) throws Exception {
    	CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
        try {
        	httpclient.start();
        	HttpGet request = new HttpGet("http://www.kuaidi100.com/autonumber/autoComNum?text=200093247451");
        	Future<HttpResponse> future = httpclient.execute(request, new AsyncClientHttpExchangeFutureCallback());
        	HttpResponse response = future.get();// 获取结果
            System.out.println(response.toString());
        } finally {
            httpclient.close();
        }
    }
}
class AsyncClientHttpExchangeFutureCallback implements FutureCallback<HttpResponse> {
	HttpGet request = new HttpGet("http://www.kuaidi100.com/autonumber/autoComNum?text=200093247451");
	@Override
	public void completed(final HttpResponse response) {
		System.out.println("completed:" + request.getRequestLine() + "->" + response.getStatusLine());
	}
	@Override
	public void failed(final Exception ex) {
		System.out.println(request.getRequestLine() + "->" + ex);
	}
	@Override
	public void cancelled() {
		System.out.println(request.getRequestLine() + " cancelled");
	}
}