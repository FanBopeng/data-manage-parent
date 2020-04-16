package com.read.write.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageHelperEntity<T> {
    /**
     * 返回的数据列表
     */
    private List<T> dataList ;
    /**
     * 总记录数
     */
    private int total;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 是否有上一页
     */
    private boolean hasPrevPage;
    /**
     * 上一页
     */
    private int prevPage ;
    /**
     * 是否有下一页
     */
    private boolean hasNextPage;
    /**
     * 下一页
     */
    private int nextPage ;
    /**
     * 当前页前后三页
     */
    private List<Integer> pageList ;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isHasPrevPage() {
        //如果前面页不是第一页，说明有上一页
        hasPrevPage = currentPage != 1;
        return hasPrevPage;
    }

    public void setHasPrevPage(boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }

    public boolean isHasNextPage() {
        //如果当前页不是最后一页，说明有下一页
        hasNextPage = currentPage != totalPage;
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getPrevPage() {
        return prevPage;
    }

    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public List<Integer> getPageList() {
        return pageList;
    }

    public void setPageList(List<Integer> pageList) {
        this.pageList = pageList;
    }

    /**
     * 判断初始化
     */
    public void initjudge(){
        hasPrevPage = isHasPrevPage();
        hasNextPage = isHasNextPage();
    }

    /**
     * 总页数
     */
    public static int countTotalPage (int pageSize,int total){
        int totalPage = total%pageSize==0 ? total/pageSize : total/pageSize+1 ;
        return totalPage ;
    }

    /**
     * 偏移量：分页开始位置
     */
    public static int countOffset (int pageSize,int currentPage){
        int offset = pageSize*(currentPage-1) ;
        return offset ;
    }

    /**
     * 分页遍历列表
     */
    public static List<Integer> pageList (int currentPage,int pageSize,int total){
        List<Integer> pageList = new ArrayList<>() ;
        int totalPage = countTotalPage(pageSize,total) ;
        int prevPage = currentPage ;
        int nextPage = currentPage ;
        // 向前推三页
        if (totalPage>1) {
            for (int i = 1; i <= 3; i++) {
                prevPage = prevPage - 1;
                if (prevPage<1){
                    break;
                }
                pageList.add(prevPage);
            }
        }
        // 向后推三页
        if (totalPage>1) {
            for (int j = 1; j <= 3; j++) {
                nextPage = nextPage + 1;
                if (nextPage>totalPage){
                    break;
                }
                pageList.add(nextPage);
            }
        }
        pageList.add(currentPage) ;
        // 排序
        Collections.sort(pageList);
        return pageList ;
    }

    public static void main(String[] args) {
        List<Integer> list = pageList(12,10,121) ;
        System.out.println(list);
    }
}