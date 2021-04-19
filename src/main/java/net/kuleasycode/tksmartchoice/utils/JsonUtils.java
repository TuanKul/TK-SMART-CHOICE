package net.kuleasycode.tksmartchoice.utils;

import com.google.gson.Gson;

public class JsonUtils {

	public static <T> String convertObjectToJsonLog(T object) {
		Gson builder = new Gson();
		return builder.toJson(object);
	}
}
