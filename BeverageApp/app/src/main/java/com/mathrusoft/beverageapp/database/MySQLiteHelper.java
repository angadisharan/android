package com.mathrusoft.beverageapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mathrusoft.beverageapp.model.ModelBeverage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharanangadi on 30/12/16.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "beverage_db";
    private static final int VERSION = 1;


    private static final String TABLE_BEVERAGE = " beverage ";
    private static final String CREATE_BEVERAGE = "create table " + TABLE_BEVERAGE
            + " ( _id integer primary key autoincrement," +
            " name text, description text , price float ) ;  ";

    private static MySQLiteHelper instance;

    public static MySQLiteHelper getInstance(Context context) {
        if (instance == null) {
            instance = new MySQLiteHelper(context);
        }
        return instance;
    }

    private MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BEVERAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_BEVERAGE);
        onCreate(sqLiteDatabase);
    }

    public long insertBeverage(ModelBeverage modelBeverage) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", modelBeverage.getName());
        contentValues.put("price", modelBeverage.getPrice());
        contentValues.put("description", modelBeverage.getDescription());

        long id = database.insert(TABLE_BEVERAGE, null, contentValues);
        database.close();

        return id;
    }


    public List<ModelBeverage> getAllBeverages() {
        List<ModelBeverage> list = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        String sql = " select * from " + TABLE_BEVERAGE + " ; ";
        Cursor cursor = database.rawQuery(sql, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToPosition(-1);
                while (cursor.moveToNext()) {
                    ModelBeverage modelBeverage = new ModelBeverage();
                    modelBeverage.set_id(cursor.getInt(cursor.getColumnIndex("_id")) + "");
                    modelBeverage.setName(cursor.getString(cursor.getColumnIndex("name")));
                    modelBeverage.setDescription(cursor.getString(cursor.getColumnIndex("description")));
                    modelBeverage.setPrice(cursor.getFloat(cursor.getColumnIndex("price")));
                    list.add(modelBeverage);
                }
                cursor.close();
            }
        }
        return list;
    }

    public long updateBeverageModel(ModelBeverage modelBeverage) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", modelBeverage.getName());
        contentValues.put("price", modelBeverage.getPrice());
        contentValues.put("description", modelBeverage.getDescription());


        long returnId = database.update(TABLE_BEVERAGE, contentValues, "_id = ? ", new String[]{modelBeverage.get_id()});

        database.close();
        return returnId;
    }

    public void deleteBeverage(ModelBeverage modelBeverage) {
        SQLiteDatabase database = this.getWritableDatabase();
        String sql = " delete from " + TABLE_BEVERAGE + " where _id = " + modelBeverage.get_id() + "; ";
        database.execSQL(sql);
        database.close();
    }


}
