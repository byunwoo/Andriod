package net.cjcity.mobile.reservation.entity;

import java.util.Calendar;

public class ReceiptCalendarCriteria extends BaseCriteria {

	private static final long serialVersionUID = -5985628188345156633L;
	
	private int year ;
	private int month;
	private int day;
	private PageList list;
	
	public ReceiptCalendarCriteria() {
		Calendar cal = Calendar.getInstance();
		this.year = cal.get(Calendar.YEAR);
		this.month = cal.get(Calendar.MONTH)+1;
		this.day = cal.get(Calendar.DAY_OF_MONTH);
	}
	public ReceiptCalendarCriteria(int year, int month) {
		this.year = year;
		this.month = month;
		this.day=1;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMonth() {
		return month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}

	public void setList(PageList list) {
		this.list = list;
	}

	public PageList getList() {
		return list;
	}

}
