package s14003.std.it_college.ac.jp.pbltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;

    private static final String DATABASE_NAME = "account.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ACCOUNT = "CREATE TABLE" + Accounts.TABLE + "("
                + Accounts.First_Name + "TEXT,"
                + Accounts.Last_Name + "TEXT,"
                + Accounts.MailAddress + "TEXT,"
                + Accounts.Address + "TEXT,"
                + Accounts.Password + "TEXT)";
        sqLiteDatabase.execSQL(CREATE_ACCOUNT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + Accounts.TABLE);
        onCreate(sqLiteDatabase);
    }
}
