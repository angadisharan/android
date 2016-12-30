package com.mathrusoft.beverageapp.database;

import android.content.Context;

import com.mathrusoft.beverageapp.model.ModelBeverage;

import java.util.List;

/**
 * Created by sharanangadi on 30/12/16.
 */

public class DataSource {

    MySQLiteHelper mySQLiteHelper;

    public DataSource(Context context) {
        if (mySQLiteHelper == null) {
            mySQLiteHelper = MySQLiteHelper.getInstance(context);
        }
    }

    public long insertBeverage(ModelBeverage modelBeverage) {
        return mySQLiteHelper.insertBeverage(modelBeverage);
    }

    public List<ModelBeverage> getAllBeverages() {
        return mySQLiteHelper.getAllBeverages();
    }

}
