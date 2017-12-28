package com.android.amlich;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class xemngay extends Activity {
	Intent layngaycus = null;
	private static int changeMode = 0;
	private static int customDay = 0;
	private static int customMonth = 0;
	private static int customYear = 0;

	private TextView thongtin1, thongtin2,ngay,thang,thu2;

	private static int ngay1;

	private static int ngay2;

	private static int i,thu;
	static String al1,thu1,ngayht,thanght,thuht;
	static String hd;
	static String al2, gio;
	static String ngaycc1;

	static String ngaycc2;

	static String ngaycc3;
	static String ngayCC = null;
	static String canchi[] = { "Giáp Tý", "Ất Sửu", "Bính Dần", "Đinh Mão",
			"Mậu Thìn", "Kỷ Tỵ", "Canh Ngọ", "Tân Mùi", "Nhâm Thân", "Quý Dậu",
			"Giáp Tuất", "Ất Hợi", "Bính Tý", "Đinh Sửu", "Mậu Dần", "Kỷ Mão",
			"Canh Thìn", "Tân Tỵ", "Nhâm Ngọ", "Quý Mùi", "Giáp Thân",
			"Ất Dậu", "Bính Tuất", "Đinh Hợi", "Mậu Tý", "Kỷ Sửu", "Canh Dần",
			"Tân Mão", "Nhâm Thìn", "Quý Tỵ", "Giáp Ngọ", "Ất Mùi",
			"Bính Thân", "Đinh Dậu", "Mậu Tuất", "Kỷ Hợi", "Canh Tý",
			"Tân Sửu", "Nhâm Dần", "Quý Mão", "Giáp Thìn", "Ất Tỵ", "Bính Ngọ",
			"Đinh Mùi", "Mậu Thân", "Kỷ Dậu", "Canh Tuất", "Tân Hợi",
			"Nhâm Tý", "Quý Sửu", "Giáp Dần", "Ất Mão", "Bính Thìn", "Đinh Tỵ",
			"Mậu Ngọ", "Kỷ Mùi", "Canh Thân", "Tân Dậu", "Nhâm Tuất",
			"Quý Hợi", };

	// tinh ngay can chi

	public static String tinhngay2015(int d1, int m1, int y1) {
		ngay1 = chuyenngay.jdFromDate(1, 3, 2015);
		ngay2 = chuyenngay.jdFromDate(d1, m1, y1);
		int du = Math.abs((ngay2 - ngay1)) % 60;

		switch (du) {
		case 0:
			ngayCC = canchi[12];
			break;
		case 1:
			ngayCC = canchi[13];
			break;
		case 2:
			ngayCC = canchi[14];
			break;
		case 3:
			ngayCC = canchi[15];
			break;
		case 4:
			ngayCC = canchi[16];
			break;
		case 5:
			ngayCC = canchi[17];
			break;
		case 6:
			ngayCC = canchi[18];
			break;
		case 7:
			ngayCC = canchi[19];
			break;
		case 8:
			ngayCC = canchi[20];
			break;
		case 9:
			ngayCC = canchi[21];
			break;
		case 10:
			ngayCC = canchi[22];
			break;
		case 11:
			ngayCC = canchi[23];
			break;
		case 12:
			ngayCC = canchi[24];
			break;
		case 13:
			ngayCC = canchi[25];
			break;
		case 14:
			ngayCC = canchi[26];
			break;
		case 15:
			ngayCC = canchi[27];
			break;
		case 16:
			ngayCC = canchi[28];
			break;
		case 17:
			ngayCC = canchi[29];
			break;
		case 18:
			ngayCC = canchi[30];
			break;
		case 19:
			ngayCC = canchi[31];
			break;
		case 20:
			ngayCC = canchi[32];
			break;
		case 21:
			ngayCC = canchi[33];
			break;
		case 22:
			ngayCC = canchi[34];
			break;
		case 23:
			ngayCC = canchi[35];
			break;
		case 24:
			ngayCC = canchi[36];
			break;
		case 25:
			ngayCC = canchi[37];
			break;
		case 26:
			ngayCC = canchi[38];
			break;
		case 27:
			ngayCC = canchi[39];
			break;
		case 28:
			ngayCC = canchi[40];
			break;
		case 29:
			ngayCC = canchi[41];
			break;
		case 30:
			ngayCC = canchi[42];
			break;
		case 31:
			ngayCC = canchi[43];
			break;
		case 32:
			ngayCC = canchi[44];
			break;
		case 33:
			ngayCC = canchi[45];
			break;
		case 34:
			ngayCC = canchi[46];
			break;
		case 35:
			ngayCC = canchi[47];
			break;
		case 36:
			ngayCC = canchi[48];
			break;
		case 37:
			ngayCC = canchi[49];
			break;
		case 38:
			ngayCC = canchi[50];
			break;
		case 39:
			ngayCC = canchi[51];
			break;
		case 40:
			ngayCC = canchi[52];
			break;
		case 41:
			ngayCC = canchi[53];
			break;
		case 42:
			ngayCC = canchi[54];
			break;
		case 43:
			ngayCC = canchi[55];
			break;
		case 44:
			ngayCC = canchi[56];
			break;
		case 45:
			ngayCC = canchi[57];
			break;
		case 46:
			ngayCC = canchi[58];
			break;
		case 47:
			ngayCC = canchi[59];
			break;
		case 48:
			ngayCC = canchi[0];
			break;
		case 49:
			ngayCC = canchi[1];
			break;
		case 50:
			ngayCC = canchi[2];
			break;
		case 51:
			ngayCC = canchi[3];
			break;
		case 52:
			ngayCC = canchi[4];
			break;
		case 53:
			ngayCC = canchi[5];
			break;
		case 54:
			ngayCC = canchi[6];
			break;
		case 55:
			ngayCC = canchi[7];
			break;
		case 56:
			ngayCC = canchi[8];
			break;
		case 57:
			ngayCC = canchi[9];
			break;
		case 58:
			ngayCC = canchi[10];
			break;
		case 59:
			ngayCC = canchi[11];
			break;

		}
		ngaycc2 = "Ngày " + ngayCC;
		return ngaycc2;
	}

	public static String tinhngayother(int d2, int m2, int y2) {
		int hieu2 = chuyenngay.jdFromDate(d2, m2, y2)
				- chuyenngay.jdFromDate(1, 3, 2015);
		if (hieu2 <= 360 && hieu2 >= 0) {
			return tinhngay2015(d2, m2, y2);
		} else {
			int hieu1 = Math.abs(2015 - y2);
			if (y2 < 2015) {
				i = 12 - (hieu1 - (int) (hieu1 / 4)) * 5 - (int) (hieu1 / 4)
						* 6;
				while (i < 0) {
					i = i + 60;
				}

			} else {
				i = 12 + (1 + (int) (hieu1 / 4)) * 6
						+ (hieu1 - (int) (hieu1 / 4) - 1) * 5;
				while (i > 60) {
					i = i - 60;
				}
			}

			ngay1 = chuyenngay.jdFromDate(1, 3, y2);
			ngay2 = chuyenngay.jdFromDate(d2, m2, y2);
			int du = Math.abs((ngay2 - ngay1)) % 60;

			switch (du) {
			case 0:
				ngayCC = canchi[i % 60];
				break;
			case 1:
				ngayCC = canchi[(i + 1) % 60];
				break;
			case 2:
				ngayCC = canchi[(i + 2) % 60];
				break;
			case 3:
				ngayCC = canchi[(i + 3) % 60];
				break;
			case 4:
				ngayCC = canchi[(i + 4) % 60];
				break;
			case 5:
				ngayCC = canchi[(i + 5) % 60];
				break;
			case 6:
				ngayCC = canchi[(i + 6) % 60];
				break;
			case 7:
				ngayCC = canchi[(i + 7) % 60];
				break;
			case 8:
				ngayCC = canchi[(i + 8) % 60];
				break;
			case 9:
				ngayCC = canchi[(i + 9) % 60];
				break;
			case 10:
				ngayCC = canchi[(i + 10) % 60];
				break;
			case 11:
				ngayCC = canchi[(i + 11) % 60];
				break;
			case 12:
				ngayCC = canchi[(i + 12) % 60];
				break;
			case 13:
				ngayCC = canchi[(i + 13) % 60];
				break;
			case 14:
				ngayCC = canchi[(i + 14) % 60];
				break;
			case 15:
				ngayCC = canchi[(i + 15) % 60];
				break;
			case 16:
				ngayCC = canchi[(i + 16) % 60];
				break;
			case 17:
				ngayCC = canchi[(i + 17) % 60];
				break;
			case 18:
				ngayCC = canchi[(i + 18) % 60];
				break;
			case 19:
				ngayCC = canchi[(i + 19) % 60];
				break;
			case 20:
				ngayCC = canchi[(i + 20) % 60];
				break;
			case 21:
				ngayCC = canchi[(i + 21) % 60];
				break;
			case 22:
				ngayCC = canchi[(i + 22) % 60];
				break;
			case 23:
				ngayCC = canchi[(i + 23) % 60];
				break;
			case 24:
				ngayCC = canchi[(i + 24) % 60];
				break;
			case 25:
				ngayCC = canchi[(i + 25) % 60];
				break;
			case 26:
				ngayCC = canchi[(i + 26) % 60];
				break;
			case 27:
				ngayCC = canchi[(i + 27) % 60];
				break;
			case 28:
				ngayCC = canchi[(i + 28) % 60];
				break;
			case 29:
				ngayCC = canchi[(i + 29) % 60];
				break;
			case 30:
				ngayCC = canchi[(i + 30) % 60];
				break;
			case 31:
				ngayCC = canchi[(i + 31) % 60];
				break;
			case 32:
				ngayCC = canchi[(i + 32) % 60];
				break;
			case 33:
				ngayCC = canchi[(i + 33) % 60];
				break;
			case 34:
				ngayCC = canchi[(i + 34) % 60];
				break;
			case 35:
				ngayCC = canchi[(i + 35) % 60];
				break;
			case 36:
				ngayCC = canchi[(i + 36) % 60];
				break;
			case 37:
				ngayCC = canchi[(i + 37) % 60];
				break;
			case 38:
				ngayCC = canchi[(i + 38) % 60];
				break;
			case 39:
				ngayCC = canchi[(i + 39) % 60];
				break;
			case 40:
				ngayCC = canchi[(i + 40) % 60];
				break;
			case 41:
				ngayCC = canchi[(i + 41) % 60];
				break;
			case 42:
				ngayCC = canchi[(i + 42) % 60];
				break;
			case 43:
				ngayCC = canchi[(i + 43) % 60];
				break;
			case 44:
				ngayCC = canchi[(i + 44) % 60];
				break;
			case 45:
				ngayCC = canchi[(i + 45) % 60];
				break;
			case 46:
				ngayCC = canchi[(i + 46) % 60];
				break;
			case 47:
				ngayCC = canchi[(i + 47) % 60];
				break;
			case 48:
				ngayCC = canchi[(i + 48) % 60];
				break;
			case 49:
				ngayCC = canchi[(i + 49) % 60];
				break;
			case 50:
				ngayCC = canchi[(i + 50) % 60];
				break;
			case 51:
				ngayCC = canchi[(i + 51) % 60];
				break;
			case 52:
				ngayCC = canchi[(i + 52) % 60];
				break;
			case 53:
				ngayCC = canchi[(i + 53) % 60];
				break;
			case 54:
				ngayCC = canchi[(i + 54) % 60];
				break;
			case 55:
				ngayCC = canchi[(i + 55) % 60];
				break;
			case 56:
				ngayCC = canchi[(i + 56) % 60];
				break;
			case 57:
				ngayCC = canchi[(i + 57) % 60];
				break;
			case 58:
				ngayCC = canchi[(i + 58) % 60];
				break;
			case 59:
				ngayCC = canchi[(i + 59) % 60];
				break;

			}
			ngaycc3 = "Ngày " + ngayCC;
			return ngaycc3;
		}
	}

	public static String tinhngay(int d, int m, int y) {

		if (y == 2015)
			return ngaycc1 = tinhngay2015(d, m, y);
		else
			return ngaycc1 = tinhngayother(d, m, y);

	}

	public static int[] layngay() {
		int year = 0;
		int month = 0;
		int day = 0;
		Calendar calender;
		if (changeMode != 1) {
			calender = Calendar.getInstance();
			year = calender.get(Calendar.YEAR);
			month = calender.get(Calendar.MONTH) + 1;
			day = calender.get(Calendar.DATE);
		} else if (changeMode == 1) {
			year = customYear;
			month = customMonth;
			day = customDay;
		}

		return new int[] { day, month, year };
	}

	public static String tinhthang(int a, int b) {

		String chiT[] = { "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi",
				"Thân", "Dậu", "Tuất", "Hợi", "Tý" };
		String canT[] = { "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh",
				"Tân", "Nhâm", "Quý" };

		int n1 = b * 12 + a + 3;
		al2 = canT[n1 % 10] + " " + chiT[a % 12];

		return al2;
	}

	// tinh gio
	public static String tinhgio(int a, int b, int c) {

		String gio1 = tinhngay(a, b, c);
		String gio2[] = gio1.split(" ");
		String gio3 = gio2[1];
		int m = 0;

		if (gio3.equals("Giáp"))
			m = 1;
		if (gio3.equals("Ất"))
			m = 2;
		if (gio3.equals("Bính"))
			m = 3;
		if (gio3.equals("Đinh"))
			m = 4;
		if (gio3.equals("Mậu"))
			m = 5;
		if (gio3.equals("Kỉ"))
			m = 6;
		if (gio3.equals("Canh"))
			m = 7;
		if (gio3.equals("Tân"))
			m = 8;
		if (gio3.equals("Nhâm"))
			m = 9;
		if (gio3.equals("Quý"))
			m = 10;

		String canG[] = { "Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh",
				"Tân", "Nhâm", "Quý" };

		int n1 = (m * 2 - 2) % 10;
		gio = canG[n1] + " Tý";

		return gio;
	}

	// tinh gio hoang dao

	public static String giohd(String a) {
		if (a.equals("Dần") || a.equals("Thân")) {
			hd = " Các giờ hoàng đạo: Tý, Sửu, Thìn, Tỵ, Mùi, Tuất";

		}
		if (a.equals("Mão") || a.equals("Dậu")) {
			hd = " Các giờ hoàng đạo: Tý, Dần, Mão, Ngọ, Mùi, Dậu";

		}
		if (a.equals("Tỵ") || a.equals("Hợi")) {
			hd = " Các giờ hoàng đạo: Sửu, Thìn, Ngọ, Mùi, Tuất, Hợi";

		}
		if (a.equals("Tý") || a.equals("Ngọ")) {
			hd = " Các giờ hoàng đạo: Tý, Sửu, Mão, Ngọ, Thân, Dậu, Tuất";

		}
		if (a.equals("Sửu") || a.equals("Mùi")) {
			hd = " Các giờ hoàng đạo: Dần, Mão, Tỵ, Thân, Hợi";

		}
		if (a.equals("Thìn") || a.equals("Tuất")) {
			hd = " Các giờ hoàng đạo: Dần, Thìn, Tỵ, Thân, Dậu, Hợi";

		}
		return hd;
	}

	//tinh thu
	public static String tinhthu(int a){
		thu = a%7;
		thu = thu +2;
		if(thu == 8) thu1="Chủ Nhật";
		else thu1 = "Thứ "+thu;
		return thu1;
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xemngay);
		setTitle("Lịch Vạn Niên:Xem Ngày");
		thongtin1 = (TextView) findViewById(R.id.tv_thongtin1);
		thongtin2 = (TextView) findViewById(R.id.tv_thongtin2);
		ngay = (TextView)findViewById(R.id.tv_ngay);
		thang = (TextView)findViewById(R.id.tv_thang);
		thu2 = (TextView)findViewById(R.id.tv_thu);

		layngaycus = getIntent();
		changeMode = Integer.parseInt(layngaycus.getStringExtra("mode"));
		if (changeMode == 1) {
			customDay = Integer.parseInt(layngaycus.getStringExtra("day"));
			customMonth = Integer.parseInt(layngaycus.getStringExtra("month"));
			customYear = Integer.parseInt(layngaycus.getStringExtra("year"));

		}
		double TZ = 7.0;
		int n[] = layngay();
		int jd = chuyenngay.jdFromDate(n[0], n[1], n[2]);
		int[] s = chuyenngay.jdToDate(jd);
		int[] l = chuyenngay.convertSolar2Lunar(s[0], s[1], s[2], TZ);

		ngayht=""+n[0];
		thuht=""+tinhthu(jd);
		thanght="Tháng "+n[1]+" Năm "+n[2];
		
		String can[] = { "Canh", "Tân", "Nhâm", "Quý", "Giáp", "Ất", "Bính",
				"Đinh", "Mậu", "Kỷ" };
		String chi[] = { "Thân", "Dậu", "Tuất", "Hợi", "Tí", "Sửu", "Dần",
				"Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân" };
		String lunarYear2 = can[(int) (l[2] % 10)] + " "
				+ chi[(int) (l[2] % 12)];
		al1 = "Ngày " + l[0] + " Tháng " + l[1] + " Năm " + lunarYear2;
		thongtin1.setText(al1);
    	ngay.setText(ngayht);
    	thang.setText(thanght);
    	thu2.setText(thuht);
		
		
		
		// goi ngay hoang dao
		String hd1 = tinhngay(n[0], n[1], n[2]);
		String hd2[] = hd1.split(" ");
		String hd3 = giohd(hd2[2]);

		// tinh can chi cua thang

		String nt = tinhngay(n[0], n[1], n[2]) + "\nTháng "
				+ tinhthang(l[1], l[2])  + "\nGiờ "
				+ tinhgio(n[0], n[1], n[2])+ "\n" + hd3;
		thongtin2.setText(nt);

	}

}
