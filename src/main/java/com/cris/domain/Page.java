package com.cris.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 封装分页查询的一些参数
 */
public class Page<T> implements Serializable {
    private int page;        //要查询第几页
    private int pageSize;    //每页条数
    private int totalPage;   //总共几页
    private int totalNum;    //数据库记录总条数
    private List<T> list;    //查询到的该页数据
    private int id;          //用于查询的标识id
    private int index;       //用于limit分页查询的索引
    private List<Integer> pages;       //返回页面的页数选项，如：12345

    public Page(int page, int pageSize, int id) {
        this.page = page;
        this.pageSize = pageSize;
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalNum=" + totalNum +
                ", list=" + list +
                ", id=" + id +
                ", index=" + index +
                ", pages=" + pages +
                '}';
    }
}
