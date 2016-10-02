package concurrent;

public class ThreadTest extends Thread {
	private String text;
	ThreadTest(String text) {
		this.text = text;
	}
	public void run() {
		for(int i = 0; i < 100; i ++) {
			System.out.println(text + ":" + i);
		}
	}
	public static void main(String[] args) {
		ThreadTest tt1 = new ThreadTest("A");
		ThreadTest tt2 = new ThreadTest("B");
		tt1.start();
		tt2.start();
	}
}