package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(10);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("task over");
			}
		};
		executor.execute(runnable);
		executor = Executors.newScheduledThreadPool(10);
		ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;
		scheduler.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);
	}
}
