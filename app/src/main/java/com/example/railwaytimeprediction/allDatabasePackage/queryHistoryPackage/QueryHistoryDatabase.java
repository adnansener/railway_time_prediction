package com.example.railwaytimeprediction.allDatabasePackage.queryHistoryPackage;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class QueryHistoryDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PS.db";
    public static final String TABLE_NAME = "history_list";
    public static final String COL_1 = "platform_name";
    public static final String COL_2 = "when_created";
    public static final String COL_3 = "departure_station";
    public static final String COL_4 = "arrival_station";
    public static final String COL_5 = "departure_time";
    public static final String COL_6 = "arrival_time";
    public static final String COL_7 = "station_counter";
    public static final String COL_8 = "station_range_time";
    public static final String COL_9 = "current_id";

    public QueryHistoryDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String string = "CREATE TABLE history_list (history_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " platform_name TEXT NOT NULL," +
                " when_created TEXT NOT NULL," +
                " departure_station TEXT NOT NULL," +
                " arrival_station TEXT NOT NULL," +
                " departure_time TEXT NOT NULL," +
                " arrival_time TEXT NOT NULL," +
                " station_counter INTEGER NOT NULL," +
                " station_range_time INTEGER NOT NULL," +
                " current_id INTEGER NOT NULL);";

        sqLiteDatabase.execSQL(string);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {
        String string = "DROP TABLE IF EXISTS history_list";
        sqLiteDatabase.execSQL(string);

        onCreate(sqLiteDatabase);
    }

    public void onDelete(int position) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = getAllData();
        int history_id = cursor.getColumnIndex("history_id");
        cursor.moveToPosition(position);

        sqLiteDatabase.delete(TABLE_NAME, "history_id = ?", new String[] {String.valueOf(cursor.getInt(history_id))});
    }

    public Cursor showListHelper(int position, Context context) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY history_id DESC", null);
        cursor.moveToPosition(position);

        return cursor;
    }

    public void insertData(String platform_name, String when_created, String departure_station, String arrival_station, String departure_time, String arrival_time, int station_counter, int station_range_time, Integer current_id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, platform_name);
        contentValues.put(COL_2, when_created);
        contentValues.put(COL_3, departure_station);
        contentValues.put(COL_4, arrival_station);
        contentValues.put(COL_5, departure_time);
        contentValues.put(COL_6, arrival_time);
        contentValues.put(COL_7, station_counter);
        contentValues.put(COL_8, station_range_time);
        contentValues.put(COL_9, current_id);

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " ORDER BY history_id DESC", null);

        return cursor;
    }

    public Cursor getAllLine(String oldMail) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_9 + " = ? ", new String[]{oldMail});

        return cursor;
    }

    public void whenChangingMail(String oldMail, String newMail) {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = getAllLine(oldMail);

        if(cursor.getCount() != 0) {
            while(cursor.moveToNext()) {
                contentValues.put("history_id", cursor.getString(0));
                contentValues.put(COL_1, cursor.getString(1));
                contentValues.put(COL_2, cursor.getString(2));
                contentValues.put(COL_3, cursor.getString(3));
                contentValues.put(COL_4, cursor.getString(4));
                contentValues.put(COL_5, cursor.getString(5));
                contentValues.put(COL_6, cursor.getString(6));
                contentValues.put(COL_7, cursor.getString(7));
                contentValues.put(COL_8, cursor.getString(8));
                contentValues.put(COL_9, newMail);

                sqLiteDatabase.update(TABLE_NAME, contentValues,"history_id = ? ", new String[]{cursor.getString(0)});

                contentValues.clear();
            }
        }
    }

    public void whenDeletingMail(Integer id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete(TABLE_NAME, "current_id = ?", new String[] {id.toString()});
    }
}
