package com.android.amlich;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.android.amlich.chuyenngay;

public class xemsao extends Activity{
	
	private Button bt_xemkq, tongquan;
	private EditText ed_ngaysinh, ed_thangsinh, ed_namsinh;
	private TextView tv_ketqua;
	private RadioButton rbtnam, rbtnu; 
	private RadioGroup gioitinh;
	private String kq;
	private int day2,month2,year2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xemsao);
		setTitle("Lịch Vạn Niên:Sao Hạn");
		tongquan = (Button)findViewById(R.id.bt_tongquan);
		ed_ngaysinh = (EditText)findViewById(R.id.ed_ngaydl2);
		ed_thangsinh = (EditText)findViewById(R.id.ed_thangdl2);
		ed_namsinh = (EditText)findViewById(R.id.ed_namdl2);
		tv_ketqua = (TextView)findViewById(R.id.tv_saochieumenh);
		bt_xemkq = (Button)findViewById(R.id.bt_xemkq);
		gioitinh = (RadioGroup)findViewById(R.id.rdg_gioitinh);
		
		tongquan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				kq="La Hầu tháng bảy,tháng giêng"+
				"\nCoi chừng kẻo gặp tai khiên đến mình."+

"\nThổ Tú,Thủy Diệu giữ mình"+

"\nTháng tư,tháng tám động tình bi ai."+

"\nNhằm sao Thái Bạch ra chi,"+

"\nTháng năm trùng kỵ gắng ghi đề phòng."+

"\nThái Dương chúa tể nhật cung,"+

"\nTháng mười,tháng sáu, vận thông sắc tài."+

"\nGặp Văn Hán tháng hai,"+

"\nCùng là tháng tám xảy hoài thị phi."+

"\nKế Đô sao ấy đến kỳ,"+

"\nTháng ba,tháng chín sầu bi khóc thầm."+

"\nNguyệt cung Hoàng hậu Thái Âm,"+

"\nTháng chín được tốt,Tháng (11) một hay lâm khổ nàn."+

"\nTới sao Mộc Đức vui an,"+

