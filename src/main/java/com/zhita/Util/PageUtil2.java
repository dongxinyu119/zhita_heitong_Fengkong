package com.zhita.Util;

/**
 * 分页工具类.泛型类lhq
 */
public class PageUtil2{
    private int page;      //当前页

    private int pageSize=10;     //每页显示的数量

    private int totalCount;     //总记录数
    
    private int totalPageCount;      //总页数


    /**
     * 通过构造函数，传入总记录数,每页显示的数量和当前页
     * @param pageNow
     * @param totalCount
     */
    public PageUtil2(int page,int pagesize,int totalCount) {
        this.page=page;
        this.pageSize=pagesize;
        this.totalCount = totalCount;
    }
    
    public PageUtil2(int page,int totalCount) {
        this.page=page;
        this.totalCount = totalCount;
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
    
    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    //获取总页数
    public int getTotalPageCount() {
	     if(this.getTotalCount()%this.getPageSize()==0) {
	    	 this.totalPageCount=this.getTotalCount()/this.getPageSize();
	     }else {
	    	 this.totalPageCount=this.getTotalCount()/this.getPageSize()+1;
	     }
	     	return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }
    
}
