package net.cjcity.mobile.reservation.view;

import net.cjcity.mobile.R;
import net.cjcity.mobile.reservation.entity.ReceiptCalendarCriteria;
import net.cjcity.mobile.reservation.entity.ReservationOrgan;
import net.cjcity.mobile.reservation.entity.ReservationOrganCriteria;
import net.cjcity.mobile.reservation.entity.ReservationProgram;
import net.cjcity.mobile.reservation.entity.ReservationProgramCriteria;
import net.cjcity.mobile.reservation.entity.ReservationReceiptCriteria;
import net.cjcity.mobile.reservation.service.BaseReservationMobileServic;
import net.cjcity.mobile.reservation.service.ReservationMobileService;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

public class AbstractReservationActivity extends /*Tab*/Activity {
	private ReservationMobileService service;
	protected ProgressDialog mProgressDialog;
	protected ReservationMobileService getService(){
		if(service==null)
			service=BaseReservationMobileServic.getInstance();
		return this.service;	
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
//	    Resources res = getResources(); // Resource object to get Drawables
//	    TabHost tabHost = getTabHost();  // The activity TabHost
//	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
//	    Intent intent;  // Reusable Intent for each tab
//
//	    // Create an Intent to launch an Activity for the tab (to be reused)
//	    intent = new Intent().setClass(this, OrganListActivity.class);
//
//	    // Initialize a TabSpec for each tab and add it to the TabHost
//	    spec = tabHost.newTabSpec("organ").setIndicator("기관"
////	    		,	                      res.getDrawable(R.drawable.ic_tab_artists)
//	    		)
//	                  .setContent(intent);
//	    tabHost.addTab(spec);
//
//	    // Do the same for the other tabs
//	    intent = new Intent().setClass(this, ProgramListActivity.class);
//	    spec = tabHost.newTabSpec("program").setIndicator("프로그램"
////	    		,	                      res.getDrawable(R.drawable.ic_tab_albums)
//	    		)
//	                  .setContent(intent);
//	    tabHost.addTab(spec);
//
//	    intent = new Intent().setClass(this, ReceiptListActivity.class);
//	    spec = tabHost.newTabSpec("receipt").setIndicator("접수"
////	    		,	                      res.getDrawable(R.drawable.ic_tab_songs)
//	    		)
//	                  .setContent(intent);
//	    tabHost.addTab(spec);
//
//	    tabHost.setCurrentTab(2);
		
	}
	
	
	
	/**
	 * 기관 목록화면으로 이동
	 * 
	 * @param packageContext
	 * @param pageNo
	 */
	protected void goOrganList(Context packageContext, ReservationOrganCriteria criteria) {
//		Toast.makeText(this, getClass().getSimpleName()+"스레드:"+Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
//		showLoading(packageContext, "기관 목록을 가져온다는...");
//		new Thread(){
//			public void run(){
//				int pn=1;
//				if (pageNo != null)
//					pageNo = 1;
				Intent intent = new Intent(packageContext, OrganListActivity.class);
				
//				ReservationOrganCriteria criteria = new ReservationOrganCriteria();
//				criteria.setPage(pageNo);
//				getService().getOrgans(criteria);
				intent.putExtra("criteria", criteria);
//				closeLoading();
				packageContext.startActivity(intent);
//			}
//		};
	}
	protected void goOrganView(Context packageContext, ReservationOrgan organ) {
		goOrganView(packageContext, organ, null);
	}
    protected void goOrganView(Context packageContext, ReservationOrgan organ, String direction) {
		Intent intent=	new Intent(packageContext ,OrganViewActivity.class);
		intent.putExtra("organId", organ.getId());
		packageContext.startActivity(intent);
			
    }
    
