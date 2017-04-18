package com.example.todolist;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Inflate your View
				setContentView(R.layout.activity_main);
				
				//Get reference to UI Widgets
				ListView myListView = (ListView) findViewById(R.id.myListView);
				final EditText myEditText = (EditText) findViewById(R.id.myEditText);
			
				final ArrayList<String> todoItems = new ArrayList<String>();
				final ArrayAdapter<String> aa;
				aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, todoItems);
			
				//Bind the Array Adapter to the ListView
				myListView.setAdapter(aa);
				myListView.setOnItemClickListener(mOnListClick);
				
				myEditText.setOnKeyListener( new View.OnKeyListener() {
					public boolean onKey(View v, int keyCode, KeyEvent event) {
						if( event.getAction() == KeyEvent.ACTION_DOWN) {
							if( (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
									(keyCode == KeyEvent.KEYCODE_ENTER)) {
								todoItems.add(0, myEditText.getText().toString());
								aa.notifyDataSetChanged();
								myEditText.setText("");
								startActivity(new Intent("com.example.todolist.DueDate"));
								return true;
							}
						}
						return false;
					}
				});
	}
	
	private OnItemClickListener mOnListClick = new OnItemClickListener(){
		@Override
		public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
			
			
			startActivity(new Intent("com.example.todolist.ViewItem"));
		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
