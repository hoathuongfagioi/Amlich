package com.android.amlich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class CustomCalendarView extends Activity {
	CalendarView calendar;
	static int customday = 0;
	static int custommonth = 0;
	static int customyear = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.calendar_activity);
		super.onCreate(savedInstanceState);
		setTitle("Lịch Vạn Niên:Lịch Tháng");
		calendar = (CalendarView) findViewById(R.id.calendar1);
		calendar.setOnDateChangeListener(new OnDateChangeListener() {

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				customday = dayOfMonth;
				custommonth = month + 1;
				customyear = year;
				CustomCalendarView.this.openOptionsMenu();

			}
		});
		calendar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.op_calendar, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.opDetailCalendar) {
			Intent i = new Intent(CustomCalendarView.this, xemngay.class);
			i.putExtra("mode", "1");
			i.putExtra("day", String.valueOf(customday));
			i.putExtra("month", String.valueOf(custommonth));
			i.putExtra("year", String.valueOf(customyear));
			startActivity(i);

		} else if (item.getItemId() == R.id.opMakeNote) {
			Intent j = new Intent(CustomCalendarView.this, GhiChu.class);
			j.putExtra("mode", "1");
			j.putExtra("day", String.valueOf(customday));
			j.putExtra("month", String.valueOf(custommonth));
			j.putExtra("year", String.valueOf(customyear));
			startActivity(j);
		}
		return super.onOptionsItemSelected(item);
	}

}
