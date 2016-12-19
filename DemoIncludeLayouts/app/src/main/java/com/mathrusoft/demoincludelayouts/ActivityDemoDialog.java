package com.mathrusoft.demoincludelayouts;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sharanangadi on 19/12/16.
 */

public class ActivityDemoDialog extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this.getApplicationContext();

        Log.d("MYAPP", "Updated code === updated");

//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this)
//                .setTitle("Test Title")
//                .setMessage("Content Message , welcome to test dialog")
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(mContext, "OK Clicked", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        dialogBuilder.setTitle("Test Title");
        dialogBuilder.setMessage("Content Message , welcome to test dialog");
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(mContext, "OK Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(mContext, "Cancel Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        dialogBuilder.setCancelable(false);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();


        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("I am progressing");
        progressDialog.setCancelable(false);
        progressDialog.show();


    }
}
