package com.example.railwaytimeprediction.allDatabasePackage.administrationPackage;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.railwaytimeprediction.allDatabasePackage.queryHistoryPackage.QueryHistoryDatabase;
import com.example.railwaytimeprediction.platformsPackage.FragmentAllPlatforms;

public class AdministrationDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Accounts.db", TABLE_NAME = "AccountList", COL_0 = "account_id", COL_1 = "first_name", COL_2 = "last_name", COL_3 = "mail", COL_4 = "password";

    public AdministrationDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE AccountList (account_id INTEGER PRIMARY KEY AUTOINCREMENT, first_name TEXT NOT NULL, last_name TEXT NOT NULL, mail TEXT NOT NULL, password TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {
        String string = "DROP TABLE IF EXISTS AccountList";
        sqLiteDatabase.execSQL(string);

        onCreate(sqLiteDatabase);
    }

    public Integer getID(String mail) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT account_id FROM AccountList WHERE mail = ?", new String[]{mail})) {

            cursor.moveToFirst();

            return cursor.getInt(0);
        }
    }

    public Boolean isAccountExists(String mail) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = ? ", new String[]{mail})) {

            return cursor.getCount() != 0;
        }
    }

    public void addAccount(String firstName, String lastName, String mail, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, firstName);
        contentValues.put(COL_2, lastName);
        contentValues.put(COL_3, mail);
        contentValues.put(COL_4, password);

        sqLiteDatabase.insert("AccountList", null, contentValues);
    }
    
    public void changeFirstName(String newFirstName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = getAllData();

        cursor.moveToFirst();
        contentValues.put(COL_0, cursor.getString(0));
        contentValues.put(COL_1, newFirstName);
        contentValues.put(COL_2, cursor.getString(2));
        contentValues.put(COL_3, cursor.getString(3));
        contentValues.put(COL_4, cursor.getString(4));

        sqLiteDatabase.update("AccountList", contentValues, "mail = ?", new String[]{FragmentAllPlatforms.currentMail});
    }

    public void changeLastName(String newLastName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = getAllData();

        cursor.moveToFirst();
        contentValues.put(COL_0, cursor.getString(0));
        contentValues.put(COL_1, cursor.getString(1));
        contentValues.put(COL_2, newLastName);
        contentValues.put(COL_3, cursor.getString(3));
        contentValues.put(COL_4, cursor.getString(4));

        sqLiteDatabase.update("AccountList", contentValues, "mail = ?", new String[]{FragmentAllPlatforms.currentMail});
    }

    public void changeMail(String newMail, Context context) {
        try (QueryHistoryDatabase queryHistoryDatabase = new QueryHistoryDatabase(context)) {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            Cursor cursor = getAllData();

            cursor.moveToFirst();
            contentValues.put(COL_0, cursor.getString(0));
            contentValues.put(COL_1, cursor.getString(1));
            contentValues.put(COL_2, cursor.getString(2));
            contentValues.put(COL_3, newMail);
            contentValues.put(COL_4, cursor.getString(4));

            sqLiteDatabase.update("AccountList", contentValues, "mail = ?", new String[]{FragmentAllPlatforms.currentMail});

            queryHistoryDatabase.whenChangingMail(FragmentAllPlatforms.currentMail, newMail);
        }
    }

    public void changePassword(String newPassword) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = getAllData();

        cursor.moveToFirst();
        contentValues.put(COL_0, cursor.getString(0));
        contentValues.put(COL_1, cursor.getString(1));
        contentValues.put(COL_2, cursor.getString(2));
        contentValues.put(COL_3, cursor.getString(3));
        contentValues.put(COL_4, newPassword);

        sqLiteDatabase.update("AccountList", contentValues, "mail = ?", new String[]{FragmentAllPlatforms.currentMail});
    }

    public void deleteAccount(String mail, Context context) {
        QueryHistoryDatabase queryHistoryDatabase = new QueryHistoryDatabase(context);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.delete("AccountList", "mail = ?", new String[]{mail});
        sqLiteDatabase.close();

        queryHistoryDatabase.whenDeletingMail(FragmentAllPlatforms.currentID);
    }

    public Boolean login (String mail, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT password FROM AccountList WHERE mail = ? AND password = ?", new String[]{mail, password})) {

            return cursor.getCount() > 0;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        return sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = ? ", new String[]{FragmentAllPlatforms.currentMail});
    }

    public Boolean getOneLine(Integer whichOne, String newValue) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        try (Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_3 + " = ? ", new String[]{FragmentAllPlatforms.currentMail})) {
            cursor.moveToFirst();

            return newValue.equals(cursor.getString(whichOne));
        }
    }
}