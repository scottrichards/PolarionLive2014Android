package com.BitWyze.polarionlive2014;

import android.support.v7.app.ActionBarActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseException;
import com.BitWyze.polarionlive2014.AgendaQueryAdapter;

public class MainActivity extends ActionBarActivity {
	private AgendaQueryAdapter agendaQueryAdapter;
	private boolean isLoggedIn = false;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	ParseObject.registerSubclass(Agenda.class);
    	Parse.initialize(this, "eo7wLLlQekmYfJJ77gmXhQkTfFC3qK0OvKV8pFYK", "r7dROaatklYbtxk9sG8NhXjGJ63M00KnEEWbBaOx");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isLoggedIn) {
        	doLogin();
        }
    }


    public void doLogin() 
    {
    	ParseAnonymousUtils.logIn(new LogInCallback() {
    		
    		@Override
    		 public void done(ParseUser user, ParseException e) {
    		    if (e != null) {
    		      Log.d("MyApp", "Anonymous login failed.");
    		    } else {
    		    	isLoggedIn = true;
    		      Log.d("MyApp", "Anonymous user logged in.");
    		    }
    		  }
    		});
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

			case R.id.action_agenda: {
				startActivity(new Intent(this, AgendaListActivity.class));
				break;
			}
			case R.id.action_partners: {
				startActivity(new Intent(this, PartnerActivity.class));
				break;
			}
			case R.id.action_raffle: {
				startActivity(new Intent(this, RaffleActivity.class));
				break;
			}
	
		}
        
        return super.onOptionsItemSelected(item);
    }
    
}
