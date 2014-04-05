package fi.metropolia.fourhomework;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class MyTitleClickListener implements OnClickListener {
	private Activity mainActivity;
	int GONE=8;
	int VISIBLE = 0;
	public MyTitleClickListener(Activity a){
		this.mainActivity = a;
		
	}
	public void onClick(View v) {
		if(v.getId() == R.id.today_header){
			if(this.mainActivity.findViewById(R.id.today_item_listview).getVisibility() == VISIBLE){
				this.mainActivity.findViewById(R.id.today_item_listview).setVisibility(GONE);
			}else if(this.mainActivity.findViewById(R.id.today_item_listview).getVisibility() == GONE){
				this.mainActivity.findViewById(R.id.today_item_listview).setVisibility(VISIBLE);
			}
			
		}else if(v.getId() == R.id.tomorrow_header){
			if(this.mainActivity.findViewById(R.id.tomorrow_item_listview).getVisibility() == VISIBLE){
				this.mainActivity.findViewById(R.id.tomorrow_item_listview).setVisibility(GONE);
			}else if(this.mainActivity.findViewById(R.id.tomorrow_item_listview).getVisibility() == GONE){
				this.mainActivity.findViewById(R.id.tomorrow_item_listview).setVisibility(VISIBLE);
			}
		}else if(v.getId() == R.id.later_header){
			if(this.mainActivity.findViewById(R.id.later_item_listview).getVisibility() == VISIBLE){
				this.mainActivity.findViewById(R.id.later_item_listview).setVisibility(GONE);
			}else if(this.mainActivity.findViewById(R.id.later_item_listview).getVisibility() == GONE){
				this.mainActivity.findViewById(R.id.later_item_listview).setVisibility(VISIBLE);
			}
		}
		
		
		
	}

}
