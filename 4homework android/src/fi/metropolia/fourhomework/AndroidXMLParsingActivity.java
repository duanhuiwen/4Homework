package fi.metropolia.fourhomework;

import com.google.android.gcm.GCMRegistrar;
import java.util.ArrayList;
import java.util.HashMap;



import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class AndroidXMLParsingActivity extends Activity implements XmlFetchListener{








	static final String HOMEWORK = "homework" ;
	static final String HOMEWORK_ID ="homework_id";
	static final String TITLE = "title";
	static final String DUE_DATE = "due_date";
	static final String DUE_DATE_TIME = "due_date_time";
	static final String DESCCRIPTION = "description";
	static final String AUTHOR = "author";
	
	
	// gcm paras  
/*	static final String SENDER_ID = "584827760743";
	private static final String TAG = "registered status";
	*/
	private ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
	
	private  FetchXmlTask fetchxml = new FetchXmlTask(this);
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		//gcm service currently not working
/*		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		final String regId = GCMRegistrar.getRegistrationId(this);
		if (regId.equals("")) {
		  GCMRegistrar.register(this, SENDER_ID);
		} else {
		  Log.v(TAG, "Already registered");
		}*/
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowHomeEnabled(true);
		fetchxml.execute();
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 switch(item.getItemId()) {
	        case R.id.refreshBtn:
	        	FetchXmlTask t = new FetchXmlTask(this);
	        	t.execute();
	            break;
	      
	        	}
	        //return true;
		
		
		
		return super.onOptionsItemSelected(item);
	}*/
	
	

	public void updateUI() {
		
		menuItems = fetchxml.getXml();
		
/*		ListAdapter adapter = new SimpleAdapter(this, menuItems,R.layout.list_item,
				new String[] {TITLE}, new int[] {
						R.id.title});

		
		ListView today_items = (ListView) this.findViewById(R.id.today_item_listview);
		today_items.setAdapter(adapter);
		//setListAdapter(adapter);
		//ListView lv = getListView();

		today_items.setOnItemClickListener(new OnItemClickListener() {

			//@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String desc = menuItems.get(position).get(DESCCRIPTION);
				String title = menuItems.get(position).get(TITLE);
				String due_date = menuItems.get(position).get(DUE_DATE);
				String author = menuItems.get(position).get(AUTHOR);

				Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
				in.putExtra(TITLE, title);
				in.putExtra(DUE_DATE, due_date);
				in.putExtra(AUTHOR, author);
				in.putExtra(DESCCRIPTION, desc);
				startActivity(in);

			}
		});*/
		
	}



}