package net.cjcity.mobile;

import net.cjcity.mobile.reservation.entity.ReservationOrganCriteria;
import net.cjcity.mobile.reservation.view.AbstractReservationActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MobileMainActivity extends AbstractReservationActivity {
	private Button goOrganList;
	private Button goReceptCalendar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		goOrganList = (Button) findViewById(R.id.goOrganList);
		goReceptCalendar = (Button) findViewById(R.id.goReceiptCalendar);
//		Toast.makeText(this, getClass().getSimpleName()+"스레드:"+Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
		if(isOnline()){	
			goOrganList.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
	//				showLoading(MobileMainActivity.this,null);
					goOrganList(MobileMainActivity.this, new ReservationOrganCriteria());
				}
			});
	
			goReceptCalendar.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					goReceptCalendar(MobileMainActivity.this);
				}
			});
		}else{
			new AlertDialog.Builder(MobileMainActivity.this).setTitle("네트워크가 사용 불가능합니다.")
			.setMessage("네트웍 환경을 확인하시고 다시 시도해주세요."/* 네트워크 설정화면으로 이동하시겠습니까?"*/)
//			.setNeutralButton("예", new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface arg0, int arg1) {
////					getContentResolver().ostartSync(Uri.parse(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS));
//				      Intent intent = new Intent(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
////			            intent.setType("audio/*");
//			            startActivity(intent);
//			            finish();
//				}
//			})
//			.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
//				@Override
//				public void onClick(DialogInterface arg0, int arg1) {
//					
//				}
//			})
			.setNeutralButton("확인", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					finish();
				}
			})
			.show();
		}
	}

	
}