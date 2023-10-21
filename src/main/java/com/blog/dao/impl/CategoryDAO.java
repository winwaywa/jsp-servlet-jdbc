package com.blog.dao.impl;

import java.util.List;

import com.blog.dao.ICategoryDAO;
import com.blog.mapper.CategoryMapper;
import com.blog.mapper.RowMapper;
import com.blog.model.CategoryModel;
import com.blog.paging.Pageble;

public class CategoryDAO extends BaseDAO<CategoryModel> implements ICategoryDAO {

	private RowMapper<CategoryModel> rowMapper;

	public CategoryDAO() {
		rowMapper = new CategoryMapper();
	}

	@Override
	public List<CategoryModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from category ");
		if (pageble.getSorter().getSortName() != null && pageble.getSorter().getSortValue() != null) {
			sql.append(
					"order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortValue() + " ");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append("limit " + pageble.getOffset() + "," + pageble.getLimit());
		}
		return query(sql.toString(), rowMapper);
	}

	@Override
	public CategoryModel findOne(Long categoryId) {
		String sql = "select * from category where id = ?";
		List<CategoryModel> categories = query(sql, rowMapper, categoryId);
		return !categories.isEmpty() ? categories.get(0) : null;
	}

	@Override
	public Long save(CategoryModel categoryModel) {
		String sql = "insert into category(code, name, createdAt, createdBy, updatedAt, updatedBy) values(?,?,?,?,?,?)";
		return insert(sql, categoryModel.getCode(), categoryModel.getName(), categoryModel.getCreatedAt(),
				categoryModel.getCreatedBy(), categoryModel.getUpdatedAt(), categoryModel.getUpdatedBy());
	}

	@Override
	public boolean update(CategoryModel categoryModel) {
		StringBuilder sql = new StringBuilder();
		sql.append("update category ");
		sql.append("set code=?, name=?, updatedAt= ?, updatedBy = ? ");
		sql.append("where id=?");
		return update(sql.toString(), categoryModel.getCode(), categoryModel.getName(), categoryModel.getUpdatedAt(),
				categoryModel.getUpdatedBy(), categoryModel.getId());
	}

	@Override
	public boolean delete(long id) {
		String sql = "delete from category where id = ?";
		return delete(sql, id);
	}

	@Override
	public int count() {
		String sql = "select count(*) from category";
		return count(sql);
	}

}
