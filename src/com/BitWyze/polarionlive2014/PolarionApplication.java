package com.BitWyze.polarionlive2014;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

import android.app.Application;
import android.util.Log;

public class PolarionApplication extends Application {
	private Agenda selectedSession;
	
	public void setSession(Agenda session) {
		selectedSession = session;
	}
	
	public Agenda getSession() {
		return selectedSession;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Log.d("PolarionLive2014Application","Created App");
	}
}
