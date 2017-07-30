package concurrent;

import java.util.concurrent.*;

public class ExecutorTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		ExecutorService executor = Executors.newFixedThreadPool(10);
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("task over");
//			}
//		};
//		executor.execute(runnable);
//		executor = Executors.newScheduledThreadPool(10);
//		ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;
//		scheduler.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.SECONDS);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future runnableFuture = executorService.submit(new RunnableTest("Runnable"));
        Future callableFuture = executorService.submit(new CallableTest("Callable"));

        Object r = runnableFuture.get();
        Object c = callableFuture.get();

        System.out.println("Runnable Future : " + r);
        System.out.println("Callable Future : " + c);

        executorService.shutdown();
	}
}
