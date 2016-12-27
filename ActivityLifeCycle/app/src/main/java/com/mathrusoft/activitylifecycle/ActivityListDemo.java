package com.mathrusoft.activitylifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by sharanangadi on 27/12/16.
 */

public class ActivityListDemo extends AppCompatActivity {

    ListView mListView;

    List<String> mDummyStringList;
    Context mContext;

    String[] stringArray = {"one", "two", "three", "Four", "five", "Six", "one","one", "two", "three", "Four", "five", "Six", "one","one", "two", "three", "Four", "five", "Six", "one","one", "two", "three", "Four", "five", "Six", "one","one", "two", "three", "Four", "five", "Six", "one","one", "two", "three", "Four", "five", "Six", "one","one", "two", "three", "Four", "five", "Six", "one", "two", "three", "Four", "five", "Six"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo);
        mListView = (ListView) findViewById(R.id.list_view);

        mContext = this.getApplicationContext();

//        SimpleAdapter simpleAdapter = new SimpleAdapter(mContext, mDummyStringList,
//                android.R.layout.simple_list_item_1,
//                android.R.id.text1, null, null);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, android.
                R.layout.simple_list_item_1, stringArray);

        mListView.setAdapter(arrayAdapter);
    }


}
