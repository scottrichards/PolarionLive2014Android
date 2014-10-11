package com.BitWyze.polarionlive2014;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class SessionDetailsActivity extends Activity {

	private Agenda sessionItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.session_details_view);
		Bundle extras = getIntent().getExtras();
		String sessionName = extras.getString("SESSION_NAME");
		String description = extras.getString("SESSION_DESCRIPTION");
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
	}
}
