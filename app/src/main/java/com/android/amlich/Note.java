package com.android.amlich;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Note {
	private String idNote;
	private String desciption;
	private Date dateFinish;
	private Date hourFinish;

	public Note(String id, String desciption, Date dateFinish, Date hourFinish) {
		super();
		this.idNote = id;
		this.desciption = desciption;
		this.dateFinish = dateFinish;
		this.hourFinish = hourFinish;
	}

	public Note() {
		super();
	}

	public String getIdNote() {
		return idNote;
	}

	public void setIdNote(String idNote) {
		this.idNote = idNote;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		this.dateFinish = dateFinish;
	}

	public Date getHourFinish() {
		return hourFinish;
	}

	public void setHourFinish(Date hourFinish) {
		this.hourFinish = hourFinish;
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
