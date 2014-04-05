package fi.metropolia.fourhomework;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MyItemClickListener implements OnItemClickListener{
	private ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();	
	private Activity mActivity;
	
	public MyItemClickListener(Activity a,ArrayList<HashMap<String, String>> items){
		this.mActivity = a;
		this.items = items;
		
	}
	public void onItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		String desc = items.get(position).get("description");
		String title = items.get(position).get("title");
		String due_date = items.get(position).get("due_date");
		String author = items.get(position).get("author");

		Intent in = new Intent(mActivity.getApplicationContext(), SingleMenuItemActivity.class);
		in.putExtra("title", title);
		in.putExtra("due_date", due_date);
		in.putExtra("author", author);
		in.putExtra("description", desc);
		mActivity.startActivity(in);


		
	}
	

}