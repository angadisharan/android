package com.mathrusoft.backupclass;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sharanangadi on 28/12/16.
 */

public class LoginActivity extends AppCompatActivity {

    EditText mEditTextUserId;
    EditText mEditTextPassword;
    Button mButtonLogin;

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mContext = this.getApplicationContext();

        SharedPreferences preferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
        String userId = preferences.getString("user_id", "");
        String password = preferences.getString("password", "");

        if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(password)) {
            if (userId.equals(password)) {
                Intent intent = new Intent(mContext, ActivityMain.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.finish();
                return;
            }
        }


        mEditTextUserId = (EditText) findViewById(R.id.user_id);
        mEditTextPassword = (EditText) findViewById(R.id.password);
        mButtonLogin = (Button) findViewById(R.id.login);
        mButtonLogin.setOnClickListener(mOnClickListener);
    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String userId = mEditTextUserId.getText().toString();
            String password = mEditTextPassword.getText().toString();

            if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(password)) {
                Toast.makeText(mContext, "Userid or password empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if (userId.equals(password)) {
                Toast.makeText(mContext, "Login success", Toast.LENGTH_SHORT).show();


                SharedPreferences preferences = getSharedPreferences("my_pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("user_id", userId);
                editor.putString("password", password);
                editor.commit();


                Intent intent = new Intent(mContext, ActivityMain.class);
                LoginActivity.this.startActivity(intent);
                LoginActivity.this.finish();

                return;
            } else {
                Toast.makeText(mContext, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
