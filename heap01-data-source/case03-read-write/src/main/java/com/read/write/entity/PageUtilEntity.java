package com.read.write.entity;

import java.util.List;

public class PageUtilEntity {

    /**
     * 分页生成方法
     */
    public static PageHelperEntity<Object> pageResult (int total, int pageSize,int currentPage, List dataList){
        PageHelperEntity<Object> pageBean = new PageHelperEntity<Object>();
        // 总页数
        int totalPage = PageHelperEntity.countTotalPage(pageSize,total) ;
        // 分页列表
        List<Integer> pageList = PageHelperEntity.pageList(currentPage,pageSize,total) ;
        // 上一页
        int prevPage = 0 ;
        if (currentPage==1){
            prevPage = currentPage ;
        } else if (currentPage>1&&currentPage<=totalPage){
            prevPage = currentPage -1 ;
        }
        // 下一页
        int nextPage =0 ;
        if (totalPage==1){
            nextPage = currentPage ;
        } else if (currentPage<=totalPage-1){
            nextPage = currentPage+1 ;
        }
        pageBean.setDataList(dataList);
        pageBean.setTotal(total);
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);
        pageBean.setPageList(pageList);
        pageBean.setPrevPage(prevPage);
        pageBean.setNextPage(nextPage);
        pageBean.initjudge();
        return  pageBean ;
    }

}
