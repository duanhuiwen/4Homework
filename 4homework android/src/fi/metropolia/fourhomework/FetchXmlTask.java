package fi.metropolia.fourhomework;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;



public class FetchXmlTask extends AsyncTask<String, Void, String>{
	
	static final String URL = "http://users.metropolia.fi/~huiwend/4homework/mobileIO/xmlGenerator.php?group_id=TJ10S1";

	

	// All static variables

	static final String HOMEWORK = "homework" ;
	static final String HOMEWORK_ID ="homework_id";
	static final String TITLE = "title";
	static final String DUE_DATE = "due_date";
	static final String DUE_DATE_TIME = "due_date_time";
	static final String DESCCRIPTION = "description";
	static final String AUTHOR = "author";
	
	//get the phone's date
	Calendar now = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	String nowDate = formatter.format(now.getTime());
	String[] separateCurrentDate = nowDate.split("-");
	String year = separateCurrentDate[0];
	String month = separateCurrentDate[1];
	String day = separateCurrentDate[2];
	
	int currentYear = Integer.parseInt(year);
	int currentMonth = Integer.parseInt(month);
	int currentDay = Integer.parseInt(day);
	
	
	
	
	private AndroidXMLParsingActivity mainActivity; 
	private XMLParser parser = new XMLParser();
	private ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();
	
	
	//replace the menu item which add homework item to list
	private ArrayList<HashMap<String, String>> today_items = new ArrayList<HashMap<String, String>>();	
	private ArrayList<HashMap<String, String>> tomorrow_items = new ArrayList<HashMap<String, String>>();	
	private ArrayList<HashMap<String, String>> later_items = new ArrayList<HashMap<String, String>>();	
	
	
	
	
	
			public FetchXmlTask(AndroidXMLParsingActivity androidXMLParsingActivity){
				this.mainActivity = androidXMLParsingActivity;
			
			}
	        @Override
	        protected String doInBackground(String... urls) {
	        	String xml = parser.getXmlFromUrl(URL);
	            return xml;
	          
	        }

