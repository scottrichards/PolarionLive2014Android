package com.BitWyze.polarionlive2014;

import com.parse.ParseObject;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseUser;

@ParseClassName("Agenda")
public class Agenda extends ParseObject {

	public Agenda() {
		// A default constructor is required.
	}
	
	public String getSession() {
		return getString("session");
	}

	public void setSession(String title) {
		put("session", title);
	}
	
	public String getLocation() {
		return getString("location");
	}

	public void setLocation(String location) {
		put("location", location);
	}
	
	public int getStart() {
		return getInt("start");
	}

	public void setStart(int location) {
		put("start", location);
	}
	
	public int getEnd() {
		return getInt("end");
	}

	public void setEnd(int location) {
		put("end", location);
	}
}
