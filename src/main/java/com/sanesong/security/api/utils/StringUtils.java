package com.sanesong.security.api.utils;

import java.util.Base64;
import java.util.Random;

public class StringUtils {

	//final static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String toBase64(final byte[] bytes) {
		return Base64.getEncoder().encodeToString(bytes);
	}
	
	public static String random(final int length) {
		final Random random = new Random();
		return String.format("%0" + length + "x", random.nextLong());
	}
}
