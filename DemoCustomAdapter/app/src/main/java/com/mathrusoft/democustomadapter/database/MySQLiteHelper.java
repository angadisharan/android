package com.mathrusoft.democustomadapter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.mathrusoft.democustomadapter.model.ModelStudentDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 29/12/16.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    static MySQLiteHelper instance;

    public static MySQLiteHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MySQLiteHelper(context);
        }
        return instance;
    }

    private MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static final String DB_NAME = "my_database";
    private static final int DB_VERSION = 1;

    private static final String TABLE_STUDENT_DETAILS = "student_details";
    private static final String CREATE_STUDENT_DETAILS = " create table " + TABLE_STUDENT_DETAILS +
            " ( _id integer primary key autoincrement,"
            + " name text,"
            + " branch text,"
            + " usn text,"
            + " address text ); ";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STUDENT_DETAILS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_STUDENT_DETAILS);
        onCreate(sqLiteDatabase);
    }


    public long insertStudentDetail(ModelStudentDetails modelStudentDetails) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", modelStudentDetails.getName());
        contentValues.put("branch", modelStudentDetails.getBranch());
        contentValues.put("usn", modelStudentDetails.getUsn());
        contentValues.put("address", modelStudentDetails.getAddress());


        long insertId = database.insert(TABLE_STUDENT_DETAILS, null, contentValues);
        database.close();

        return insertId;
    }

    public List<ModelStudentDetails> getAllStudents() {
        List<ModelStudentDetails> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        String sql = " select * from " + TABLE_STUDENT_DETAILS + "; ";

        Cursor cursor = database.rawQuery(sql, null);

        Log.d("MYAPP", " inside getAllStudents DB ========= cursor ====== " + cursor);

        if (cursor != null) {
            Log.d("MYAPP", " inside getAllStudents DB ========= cursor ====== " + cursor.getCount());
            if (cursor.getCount() > 0) {
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    ModelStudentDetails modelStudentDetails = new ModelStudentDetails();
                    modelStudentDetails.setName(cursor.getString(cursor.getColumnIndex("name")));
                    modelStudentDetails.setUsn(cursor.getString(cursor.getColumnIndex("usn")));
                    modelStudentDetails.setAddress(cursor.getString(cursor.getColumnIndex("address")));
                    modelStudentDetails.setBranch(cursor.getString(cursor.getColumnIndex("branch")));

                    list.add(modelStudentDetails);
                }
            }
            cursor.close();
        }
        database.close();
        return list;
    }
}
