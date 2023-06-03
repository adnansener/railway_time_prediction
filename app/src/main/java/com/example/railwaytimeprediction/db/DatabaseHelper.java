package com.example.railwaytimeprediction.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PS.db";
    public static final String TABLE_NAME = "history_list";
    public static final String COL_1 = "history_id";
    public static final String COL_2 = "platform_name";
    public static final String COL_3 = "when_created";
    public static final String COL_4 = "departure_station";
    public static final String COL_5 = "arrival_station";
    public static final String COL_6 = "departure_time";
    public static final String COL_7 = "arrival_time";
    public static final String COL_8 = "station_counter";
    public static final String COL_9 = "station_range_time";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE history_list (history_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " platform_name TEXT NOT NULL," +
                " when_created TEXT NOT NULL," +
                " departure_station TEXT NOT NULL," +
                " arrival_station TEXT NOT NULL," +
                " departure_time TEXT NOT NULL," +
                " arrival_time TEXT NOT NULL," +
                " station_counter INTEGER NOT NULL," +
                " station_range_time INTEGER NOT NULL);";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {
        String sql = "DROP TABLE IF EXISTS history_list";
        sqLiteDatabase.execSQL(sql);

        onCreate(sqLiteDatabase);
    }

    public void onDelete(int position) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = getAllData();
        int history_id = cursor.getColumnIndex("history_id");
        cursor.moveToPosition(position);

        db.delete(TABLE_NAME, "history_id = ?", new String[] {String.valueOf(cursor.getInt(history_id))});
    }

    public void insertData(String platform_name, String when_created, String departure_station, String arrival_station, String departure_time, String arrival_time, int station_counter, int station_range_time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, platform_name);
        contentValues.put(COL_3, when_created);
        contentValues.put(COL_4, departure_station);
        contentValues.put(COL_5, arrival_station);
        contentValues.put(COL_6, departure_time);
        contentValues.put(COL_7, arrival_time);
        contentValues.put(COL_8, station_counter);
        contentValues.put(COL_9, station_range_time);

        db.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY history_id DESC", null);

        return cursor;
    }
}
