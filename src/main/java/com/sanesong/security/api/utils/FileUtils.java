package com.sanesong.security.api.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUtils {

	public static byte[] readBytes(final String url) throws IOException {
		final URL httpUrl = new URL(url);
		
		final HttpURLConnection connection = (HttpURLConnection)httpUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(30 * 1000);
		
		final InputStream is = connection.getInputStream();
		try {
			return readBytes(connection.getInputStream());
		} finally {
			is.close();
		}
	}

	public static byte[] readBytes(final InputStream is) throws IOException {
		final ByteArrayOutputStream os = new ByteArrayOutputStream();
		final byte[] buffer = new byte[1024];
		
		int len = 0;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		
		return os.toByteArray();
	}
}
