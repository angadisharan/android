package com.mathrusoft.beverageapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sharanangadi on 19/01/17.
 */

public class ActivityLogin extends AppCompatActivity {

    private EditText mEditTextUserId;
    private EditText mEditTextPassword;
    private TextView mTextViewStatus;
    private Button mButtonSubmit;

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        mContext = this.getApplicationContext();

        mEditTextUserId = (EditText) findViewById(R.id.user_id);
        mEditTextPassword = (EditText) findViewById(R.id.password);
        mButtonSubmit = (Button) findViewById(R.id.button_login);
        mTextViewStatus = (TextView) findViewById(R.id.status);
        mButtonSubmit.setOnClickListener(mOnClickListener);
    }


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String userId = mEditTextUserId.getText().toString();
            String password = mEditTextPassword.getText().toString();

            if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(password)) {
                Snackbar.make(mButtonSubmit, "User ID or Password is empty", Snackbar.LENGTH_LONG).show();
                return;
            }

            doMakeLoginCallToServer(userId, password);


        }
    };

    private void doMakeLoginCallToServer(final String userId, final String password) {
        String url = "http://location.mathrusoft.com:4002/test/login";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("MYAPP", "response " + response);

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getBoolean("success")) {
                        Toast.makeText(mContext, "user Login success ", Toast.LENGTH_SHORT).show();
                        mTextViewStatus.setText("user Login success ");
                    } else {
                        Toast.makeText(mContext, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        mTextViewStatus.setText(jsonObject.getString("message"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MYAPP", " Excepiton ", error);
                Log.d("MYAPP", "Error " + error.getMessage());
            }
        }) {

            @Override
            public byte[] getBody() throws AuthFailureError {

                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("user_name", userId);
                    jsonObject.put("password", password);

                    JSONObject details = new JSONObject();
                    details.put("address", "Vijaynagar");
                    details.put("office", "Mathrusoft");

                    jsonObject.put("details", details);


                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("MYAPP", " Excepiton ", e);
                }

//                String bodyString = "{\"user_id\":\"" + userId + "\", \"password\":\"" + password + "\"}";
//                return "{\"user_id\":\"admin\", \"password\":\"admin\"}".getBytes();

                Log.d("MYAPP", " json data " + jsonObject.toString());
                return jsonObject.toString().getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

        };

        AppControl.getInstance().getRequestQueue().add(stringRequest);
    }

}
