package com.example.railwaytimeprediction.allDatabasePackage.variablesPackage;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VariablesDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Variables.db";
    public static final String COL_1 = "station_list";
    public static final String COL_2 = "range_list";

    public VariablesDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String string;

        string = createM1A();
        sqLiteDatabase.execSQL(string);
        importM1A(sqLiteDatabase);

        string = createM1B();
        sqLiteDatabase.execSQL(string);
        importM1B(sqLiteDatabase);

        string = createM2();
        sqLiteDatabase.execSQL(string);
        importM2(sqLiteDatabase);

        string = createM3();
        sqLiteDatabase.execSQL(string);
        importM3(sqLiteDatabase);

        string = createM4();
        sqLiteDatabase.execSQL(string);
        importM4(sqLiteDatabase);

        string = createM5();
        sqLiteDatabase.execSQL(string);
        importM5(sqLiteDatabase);

        string = createM6();
        sqLiteDatabase.execSQL(string);
        importM6(sqLiteDatabase);

        string = createM7();
        sqLiteDatabase.execSQL(string);
        importM7(sqLiteDatabase);

        string = createM8();
        sqLiteDatabase.execSQL(string);
        importM8(sqLiteDatabase);

        string = createM9();
        sqLiteDatabase.execSQL(string);
        importM9(sqLiteDatabase);

        string = createM10();
        sqLiteDatabase.execSQL(string);
        importM10(sqLiteDatabase);

        string = createM11();
        sqLiteDatabase.execSQL(string);
        importM11(sqLiteDatabase);

        string = createM12();
        sqLiteDatabase.execSQL(string);
        importM12(sqLiteDatabase);

        string = createM13();
        sqLiteDatabase.execSQL(string);
        importM13(sqLiteDatabase);

        string = createM14();
        sqLiteDatabase.execSQL(string);
        importM14(sqLiteDatabase);

        string = createF1();
        sqLiteDatabase.execSQL(string);
        importF1(sqLiteDatabase);

        string = createF2();
        sqLiteDatabase.execSQL(string);
        importF2(sqLiteDatabase);

        string = createF3();
        sqLiteDatabase.execSQL(string);
        importF3(sqLiteDatabase);

        string = createF4();
        sqLiteDatabase.execSQL(string);
        importF4(sqLiteDatabase);

        string = createF5();
        sqLiteDatabase.execSQL(string);
        importF5(sqLiteDatabase);

        string = createT1();
        sqLiteDatabase.execSQL(string);
        importT1(sqLiteDatabase);

        string = createT2();
        sqLiteDatabase.execSQL(string);
        importT2(sqLiteDatabase);

        string = createT3();
        sqLiteDatabase.execSQL(string);
        importT3(sqLiteDatabase);

        string = createT4();
        sqLiteDatabase.execSQL(string);
        importT4(sqLiteDatabase);

        string = createT5();
        sqLiteDatabase.execSQL(string);
        importT5(sqLiteDatabase);

        string = createT6();
        sqLiteDatabase.execSQL(string);
        importT6(sqLiteDatabase);

        string = createTF1();
        sqLiteDatabase.execSQL(string);
        importTF1(sqLiteDatabase);

        string = createTF2();
        sqLiteDatabase.execSQL(string);
        importTF2(sqLiteDatabase);

        string = createMarmaray();
        sqLiteDatabase.execSQL(string);
        importMarmaray(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old_version, int new_version) {
        String string = "DROP TABLE IF EXISTS marmaray";
        sqLiteDatabase.execSQL(string);

        onCreate(sqLiteDatabase);
    }

    public Cursor getAllData(String platform) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + platform, null);

        return cursor;
    }

    public String createMarmaray() {
        String string = "CREATE TABLE marmaray (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importMarmaray(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Gebze");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Darıca");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Osmangazi");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Fatih");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Çayırova");
        contentValues.put(COL_2, "240");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Tuzla");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "İçmeler");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Aydıntepe");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Güzelyalı");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Tersane");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Kaynarca");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Pendik");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Yunus");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Kartal");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Başak");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Atalar");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Cevizli");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Maltepe");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Süreyya Plajı");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "İdealtepe");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Küçükyalı");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("TABLE_NAME", null, contentValues);

        contentValues.put(COL_1, "Bostancı");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Suadiye");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Erenköy");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Göztepe");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Feneryolu");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Söğütlüçeşme");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Ayrılık Çeşmesi");
        contentValues.put(COL_2, "240");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Üsküdar");
        contentValues.put(COL_2, "240");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Sirkeci");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Yenikapı");
        contentValues.put(COL_2, "240");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Kazlıçesme");
        contentValues.put(COL_2, "240");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Zeytinburnu");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Yenimahalle");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Bakırköy");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Ataköy");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Yeşilyurt");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Yeşilköy");
        contentValues.put(COL_2, "240");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Florya Akvaryum");
        contentValues.put(COL_2, "120");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Florya");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Küçükçekmece");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Mustafa Kemal");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("marmaray", null, contentValues);

        contentValues.put(COL_1, "Halkalı");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("marmaray", null, contentValues);
    }
    public String createM1A() {
        String string = "CREATE TABLE m1a (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM1A(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Atatürk Havalimanı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "DTM-İstanbul Fuar Merkezi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Yenibosna");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Ataköy-Şirinevler");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Bahçelievler");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Bakırköy-İncirli");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Zeytinburnu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Merter");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Davutpaşa-YTÜ");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Terazidere");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Otogar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Kocatepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Sağmalcılar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Bayrampaşa-Maltepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Topkapı-Ulubatlı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Emniyet-Fatih");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Aksaray");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1a", null, contentValues);

        contentValues.put(COL_1, "Yenikapı");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m1a", null, contentValues);
    }
    public String createM1B() {
        String string = "CREATE TABLE m1b (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM1B(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Kirazlı-Bağcılar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Bağcılar Meydan");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Üçyüzlü");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Menderes");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Esenler");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Otogar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Kocatepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Sağmalcılar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Bayrampaşa-Maltepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Topkapı-Ulubatlı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Emniyet-Fatih");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Aksaray");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m1b", null, contentValues);

        contentValues.put(COL_1, "Yenikapı");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m1b", null, contentValues);
    }
    public String createM2() {
        String string = "CREATE TABLE m2 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM2(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Yenikapı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Vezneciler-İstanbul Ü.");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Haliç");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Şişhane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Taksim");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Osmanbey");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Şişli-Mecidiyeköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Gayrettepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Levent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "4.Levent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Sanayi Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Seyrantepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "İTÜ-Ayazağa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Atatürk Oto Sanayi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Darüşşafaka");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m2", null, contentValues);

        contentValues.put(COL_1, "Hacıosman");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m2", null, contentValues);
    }
    public String createM3() {
        String string = "CREATE TABLE m3 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM3(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Kayaşehir Merkez");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Toplu Konutlar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Şehir Hastanesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Onurkent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Başakşehir-Metrokent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Başak Konutları");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Siteler");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Turgut Özal");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "İkitelli Sanayi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "İSTOÇ");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Mahmutbey");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Yenimahalle");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m3", null, contentValues);

        contentValues.put(COL_1, "Kirazlı-Bağcılar");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m3", null, contentValues);
    }
    public String createM4() {
        String string = "CREATE TABLE m4 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM4(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Kadıköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Ayrılık Çeşmesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Acıbadem");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Ünalan");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Göztepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Yenisahra");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Kozyatağı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Bostancı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Küçükyalı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Maltepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Huzurevi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Gülsuyu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Esenkent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Hastane-Adliye");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Soğanlık");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Kartal");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Yakacık-Adnan Kahveci");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Pendik");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Tavşantepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Fevzi Çakmak-Hastane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Yayalar-Şeyhli");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Kurtköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m4", null, contentValues);

        contentValues.put(COL_1, "Sabiha Gökçen Havalimanı");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m4", null, contentValues);
    }
    public String createM5() {
        String string = "CREATE TABLE m5 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM5(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Üsküdar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Fıstıkağacı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Bağlarbaşı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Altunizade");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Kısıklı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Bulgurlu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Ümraniye");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Çarşı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Yamanevler");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Çakmak");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Ihlamurkuyu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Altınşehir");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "İmam Hatip Lisesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Dudullu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Necip Fazıl");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m5", null, contentValues);

        contentValues.put(COL_1, "Çekmeköy");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m5", null, contentValues);
    }
    public String createM6() {
        String string = "CREATE TABLE m6 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM6(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Levent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m6", null, contentValues);

        contentValues.put(COL_1, "Nispetiye");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m6", null, contentValues);

        contentValues.put(COL_1, "Etiler");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m6", null, contentValues);

        contentValues.put(COL_1, "Boğaziçi Ü.-Hisarüstü");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m6", null, contentValues);
    }
    public String createM7() {
        String string = "CREATE TABLE m7 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM7(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Yıldız");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Fulya");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Mecidiyeköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Çağlayan");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Kağıthane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Nurtepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Alibeyköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Çırçır");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Veysel Karani-Akşemsettin");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Yeşilpınar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Kazım Karabekir");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Yenimahalle");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Karadeniz Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Tekstilkent-Giyimkent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Oruç Reis");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Göztepe Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m7", null, contentValues);

        contentValues.put(COL_1, "Mahmutbey");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m7", null, contentValues);
    }
    public String createM8() {
        String string = "CREATE TABLE m8 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM8(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Bostancı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Emin Ali Paşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Ayşekadın");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Kozyatağı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Küçükbakkalköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "İçerenköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Kayışdağı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Mevlana");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "İmes");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Modoko-Keyap");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Dudullu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Huzur");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m8", null, contentValues);

        contentValues.put(COL_1, "Parseller");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m8", null, contentValues);
    }
    public String createM9() {
        String string = "CREATE TABLE m9 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM9(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Olimpiyat");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m9", null, contentValues);

        contentValues.put(COL_1, "Ziya Gökalp Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m9", null, contentValues);

        contentValues.put(COL_1, "İkitelli Sanayi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m9", null, contentValues);

        contentValues.put(COL_1, "Masko");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m9", null, contentValues);

        contentValues.put(COL_1, "Bahariye");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m9", null, contentValues);
    }
    public String createM10() {
        String string = "CREATE TABLE m10 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM10(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Pendik Merkez");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Kaynarca Merkez");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Fevzi Çakmak Hastane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Yayalar-Şeyhli");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Kurtköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Sabiha Gökçen Havalimanı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Teknopark");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Yenişehir");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m10", null, contentValues);

        contentValues.put(COL_1, "Kurtköy YHT/ViaPort");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m10", null, contentValues);
    }
    public String createM11() {
        String string = "CREATE TABLE m11 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM11(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Gayrettepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Kâğıthane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Hasdal");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Kemerburgaz");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Göktürk");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "İhsaniye");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Terminal 2");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "İstanbul Havalimanı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Kargo Terminali");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Taşoluk");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Arnavutköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Fenertepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Kayaşehir Merkez");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Olimpiyat");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Halkalı Stadı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m11", null, contentValues);

        contentValues.put(COL_1, "Halkalı");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m11", null, contentValues);
    }
    public String createM12() {
        String string = "CREATE TABLE m12 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM12(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "60. Yıl Parkı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Tütüncü Mehmet Efendi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Sahrayıcedit");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Yenisahra");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Ataşehir");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Finans Merkezi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Site");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Atakent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Çarşı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "SBÜ Hastanesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m12", null, contentValues);

        contentValues.put(COL_1, "Kazım Karabekir");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m12", null, contentValues);
    }
    public String createM13() {
        String string = "CREATE TABLE m13 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM13(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Söğütlüçeşme");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Ünalan");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Esatpaşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Site");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Atay Caddesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Çakmak");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "İMES");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Dudullu OSB");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Esenkent");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Emek");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Sarıgazi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Aydınlar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Cumhuriyet");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Soğukpınar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m13", null, contentValues);

        contentValues.put(COL_1, "Yenidoğan");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m13", null, contentValues);
    }
    public String createM14() {
        String string = "CREATE TABLE m14 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importM14(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Altunizade");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m14", null, contentValues);

        contentValues.put(COL_1, "Ferah Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m14", null, contentValues);

        contentValues.put(COL_1, "Çamlıca Camii");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m14", null, contentValues);

        contentValues.put(COL_1, "Bosna Bulvarı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m14", null, contentValues);

        contentValues.put(COL_1, "Yavuztürk Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("m14", null, contentValues);

        contentValues.put(COL_1, "Kazım Karabekir");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("m14", null, contentValues);
    }
    public String createT1() {
        String string = "CREATE TABLE t1 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importT1(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Bağcılar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Güneştepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Yavuzselim");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Soğanlı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Akıncılar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Güngören");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Merter Tekstil Merkezi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Mehmet Akif");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Zeytinburnu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Mithatpaşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Seyitnizam-Akşemsettin");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Merkezefendi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Cevizlibağ-AÖY");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Topkapı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Pazartekke");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Çapa-Şehremini");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Fındıkzade");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Haseki");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Yusufpaşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Aksaray");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Laleli-İstanbul Ü.");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Beyazıt-Kapalıçarşı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Çemberlitaş");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Sultanahmet");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Gülhane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Sirkeci");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Eminönü");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Karaköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Tophane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Fındıklı-Mimar Sinan Ü.");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t1", null, contentValues);

        contentValues.put(COL_1, "Kabataş");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("t1", null, contentValues);
    }
    public String createT2() {
        String string = "CREATE TABLE t2 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importT2(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Taksim");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t2", null, contentValues);

        contentValues.put(COL_1, "Hüseyin Ağa Camii");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t2", null, contentValues);

        contentValues.put(COL_1, "Galatasaray Lisesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t2", null, contentValues);

        contentValues.put(COL_1, "Odakule");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t2", null, contentValues);

        contentValues.put(COL_1, "Tünel");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("t2", null, contentValues);
    }
    public String createT3() {
        String string = "CREATE TABLE t3 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importT3(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "İskele Cami");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Çarşı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Altıyol");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Bahariye");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Kilise");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Moda İlkokulu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Moda Caddesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Rıza Paşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Mühürdar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Damga Sokak");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t3", null, contentValues);

        contentValues.put(COL_1, "Kadıköy İDO");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("t3", null, contentValues);
    }
    public String createT4() {
        String string = "CREATE TABLE t4 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importT4(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Mescid-i Selam");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Cebeci");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Sultançiftliği");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Yenimahalle");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Hacı Şükrü");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "50.Yıl-Baştabya");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Cumhuriyet Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Kiptaş-Venezia");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Karadeniz");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Taşköprü");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Ali Fuat Başgil");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Bosna Çukurçeşme");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Sağmalcılar");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Uluyol Bereç");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Rami");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Topçular");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Demirkapı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Şehitlik");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Edirnekapı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Vatan");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Fetihkapı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t4", null, contentValues);

        contentValues.put(COL_1, "Topkapı");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("t4", null, contentValues);
    }
    public String createT5() {
        String string = "CREATE TABLE t5 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importT5(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Cibali");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Fener");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Balat");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Ayvansaray");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Feshane");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Eyüpsultan Teleferik");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Eyüpsultan Devlet Hastanesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Silahtarağa Mahallesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Üniversite");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Alibeyköy Merkez");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Alibeyköy Metro İstasyonu");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t5", null, contentValues);

        contentValues.put(COL_1, "Alibeyköy Cep Otogarı");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("t5", null, contentValues);
    }
    public String createT6() {
        String string = "CREATE TABLE t6 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importT6(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Sirkeci");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t6", null, contentValues);

        contentValues.put(COL_1, "Cankurtaran");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t6", null, contentValues);

        contentValues.put(COL_1, "Kumkapı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t6", null, contentValues);

        contentValues.put(COL_1, "Yenikapı");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t6", null, contentValues);

        contentValues.put(COL_1, "Cerrahpaşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t6", null, contentValues);

        contentValues.put(COL_1, "Kocamustafapaşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t6", null, contentValues);

        contentValues.put(COL_1, "Yedikule");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("t6", null, contentValues);

        contentValues.put(COL_1, "Kazlıçeşme");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("t6", null, contentValues);
    }
    public String createF1() {
        String string = "CREATE TABLE f1 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importF1(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Taksim");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("f1", null, contentValues);

        contentValues.put(COL_1, "Kabataş");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("f1", null, contentValues);
    }
    public String createF2() {
        String string = "CREATE TABLE f2 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importF2(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Karaköy");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("f2", null, contentValues);

        contentValues.put(COL_1, "Beyoğlu");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("f2", null, contentValues);
    }
    public String createF3() {
        String string = "CREATE TABLE f3 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importF3(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Seyrantepe");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("f3", null, contentValues);

        contentValues.put(COL_1, "Vadistanbul");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("f3", null, contentValues);
    }
    public String createF4() {
        String string = "CREATE TABLE f4 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importF4(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Boğaziçi Üniversitesi");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("f4", null, contentValues);

        contentValues.put(COL_1, "Hisarüstü-Aşiyan");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("f4", null, contentValues);
    }
    public String createF5() {
        String string = "CREATE TABLE f5 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importF5(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "İTÜ");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("f5", null, contentValues);

        contentValues.put(COL_1, "Reşitpaşa");
        contentValues.put(COL_2, "300");
        sqLiteDatabase.insert("f5", null, contentValues);

        contentValues.put(COL_1, "İstinye");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("f5", null, contentValues);
    }
    public String createTF1() {
        String string = "CREATE TABLE tf1 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importTF1(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Maçka");
        contentValues.put(COL_2, "240");
        sqLiteDatabase.insert("tf1", null, contentValues);

        contentValues.put(COL_1, "Taşkışla");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("tf1", null, contentValues);
    }
    public String createTF2() {
        String string = "CREATE TABLE tf2 (station_id INTEGER PRIMARY KEY AUTOINCREMENT, station_list TEXT NOT NULL, range_list INTEGER);";

        return string;
    }
    public void importTF2(SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, "Eyüp");
        contentValues.put(COL_2, "180");
        sqLiteDatabase.insert("tf2", null, contentValues);

        contentValues.put(COL_1, "Piyer Loti");
        contentValues.put(COL_2, "");
        sqLiteDatabase.insert("tf2", null, contentValues);
    }

    public Integer getStationId(String stationName, String platform) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + platform + " WHERE station_list = ?", new String[]{stationName});
        cursor.moveToFirst();

        return cursor.getInt(0) - 1;
    }
}
