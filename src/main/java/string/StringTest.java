package string;

@SuppressWarnings("unused")
public class StringTest {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.reverse().toString();
		String str = "test";
		str.equalsIgnoreCase("TEst");
		str.contains(".");
	}
}