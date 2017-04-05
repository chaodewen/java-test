package string;

@SuppressWarnings("unused")
public class StringTest {
	public static void main(String[] args) {
//		testSimpleMethod();
		testSplit();
	}
	public static void testSimpleMethod() {
		StringBuilder sb = new StringBuilder();
		sb.reverse().toString();
		String str = "test";
		str.equalsIgnoreCase("TEst");
		str.contains(".");
		System.out.println("abc".compareTo("cde"));
	}
	public static void testSplit() {
		String str = "%^&%a BC_( *{:b cA (";

		for(String s : str.split("[^a-zA-Z]"))
			System.out.print(s + " ");
		System.out.println();

		String str2 = "boo:and:foo";

		for(String s : str2.split("o"))
			System.out.print(s + " ");
		System.out.println();

		System.out.println(str.trim());
	}
	public static void testStringBuilder() {
		StringBuilder sb = new StringBuilder();
		System.out.println(sb.length());
	}
}