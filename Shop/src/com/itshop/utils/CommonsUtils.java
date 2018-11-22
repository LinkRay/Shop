package com.itshop.utils;

import java.util.UUID;

public class CommonsUtils {
	//生成uid
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}
