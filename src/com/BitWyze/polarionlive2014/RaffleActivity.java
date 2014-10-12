package com.BitWyze.polarionlive2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RaffleActivity extends Activity {

	private OnClickListener handleClick = new OnClickListener(){
	    public void onClick(View arg0) {
	        Button btn = (Button)arg0;
	        startActivity(new Intent());
	    }
	};

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.raffle_view);
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				
				Intent raffleContactIntent = new Intent(getBaseContext(),RaffleContactActivity.class);
				TextView textView = (TextView)findViewById(R.id.testimonial_text);
				String testimonialText = textView.getText().toString();
				if (testimonialText.length() == 0) {
					Toast.makeText(RaffleActivity.this, "Please provide a testimonial to enter the raffle",
							Toast.LENGTH_LONG).show();
				} else {
					raffleContactIntent.putExtra("TESTIMONIAL_TEXT",testimonialText);
					startActivity(raffleContactIntent);
				}
			}
		});
	}
}