	        @Override
	        protected void onPostExecute(String result) {

	        	// getting DOM element
	    		Document doc = parser.getDomElement(result); 

	    		NodeList nl = doc.getElementsByTagName(HOMEWORK);
	    		
/*     		
    		for (int i = 0; i < nl.getLength(); i++) {
    			
    	
    			
	    			// creating new HashMap
	    			HashMap<String, String> map = new HashMap<String, String>();
	    			Element e = (Element) nl.item(i);
	    			
	    			String homeworkDate = parser.getValue(e, DUE_DATE);
	    			//Log.d("homeworkDate",homeworkDate);
	    			
	    			//String homeworkDate ="2012-10-21";
	    			String[] separateDate = homeworkDate.split("-");
	    			
	    			int homeworkYear = Integer.parseInt(separateDate[0]);
	    			//Log.d("separateDate[0]",""+Integer.parseInt(separateDate[0]));
	    			
	    			int homeworkMonth = Integer.parseInt(separateDate[1]);
	    			int homeworkDay = Integer.parseInt(separateDate[2]);
	    			// adding each child node to HashMap key => value
	    			//System.out.print(homeworkDay);
	    			map.put(HOMEWORK_ID, parser.getValue(e, HOMEWORK_ID));
	    			map.put(TITLE, parser.getValue(e, TITLE));
	    			map.put(DUE_DATE, parser.getValue(e, DUE_DATE));
	    			map.put(DUE_DATE_TIME, parser.getValue(e, DUE_DATE_TIME));
	    			map.put(DESCCRIPTION, parser.getValue(e, DESCCRIPTION));
	    			map.put(AUTHOR, parser.getValue(e, AUTHOR));

	    			// adding HashList to ArrayList
	    			today_items.add(map);
	    		}
	    		*/
	    		
	    		
	    			
	    		for (int i = 0; i < nl.getLength(); i++) {
	    			// creating new HashMap
	    			
	    			
	    			
	    			
	    			Element e = (Element) nl.item(i);
	    			// adding each child node to HashMap key => value
	     			String homeworkDate = parser.getValue(e, DUE_DATE);
	    			String[] separateDate = homeworkDate.split("-");
	    			int homeworkYear = Integer.parseInt(separateDate[0]);
	    			int homeworkMonth = Integer.parseInt(separateDate[1]);
	    			int homeworkDay = Integer.parseInt(separateDate[2]);
	    			
	    			
	    			if(currentYear == homeworkYear && currentMonth == homeworkMonth && currentDay == homeworkDay){
	    				
	    					HashMap<String, String> today_map = new HashMap<String, String>();
			    			today_map.put(HOMEWORK_ID, parser.getValue(e, HOMEWORK_ID));
			    			today_map.put(TITLE, parser.getValue(e, TITLE));
			    			today_map.put(DUE_DATE, parser.getValue(e, DUE_DATE));
			    			today_map.put(DUE_DATE_TIME, parser.getValue(e, DUE_DATE_TIME));
			    			today_map.put(DESCCRIPTION, parser.getValue(e, DESCCRIPTION));
			    			today_map.put(AUTHOR, parser.getValue(e, AUTHOR));	   
			    			today_items.add(today_map);
	    					
	    			}else if(currentYear == homeworkYear && currentMonth == homeworkMonth && (currentDay+1) == homeworkDay){
	    					HashMap<String, String> tomorrow_map = new HashMap<String, String>();
			    			tomorrow_map.put(HOMEWORK_ID, parser.getValue(e, HOMEWORK_ID));
			    			tomorrow_map.put(TITLE, parser.getValue(e, TITLE));
			    			tomorrow_map.put(DUE_DATE, parser.getValue(e, DUE_DATE));
			    			tomorrow_map.put(DUE_DATE_TIME, parser.getValue(e, DUE_DATE_TIME));
			    			tomorrow_map.put(DESCCRIPTION, parser.getValue(e, DESCCRIPTION));
			    			tomorrow_map.put(AUTHOR, parser.getValue(e, AUTHOR));
			    			tomorrow_items.add(tomorrow_map);
	    				

	    			}else{
	    				HashMap<String, String> later_map = new HashMap<String, String>();
		    			later_map.put(HOMEWORK_ID, parser.getValue(e, HOMEWORK_ID));
		    			later_map.put(TITLE, parser.getValue(e, TITLE));
		    			later_map.put(DUE_DATE, parser.getValue(e, DUE_DATE));
		    			later_map.put(DUE_DATE_TIME, parser.getValue(e, DUE_DATE_TIME));
		    			later_map.put(DESCCRIPTION, parser.getValue(e, DESCCRIPTION));
		    			later_map.put(AUTHOR, parser.getValue(e, AUTHOR));	
		    			later_items.add(later_map);
	    			}
	    		}
	    		
	    		
	    		// looping through all item nodes <homework>
	/*    		for (int i = 0; i < nl.getLength(); i++) {
	    			// creating new HashMap
	    			
	    			
	    			
	    			
	    			Element e = (Element) nl.item(i);
	    			// adding each child node to HashMap key => value
	    			Date date1 = sdf.parse(parser.getValue(e, DUE_DATE));
	    			String homeworkDate = parser.getValue(e, DUE_DATE);
	    			String[] separateDate = homeworkDate.split("-");
	    			int homeworkYear = Integer.parseInt(separateDate[0]);
	    			int homeworkMonth = Integer.parseInt(separateDate[1]);
	    			int homeworkDay = Integer.parseInt(separateDate[2]);
	    			
	    			
	    			if(currentYear == homeworkYear && currentMonth == homeworkMonth && currentDay == homeworkDay){
	    				
	    					HashMap<String, String> today_map = new HashMap<String, String>();
			    			today_map.put(HOMEWORK_ID, parser.getValue(e, HOMEWORK_ID));
			    			today_map.put(TITLE, parser.getValue(e, TITLE));
			    			today_map.put(DUE_DATE, parser.getValue(e, DUE_DATE));
			    			today_map.put(DUE_DATE_TIME, parser.getValue(e, DUE_DATE_TIME));
			    			today_map.put(DESCCRIPTION, parser.getValue(e, DESCCRIPTION));
			    			today_map.put(AUTHOR, parser.getValue(e, AUTHOR));	   
			    			today_items.add(today_map);
	    					
	    			}else if(currentYear == homeworkYear && currentMonth == homeworkMonth && (currentDay+1) == homeworkDay){
	    					HashMap<String, String> tomorrow_map = new HashMap<String, String>();
			    			tomorrow_map.put(HOMEWORK_ID, parser.getValue(e, HOMEWORK_ID));
			    			tomorrow_map.put(TITLE, parser.getValue(e, TITLE));
			    			tomorrow_map.put(DUE_DATE, parser.getValue(e, DUE_DATE));
			    			tomorrow_map.put(DUE_DATE_TIME, parser.getValue(e, DUE_DATE_TIME));
			    			tomorrow_map.put(DESCCRIPTION, parser.getValue(e, DESCCRIPTION));
			    			tomorrow_map.put(AUTHOR, parser.getValue(e, AUTHOR));
			    			tomorrow_items.add(tomorrow_map);
	    				

	    			}else{
	    				HashMap<String, String> later_map = new HashMap<String, String>();
		    			later_map.put(HOMEWORK_ID, parser.getValue(e, HOMEWORK_ID));
		    			later_map.put(TITLE, parser.getValue(e, TITLE));
		    			later_map.put(DUE_DATE, parser.getValue(e, DUE_DATE));
		    			later_map.put(DUE_DATE_TIME, parser.getValue(e, DUE_DATE_TIME));
		    			later_map.put(DESCCRIPTION, parser.getValue(e, DESCCRIPTION));
		    			later_map.put(AUTHOR, parser.getValue(e, AUTHOR));	
		    			later_items.add(later_map);
	    			}
	    			}*/
	    			
		    //     TextView t = (TextView) this.mainActivity.findViewById(R.id.today_header);
		    //     t.setText("Today");
		    //     TextView s = (TextView) this.mainActivity.findViewById(R.id.today_total);
		    //     s.setText("4");
	    	//	((XmlFetchListener) mainActivity).updateUI();
	    		
		         updateUI();
		         
		         
		         
		         
		         
	        }
	        
	        
	        
