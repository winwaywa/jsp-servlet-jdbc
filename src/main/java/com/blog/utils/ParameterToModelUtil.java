package com.blog.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class ParameterToModelUtil {

	// using package commons-beanutils
	@SuppressWarnings("unchecked")
	public static <T> T bindToModel(Class<T> tclass, HttpServletRequest req) {
		T object = null;
		try {
			object = tclass.newInstance();
			BeanUtils.populate(object, req.getParameterMap());
		} catch (IllegalAccessException | InstantiationException |InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;

	}
}
