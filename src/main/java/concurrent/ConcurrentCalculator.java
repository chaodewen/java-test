package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentCalculator {
	private ExecutorService executorService;
	private CompletionService<Long> completionService;
	private int processorNum;
	class SumCalculator implements Callable<Long> {
		private int[] data;
		private int startIndex;
		private int endIndex;
		public SumCalculator(int[] data, int startIndex, int endIndex) {
			super();
			this.data = data;
			this.startIndex = startIndex;
			this.endIndex = endIndex;
		}
		@Override
		public Long call() throws Exception {
			Long sum = 0L;
			for(int i = startIndex; i <= endIndex; i ++) {
				sum += data[i];
			}
			System.out.println(Thread.currentThread().getName() + " : " + "data[" +startIndex 
					+ "---" + endIndex + "] = " + sum);
			return sum;
		}
	}
	public ConcurrentCalculator() {
		processorNum = Runtime.getRuntime().availableProcessors();
		executorService = Executors.newFixedThreadPool(processorNum);
		completionService = new ExecutorCompletionService<Long>(executorService);
		System.out.println("Available Processors Number : " + processorNum);
	}
	public Long sum(final int[] data) {
		// 根据线程数拆分任务，创建FutureTask并提交到Executor
		if(data.length <= processorNum) {
			SumCalculator sumCalculator = new SumCalculator(data, 0, data.length - 1);
			if(!executorService.isShutdown()) {
				completionService.submit(sumCalculator);
			}
		}
		else {
			int interval = data.length / processorNum + 1;
			for(int i = 0; i < processorNum; i ++) {
				int start = i * interval;
				int end = start + interval - 1;
				if(end >= data.length) {
					end = data.length - 1;
				}
				SumCalculator sumCalculator = new SumCalculator(data, start, end);
				if(!executorService.isShutdown()) {
					completionService.submit(sumCalculator);
				}
			}
		}
		return getResult();
	}
	// 迭代每个只任务，获得部分和，相加返回
	public Long getResult() {
		Long result = 0L;
		for(int i = 0; i < processorNum; i ++) {
			try {
				Long subSum = completionService.take().get();
				result += subSum;
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public void close() {
		executorService.shutdown();
	}
	public static void main(String[] args) {
		int data[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ConcurrentCalculator concurrentCalculator = new ConcurrentCalculator();
		System.out.println(concurrentCalculator.sum(data));
		concurrentCalculator.close();
	}
}