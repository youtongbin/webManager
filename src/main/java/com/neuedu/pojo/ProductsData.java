package com.neuedu.pojo;

import lombok.Data;

import java.util.List;

@Data
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

    public void setUrl(String url,String params){
        this.url = url;
        StringBuffer strb = new StringBuffer();
        if(pageNo==1){
            strb.append("<li class='page'><a href='javascript:void(0)"+params+"' >首页</a></li>");
            strb.append("<li class='page'><a href='javascript:void(0)"+params+"' >上一页</a></li>");
        }else{
            strb.append("<li class='page'><a href='"+url+"?pageNo=1"+params+"' >首页</a></li>");
            strb.append("<li class='page'><a href='"+url+"?pageNo="+(pageNo-1)+""+params+"'>上一页</a></li>");
        }

        int min = pageNo-2;

        if(min<=0){
            min=1;
            int max=min+4;
            if(max>maxPage){
                max=maxPage;
            }
            for(int i =min;i<=max;i++){
                if(i==pageNo){
                    strb.append("<li><a href='javascript:void(0)"+params+"' >"+i+"</a></li>");
                }else{
                    strb.append("<li><a href='"+url+"?pageNo="+i+""+params+"'>"+i+"</a></li>");
                }
            }
        }else{
            int max=min+4;
            if(max>maxPage){
                max=maxPage;
                min=max-4;
                if(min<=0){
                    min=1;
                }
            }
            for(int i =min;i<=max;i++){
                if(i==pageNo){
                    strb.append("<li><a href='javascript:void(0)"+params+"' >"+i+"</a></li>");
                }else{
                    strb.append("<li><a href='"+url+"?pageNo="+i+""+params+"'>"+i+"</a></li>");
                }
            }
        }

        if(pageNo==maxPage){
            strb.append("<li class='page'><a href='javascript:void(0)"+params+"'>下一页</a></li>");
            strb.append("<li class='page'><a href='javascript:void(0)"+params+"'>尾页</a></li>");
        }else{
            strb.append("<li class='page'><a href='"+url+"?pageNo="+(pageNo+1)+""+params+"'>下一页</a></li>");
            strb.append("<li class='page'><a href='"+url+"?pageNo="+(maxPage)+""+params+"'>尾页</a></li>");
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