	        public ArrayList<HashMap<String, String>> getXml(){	        	
	        	return  menuItems;
	        }
	        
	        
	        public void updateUI(){
	        	
	        	TextView today_header = (TextView) this.mainActivity.findViewById(R.id.today_header);
	        	TextView tomorrow_header = (TextView) this.mainActivity.findViewById(R.id.tomorrow_header);
	        	TextView later_header = (TextView) this.mainActivity.findViewById(R.id.later_header);
	        	
	        	TextView today_total = (TextView) this.mainActivity.findViewById(R.id.today_total);
	        	TextView tomorrow_total = (TextView) this.mainActivity.findViewById(R.id.tomorrow_total);
	        	TextView later_total = (TextView) this.mainActivity.findViewById(R.id.later_total);
	        	
	        	ListView today_list = (ListView) this.mainActivity.findViewById(R.id.today_item_listview);
	        	ListView tomorrow_list = (ListView) this.mainActivity.findViewById(R.id.tomorrow_item_listview);
	        	ListView later_list = (ListView) this.mainActivity.findViewById(R.id.later_item_listview);
	        	
	    		ListAdapter today_adapter = new SimpleAdapter(this.mainActivity, today_items,R.layout.list_item,
	    				new String[] {TITLE}, new int[] {
	    						R.id.title});
	    		ListAdapter tomorrow_adapter = new SimpleAdapter(this.mainActivity, tomorrow_items,R.layout.list_item,
	    				new String[] {TITLE}, new int[] {
	    						R.id.title});
	    		ListAdapter later_adapter = new SimpleAdapter(this.mainActivity, later_items,R.layout.list_item,
	    				new String[] {TITLE}, new int[] {
	    						R.id.title});
	    		
	    		//ListView today_items = (ListView) this.mainActivity.findViewById(R.id.today_item_listview);
	    		today_list.setAdapter(today_adapter);
	    		today_list.setOnItemClickListener((OnItemClickListener) new MyItemClickListener(this.mainActivity,today_items));
	    		today_header.setText(R.string.today);
	    		today_total.setText("("+today_items.size()+")");
	    		
	    		tomorrow_list.setAdapter(tomorrow_adapter);
	    		tomorrow_list.setOnItemClickListener((OnItemClickListener) new MyItemClickListener(this.mainActivity,tomorrow_items));
	    		tomorrow_header.setText(R.string.tomorrow);
	    		tomorrow_total.setText("("+tomorrow_items.size()+")");
	    		
	    		 later_list.setAdapter( later_adapter);
	    		 later_list.setOnItemClickListener((OnItemClickListener) new MyItemClickListener(this.mainActivity, later_items));
	    		 later_header.setText(R.string.later);
	    		 later_total.setText("("+ later_items.size()+")");
	        	
    		today_header.setOnClickListener(new MyTitleClickListener(this.mainActivity)) ;
    		tomorrow_header.setOnClickListener(new MyTitleClickListener(this.mainActivity)) ;
    		later_header.setOnClickListener(new MyTitleClickListener(this.mainActivity)) ;
	        }

}
