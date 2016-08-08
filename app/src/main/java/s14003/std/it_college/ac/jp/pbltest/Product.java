package s14003.std.it_college.ac.jp.pbltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Product {
    private CodeHelper cHelper;

    public Product(Context context) {
        cHelper = new CodeHelper(context);
    }

    public int insert(Code code) {

        //Open connection to write data
        SQLiteDatabase db = cHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Code.codeID, code.codeId);
        values.put(Code.blacklistID, code.blackListID);

        long code_id = db.insert(Code.CODE_TABLE, null, values);
        db.close();
        return (int)code_id;
    }
    public void delete(int code_id) {
        SQLiteDatabase db = cHelper.getWritableDatabase();
        db.delete(Code.CODE_TABLE, Code.codeID + "=?", new String[] {String.valueOf(code_id)});
        db.close();
    }

    public void update(Code code) {
        SQLiteDatabase db = cHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Code.codeID, code.codeId);
        values.put(Code.blacklistID, code.blackListID);
        values.put(Code.value, code.codeValues);

        db.update(Code.CODE_TABLE, values, Code.codeID + "=?", new String[] {String.valueOf(code.codeId)});
        db.close();
    }
}
