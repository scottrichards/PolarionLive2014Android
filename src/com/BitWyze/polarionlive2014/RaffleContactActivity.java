package com.BitWyze.polarionlive2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RaffleContactActivity extends Activity {
	private String testimonial;
	
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
