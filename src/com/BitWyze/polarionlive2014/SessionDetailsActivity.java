package com.BitWyze.polarionlive2014;

import com.parse.ParseException;
import com.parse.ParseObject;
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
import android.widget.RatingBar;
import android.widget.TextView;

public class SessionDetailsActivity extends Activity {

	protected static final String TAG = "SessionDetailsActivity";
	private Agenda sessionItem;
	private RatingBar contentRatingBar;
	private RatingBar speakerRatingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.session_details_view);
		Bundle extras = getIntent().getExtras();
		TextView sessionNameView = (TextView)findViewById(R.id.session_name);
		TextView sessionDescriptionView = (TextView)findViewById(R.id.session_description);
		TextView sessionSpeakersView = (TextView)findViewById(R.id.session_speakers);
		TextView sessionTimeView = (TextView)findViewById(R.id.session_time);
		TextView sessionLocationView = (TextView)findViewById(R.id.session_location);
		PolarionApplication app = (PolarionApplication)getApplication();
		sessionItem = app.getSession();
		sessionNameView.setText(sessionItem.getSession());
		sessionDescriptionView.setText(sessionItem.getDescription());
		sessionSpeakersView.setText(sessionItem.getSpeakers());
		sessionTimeView.setText(sessionItem.getTime());
		sessionLocationView.setText(sessionItem.getLocation());
		contentRatingBar = (RatingBar)findViewById(R.id.contentRatingBar);
		speakerRatingBar = (RatingBar)findViewById(R.id.speakerRatingBar);
		contentRatingBar.setStepSize(1);
		speakerRatingBar.setStepSize(1);
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.session_details_menu, menu);
        return true;
    }
	
	 @Override
    public boolean onOptionsItemSelected(MenuItem item) 
	 {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

			case R.id.action_rate: {
				postRating();
				Intent mainActivityIntent = new Intent(getBaseContext(),MainActivity.class);
				startActivity(mainActivityIntent);
				break;
			}
		}
        
        return super.onOptionsItemSelected(item);
    }
	 
	private void postRating()
	{
		ParseObject sessionRating = new ParseObject("SessionRating");
		int contentRating = (int)contentRatingBar.getRating();
		int speakerRating = (int)speakerRatingBar.getRating();
		sessionRating.put("contentRating", contentRating);
		sessionRating.put("presenterRating", speakerRating);
		sessionRating.put("user",ParseUser.getCurrentUser());
		sessionRating.put("session",sessionItem);
		sessionRating.saveInBackground(new SaveCallback() {
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
}
