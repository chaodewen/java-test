package regex;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class RegexTest {
	public static boolean testRegex(String regex) {
//		return regex.matches("(/|(/([\\w-?%&=]+))+)(/<[a-zA-Z][\\w]+:[\\w-?%&=]+>)*/?");
//		return regex.matches("(/|(/([\\w-?%&=]+))+)/?");
//		return regex.matches("([\\w]|[\\u2E80-\\uFE4F]){5,16}");
//		return regex.matches("http://[^\\s]+");
//		return regex.matches("^(/([^/]+))+$");
		return regex.matches(".*");
	}
	public static void main(String[] args) {
		//http://img04.store.sogou.com/net/a/46/link?appid=46&url=http://c2.hoopchina.com.cn/uploads/star/event/images/160506/92846ec1cc76c928ded6ccfb6e19eb2b92952855.jpg)
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		while(in.hasNext()) {
			String input = in.next();
//			System.out.println(input + ":" + testRegex(input));
			System.out.println(testRegex(input));
		}
		in.close();
	}
}