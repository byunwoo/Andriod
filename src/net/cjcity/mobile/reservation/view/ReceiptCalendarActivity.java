package net.cjcity.mobile.reservation.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import net.cjcity.mobile.R;
import net.cjcity.mobile.reservation.entity.PageList;
import net.cjcity.mobile.reservation.entity.ReceiptCalendarCriteria;
import net.cjcity.mobile.reservation.entity.ReservationProgram;
import net.cjcity.mobile.reservation.entity.ReservationReceipt;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiptCalendarActivity extends AbstractReservationActivity {
	// 디스플레이 셋팅
	private int width;
	private int height;
	
	// criteria
	private ReceiptCalendarCriteria criteria;
	private GridView grid;
	private TextView calTitle;
	private ArrayList<Date> gridData = new ArrayList<Date>();
	private Integer calendarMonth;
	private Integer calendarYear;
	private ViewGroup layout;
     
//	private int dayOfWeek, max, dayOfMonth, weekOfMonth, FoM, year, month;
	private GestureDetector gestureScanner;
	private PageList pList;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.receipt_calendar);
		layout = (ViewGroup)findViewById(R.id.calendar_layout);
		grid = (GridView) findViewById(R.id.CalGrid);
		// 이하 셋팅
		setDisplay();
		
		
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(ReceiptCalendarActivity.this,((TextView) view).getText(),Toast.LENGTH_SHORT).show();
			}
		});
		
      gestureScanner = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
            private static final int SWIPE_MIN_DISTANCE = 120;
            private static final int SWIPE_MAX_OFF_PATH = 250;
            private static final int SWIPE_THRESHOLD_VELOCITY = 200;
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                try {
                    if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                        return false;
                    
                    // right to left swipe
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    	Calendar temp = Calendar.getInstance();
                    	temp.set(calendarYear, (calendarMonth-1),1);
                    	temp.add(Calendar.MONTH, +1);
                    	direction="left";
                    	goReceptCalendar(ReceiptCalendarActivity.this, new ReceiptCalendarCriteria(temp.get(Calendar.YEAR),(temp.get(Calendar.MONTH)+1)));
                    }
                    // left to right swipe
                    else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    	Calendar temp = Calendar.getInstance();
                    	temp.set(calendarYear, (calendarMonth-1),1);
                    	temp.add(Calendar.MONTH, -1);
                    	direction="right";
                    	goReceptCalendar(ReceiptCalendarActivity.this, new ReceiptCalendarCriteria(temp.get(Calendar.YEAR),(temp.get(Calendar.MONTH)+1)));
                    }
                } catch (Exception e) {
                    
                }
                return true;
            }
        });
	}
	@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    	super.dispatchTouchEvent(ev);
    	return gestureScanner.onTouchEvent(ev);
    }
    
	/**
	 * 기기의 화면 크기를 받아온다.
	 */
	private void setDisplay() {
		DisplayMetrics displayMetrics = new DisplayMetrics(); 
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics); 
		width = displayMetrics.widthPixels; 
		height = displayMetrics.heightPixels;
//		width =  ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
//		height =  ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
		width = (int) (width - (width * 0.05));
		height = (int) (height - (height * 0.05));
	}

	private void setGrid() {
		
		grid.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// 실제 그리드 생성 부분
				TextView textView;
				if (convertView == null) { // if it's not recycled, initialize
					// some attributes
					textView = new TextView(ReceiptCalendarActivity.this);
					textView.setLayoutParams(new GridView.LayoutParams((width/ 7), (height/ 8)));
					textView.setPadding(1, 1, 1, 1);
					textView.setBackgroundColor(Color.GRAY);
				} else {
					textView = (TextView) convertView;
				}
				Date date = gridData.get(position);
				
				if((date.getMonth()+1)!=calendarMonth){
					textView.setTextSize(12);
				}else{
					
					if(date.getDay()==0){
						textView.setTextColor(Color.RED);
					}else if(date.getDay()==6){
						textView.setTextColor(Color.BLUE);
					}else{
						textView.setTextColor(Color.WHITE);
					}
				}
				StringBuilder sb = new StringBuilder(String.valueOf(date.getDate()));
				populateReceiptInfo(sb, date);
				textView.setText(sb.toString());
				return textView;
			}

			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public Object getItem(int position) {
				return gridData.get(position);
			}

			@Override
			public int getCount() {
				return gridData.size();
			}
		});
	}

	protected void populateReceiptInfo(StringBuilder sb, Date date) {
		if(pList==null||pList.size()==0)
			return;
		for (int i = 0; i < this.pList.size(); i++) {
		       ReservationReceipt receipt = (ReservationReceipt) pList.get(i);
		       if(date.after(receipt.getReceiptStartDate())
		    		   &&
		    		   date.before(receipt.getReceiptEndDate())
		       ){
			       sb.append("[");
			       sb.append(receipt.getName());
			       sb.append("]");
		       }
		}
		
	}
	private void setCalendarData(Integer year, Integer month) {
		calendarYear = year;
		calendarMonth = month;
		gridData.clear();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1); 
		cal.set(Calendar.DAY_OF_MONTH,1); //1일
		gridData.ensureCapacity(49);
//		gridData.addAll(0, Array.);
//		gridData.add(i, Day[i]);		
		//이전달의 마지막주 자투리 삽입
		while(cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY){
			cal.add(Calendar.DATE, -1);//1일씩 감소
			gridData.add(cal.getTime());
		}
		//이번달 
		//초기화
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1); //1일
		cal.set(Calendar.DAY_OF_MONTH, 1);
//		cal.add(Calendar.DAY_OF_MONTH, -1);
		//루프
		do{
			gridData.add(cal.getTime());
			cal.add(Calendar.DAY_OF_MONTH, +1);//1일씩 증가
		}	while(cal.get(Calendar.MONTH)==(month-1));
		
		//다음달
		while(cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY){
			gridData.add(cal.getTime());
			cal.add(Calendar.DATE, +1);//1일씩 증가
		}
//		마지막 토요일인 날 
		gridData.add(cal.getTime());
		
		calTitle = (TextView) findViewById(R.id.CalTitle);
		calTitle.setText(year + " 년 " + month + " 월 ");
	}
	
	
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	this.calendarYear = savedInstanceState.getInt("year");
    	this.calendarMonth= savedInstanceState.getInt("month");
    	this.pList= (PageList) savedInstanceState.getSerializable("list");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	outState.putInt("year", this.calendarYear);
    	outState.putInt("month", this.calendarMonth);
    	outState.putSerializable("list", this.pList);
    	super.onSaveInstanceState(outState);
    }
    
    //실제 화면에 내용을 생성하는 부분
    @Override
    protected void onResume() {
    	super.onResume();
    	if(this.calendarYear==null||this.calendarMonth==null){
    		criteria = (ReceiptCalendarCriteria) getIntent().getExtras().get("criteria");
	    	this.calendarYear=criteria.getYear();
	    	this.calendarMonth=criteria.getMonth();
	    	this.pList=criteria.getList();
    	}
    	animate(layout, direction);
//		달력 그려주기
		setCalendarData(this.calendarYear, this.calendarMonth);
		setGrid();
    }
    
    @Override
    protected void onNewIntent(Intent intent) {
    		criteria = (ReceiptCalendarCriteria) intent.getExtras().get("criteria");
	    	this.calendarYear=criteria.getYear();
	    	this.calendarMonth=criteria.getMonth();
	    	this.pList=criteria.getList();
    }
}