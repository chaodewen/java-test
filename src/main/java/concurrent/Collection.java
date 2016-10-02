package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unused")
public class Collection {
	public static void main(String[] args) {
		Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
	}
}