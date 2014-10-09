package com.BitWyze.polarionlive2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
				startActivity(new Intent(getBaseContext(),RaffleContactActivity.class));
			}
		});
	}
}
