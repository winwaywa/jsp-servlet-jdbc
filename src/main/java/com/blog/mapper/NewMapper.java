package com.blog.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.model.NewsModel;

public class NewMapper implements RowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel news = new NewsModel();
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setThumbnail(resultSet.getString("thumbnail"));
			news.setShortDescription(resultSet.getString("short_description"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("news_id"));
			news.setCreatedAt(resultSet.getTimestamp("createdAt"));
			news.setCreatedBy(resultSet.getString("createdBy"));
			news.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
			news.setUpdatedBy(resultSet.getString("updatedBy"));
			return news;
		} catch (SQLException e) {
			return null;
		}
	}
}
