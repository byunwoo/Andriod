package net.cjcity.mobile.reservation.view;

import net.cjcity.mobile.R;
import net.cjcity.mobile.reservation.entity.ReservationOrgan;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OrganViewActivity extends AbstractReservationActivity {
    private TextView organName;
    private Integer organId;
	private WebView organView;
	private ImageView organPictureView;
	private LinearLayout layout;
	/** Called when the activity is first created. */
	 private GestureDetector gestureScanner;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organ_view);
//        Toast.makeText(this, getClass().getSimpleName()+"스레드:"+Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
        layout = (LinearLayout)findViewById(R.id.organ_view_layout);
        organName = (TextView)findViewById(R.id.organ_view_title);
        organView = (WebView)findViewById(R.id.WebView01);
        organPictureView = (ImageView)findViewById(R.id.ImageView01);
        
        
        Button getProgramBtn = (Button)findViewById(R.id.getProgram);
        getProgramBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				showLoading(MobileMainActivity.this,null);
				goProgramList(OrganViewActivity.this, organId);
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
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    	ReservationOrgan nextOrgan =  getService().getNextOrgan(organId);
                    	if(nextOrgan!=null){
                    		goOrganView(OrganViewActivity.this, nextOrgan);
                    		direction="left";
//                    		generateOrganDetail(nextOrgan);
//                    		getIntent().getExtras().putInt("organId", nextOrgan.getId());	
                    	}else
                    		Toast.makeText(getApplicationContext(), "마지막 기관입니다.", Toast.LENGTH_SHORT).show();
                    }
                    // left to right swipe
                    else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    	ReservationOrgan prevOrgan =  getService().getPrevOrgan(organId);
                    	if(prevOrgan!=null){
                    		goOrganView(OrganViewActivity.this, prevOrgan);
                    		direction="right";
//                    		generateOrganDetail(prevOrgan);
//                    		getIntent().getExtras().putInt("organId", prevOrgan.getId());
                    	}else
                    		Toast.makeText(getApplicationContext(), "처음 기관입니다.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    
                }
                return true;
            }
        });
//        Toast.makeText(OrganViewActivity.this, "onCreate",Toast.LENGTH_SHORT).show();
    }
    
    private void generateOrganDetail(ReservationOrgan organ) {
//      organViewLayout.onTouchEvent(new on)
        this.organId = organ.getId();
        organName.setText(organ.getId()+". "+organ.getName());
//        "+organ.getDetail()+"
        try{
	    	Bitmap bm = organ.getImage();
	    	organPictureView.setImageBitmap(bm);
        }catch(Exception e){}
        
        organView.loadData("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'/>"+organ.getDetail(),"text/html","utf-8");
	}
    
	@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    	super.dispatchTouchEvent(ev);
    	return gestureScanner.onTouchEvent(ev);
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	this.organId = savedInstanceState.getInt("organId");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	outState.putInt("organId", this.organId);
    	super.onSaveInstanceState(outState);
    }
    
    //실제 화면에 내용을 생성하는 부분
    @Override
    protected void onResume() {
    	super.onResume();
    	if(this.organId==null)
        this.organId =  getIntent().getExtras().getInt("organId");
        ReservationOrgan organ = getService().getOrgan(this.organId);
        generateOrganDetail(organ);
     	animate(layout, direction);
    }
    
	@Override
    protected void onNewIntent(Intent intent) {
    	this.organId = intent.getExtras().getInt("organId");
    	animate(layout, direction);
    }

 }
