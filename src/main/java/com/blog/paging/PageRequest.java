package com.blog.paging;

import com.blog.sorter.Sorter;

public class PageRequest implements Pageble {

	private Integer page;
	private Integer limit;
	Sorter sorter;
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.limit = maxPageItem;
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		return page;
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.limit != null) {
			return (this.page - 1) * this.limit;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return limit;
	}

	@Override
	public Sorter getSorter() {
		return sorter;
	}

}
