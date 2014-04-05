package fi.metropolia.fourhomework;

import fi.metropolia.fourhomework.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleMenuItemActivity  extends Activity {
	
	// XML node keys
	static final String KEY_NAME = "name";
	static final String KEY_COST = "cost";
	static final String KEY_DESC = "description";
	
	static final String HOMEWORK = "homework" ;
	static final String HOMEWORK_ID ="homework_id";
	static final String TITLE = "title";
	static final String DUE_DATE = "due_date";
	static final String DESCCRIPTION = "description";
	static final String AUTHOR = "author";
	
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get XML values from previous intent
        String title = in.getStringExtra(TITLE);
        String due_date = in.getStringExtra(DUE_DATE);
        String desc = in.getStringExtra(DESCCRIPTION);
        String author = in.getStringExtra(AUTHOR);
        // Displaying all values on the screen
        TextView sTitle = (TextView) findViewById(R.id.single_title);
        TextView sDue = (TextView) findViewById(R.id.single_due);
        TextView sDesc = (TextView) findViewById(R.id.single_desc);
        TextView sAuthor = (TextView) findViewById(R.id.single_author);
        
        sTitle.setText(title);
        sDue.setText(due_date);
        sDesc.setText(desc);
        sAuthor.setText(author);
    }
}
