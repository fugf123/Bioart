package com.xiaowa.bioart.util;

/**
 * ��ҳ��ѯ������
 *
 * @author miaoruntu
 */
public class PageQuery {

    public static final int PageQuery_pageSize_common = 30;

    // ��ǰҳ��
    private int PageQuery_currPage;

    // ��ҳ��
    private int PageQuery_Psize;

    // �ܼ�¼��
    private int PageQuery_infoCount;

    // ÿҳ��ʾ����
    private int PageQuery_pageSize = PageQuery_pageSize_common;

    // ��ʼ����
    private int PageQuery_start = 0;

    // ��������
    private int PageQuery_end = 30;


    public static final String PageQuery_classname = "pagequery";


    /**
     * ���ֲ��������봦�����ռ������ǰҳ��PageQuery_currPage����ʼ����PageQuery_star����������PageQuery_end����ҳ��PageQuery_Psize
     *
     * @param infoCount ��¼����
     * @param pageSize  ÿҳ��ʾ����
     * @param currPage  ��ǰҳ��
     */
    public void setPageParams(int infoCount, int pageSize, int currPage) {
        this.PageQuery_infoCount = infoCount;
        this.PageQuery_pageSize = pageSize;
        this.PageQuery_currPage = currPage;

        float Psize_l = infoCount / (float) (this.PageQuery_pageSize);
        if (PageQuery_currPage < 2) {
            PageQuery_currPage = 1;
            PageQuery_start = 0;
        } else if (PageQuery_currPage > Psize_l) {
            if (Psize_l == 0) {

                PageQuery_currPage = 1;
            } else {
                PageQuery_currPage = (int) Math.ceil(Psize_l);
            }

            PageQuery_start = (PageQuery_currPage - 1) * this.PageQuery_pageSize;
        } else {
            PageQuery_start = (PageQuery_currPage - 1) * this.PageQuery_pageSize;
        }
        PageQuery_Psize = (int) Math.ceil(Psize_l);
        this.PageQuery_end = PageQuery_currPage * this.PageQuery_pageSize;
    }

    public int getPageQuery_currPage() {
        return PageQuery_currPage;
    }

    public void setPageQuery_currPage(int pageQuery_currPage) {
        PageQuery_currPage = pageQuery_currPage;
    }

    public int getPageQuery_Psize() {
        return PageQuery_Psize;
    }

    public void setPageQuery_Psize(int pageQuery_Psize) {
        PageQuery_Psize = pageQuery_Psize;
    }

    public int getPageQuery_infoCount() {
        return PageQuery_infoCount;
    }

    public void setPageQuery_infoCount(int pageQuery_infoCount) {
        PageQuery_infoCount = pageQuery_infoCount;
    }

    public int getPageQuery_pageSize() {
        return PageQuery_pageSize;
    }

    public void setPageQuery_pageSize(int pageQuery_pageSize) {
        PageQuery_pageSize = pageQuery_pageSize;
    }

    public int getPageQuery_start() {
        return PageQuery_start;
    }

    public void setPageQuery_start(int pageQuery_start) {
        PageQuery_start = pageQuery_start;
    }

    public PageQuery getPageQuery() {
        return this;
    }

    public int getPageQuery_end() {
        return PageQuery_end;
    }


}
