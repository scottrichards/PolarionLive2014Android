package com.BitWyze.polarionlive2014;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

public class RaffleContactActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.raffle_contact_view);
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
