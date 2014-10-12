package com.BitWyze.polarionlive2014;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQueryAdapter;



import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
		
		 
		
//	    ListView list = getListView();
//	    list.setOnItemLongClickListener(new OnItemLongClickListener() {
//
//	        @Override
//	        public boolean onItemLongClick(AdapterView<?> parent, View view,
//	            int position, long id) {
//	          Toast.makeText(AgendaListActivity.this,
//	              "Item in position " + position + " clicked",
//	              Toast.LENGTH_LONG).show();
//	          // Return true to consume the click event. In this case the
//	          // onListItemClick listener is not called anymore.
//	          return true;
//	        }
//	      });
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState){

	    super.onPostCreate(savedInstanceState);
	}
	
	 @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    super.onListItemClick(l, v, position, id);
	    // Get the item that was clicked
	    Agenda sessionInfo = (Agenda)this.getListAdapter().getItem(position);
	    Intent detailsIntent = new Intent(getBaseContext(),SessionDetailsActivity.class);
	    PolarionApplication application = (PolarionApplication) getApplication();
	    application.setSession(sessionInfo);
	    startActivity(detailsIntent);
	  }
}
