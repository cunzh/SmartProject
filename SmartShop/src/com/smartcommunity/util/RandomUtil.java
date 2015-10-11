package com.smartcommunity.util;

import java.util.Random;

public class RandomUtil {

	public static final String characters = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJILMNOPQRSTUVWXYZ";
	public static final String numberString = "0123456789";

	public static String getRandomString(int length) {
		if (length <= 0) {
			length = 6;
		}
		   Random random = new Random();     
		   StringBuilder stringBuilder = new StringBuilder();   
		    for (int i = 0; i < length; i++) {     
		        int number = random.nextInt(characters.length());     
		        stringBuilder.append(characters.charAt(number));

		    }     
		    return stringBuilder.toString();
	}
	public static String getRandomNumber() {
		return getRandomNumber(10);
	}
	/** 可能会出现重复 */
	public static String getRandomNumber(int length) {
		if (length <= 0) {
			length = 10;
		}
		   Random random = new Random();     
		   StringBuilder stringBuilder = new StringBuilder();   
		    for (int i = 0; i < length; i++) {     
		        int number = random.nextInt(numberString.length());     
		        stringBuilder.append(numberString.charAt(number));

		    }     
		    return stringBuilder.toString();
	}
}
