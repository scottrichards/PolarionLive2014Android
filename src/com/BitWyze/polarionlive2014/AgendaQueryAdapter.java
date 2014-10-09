package com.BitWyze.polarionlive2014;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import android.R.string;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;



public class AgendaQueryAdapter extends ParseQueryAdapter<Agenda> {

	public AgendaQueryAdapter(Context context) {
		super(context, new ParseQueryAdapter.QueryFactory<Agenda>() {
			public ParseQuery<Agenda> create() {
				// Here we can configure a ParseQuery to display
				// only top-rated meals.
				ParseQuery query = new ParseQuery("Agenda");
				query.orderByAscending("start");
				return query;
			}
		});
	}

	@Override
	public View getItemView(Agenda agendaItem, View v, ViewGroup parent) {

		if (v == null) {
			v = View.inflate(getContext(), R.layout.agenda_list_session, null);
		}

		super.getItemView(agendaItem, v, parent);

//		ParseImageView iconImage = (ParseImageView) v.findViewById(R.id.icon);
	
		TextView sessionNameView = (TextView) v.findViewById(R.id.session_name);
		sessionNameView.setText(agendaItem.getSession());
		TextView locationView = (TextView) v
				.findViewById(R.id.location);
		locationView.setText(agendaItem.getLocation());
		TextView timeView = (TextView) v
				.findViewById(R.id.time);
		timeView.setText(getSessionTime(agendaItem));
		return v;
	}
	
	public String getSessionTime(Agenda session) {
		Date start = session.getDate("start");
		Date end = session.getDate("end");
		SimpleDateFormat df = new SimpleDateFormat("hh:mm");
		String startTime = "", endTime = "";
		if (start != null)
			startTime = df.format(start);
		if (end != null)
			endTime = df.format(end);
		String time = startTime + " - " + endTime;
		return time;
	}
}
