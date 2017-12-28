package com.android.amlich;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btXemNgay, btChuyenNgay, btXemsao,btghichu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("Lịch Vạn Niên");

		btXemNgay = (Button) findViewById(R.id.bt_xemngay);
		btXemNgay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentXemNgay = new Intent(MainActivity.this,
						xemngay.class);
				intentXemNgay.putExtra("mode", "0");
				startActivity(intentXemNgay);
			}
		});
		btChuyenNgay = (Button) findViewById(R.id.bt_chuyenngay);
		btChuyenNgay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentChuyenNgay = new Intent(MainActivity.this,
						chuyenngay.class);
				startActivity(intentChuyenNgay);
			}
		});

		btXemsao = (Button) findViewById(R.id.bt_xemsao);
		btXemsao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentxemsao = new Intent(MainActivity.this,
						xemsao.class);
				startActivity(intentxemsao);
			}
		});
		
		btghichu = (Button) findViewById(R.id.btnMainGhiChu);
		btghichu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentnote = new Intent(MainActivity.this,
						GhiChu.class);
				intentnote.putExtra("mode", "0");
				startActivity(intentnote);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		new MenuInflater(this).inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.opcalendar) {
			startActivity(new Intent(MainActivity.this,
					CustomCalendarView.class));
		} else if (item.getItemId() == R.id.opMakeNote2) {
			Intent intent = new Intent(MainActivity.this, GhiChu.class);
			intent.putExtra("mode", "0");
			startActivity(intent);
		} else if (item.getItemId() == R.id.op_main_about) {
			Intent intent = new Intent(MainActivity.this, About.class);

			startActivity(intent);
		} else if (item.getItemId() == R.id.op_main_chuyenngay) {
			Intent intent = new Intent(MainActivity.this, chuyenngay.class);

			startActivity(intent);
		} else if (item.getItemId() == R.id.opmainsaochieumenh) {
			Intent intent = new Intent(MainActivity.this, xemsao.class);

			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

}
