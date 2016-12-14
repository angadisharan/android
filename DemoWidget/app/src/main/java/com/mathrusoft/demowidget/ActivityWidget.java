package com.mathrusoft.demowidget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityWidget extends AppCompatActivity {

    private RadioGroup mRadioGroupGender;
    private Context mContext;


    private CheckBox mCheckBoxJava;
    private CheckBox mCheckBoxAndroid;
    private CheckBox mCheckBoxJ2EE;
    private CheckBox mCheckBoxSQL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        mContext = this.getApplicationContext();

        mRadioGroupGender = (RadioGroup) findViewById(R.id.radio_group_gender);
        mRadioGroupGender.setOnCheckedChangeListener(mOnGenderRadioChanged);

        //Init Checkbox here
        mCheckBoxJava = (CheckBox) findViewById(R.id.checkbox_java);
        mCheckBoxAndroid = (CheckBox) findViewById(R.id.checkbox_android);
        mCheckBoxJ2EE = (CheckBox) findViewById(R.id.checkbox_j2ee);
        mCheckBoxSQL = (CheckBox) findViewById(R.id.checkbox_sql);

        mCheckBoxJava.setOnCheckedChangeListener(mCheckBoxChangeListener);
        mCheckBoxAndroid.setOnCheckedChangeListener(mCheckBoxChangeListener);
        mCheckBoxJ2EE.setOnCheckedChangeListener(mCheckBoxChangeListener);
        mCheckBoxSQL.setOnCheckedChangeListener(mCheckBoxChangeListener);
    }

    RadioGroup.OnCheckedChangeListener mOnGenderRadioChanged = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int id) {
            switch (id) {
                case R.id.male:
                    Toast.makeText(mContext, "Male Selected", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.female:
                    Toast.makeText(mContext, "FeMale Selected", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

    CompoundButton.OnCheckedChangeListener mCheckBoxChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()) {
                case R.id.checkbox_java:
                    Toast.makeText(mContext, "Java Checked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_android:
                    Toast.makeText(mContext, "Android Checked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_j2ee:
                    Toast.makeText(mContext, "J2EE Checked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkbox_sql:
                    Toast.makeText(mContext, "SQL Checked", Toast.LENGTH_SHORT).show();
                    break;

            }
        }
    };

}
