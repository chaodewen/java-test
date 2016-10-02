package parampassing;

public class Main {
	public static void main(String[] args) {
		A a = new A(3);
		B.setX(a, 4);
		System.out.println(a.x);
	}
}