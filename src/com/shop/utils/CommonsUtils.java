package com.shop.utils;

import java.util.UUID;

public class CommonsUtils {

	//生成uuid方法
	public static String getID(){
		return UUID.randomUUID().toString();
	}
	
}
