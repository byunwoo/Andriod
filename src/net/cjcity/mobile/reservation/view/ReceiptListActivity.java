package net.cjcity.mobile.reservation.view;

import java.util.Calendar;
import java.util.Date;

import net.cjcity.mobile.R;
import net.cjcity.mobile.reservation.entity.BaseCriteria;
import net.cjcity.mobile.reservation.entity.PageList;
import net.cjcity.mobile.reservation.entity.ReceiptCalendarCriteria;
import net.cjcity.mobile.reservation.entity.ReservationReceipt;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;

public class ReceiptListActivity extends AbstractReservationActivity {
    /** Called when the activity is first created. */
	private ListView listView;
	private PageList plist ;
	private TextView empty;
	private Button goCalendarBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receipt_list);
        listView = (ListView) findViewById(R.id.ListView01);
        empty = (TextView)findViewById(R.id.emptyTxt01);
        goCalendarBtn = (Button)findViewById(R.id.goReceiptCalendar);
        Intent intent = getIntent();
        final BaseCriteria criteria = (BaseCriteria) intent.getExtras().get("criteria");
        
        plist =  getService().getReceipts(criteria);
        if(plist!=null){
        	empty.setVisibility(View.GONE);
        	listView.setAdapter(new EfficientAdapter(ReceiptListActivity.this, plist));
	        listView.setOnItemLongClickListener(new OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//					ReservationReceipt receipt = (ReservationReceipt) plist.get(position);
					showDialogTemp(position);
					return false;
				}
			});
        } else {
        	empty.setVisibility(View.VISIBLE);
        }
        
        goCalendarBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ReceiptCalendarCriteria criteria = new ReceiptCalendarCriteria();
				criteria.setList(plist);
				goReceptCalendar(ReceiptListActivity.this, criteria);
			}
		});
    }
    
    private void showDialogTemp(int plistPosition) {
    	Date date = new Date();
    	ReservationReceipt receipt = (ReservationReceipt)plist.get(plistPosition); 
    	if(date.before(receipt.getReceiptStartDate())){
    		AlarmStartDate = receipt.getReceiptStartDate();
    		showDialog(2);
    	} else {
    		showDialog(1);
    	}
	}

    @Override
    protected android.app.Dialog onCreateDialog(int id) {
    	switch (id) {
        case 1:
            return new AlertDialog.Builder(ReceiptListActivity.this)
                .setIcon(R.drawable.alert_dialog_icon)
                .setTitle("접수가 이미 시작되었거나 종료되었습니다.")
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {}
                })
                .create();
        case 2:
            return new AlertDialog.Builder(ReceiptListActivity.this)
                .setIcon(R.drawable.alert_dialog_icon)
                .setTitle("접수시작 전에 알람설정.")
                .setSingleChoiceItems(R.array.select_dialog_items, 0, new DialogInterface.OnClickListener() {
                	public void onClick(DialogInterface dialog, int whichButton) {
                		AlarmStringIdx = whichButton;
                	}
                })
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    	setAlarm();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {}
                })
               .create();
            
            default : break;
    	}
    	return null;
    };
    
    private int AlarmStringIdx = 0;
    private Date AlarmStartDate;
    private AlarmManager mManager;
	private void setAlarm() {
		mManager = (AlarmManager)getSystemService(ALARM_SERVICE);
		Calendar AlarmStartCalendar = Calendar.getInstance();
		AlarmStartCalendar.setTime(AlarmStartDate);
		
		switch(AlarmStringIdx){
			case 0 : AlarmStartCalendar.add(Calendar.MINUTE, -5); break;
			case 1 : AlarmStartCalendar.add(Calendar.MINUTE, -30); break;
			case 2 : AlarmStartCalendar.add(Calendar.HOUR_OF_DAY, -1); break;
			case 3 : AlarmStartCalendar.add(Calendar.HOUR_OF_DAY, -2); break;
			default: break;
		}
		
		mManager.set(AlarmManager.RTC_WAKEUP,	AlarmStartCalendar.getTimeInMillis(),	pendingIntent());
	}
    
	private PendingIntent pendingIntent(){
		Intent i = new Intent(ReceiptListActivity.this.getApplicationContext(), MusicAlarmActivity.class);
		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
		return pi;
	}
	
    private static class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private PageList plist ;
        
        public EfficientAdapter(Context context, PageList plist) {
            // Cache the LayoutInflate to avoid asking for a new one each time.
        	this.mInflater = LayoutInflater.from(context);
            this.plist = plist;
            // Icons bound to the rows.
//            mIcon1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon48x48_1);
//            mIcon2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon48x48_2);
        }

        /**
         * The number of items in the list is determined by the number of speeches
         * in our array.
         *
         * @see android.widget.ListAdapter#getCount()
         */
        public int getCount() {
            return plist.getTotalSize();
        }

        /**
         * Since the data comes from an array, just returning the index is
         * sufficent to get at the data. If we were using a more complex data
         * structure, we would return whatever object represents one row in the
         * list.
         *
         * @see android.widget.ListAdapter#getItem(int)
         */
        public Object getItem(int position) {
        	 return (ReservationReceipt) plist.get(position);
        }

        /**
         * Use the array index as a unique id.
         *
         * @see android.widget.ListAdapter#getItemId(int)
         */
        public long getItemId(int position) {
            return position;
        }

        /**
         * Make a view to hold each row.
         *
         * @see android.widget.ListAdapter#getView(int, android.view.View,
         *      android.view.ViewGroup)
         */
        public View getView(int position, View convertView, ViewGroup parent) {
            // A ViewHolder keeps references to children views to avoid unneccessary calls
            // to findViewById() on each row.
            ViewHolder holder;

            // When convertView is not null, we can reuse it directly, there is no need
            // to reinflate it. We only inflate a new View when the convertView supplied
            // by ListView is null.
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.list_item_text, null);

                // Creates a ViewHolder and store references to the two children views
                // we want to bind data to.
                holder = new ViewHolder();
                holder.textForName = (TextView) convertView.findViewById(R.id.listTextName);
                holder.textForReceiptDate = (TextView) convertView.findViewById(R.id.listTextReceiptDate);
                holder.textForAttendingDate = (TextView) convertView.findViewById(R.id.listTextAttendingDate);
                holder.textForAcceptingMethod = (TextView) convertView.findViewById(R.id.listTextAcceptingMethod);
                
                
                convertView.setTag(holder);
            } else {
                // Get the ViewHolder back to get fast access to the TextView
                // and the ImageView.
                holder = (ViewHolder) convertView.getTag();
            }

            // Bind the data efficiently with the holder.
            ReservationReceipt receipt = (ReservationReceipt) getItem(position);
            holder.textForName.setText(receipt.getName());
            String acceptingMethod = receipt.getAcceptingMethod();
            if(acceptingMethod.equals("A")){
            	acceptingMethod = "[자동]선착순 선정";
            } else if(acceptingMethod.equals("B")){
            	acceptingMethod = "[수동]관리자 직접 선정";
            } else {
            	acceptingMethod = "[자동]무작위 선정";
            }
            holder.textForAcceptingMethod.setText("선정방식 : "+acceptingMethod);
            holder.textForReceiptDate.setText("접수기간 : "
            		+DateFormat.format("yyyy/MM/dd hh:mm", receipt.getReceiptStartDate())
            		+"~"
            		+DateFormat.format("yyyy/MM/dd hh:mm", receipt.getReceiptEndDate()));
            holder.textForAttendingDate.setText("이용기간 : "
            		+DateFormat.format("yyyy/MM/dd hh:mm", receipt.getAttendingStartDate())
            		+"~"
            		+DateFormat.format("yyyy/MM/dd hh:mm", receipt.getAttendingEndDate()));
            
            return convertView;
        }

		static class ViewHolder {
            TextView textForName;
            TextView textForReceiptDate;
            TextView textForAttendingDate;
            TextView textForAcceptingMethod;
        }
    }
}