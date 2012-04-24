package net.cjcity.mobile.reservation.entity;

import java.io.Serializable;



public class BaseCriteria implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * The user-provided search criteria for finding Hotels.
     */
    private boolean enableSearch=false;

    /**
     * 한페이지당 갯수
     */
    private int pageSize = 10;
    
    private int selectedTabIndex=0;
    
    private String nameForList="";

    public String getNameForList() {
		return nameForList;
	}

	public void setNameForList(String nameForList) {
		this.nameForList = nameForList;
	}

	private String searchPk4="";
	public String getSearchPk4() {
		return searchPk4;
	}

	public void setSearchPk4(String searchPk4) {
		this.searchPk4 = searchPk4;
	}

	private String searchPk3="";
	private String searchPk2="";
	private String searchPk1="";
	private String searchKey3="";
	private String searchKey2="";
	private String searchKey1="";
	public String getSearchKey3() {
		return searchKey3;
	}

	public void setSearchKey3(String searchKey3) {
		this.searchKey3 = searchKey3;
	}

	public String getSearchKey2() {
		return searchKey2;
	}

	public void setSearchKey2(String searchKey2) {
		this.searchKey2 = searchKey2;
	}

	public String getSearchKey1() {
		return searchKey1;
	}

	public void setSearchKey1(String searchKey1) {
		this.searchKey1 = searchKey1;
	}

	public String getSearchPk3() {
		return searchPk3;
	}

	public void setSearchPk3(String searchPk3) {
		this.searchPk3 = searchPk3;
	}

	/**
     * 현재페이지
     */
    private int page = 1;


    /**
     * 한페이지당 건수
     * @return
     */
    public int getPageSize() {
    	return pageSize;
    }

    public void setPageSize(int pageSize) {
    	this.pageSize = pageSize;
    }

    /**
     * 현재 페이지
     * @return
     */
    public int getPage() {
    	return page;
    }

    public void setPage(int page) {
    	this.page = page;
    }

	/**
	 * @param enableSearch the enableSearch to set
	 */
	public void setEnableSearch(boolean enableSearch) {
		this.enableSearch = enableSearch;
	}

	/**
	 * @return the enableSearch
	 */
	public boolean isEnableSearch() {
		return enableSearch;
	}

	/**
	 * @param selectedTabIndex the selectedTabIndex to set
	 */
	public void setSelectedTabIndex(int selectedTabIndex) {
		this.selectedTabIndex = selectedTabIndex;
	}

	/**
	 * @return the selectedTabIndex
	 */
	public int getSelectedTabIndex() {
		return selectedTabIndex;
	}

	public void setSearchPk2(String searchPk2) {
		this.searchPk2 = searchPk2;
	}

	public String getSearchPk2() {
		return searchPk2;
	}

	public void setSearchPk1(String searchPk1) {
		this.searchPk1 = searchPk1;
	}

	public String getSearchPk1() {
		return searchPk1;
	}
	
}