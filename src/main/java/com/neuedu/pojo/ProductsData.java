package com.neuedu.pojo;

import java.util.List;

/**
 * 分页条
 * list集合放查询数据
 * page_number给出数据展示页面
 * page_Size给定每页存放的信息条数
 * max_page最大页数
 * max_count数据条数
 * url跳转页数地址
 * page_view拼接展示分页条
 */
public class ProductsData {
    private List<?> lists;
    private int pageNo;
    private int pageSize;
    private int maxPage;
    private int maxCount;
    private String url;
    private String pageView;


    public String getPageView(){
        return pageView;
    }

    public void setUrl(String url){
        this.url = url;
        StringBuffer strb = new StringBuffer();
        if (pageNo == 1){
            strb.append("<li class='page'><a href='javascript:void(0)'>首页</a></li>");
            strb.append("<li class='page'><a href='javascript:void(0)'>上一页</a></li>");
        }else {
            strb.append("<li class='page'><a href='" + url + "?pageNo=1'>首页</a></li>");
            strb.append("<li class='page'><a href='" + url + "?pageNo=" + (pageNo-1) + "'>上一页</a></li>");
        }

        for (int i = 1;i <= maxPage;i++){
            if (i == pageNo){
                strb.append("<li class='page'><a href='javascript:void(0)'>" + i +"</a></li>");
            }else {
                strb.append("<li class='page'><a href='" + url + "?pageNo=" + (i) + "'>" + i + "</a></li>");
            }
        }

        if (pageNo == maxPage){
            strb.append("<li class='page'><a href='javascript:void(0)'>下一页</a></li>");
            strb.append("<li class='page'><a href='javascript:void(0)'>尾页</a></li>");
        }else {
            strb.append("<li class='page'><a href='" + url + "?pageNo=" + (pageNo+1) + "'>下一页</a></li>");
            strb.append("<li class='page'><a href='" + url + "?pageNo=" + (maxPage) + "'>尾页</a></li>");
        }
        this.pageView = strb.toString();


    }






    public ProductsData(int pageNo, int pageSize, int maxCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.maxCount = maxCount;
        this.maxPage = (maxCount % pageSize) == 0 ? maxCount / pageSize : maxCount / pageSize + 1;
    }

    public List<?> getLists() {
        return lists;
    }

    public void setLists(List<?> lists) {
        this.lists = lists;
    }
}
