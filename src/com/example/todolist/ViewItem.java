package com.example.todolist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewItem extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_item);
		
		
		TextView text = (TextView) findViewById(R.id.text);
		/*Button set = (Button) findViewById(R.id.set_button);
		
		
		set.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});*/
		
	}
}
