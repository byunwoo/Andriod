package net.cjcity.mobile.reservation.view;

import net.cjcity.mobile.R;
import net.cjcity.mobile.reservation.entity.BaseCriteria;
import net.cjcity.mobile.reservation.entity.PageList;
import net.cjcity.mobile.reservation.entity.ReservationOrgan;
import net.cjcity.mobile.reservation.entity.ReservationOrganCriteria;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OrganListActivity extends AbstractReservationActivity{
    private ListView listView;
	/** Called when the activity is first created. */
    private PageList plist ;
    
    private Button searchBtn;
    private EditText searchTxt;
    private TextView empty;
	private LinearLayout searchLayout;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organ_list);
		new Thread() {
			public void run() {
				showLoading(OrganListActivity.this, "기관목록을 가져오고 있다는...");
			}
		};
        
        listView = (ListView) findViewById(R.id.ListView01);
        empty = (TextView)findViewById(R.id.emptyTxt01);
        
    	
	        searchLayout = (LinearLayout)findViewById(R.id.searchLayout);
	        searchLayout.setVisibility(View.GONE);
	          
	    	searchBtn = (Button)findViewById(R.id.serachBtn01);
	    	searchTxt = (EditText)findViewById(R.id.searchText01);
 
//    	/*안보이게하기*/
//		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//		imm.hideSoftInputFromWindow(searchTxt.getWindowToken(), 0);
		
    	searchBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ReservationOrganCriteria criteria = new ReservationOrganCriteria();
				criteria.setNameForList(searchTxt.getText().toString());
				goOrganList(OrganListActivity.this, criteria);
				
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchTxt.getWindowToken(), 0);
			}
		});
    }

    @Override
    protected void onResume() {
    	super.onResume();
//    	new Thread(){
//    		public void run(){
    	        Intent intent = getIntent();
    	        final BaseCriteria criteria = (BaseCriteria) intent.getExtras().get("criteria");
		        plist =  getService().getOrgans(criteria);
		        if(plist!=null) {
		        	empty.setVisibility(View.GONE);
		        	listView.setAdapter(new EfficientAdapter(OrganListActivity.this, plist));
		        	listView.setOnItemClickListener(new OnItemClickListener() {
		    			@Override
		    			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    				ReservationOrgan organ = (ReservationOrgan) plist.get(position);
		    				goOrganView(OrganListActivity.this,organ);
		    			}
		    		});
		        } else {
		        	empty.setVisibility(View.VISIBLE);
		        	searchLayout.setVisibility(View.VISIBLE);
		        }
		        			
	        	Toast.makeText(OrganListActivity.this, "기관 목록 다 가져왔음.", Toast.LENGTH_SHORT).show();
		        closeLoading();
//    		}
//    	};
    	
    }
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_SEARCH) {
			if (searchLayout.getVisibility() == View.GONE){
				searchLayout.setVisibility(View.VISIBLE);
			}else
				searchLayout.setVisibility(View.GONE);
			return false;
		}
		return super.onKeyDown(keyCode, event);
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
        	 return (ReservationOrgan) plist.get(position);
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
                convertView = mInflater.inflate(R.layout.list_item_icon_text, null);

                // Creates a ViewHolder and store references to the two children views
                // we want to bind data to.
                holder = new ViewHolder();
                holder.text = (TextView) convertView.findViewById(R.id.listText);
                holder.icon = (ImageView) convertView.findViewById(R.id.listIcon);
                
                convertView.setTag(holder);
            } else {
                // Get the ViewHolder back to get fast access to the TextView
                // and the ImageView.
                holder = (ViewHolder) convertView.getTag();
            }

            // Bind the data efficiently with the holder.
            ReservationOrgan organ = (ReservationOrgan) getItem(position);
        	holder.text.setText(organ.getId()+"-"+organ.getName());
        	Bitmap bm = organ.getImage();
        	if(bm!=null)
        		holder.icon.setImageBitmap(bm);
        	else
        		holder.icon.setImageResource(R.drawable.organ_icon);
            return convertView;
        }

		static class ViewHolder {
            TextView text;
            ImageView icon;
        }
    }


}