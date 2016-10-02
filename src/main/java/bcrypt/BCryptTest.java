package bcrypt;

public class BCryptTest {
	public static String hash(String password) {
		String salt = BCrypt.gensalt(12);
		System.out.println(salt);
		return BCrypt.hashpw(password, salt);
	}
	public static void main(String[] args) {
		System.out.println(hash("12345"));
		System.out.println(BCrypt.hashpw("12345", "$2a$12$wHXJKxLm4MsHW.7ymgh8lO"));
		System.out.println(BCrypt.checkpw("12345", "$2a$12$eL4z4mI9QIpdD2eeIWph3eR5HFPig0pIX.5nAHIZhgx38ZvgQAi0O"));
	}
}