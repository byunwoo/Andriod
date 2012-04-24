package net.cjcity.mobile.reservation.view;

import net.cjcity.mobile.R;
import net.cjcity.mobile.reservation.entity.ReservationProgram;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProgramViewActivity extends AbstractReservationActivity {
    /** Called when the activity is first created. */
	private Integer programId;
	private TextView programTitle;
	private WebView programExplain;
	private ImageView programImage;
	private GestureDetector gestureScanner;
	private ViewGroup layout;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_view);
        layout = (ViewGroup)findViewById(R.id.program_view_layout);
        programTitle = (TextView)findViewById(R.id.program_title);
        programExplain = (WebView)findViewById(R.id.program_explan);
        programImage = (ImageView)findViewById(R.id.program_image);
        
        Button getReceiptBtn = (Button)findViewById(R.id.goReceiptList);
        getReceiptBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
//				showLoading(MobileMainActivity.this,null);
				goReceiptList(ProgramViewActivity.this, programId);
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
                    	ReservationProgram nextProgram =  getService().getNextProgram(programId);
                    	if(nextProgram!=null){
                    		direction="left";
                    		goProgramView(ProgramViewActivity.this, nextProgram);
                    	}else
                    		Toast.makeText(getApplicationContext(), "마지막 프로그램입니다.", Toast.LENGTH_SHORT).show();
                    }
                    // left to right swipe
                    else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    	ReservationProgram prevProgram =  getService().getPrevProgram(programId);
                    	if(prevProgram!=null){
                    		direction="right";
                    		goProgramView(ProgramViewActivity.this, prevProgram);
                    	}else
                    		Toast.makeText(getApplicationContext(), "처음 프로그램입니다.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    
                }
                return true;
            }
        });
    }
    
	private void generateProgramDetail(ReservationProgram program) {
	//  organViewLayout.onTouchEvent(new on)
	    this.programId = program.getId();
	    
	    programTitle.setText(program.getId()+". "+program.getName());
	//    "+organ.getDetail()+"
	    try{
	    	Bitmap bm = program.getImage();
	    	programImage.setImageBitmap(bm);
	    }catch(Exception e){}
	    
	    programExplain.loadData("<meta http-equiv='Content-Type' content='text/html;charset=utf-8'/>"+program.getExplain(),"text/html","utf-8");
	}
	@Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    	super.dispatchTouchEvent(ev);
    	return gestureScanner.onTouchEvent(ev);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	this.programId = savedInstanceState.getInt("programId");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	outState.putInt("programId", this.programId);
    	super.onSaveInstanceState(outState);
    }
    
    //실제 화면에 내용을 생성하는 부분
    @Override
    protected void onResume() {
    	super.onResume();
    	if(this.programId==null)
        this.programId =  getIntent().getExtras().getInt("programId");
        ReservationProgram program = getService().getProgram(this.programId);
        generateProgramDetail(program);
     	animate(layout, direction);
    }
    
    @Override
    protected void onNewIntent(Intent intent) {
    	this.programId = intent.getExtras().getInt("programId");
    }
	
}