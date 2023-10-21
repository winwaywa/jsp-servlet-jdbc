package com.blog.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

// using package jackson.databind
public class ApiToModelUtil {

	private String value;

	public ApiToModelUtil(String value) {
		this.value = value;
	}
	
	public static ApiToModelUtil convertToString(BufferedReader br) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
		}

		return new ApiToModelUtil(sb.toString());
	}
	
	public <T> T bindToModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
