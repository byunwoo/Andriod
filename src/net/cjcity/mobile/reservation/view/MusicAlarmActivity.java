package net.cjcity.mobile.reservation.view;

import net.cjcity.mobile.R;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MusicAlarmActivity extends Activity {
//	MediaPlayer mp;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarm);
		getSystemService(VIBRATOR_SERVICE);
		  Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
		  long[] pattern =MorseCodeConverter.pattern("WAKE UP");
          vibrator.vibrate(pattern, 10);
		
//		mp = MediaPlayer.create(this, R.raw.hallelujah);
//		mp.start();
		Button cancleB = (Button)findViewById(R.id.alarmBtn);
		cancleB.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				AlarmManager mManager = (AlarmManager)getSystemService(ALARM_SERVICE);
				mManager.cancel(pendingIntent());
//				mp.stop();
				finish();
			}
		});
		
	}

	private PendingIntent pendingIntent(){
		Intent i = new Intent(getApplicationContext(), MusicAlarmActivity.class);
		PendingIntent pi=PendingIntent.getActivity(this, 0, i, 0);
		return pi;
	}
}