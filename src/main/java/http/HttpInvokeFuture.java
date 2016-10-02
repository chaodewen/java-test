package http;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.ning.http.client.Response;

public class HttpInvokeFuture implements Future<Response> {
	Future<Response> future;
	public HttpInvokeFuture(Future<Response> future) {
		super();
		this.future = future;
	}
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return this.future.cancel(mayInterruptIfRunning);
	}
	@Override
	public boolean isCancelled() {
		return this.future.isCancelled();
	}
	@Override
	public boolean isDone() {
		return this.future.isDone();
	}
	@Override
	public Response get() {
		try {
			return this.get(30000, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Response get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return this.future.get(timeout, unit);
	}
}
