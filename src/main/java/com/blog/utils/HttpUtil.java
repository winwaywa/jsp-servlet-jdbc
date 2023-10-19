package com.blog.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {

	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}
	
	public static HttpUtil convertToString(BufferedReader br) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
		}

		return new HttpUtil(sb.toString());
	}
	
	public <T> T bindToModel(Class<T> tClass) {
		try {
			// jackson.databind;
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
