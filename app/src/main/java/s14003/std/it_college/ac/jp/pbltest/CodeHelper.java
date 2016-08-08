package s14003.std.it_college.ac.jp.pbltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CodeHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;

    private static final String DATABASE_NAME = "codeM.db";

    public CodeHelper(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_ACCOUNT = "CREATE TABLE" + Code.CODE_TABLE + "("
                + Code.codeID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Code.blacklistID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Code.value + "INTEGER";
        sqLiteDatabase.execSQL(CREATE_ACCOUNT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + Code.CODE_TABLE);
        onCreate(sqLiteDatabase);
    }
}