"\nNội trong tháng Chạp đăng quang phước lành.";
				
				tv_ketqua.setText(kq);
				
			}
		});
		
		
		bt_xemkq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String ngaydl2 = ed_ngaysinh.getText().toString();
				  day2 = Integer.parseInt(ngaydl2);
				String thangdl2 = ed_thangsinh.getText().toString();
				 month2 = Integer.parseInt(thangdl2);
				String namdl2 = ed_namsinh.getText().toString();
				 year2 = Integer.parseInt(namdl2);
				 
				 double TZ = 7.0;
			    	int jd = chuyenngay.jdFromDate(day2, month2, year2);  	
			    	int[] s = chuyenngay.jdToDate(jd);
					int[] l = chuyenngay.convertSolar2Lunar(s[0], s[1], s[2], TZ);
					
					Calendar calender=Calendar.getInstance();
					int year2=calender.get(Calendar.YEAR);
					int month2=calender.get(Calendar.MONTH) + 1;
					int day2=calender.get(Calendar.DATE);
					  
					int tuoi = year2 - l[2]+1;
					 final int du = tuoi%9;
				
				
				switch (gioitinh.getCheckedRadioButtonId()) {
				case R.id.rbt_nam:
					
					switch (du) {
					case 0:
						kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
								"Bị Sao Mộc Đức chiếu mạng\nNgũ hành thuộc mộc, là sao xấu, chủ yếu bất lợi về âm phần. Mộc đức chiếu mệnh, nam dễ bị mắc các bệnh về mắt; nữ dễ xảy tai nạn đổ máu; nhưng nếu năm mộc đức chiếu mệnh mà kết hôn thì Vợ chồng vẫn hòa hợp, con cháu bình an.";
									
						break;
case 1:
	kq = "Bạn năm nay: "+"tuổi\n"+
			"Bị sao Sao La Hầu chiếu mạng\nChủ chuyện khẩu thiệt, kiện tụng. Nam giới tai nạn quan trường, công danh; nữ giới u sầu chuyện tình cảm, cẩn thận nạn đổ máu, nạn thai sản";				
								
						break;

case 2:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
"Bị Sao Thổ Tú chiếu mạng\nNgũ hành thuộc thổ, là sao xấu về mọi phương diện. Thổ tú chiếu mệnh mọi sự ưu phiền, đêm ngủ không yên, mơ toàn chuyện gở; chăn nuôi, kinh doanh bất vượng; thường bị tiểu nhân ám hại, dèm pha.";
	break;

case 3:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
			"Bị Sao Thủy Diệu chiếu mạng\nNgũ hành thuộc thủy, là sao phúc lộc, chủ về tài vận, cơ hội làm ăn phát triển trở lại, có thể đầu tư phát triển sản xuất kinh doanh. Nam giới gặp vận hội làm ăn, giao du bạn bè có tài có lộc. Nữ giới nhiều tai nạn, nhất là chuyện khẩu thiệt tranh cãi kiện tụng. Nam nữ phải cẩn thận đề phòng khi đi trên sông nước.";
				
	break;

case 4:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
"Bị Sao Thái Bạch chiếu mạng\nNgũ hành thuộc kim, chủ tai ách bệnh tật, nam nữ đều xấu, nhất là đối với nữ giới. Tuy nhiên, quý nhân gặp kim tinh lại có điềm tốt, có thể tăng thêm nhân khẩu, gặp cơ hội thăng tiến. Riêng việc hôn nhân, cưới hỏi nên tránh, vì cưới hỏi năm Thái bạch chiếu mệnh thường gặp nạn đổ máu ở bụng.";
	break;

case 5:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
			"Bị Sao Thái Dương chiếu mạng\nSao tốt, chủ việc đi làm ăn ngoài địa phương nơi mình ở phát tài; gia đình có thể tăng nhân khẩu; vạn sự hòa hợp. Nhưng Thái dương chỉ tốt cho nam giới, gọi là “hỷ sự trùng trùng”; với nữ giới lại là “tai ương”.";
				
	break;

case 6:
	kq = "Bạn năm nay: "+tuoi+"" +
			"Bị Sao Vân Hán chiếu mạng\nNgũ hành thuộc hỏa, là sao xấu, chủ tật bệnh, nạn đổ máu, làm ăn khó khăn; phụ nữ thai sản bất lợi. Năm Hỏa tinh chiếu mệnh không nên làm gì mới, như lập doanh nghiệp, mua thêm bán bớt… Tốt nhất giữ mọi việc tuần tự như năm trước, gọi là “thủ cựu bình an”.";
	break;

case 7:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n" +
			"Bị Sao Kế Đô chiếu mạng\nChủ tai nạn bất ngờ, người âm ám thị, thuộc loại hung tinh, nam nữ đều kỵ. ";
	break;

case 8:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
"Bị Sao Thái Âm chiếu mạng\nNgũ hành thuộc thủy, âm, mọi việc như ý, nhất là công danh, cầu tài cầu lộc, đầu tư buôn bán, du lịch, ngoại giao… Nhưng Thái âm cũng chỉ lợi nam giới; nữ giới gặp năm Thái âm chiếu mệnh rất dễ xảy tai ách, nhất là về việc thai sản.";
	break;

	

					}
					
					
					break;

					
case R.id.rbt_nu:
					
					switch (du) {
					case 3:
						kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
					"Bị Sao Mộc Đức chiếu mạng\nNgũ hành thuộc mộc, là sao xấu, chủ yếu bất lợi về âm phần. Mộc đức chiếu mệnh, nam dễ bị mắc các bệnh về mắt; nữ dễ xảy tai nạn đổ máu; nhưng nếu năm mộc đức chiếu mệnh mà kết hôn thì Vợ chồng vẫn hòa hợp, con cháu bình an.";
						break;
case 6:
	kq = "Bạn năm nay: "+"tuổi\n"+
"Bị Sao La Hầu chiếu mạng\nChủ chuyện khẩu thiệt, kiện tụng. Nam giới tai nạn quan trường, công danh; nữ giới u sầu chuyện tình cảm, cẩn thận nạn đổ máu, nạn thai sản";				
						break;

case 5:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
"Bị Sao Thổ Tú chiếu mạng\nNgũ hành thuộc thổ, là sao xấu về mọi phương diện. Thổ tú chiếu mệnh mọi sự ưu phiền, đêm ngủ không yên, mơ toàn chuyện gở; chăn nuôi, kinh doanh bất vượng; thường bị tiểu nhân ám hại, dèm pha.";

	break;

case 0:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
"Bị Sao Thủy Diệu chiếu mạng\nNgũ hành thuộc thủy, là sao phúc lộc, chủ về tài vận, cơ hội làm ăn phát triển trở lại, có thể đầu tư phát triển sản xuất kinh doanh. Nam giới gặp vận hội làm ăn, giao du bạn bè có tài có lộc. Nữ giới nhiều tai nạn, nhất là chuyện khẩu thiệt tranh cãi kiện tụng. Nam nữ phải cẩn thận đề phòng khi đi trên sông nước.";
	break;

case 8:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
			"Bị Sao Thái Bạch chiếu mạng\nNgũ hành thuộc kim, chủ tai ách bệnh tật, nam nữ đều xấu, nhất là đối với nữ giới. Tuy nhiên, quý nhân gặp kim tinh lại có điềm tốt, có thể tăng thêm nhân khẩu, gặp cơ hội thăng tiến. Riêng việc hôn nhân, cưới hỏi nên tránh, vì cưới hỏi năm Thái bạch chiếu mệnh thường gặp nạn đổ máu ở bụng.";
				
	break;

case 7:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
			"Bị Sao Thái Dương chiếu mạng\nSao tốt, chủ việc đi làm ăn ngoài địa phương nơi mình ở phát tài; gia đình có thể tăng nhân khẩu; vạn sự hòa hợp. Nhưng Thái dương chỉ tốt cho nam giới, gọi là “hỷ sự trùng trùng”; với nữ giới lại là “tai ương”.";
	break;

case 2:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n" +
			"Bị Sao Vân Hán chiếu mạng\nNgũ hành thuộc hỏa, là sao xấu, chủ tật bệnh, nạn đổ máu, làm ăn khó khăn; phụ nữ thai sản bất lợi. Năm Hỏa tinh chiếu mệnh không nên làm gì mới, như lập doanh nghiệp, mua thêm bán bớt… Tốt nhất giữ mọi việc tuần tự như năm trước, gọi là “thủ cựu bình an”.";
	
	break;

case 1:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n" +
			"Bị Sao Kế Đô chiếu mạng\nChủ tai nạn bất ngờ, người âm ám thị, thuộc loại hung tinh, nam nữ đều kỵ.";
	break;

case 4:
	kq = "Bạn năm nay: "+tuoi+"tuổi\n"+
			"Bị Sao Thái Âm chiếu mạng\nNgũ hành thuộc thủy, âm, mọi việc như ý, nhất là công danh, cầu tài cầu lộc, đầu tư buôn bán, du lịch, ngoại giao… Nhưng Thái âm cũng chỉ lợi nam giới; nữ giới gặp năm Thái âm chiếu mệnh rất dễ xảy tai ách, nhất là về việc thai sản.";
				
	break;
					}
					
					
					break;
							
				}
							
				
				tv_ketqua.setText(kq);
			}
		});
	}
	
}
