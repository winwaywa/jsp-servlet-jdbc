package com.blog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.GenericDAO;
import com.blog.mapper.RowMapper;
import com.blog.model.NewsModel;

public class BaseDAO<T> implements GenericDAO<T> {
	
	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/shopDB";
			String user = "root";
			String password = "admin";
			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public List<T> query(String sql, RowMapper<T> rowMapper, Object ...parameters) {
		List<T> result = new ArrayList<>();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// open connection
		Connection connection = getConnection();
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				setParameter(statement, parameters);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					result.add(rowMapper.mapRow(resultSet));
				}
				return result;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return null;
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
		for(int i = 0; i < parameters.length ; i++) {
			int parameterIndex = i+1;
			Object parameter = parameters[i];
				if (parameter instanceof Integer) {
					statement.setInt(parameterIndex, (int) parameter);
				}else if (parameter instanceof Long) {
					statement.setLong(parameterIndex, (Long) parameter);
				}else if (parameter instanceof String) {
					statement.setString(parameterIndex, (String) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
