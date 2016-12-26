package com.mathrusoft.formvalidation;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by sharanangadi on 26/12/16.
 */

public class ActivityAsycDemo extends AppCompatActivity {


    Context mContext;

    ProgressBar mProgressBar;
    Button mButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this.getApplicationContext();

        setContentView(R.layout.activity_async_demo);

        mButton = (Button) findViewById(R.id.start_async);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mButton.setOnClickListener(mOnClickListener);


    }

    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            new MyAsyncDemo().execute();
        }
    };

    ProgressDialog progressDialog;

    class MyAsyncDemo extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d("MYAPP", " Updated Code =======");

            mProgressBar.setProgress(0);

//            progressDialog = new ProgressDialog(ActivityAsycDemo.this);
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//            progressDialog.setMessage("Loading");
//            progressDialog.setIndeterminate(true);
//            progressDialog.setCancelable(false);
////            progressDialog.setMax(100);
////            progressDialog.setProgress(100);
//            progressDialog.show();

//            progressDialog = new ProgressDialog(ActivityAsycDemo.this);
//            progressDialog.show();
//            progressDialog.setIndeterminate(false);
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//            progressDialog.setMax(100);
//            progressDialog.setMessage("Please wait");
            Toast.makeText(mContext, "Before Network Call", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i * 10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
//            progressDialog.setProgress(values[0]);

            Toast.makeText(mContext, "Progress " + values[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            progressDialog.dismiss();

            Toast.makeText(mContext, "End Network Call", Toast.LENGTH_SHORT).show();

        }
    }

}
