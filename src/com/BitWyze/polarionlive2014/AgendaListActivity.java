package com.BitWyze.polarionlive2014;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQueryAdapter;



import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AgendaListActivity extends ListActivity {
	private AgendaQueryAdapter agendaQueryAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getListView().setClickable(false);

		agendaQueryAdapter = new AgendaQueryAdapter(this);
		agendaQueryAdapter.setTextKey("session");
		// Default view is all meals
		setListAdapter(agendaQueryAdapter);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState){

	    super.onPostCreate(savedInstanceState);
	}
}
