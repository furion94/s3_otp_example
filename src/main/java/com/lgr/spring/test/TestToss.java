package com.lgr.spring.test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.lgr.spring.dto.TossAPI;

public class TestToss {
	public static void main(String[] args) throws ParseException {
		TossAPI toss = new TossAPI();
		String reponse = toss.doToss();
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(reponse);
		JSONObject json = (JSONObject)obj;
		System.out.println(json.get("code"));
		System.out.println(json.get("checkoutPage"));
	}
}

/*{
 * "code":0,
 * "status":200,
 * "payToken":"wKZ1uRg1VGnT0ZZ7Rpdj43",
 * "checkoutPage":"https://pay.toss.im/payfront/auth?payToken=wKZ1uRg1VGnT0ZZ7Rpdj43",
 * "checkoutAppScheme":"supertoss://pay?payToken=wKZ1uRg1VGnT0ZZ7Rpdj43"
 * }
 */

