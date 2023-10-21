package com.blog.sorter;

public class Sorter {
	private String sortName;
	private String sortValue;

	public Sorter(String sortName, String sortValue) {
		this.setSortName(sortName);
		this.setSortValue(sortValue);
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortValue() {
		return sortValue;
	}

	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}
}
