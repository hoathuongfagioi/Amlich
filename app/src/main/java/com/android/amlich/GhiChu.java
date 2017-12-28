package com.android.amlich;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Class xử lý nghiệp vụ
 * 
 * @author drthanh
 * 
 */
public class GhiChu extends Activity {
	Cursor model = null;
	NoteAdapter adapter = null;
	NoteHelper helper = null;
	TextView txtDate, txtTime;
	EditText editNd;
	Button btnDate, btnTime, btnAdd;
	boolean isAdd = true;
	static String idSelected = "";
	static int rowIdSave = 0;
	ListView lvCv;
	Calendar cal;
	Date dateFinish;
	Date hourFinish;
	private int changeMode = 0;
	private Intent layDateTimeCus = null;
	static String luuVet = "";
	static int possition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ghi_chu);
		setTitle("Lịch Vạn Niên:Ghi Chú");
		helper = new NoteHelper(this);
		getFormWidgets();

		layDateTimeCus = getIntent();
		changeMode = Integer.parseInt(layDateTimeCus.getStringExtra("mode"));
		if (changeMode == 0) {
			getDefaultInfor();
		} else if (changeMode == 1) {
			// lấy ngày hiện tại của hệ thống
			int year = Integer.parseInt(layDateTimeCus.getStringExtra("year")) - 1900;
			int month = Integer
					.parseInt(layDateTimeCus.getStringExtra("month")) - 1;
			int day = Integer.parseInt(layDateTimeCus.getStringExtra("day"));
			Date date = new Date(year, month, day, 0, 0);
			// cal.set(year, month, day, 0, 0);

			SimpleDateFormat dft = null;
			// Định dạng ngày / tháng /năm
			dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
			String strDate = dft.format(date);
			// hiển thị lên giao diện
			txtDate.setText(strDate);
			// Định dạng giờ phút am/pm
			dft = new SimpleDateFormat("hh:mm a", Locale.getDefault());
			String strTime = dft.format(date);
			// đưa lên giao diện
			txtTime.setText(strTime);
			// lấy giờ theo 24 để lập trình theo Tag
			dft = new SimpleDateFormat("HH:mm", Locale.getDefault());
			txtTime.setTag(dft.format(date));

			editNd.requestFocus();
			// gán cal.getTime() cho ngày hoàn thành và giờ hoàn thành
			dateFinish = date;
			hourFinish = date;
		}

		addEventFormWidgets();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		helper.close();
	}

	private void getCustomInfo() {

	}

	/**
	 * hàm dùng để load các control theo Id
	 */
	public void getFormWidgets() {
		txtDate = (TextView) findViewById(R.id.showDate);
		txtTime = (TextView) findViewById(R.id.showTimeOfDate);
		// editCv = (EditText) findViewById(R.id.TieuDe);
		editNd = (EditText) findViewById(R.id.editGhiChu);
		editNd.setText("");
		btnDate = (Button) findViewById(R.id.pickDate);
		btnTime = (Button) findViewById(R.id.pickTimeOfDate);
		btnAdd = (Button) findViewById(R.id.addNote);
		lvCv = (ListView) findViewById(R.id.listNote);
		// // Gán DataSource vào ArrayAdapter
		// adapter = new ArrayAdapter<NoteGhiChu>(this,
		// android.R.layout.simple_list_item_1, arrGhiChu);
		// // gán Adapter vào ListView
		// lvCv.setAdapter(adapter);
		model = helper.getAll();
		startManagingCursor(model);
		adapter = new NoteAdapter(model);
		lvCv.setAdapter(adapter);
	}

	/**
	 * Hàm lấy các thông số mặc định khi lần đầu tiền chạy ứng dụng
	 */
	public void getDefaultInfor() {
		// lấy ngày hiện tại của hệ thống
		cal = Calendar.getInstance();
		SimpleDateFormat dft = null;
		// Định dạng ngày / tháng /năm
		dft = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
		String strDate = dft.format(cal.getTime());
		// hiển thị lên giao diện
		txtDate.setText(strDate);
		// Định dạng giờ phút am/pm
		dft = new SimpleDateFormat("hh:mm a", Locale.getDefault());
		String strTime = dft.format(cal.getTime());
		// đưa lên giao diện
		txtTime.setText(strTime);
		// lấy giờ theo 24 để lập trình theo Tag
		dft = new SimpleDateFormat("HH:mm", Locale.getDefault());
		txtTime.setTag(dft.format(cal.getTime()));

		editNd.requestFocus();
		// gán cal.getTime() cho ngày hoàn thành và giờ hoàn thành
		dateFinish = cal.getTime();
		hourFinish = cal.getTime();
	}

	public void addEventFormWidgets() {
		btnDate.setOnClickListener(new MyButtonEvent());
		btnTime.setOnClickListener(new MyButtonEvent());
		btnAdd.setOnClickListener(new MyButtonEvent());
		lvCv.setOnItemClickListener(new MyListViewEvent());
		lvCv.setOnItemLongClickListener(new MyListViewEvent());
	}

	private class MyButtonEvent implements OnClickListener {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.pickDate:
				showDatePickerDialog();
				break;
			case R.id.pickTimeOfDate:
				showTimePickerDialog();
				break;
			case R.id.addNote:
				processAddGhiChu();
				break;
			}
		}

	}

	private class MyListViewEvent implements OnItemClickListener,
			OnItemLongClickListener {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long arg3) {
			model.moveToPosition(arg2);
			helper.deleteNote(helper.getId(model));
			model.requery();
			editNd.setText("");
			isAdd = true;
			btnAdd.setText("Thêm Ghi Chú");
			return false;
		}

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			model.moveToPosition(arg2);
			possition = arg2;
			isAdd = false;
			editNd.setText(helper.getName(model));
			txtDate.setText(helper.getDate(model));
			txtTime.setText(helper.getTime(model));
			idSelected = String.valueOf(arg2);
			rowIdSave = arg2;
			btnAdd.setText("Sửa Ghi Chú");
		}

	}

	// ================================xử lý lấy thời
	// gian=============================================
	public void showDatePickerDialog() {
		OnDateSetListener callback = new OnDateSetListener() {
			public void onDateSet(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// Mỗi lần thay đổi ngày tháng năm thì cập nhật lại TextView
				// Date
				txtDate.setText((dayOfMonth) + "/" + (monthOfYear + 1) + "/"
						+ year);
				// Lưu vết lại biến ngày hoàn thành
				cal.set(year, monthOfYear, dayOfMonth);
				dateFinish = cal.getTime();
			}
		};
		// các lệnh dưới này xử lý ngày giờ trong DatePickerDialog
		// sẽ giống với trên TextView khi mở nó lên
		String s = txtDate.getText() + "";
		String strArrtmp[] = s.split("/");
		int ngay = Integer.parseInt(strArrtmp[0]);
		int thang = Integer.parseInt(strArrtmp[1]) - 1;
		int nam = Integer.parseInt(strArrtmp[2]);
		DatePickerDialog pic = new DatePickerDialog(GhiChu.this, callback, nam,
				thang, ngay);
		pic.setTitle("Chọn ngày hoàn thành");
		pic.show();
	}

	public void showTimePickerDialog() {
		OnTimeSetListener callback = new OnTimeSetListener() {
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				// Xử lý lưu giờ và AM,PM
				String s = hourOfDay + ":" + minute;
				int hourTam = hourOfDay;
				if (hourTam > 12)
					hourTam = hourTam - 12;
				txtTime.setText(hourTam + ":" + minute
						+ (hourOfDay > 12 ? " PM" : " AM"));
				// lưu giờ thực vào tag
				txtTime.setTag(s);
				// lưu vết lại giờ vào hourFinish
				cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
				cal.set(Calendar.MINUTE, minute);
				hourFinish = cal.getTime();
			}
		};
		// các lệnh dưới này xử lý ngày giờ trong TimePickerDialog
		// sẽ giống với trên TextView khi mở nó lên
		String s = txtTime.getTag() + "";
		String strArr[] = s.split(":");
		int gio = Integer.parseInt(strArr[0]);
		int phut = Integer.parseInt(strArr[1]);
		TimePickerDialog time = new TimePickerDialog(GhiChu.this, callback,
				gio, phut, true);
		time.setTitle("Chọn giờ hoàn thành");
		time.show();
	}

	// ======================xử lý sự kiện thêm hoặc chỉnh sửa ghi
	// chú================================
	// chú===========================================
	public void processAddGhiChu() {
try{
		if (!editNd.getText().toString().equalsIgnoreCase("")) {
			if (isAdd == true) {
				Calendar cacl = Calendar.getInstance();
				SimpleDateFormat dft = null;
				// Định dạng ngày / tháng /năm
				dft = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
				String strDate1 = dft.format(cacl.getTime());
				
				String idc = "";
				if (strDate1.equals(luuVet)) {
					idc = strDate1 + "0";
				} else {
					idc = strDate1;
				}
				String description = editNd.getText().toString().trim();
				Note job = new Note(idc, description, dateFinish, hourFinish);

				helper.insert(job.getIdNote(), job.getDesciption(),
						job.getDateFormat(job.getDateFinish()),
						job.getHourFormat(job.getHourFinish()));
				luuVet = idc;
				model.requery();
				editNd.setText("");
				editNd.requestFocus();

			}
			if (isAdd == false && btnAdd.getText() == "Sửa Ghi Chú") {
				model.moveToPosition(possition);
				// Note temp = new
				// Note(helper.getId(model),helper.getName(model),getDateFormat(helper.getDate(model)),getHourFormat(helper.getTime(model)));
				Note temp = new Note();
				temp.setIdNote(helper.getId(model));
				temp.setDesciption(editNd.getText().toString().trim());
				temp.setDateFinish(dateFinish);
				temp.setHourFinish(hourFinish);

				helper.updateOne(temp, temp.getIdNote());
				model.requery();
				btnAdd.setText("Thêm Ghi Chú");
				isAdd = true;
				editNd.setText("");
				editNd.requestFocus();
			}
		} } catch(Exception e){
			
		}

	}

	// =========================adapter sử dụng cho ListView Ghi
	// chú===================================================
	class NoteAdapter extends CursorAdapter {
		@SuppressWarnings("deprecation")
		NoteAdapter(Cursor c) {
			super(GhiChu.this, c);
		}

		@Override
		public void bindView(View row, Context ctxt, Cursor c) {
			NoteHolder holder = (NoteHolder) row.getTag();

			holder.populateFrom(c, helper);
		}

		@Override
		public View newView(Context ctxt, Cursor c, ViewGroup parent) {
			LayoutInflater inflater = getLayoutInflater();
			View row = inflater.inflate(R.layout.row, parent, false);
			NoteHolder holder = new NoteHolder(row);

			row.setTag(holder);

			return (row);
		}
	}

	static class NoteHolder {
		private TextView tvname = null;
		private TextView tvdate = null;
		private TextView tvtime = null;

		NoteHolder(View row) {
			tvname = (TextView) row.findViewById(R.id.rownote);
			tvdate = (TextView) row.findViewById(R.id.rowdate);
			tvtime = (TextView) row.findViewById(R.id.rowtime);
		}

		void populateFrom(Cursor c, NoteHelper helper) {
			tvname.setText(helper.getName(c));
			tvdate.setText(helper.getDate(c));
			tvtime.setText(helper.getTime(c));

		}
	}

	public String getHourFormat2(Date d) {
		SimpleDateFormat dft = new SimpleDateFormat("hh:mm:ss",
				Locale.getDefault());
		return dft.format(d);
	}

	public String getDateFormat(Date d) {
		SimpleDateFormat dft = new SimpleDateFormat("dd/MM/yyyy",
				Locale.getDefault());
		return dft.format(d);
	}

	public String getHourFormat(Date d) {
		SimpleDateFormat dft = new SimpleDateFormat("hh:mm a",
				Locale.getDefault());
		return dft.format(d);
	}
}
