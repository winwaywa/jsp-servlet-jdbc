package com.blog.paging;

import com.blog.sorter.Sorter;

public interface Pageble {
	 Integer getPage();
	 Integer getOffset();
	 Integer getLimit();
	 Sorter getSorter();
}
