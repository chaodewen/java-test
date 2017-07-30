package concurrent;

public class RunnableTest implements Runnable {
	private String text;
	RunnableTest(String text) {
		this.text = text;
	}
	@Override
	public void run() {
		int num = 0;
		for(int i = 0; i < 100; i ++) {
			System.out.println(text + ":" + i);
		}
		System.out.println("num : " + ++ num);
	}
	public static void main(String[] args) {
//		RunnableTest rt1 = new RunnableTest("A");
//		RunnableTest rt2 = new RunnableTest("B");
//		Thread t1 = new Thread(rt1);
//		Thread t2 = new Thread(rt2);
//		t1.start();
//		t2.start();
//		for(int i = 0; i < 3; i ++) {
//			new Thread(new RunnableTest((char)('A' + i))).start();
//		}

		RunnableTest rt = new RunnableTest("t");
		for(int i = 0; i < 3; i ++)
			new Thread(rt).start();
    }
}
