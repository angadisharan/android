package com.mathrusoft.demostartactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharanangadi on 15/12/16.
 */

public class ActivityLogin extends AppCompatActivity {

    private EditText mEditTextUserId;
    private EditText mEditTextUserPassword;
    private Button mButtonLogin;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this.getApplicationContext();

        mEditTextUserId = (EditText) findViewById(R.id.user_id);
        mEditTextUserPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.login);

        mButtonLogin.setOnClickListener(mOnClickListener);

        if (isUserLoginIn()) {
            Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
            ActivityLogin.this.startActivity(intent);

            ActivityLogin.this.finish();
        }
    }

    private boolean isUserLoginIn() {
        SharedPreferences preferences = getSharedPreferences("local", Context.MODE_PRIVATE);
        String userId = preferences.getString("user_id", "");
        String password = preferences.getString("password", "");

        Log.d("MYTAG", " user Id ================================= " + userId);
        Log.d("MYTAG", " password ================================= " + password);

        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(password)) {
            return false;
        }

        if (userId.equals(password)) {
            return true;
        } else {
            return false;
        }
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String userId = mEditTextUserId.getText().toString();
            String password = mEditTextUserPassword.getText().toString();

            if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(password)) {
                Toast.makeText(mContext, "Password or Username is empty", Toast.LENGTH_SHORT).show();
                return;
            }

            if (userId.equals(password)) {

                SharedPreferences preferences = getSharedPreferences("local", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("user_id", userId);
                editor.putString("password", password);
                editor.commit();

                Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                ActivityLogin.this.startActivity(intent);

                ActivityLogin.this.finish();

            } else {
                Toast.makeText(mContext, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }

        }
    };

}
