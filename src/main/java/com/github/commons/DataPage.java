package com.github.commons;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页封装
 * @author xiebiao
 * @param <E>
 */
public final class DataPage<E> extends ArrayList<E> {

    private static final long serialVersionUID = 1L;
    private final static int  MAX_PAGE_SIZE    = 50;
    private int               totalRecord;
    private int               totalPage;

    private int               pageSize         = 20;
    private int               index;

    /**
     * @param totalRecord 总记录数
     * @param pageIndex 当前页
     * @param pageSize 每页记录数
     */
    public DataPage(int totalRecord, int pageIndex, int pageSize) {
        this.totalRecord = totalRecord;
        this.index = pageIndex == 0 ? 1 : pageIndex;
        this.pageSize = pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;
        int remainder = this.totalRecord % this.pageSize;
        int totalPage = this.totalRecord / this.pageSize;
        this.totalPage = remainder == 0 ? totalPage : totalPage + 1;

    }

    public int getOffset() {
        return (this.index - 1) * pageSize;
    }

    public void addAll(List<E> list) {
        super.addAll(list);
    }

    /**
     * 获取下一页
     * @return
     */
    public int getNextPage() {
        return (this.index + 1) > this.totalPage ? this.totalPage : this.index + 1;
    }

    /**
     * 获取前一页
     * @return
     */
    public int getPreviousPage() {
        return (this.index - 1) <= 0 ? 1 : this.index - 1;
    }

    /**
     * 总页数
     * @return
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 每页记录数
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIndex() {
        return index;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nextPage=" + this.getNextPage() + ",dataSize=" + this.size() + ",totalPage=" + this.totalPage
                + ",totalRecord=" + this.totalRecord + ",pageIndex=" + this.index + ",pageSize=" + this.pageSize);
        return sb.toString();
    }
}
