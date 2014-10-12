package com.BitWyze.polarionlive2014;

import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ExpertsActivity extends Activity implements OnItemSelectedListener {
	static String TAG = "ExpertsActivity";
	private EditText emailView;
	private TextView topicDescriptionView;
	private TextView expertsTextView;
	private Spinner topicSpinner;
	private List<ParseObject> expertsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.experts_view);
		findViewById(R.id.signUpButton).setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				postExpertsSignup();
				Intent mainActivityIntent = new Intent(getBaseContext(),MainActivity.class);
				startActivity(mainActivityIntent);
			}
		});
		emailView = (EditText)findViewById(R.id.emailField);
		topicDescriptionView = (TextView)findViewById(R.id.topicDescription);
		expertsTextView = (TextView)findViewById(R.id.expertsTextView);
		topicSpinner = (Spinner)findViewById(R.id.topicSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.experts_topics, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		topicSpinner.setAdapter(adapter);
		topicSpinner.setOnItemSelectedListener(this);
		getTopics();
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.experts, menu);
        return true;
    }
	
	 @Override
    public boolean onOptionsItemSelected(MenuItem item) 
	 {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
			case R.id.action_done: {
				postExpertsSignup();
				Intent mainActivityIntent = new Intent(getBaseContext(),MainActivity.class);
				startActivity(mainActivityIntent);
				break;
			}
		}
        
        return super.onOptionsItemSelected(item);
    }
	 
	private void getTopics() {
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Experts");
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> resultList, ParseException e) {
		        if (e == null) {
		        	expertsList = resultList;
		        	updateTopicData(0);
		            Log.d("score", "Retrieved " + resultList.size() + " scores");
		        } else {
		            Log.d("score", "Error: " + e.getMessage());
		        }
		    }
		});
	}
	
	private void updateTopicData(int pos) {
		if (expertsList != null && pos < expertsList.size()) {
			topicDescriptionView.setText(expertsList.get(pos).getString("description"));
			expertsTextView.setText(expertsList.get(pos).getString("expert"));
		}
	}
	
	
	private void postExpertsSignup() {
		 ParseObject expertSignup = new ParseObject("ExpertSignUp");
		 int selectedItem = topicSpinner.getSelectedItemPosition();
		 expertSignup.put("session", selectedItem);
		 String emailStr = emailView.getText().toString();
		 expertSignup.put("email", emailStr);
		 ParseUser currentUser = ParseUser.getCurrentUser();
		 expertSignup.put("user", currentUser);
		 expertSignup.saveInBackground(new SaveCallback() {
				@Override
				public void done(ParseException e) {				
					if (e == null) {
						Log.d(TAG,"SUCCESS");
				     } else {
				    	 Log.d(TAG,"FAILURE"); 
				     }
				}
			});
	}
	
	public void onItemSelected(AdapterView<?> parent, View view, 
            int pos, long id) {
		updateTopicData(pos);
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
