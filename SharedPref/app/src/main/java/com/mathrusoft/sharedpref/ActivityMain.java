package com.mathrusoft.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    private EditText mEditTextTitle;
    private Button mButtonSubmit;
    private Button mButtonGetValueFromPref;

    private TextView mTextViewTitle;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();

        mTextViewTitle = (TextView)findViewById(R.id.title_from_pref);

        mEditTextTitle = (EditText) findViewById(R.id.text_title);
        mButtonSubmit = (Button) findViewById(R.id.save_to_pref);
        mButtonGetValueFromPref = (Button) findViewById(R.id.get_title_from_pref);

        mButtonSubmit.setOnClickListener(mOnClickListener);
        mButtonGetValueFromPref.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.get_title_from_pref:
                    printTitleFromPref();
                    break;
                case R.id.save_to_pref:
                    saveToPref();
                    break;
            }
        }
    };

    private void saveToPref() {
        String title = mEditTextTitle.getText().toString();

        SharedPreferences preferences = getSharedPreferences("local", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("title", title);
        editor.commit();

        Toast.makeText(mContext, "Values Saved", Toast.LENGTH_SHORT).show();
    }

    private void printTitleFromPref() {
        SharedPreferences preferences = getSharedPreferences("local", Context.MODE_PRIVATE);
        String titleFromPref = preferences.getString("title", "No Title Found");

        Toast.makeText(mContext, titleFromPref, Toast.LENGTH_SHORT).show();

        mTextViewTitle.setText(titleFromPref);

    }

}
