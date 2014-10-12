package com.BitWyze.polarionlive2014;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.parse.ParseObject;
import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseUser;

@ParseClassName("Agenda")
public class Agenda extends ParseObject {
	static SimpleDateFormat dateFormat;
	
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
	
	public String getDescription() {
		return getString("description");
	}
	
	public String getIcon() {
		return getString("icon");
	}
	
	public String getSpeakers() {
		return getString("presenter");
	}
	
	public String getTime() {
		if (dateFormat == null) {
			dateFormat = new SimpleDateFormat("hh:mm",java.util.Locale.getDefault());
		}
		String timeStr = "";
		Date start = getDate("start");
		Date end = getDate("end");
		if (start != null) {
			timeStr = dateFormat.format(start);
		}
		if (end != null) {
			timeStr += " - " + dateFormat.format(end);
		}
		return timeStr;
	}
}
