package net.cjcity.mobile.reservation.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageList extends ArrayList implements Serializable {

    private static final long serialVersionUID = 0xcc53b1385d1d2f53L;

    private int totalSize=0;

    private int pageNo = 1;

    private int listSize = 10;

    private int totalPage;

    public PageList(List list, int totalSize, int pageNo, int listSize) {
        super(list);
        this.totalSize = totalSize;
        this.pageNo = pageNo;
        this.listSize = listSize;
        totalPage = totalSize / listSize;
        if (totalSize % listSize != 0)
            totalPage++;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getListSize() {
        return listSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int lastPage() {
        return getTotalSize() / getListSize()
                + (getTotalSize() % getListSize() == 0 ? 0 : 1);
    }

    public int currentTab(int tabSize) {
        return 1 + (getPageNo() - 1) / tabSize;
    }

    public int firstPageInTab(int tabSize) {
        return (currentTab(tabSize) - 1) * tabSize + 1;
    }

    public int lastPageInTab(int tabSize) {
        int i = hasNextTab(tabSize) ? currentTab(tabSize) * tabSize
                : lastPage();
        return i;
    }

    public boolean hasPreviousTab(int tabSize) {
        return currentTab(tabSize) > 1;
    }

    public boolean hasNextTab(int tabSize) {
        return currentTab(tabSize) * tabSize - lastPage() < 0;
    }
}
