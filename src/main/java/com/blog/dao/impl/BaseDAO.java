package com.blog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.blog.dao.GenericDAO;
import com.blog.mapper.RowMapper;

/**
 * Base logic JDBC (connect DB, select, insert, update, delete)
 * 
 * @author Hiep Nguyen
 * @param <T>
 */
public class BaseDAO<T> implements GenericDAO<T> {
	
	// load to /src/main/resources/db.properties
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
//			String url = "jdbc:mysql://localhost:3306/shopDB";
//			String user = "root";
//			String password = "admin";
//			Class.forName("com.mysql.jdbc.Driver");
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			Class.forName(resourceBundle.getString("driverName"));
			
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				int parameterIndex = i + 1;
				Object parameter = parameters[i];
				if (parameter instanceof Integer) {
					statement.setInt(parameterIndex, (int) parameter);
				} else if (parameter instanceof Long) {
					statement.setLong(parameterIndex, (Long) parameter);
				} else if (parameter instanceof Double) {
					statement.setDouble(parameterIndex, (Double) parameter);
				} else if (parameter instanceof String) {
					statement.setString(parameterIndex, (String) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(parameterIndex, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

	@Override
	public Long insert(String sql, Object... parameters) {
		Long id = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				// return key of added row
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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

	@Override
	public boolean update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
			return true;
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
			}
		}
		return false;
	}

	@Override
	public boolean delete(String sql, long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, id);
			statement.executeUpdate();
			connection.commit();
			return true;
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
			}
		}
		return false;
	}

	@Override
	public int count(String sql) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			connection.commit();
		} catch (SQLException e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
			}
		}
		return count;
	}

}
