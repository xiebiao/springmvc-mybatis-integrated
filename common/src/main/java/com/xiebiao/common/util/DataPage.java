package com.xiebiao.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页封装
 * 
 * @author xiaog(joyrap@gmail.com)
 * @date Apr 19, 2012 10:32:40 PM
 * @param <E>
 */
public final class DataPage<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1L;
	private final static int MAX_PAGE_SIZE = 50;
	private int totalRecord;
	private int totalPage;
	private int pageSize = 20;
	private int pageIndex;
	private int startRecord;

	public DataPage(int totalRecord, int pageIndex, int pageSize) {
		this.totalRecord = totalRecord;
		this.pageIndex = pageIndex == 0 ? 1 : pageIndex;
		this.pageSize = pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;
		int remainder = this.totalRecord % this.pageSize;
		int totalPage = this.totalRecord / this.pageSize;
		this.totalPage = remainder == 0 ? totalPage : totalPage + 1;

	}

	public int getStartRecord() {
		this.startRecord = (this.pageIndex - 1) * pageSize;
		return this.startRecord;
	}

	public int getEndRecord() {

		return this.pageSize;
	}

	public void addAll(List<E> list) {
		super.addAll(list);
	}

	public boolean hasForwardPage() {
		if (pageIndex <= 1) {
			return false;
		}
		return true;
	}

	public boolean hasNextPage() {
		if (pageIndex >= totalPage) {
			return false;
		}
		return true;
	}

	public int getNextPage() {
		int nextPage = this.pageIndex + 1;
		return nextPage = nextPage > this.totalPage ? this.totalPage : nextPage;
	}

	public int getForwardPage() {
		int forwardPage = this.pageIndex - 1;
		return forwardPage <= 0 ? 1 : forwardPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("nextPage=" + this.getNextPage() + ",dataSize=" + this.size()
				+ ",totalPage=" + this.totalPage + ",totalRecord="
				+ this.totalRecord + ",pageIndex=" + this.pageIndex
				+ ",pageSize=" + this.pageSize);
		return sb.toString();
	}
}
