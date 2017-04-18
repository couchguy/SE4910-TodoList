package com.example.todolist;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class DueDate extends Activity {
	int mYear;
	int mMonth;
	int mDay;
	int mHour;
	int mMinute;
	static final int DATE_DIALOG_ID = 0;
	static final int TIME_DIALOG_ID = 1;
	Button set;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.due_date);
		
		set = (Button) findViewById(R.id.set_button);
		
		
		
		set.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener = 
			new DatePickerDialog.OnDateSetListener() {
					
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				
					mYear = year;
					mMonth = monthOfYear;
					mDay = dayOfMonth;	
					
				}
		};
		
		private TimePickerDialog.OnTimeSetListener mTimeSetListener = 
			new TimePickerDialog.OnTimeSetListener() {
					
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					mHour = hourOfDay;
					mMinute = minute;						
				}
		};
		
		@Override
		protected Dialog onCreateDialog(int id) {
			switch (id) {
				case TIME_DIALOG_ID:
					return new TimePickerDialog(getParent(), 
						mTimeSetListener, mHour, mMinute, false);
				case DATE_DIALOG_ID:
					return new DatePickerDialog(getParent(),
						mDateSetListener,
						mYear, mMonth, mDay);
			}

			return null;
		}
}
