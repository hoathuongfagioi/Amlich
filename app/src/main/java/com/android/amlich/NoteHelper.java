package com.android.amlich;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

class NoteHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "ghichu.db";
	private static final int SCHEMA_VERSION = 1;

	public NoteHelper(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE notes (_id TEXT PRIMARY KEY, name TEXT, date TEXT, time TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// no-op, since will not be called until 2nd schema
		// version exists
	}

	public Cursor getAll() {
		return (getReadableDatabase().rawQuery(
				"SELECT _id, name, date, time FROM notes ORDER BY name", null));
	}

	public void insert(String id,String name, String date, String time) {
		ContentValues cv = new ContentValues();
		cv.put("_id", id);
		cv.put("name", name);
		cv.put("date", date);
		cv.put("time", time);

		getWritableDatabase().insert("notes", "name", cv);
	}

	public boolean deleteNote(String rowId) {
	
		return getWritableDatabase().delete("notes", "_id=?",
				new String[] {rowId }) > 0;
	}

	public void updateOne(Note temp, String rowId) {
		ContentValues cv = new ContentValues();
		cv.put("name", temp.getDesciption());
		cv.put("date", temp.getDateFormat(temp.getDateFinish()));
		cv.put("time", temp.getHourFormat(temp.getHourFinish()));

		getWritableDatabase().update("notes", cv, "_id=?",
				new String[] {rowId});

	}
	
	public String getId(Cursor c) {
		return (c.getString(0));
	}
	public String getName(Cursor c) {
		return (c.getString(1));
	}

	public String getDate(Cursor c) {
		return (c.getString(2));
	}

	public String getTime(Cursor c) {
		return (c.getString(3));
	}

}
