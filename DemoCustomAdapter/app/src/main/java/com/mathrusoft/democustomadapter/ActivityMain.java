package com.mathrusoft.democustomadapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.mathrusoft.democustomadapter.adapter.AdapterStudentsDetail;
import com.mathrusoft.democustomadapter.database.DataSource;
import com.mathrusoft.democustomadapter.model.ModelStudentDetails;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity {

    ListView mListView;

    List<ModelStudentDetails> mStudentDetailsList = new ArrayList<>();

    AdapterStudentsDetail mAdapterStudentsDetail;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this.getApplicationContext();


        mAdapterStudentsDetail = new AdapterStudentsDetail(this.getApplicationContext(),
                -1, mStudentDetailsList);

        initialiseDummyStudentList();


        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(mAdapterStudentsDetail);
    }

    private void initialiseDummyStudentList() {

        ModelStudentDetails modelStudentDetails = new ModelStudentDetails();
        modelStudentDetails.setName("Ram");
        modelStudentDetails.setAddress("123 Bengaluru");
        modelStudentDetails.setUsn("123123");
        modelStudentDetails.setBranch("MCA");

        DataSource dataSource = new DataSource(mContext);
        long id = dataSource.insertStudentDetail(modelStudentDetails);
        Toast.makeText(mContext, "Student inserted " + id, Toast.LENGTH_SHORT).show();
        Log.d("MYAPP", " id ==============" + id);


//        mStudentDetailsList = dataSource.getAllStudents();
        mStudentDetailsList.clear();
        mStudentDetailsList.addAll(dataSource.getAllStudents());
        mAdapterStudentsDetail.notifyDataSetChanged();

        Log.d("MYAPP", " mStudentDetailsList size ======= " + mStudentDetailsList.size());


//        modelStudentDetails = new ModelStudentDetails();
//        modelStudentDetails.setName("Sita");
//        modelStudentDetails.setAddress("123 Mysuru");
//        modelStudentDetails.setUsn("123245");
//        modelStudentDetails.setBranch("CS");
//        mStudentDetailsList.add(modelStudentDetails);
//
//        modelStudentDetails = new ModelStudentDetails();
//        modelStudentDetails.setName("Laxman");
//        modelStudentDetails.setAddress("123 Bengaluru");
//        modelStudentDetails.setUsn("123125");
//        modelStudentDetails.setBranch("Mech");
//        mStudentDetailsList.add(modelStudentDetails);
//
//        modelStudentDetails = new ModelStudentDetails();
//        modelStudentDetails.setName("Ravan");
//        modelStudentDetails.setAddress("123 SriLanka");
//        modelStudentDetails.setUsn("420");
//        modelStudentDetails.setBranch("Civil");
//        mStudentDetailsList.add(modelStudentDetails);
//
//
//        for (int i = 0; i < 100; i++) {
//            modelStudentDetails = new ModelStudentDetails();
//            modelStudentDetails.setName("Dummmy student name" + i);
//            modelStudentDetails.setAddress("Dummmy student Address" + i);
//            modelStudentDetails.setUsn("Dummmy student USN" + i);
//            modelStudentDetails.setBranch("Dummmy student branch" + i);
//            mStudentDetailsList.add(modelStudentDetails);
//        }

    }


}
