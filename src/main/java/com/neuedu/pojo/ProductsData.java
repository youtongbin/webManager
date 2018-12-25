package com.neuedu.pojo;

import java.util.List;

/**
 * ��ҳ��
 * list���ϷŲ�ѯ����
 * page_number��������չʾҳ��
 * page_Size����ÿҳ��ŵ���Ϣ����
 * max_page���ҳ��
 * max_count��������
 * url��תҳ����ַ
 * page_viewƴ��չʾ��ҳ��
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
            strb.append("<li class='page'><a href='javascript:void(0)'>��ҳ</a></li>");
            strb.append("<li class='page'><a href='javascript:void(0)'>��һҳ</a></li>");
        }else {
            strb.append("<li class='page'><a href='" + url + "?pageNo=1'>��ҳ</a></li>");
            strb.append("<li class='page'><a href='" + url + "?pageNo=" + (pageNo-1) + "'>��һҳ</a></li>");
        }

        for (int i = 1;i <= maxPage;i++){
            if (i == pageNo){
                strb.append("<li class='page'><a href='javascript:void(0)'>" + i +"</a></li>");
            }else {
                strb.append("<li class='page'><a href='" + url + "?pageNo=" + (i) + "'>" + i + "</a></li>");
            }
        }

        if (pageNo == maxPage){
            strb.append("<li class='page'><a href='javascript:void(0)'>��һҳ</a></li>");
            strb.append("<li class='page'><a href='javascript:void(0)'>βҳ</a></li>");
        }else {
            strb.append("<li class='page'><a href='" + url + "?pageNo=" + (pageNo+1) + "'>��һҳ</a></li>");
            strb.append("<li class='page'><a href='" + url + "?pageNo=" + (maxPage) + "'>βҳ</a></li>");
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