    /**
	 * 프로그램 목록화면으로 이동
	 * 
	 * @param packageContext
	 * @param pageNo
	 */
	protected void goProgramList(Context packageContext, Integer organId) {
//		Toast.makeText(this, getClass().getSimpleName()+"스레드:"+Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
//		showLoading(packageContext, "기관 목록을 가져온다는...");
//		new Thread(){
//			public void run(){
//				int pn=1;
//				if (pageNo != null)
//					pageNo = 1;
				Intent intent = new Intent(packageContext, ProgramListActivity.class);
				
				ReservationProgramCriteria criteria = new ReservationProgramCriteria();
				if(null!=organId)
					criteria.setSearchPk3(String.valueOf(organId));
//				criteria.setPage(pageNo);
//				getService().getOrgans(criteria);
				intent.putExtra("criteria", criteria);
//				closeLoading();
				packageContext.startActivity(intent);
//			}
//		};
	}
	
	
    /**
	 * 프로그램 상세화면으로 이동
	 * 
	 * @param packageContext
	 * @param pageNo
	 */
	protected void goProgramView(Context packageContext, ReservationProgram program) {
		Intent intent = new Intent(packageContext, ProgramViewActivity.class);
		intent.putExtra("programId", program.getId());
		packageContext.startActivity(intent);
	}
	
    /**
	 * 접수 목록화면으로 이동
	 * 
	 * @param packageContext
	 * @param pageNo
	 */
	protected void goReceiptList(Context packageContext, Integer programId) {
//		Toast.makeText(this, getClass().getSimpleName()+"스레드:"+Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
//		showLoading(packageContext, "기관 목록을 가져온다는...");
//		new Thread(){
//			public void run(){
//				int pn=1;
//				if (pageNo != null)
//					pageNo = 1;
				Intent intent = new Intent(packageContext, ReceiptListActivity.class);
				
				ReservationReceiptCriteria criteria = new ReservationReceiptCriteria();
				if(null!=programId)
					criteria.setSearchPk4(String.valueOf(programId));
//				criteria.setPage(pageNo);
//				getService().getOrgans(criteria);
				intent.putExtra("criteria", criteria);
//				closeLoading();
				packageContext.startActivity(intent);
//			}
//		};
	}
	
	// 임시로 baseCriteria 로 되어 있음. 수정
	protected void goReceptCalendar(Context packageContext){
		goReceptCalendar(packageContext, new ReceiptCalendarCriteria());
	}
	protected void goReceptCalendar(Context packageContext, ReceiptCalendarCriteria criteria){
		Intent intent =	new Intent(packageContext ,ReceiptCalendarActivity.class);
		intent.putExtra("criteria", criteria);
		packageContext.startActivity(intent);
	}
	
	protected void showLoading(Context packageContext, String msg) {
		mProgressDialog = ProgressDialog.show(
				packageContext, 
				"잠시만 기다려주세요.", 
				msg);
	}
	protected void closeLoading() {
		mHandler.sendEmptyMessage(0);
	}
	
	 //프로그레스 창 닫기 및 버퍼 EditText세팅용 핸들러객체
	protected Handler mHandler = new Handler(){
		
		@Override
		public void handleMessage(Message msg) {
			mProgressDialog.dismiss();
			//mEditText02.setText(sb);
//			mEditText02.setText(msg.getData().getString("setText"));
		}
	};
	
	protected String direction=null;
	protected void animate(ViewGroup layout) {
		animate(layout, null);
	}
	protected void animate(ViewGroup layout, String direction) {
		LayoutAnimationController animation = null;
		if("left".equals(direction))
			animation = AnimationUtils.loadLayoutAnimation(layout.getContext(), R.anim.push_left_layout);
		else if("right".equals(direction))
			animation = AnimationUtils.loadLayoutAnimation(layout.getContext(), R.anim.push_right_layout);
		if(animation!=null)
			layout.setLayoutAnimation(animation);
	}
	
	public boolean isOnline() {
		boolean result = false;
		try{
			ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo info =  cm.getActiveNetworkInfo();
			result = info.isConnected();
		}catch(Exception e){}
		return result;
	}
}