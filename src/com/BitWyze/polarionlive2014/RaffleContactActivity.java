package com.BitWyze.polarionlive2014;

import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.parse.ParseException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RaffleContactActivity extends Activity {
	private String testimonial;
	static String TAG = "RaffleContactActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.raffle_contact_view);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			testimonial = extras.getString("TESTIMONIAL_TEXT");
		}
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent mainActivityIntent = new Intent(getBaseContext(),MainActivity.class);
				ParseObject testimonialObject = new ParseObject("Testimonial");
				TextView nameView = (TextView)findViewById(R.id.name_text);
				TextView companyView = (TextView)findViewById(R.id.company_text);
				TextView titleView = (TextView)findViewById(R.id.title_text);
				TextView emailView = (TextView)findViewById(R.id.email_text);
				testimonialObject.put("company", companyView.getText().toString());
				testimonialObject.put("email", emailView.getText().toString());
				testimonialObject.put("name", nameView.getText().toString());
				testimonialObject.put("title", titleView.getText().toString());
				testimonialObject.put("tesimonial", testimonial);
				testimonialObject.saveInBackground(new SaveCallback() {
					@Override
					public void done(ParseException e) {
					
						if (e == null) {
							Log.d(TAG,"SUCCESS");
					     } else {
					    	 Log.d(TAG,"FAILURE"); 
					     }
					}
				});
				startActivity(mainActivityIntent);
			}
		});
		
		
	}
	
	 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.raffle_contact_menu, menu);
        return true;
    }
	 
	 // Move to the Raffle Contact Info Screen
	 public void onEnter() {
	 }
}
