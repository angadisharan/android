package com.mathrusoft.democustomadapter.database;

import android.content.Context;

import com.mathrusoft.democustomadapter.model.ModelStudentDetails;

import java.util.List;

/**
 * Created by sharanangadi on 29/12/16.
 */

public class DataSource {

    MySQLiteHelper mySQLiteHelper;

    public DataSource(Context context) {
        if (mySQLiteHelper == null) {
            mySQLiteHelper = MySQLiteHelper.getInstance(context);
        }
    }

    public long insertStudentDetail(ModelStudentDetails modelStudentDetails) {
        return mySQLiteHelper.insertStudentDetail(modelStudentDetails);
    }

    public List<ModelStudentDetails> getAllStudents() {
        return mySQLiteHelper.getAllStudents();
    }


}
