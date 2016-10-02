package json;

import com.alibaba.fastjson.JSONObject;

public class JsonTest {
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		json.put("column", "last_price");
	}
}