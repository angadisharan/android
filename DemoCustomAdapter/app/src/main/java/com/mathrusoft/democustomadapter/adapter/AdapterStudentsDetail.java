package com.mathrusoft.democustomadapter.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mathrusoft.democustomadapter.R;
import com.mathrusoft.democustomadapter.model.ModelStudentDetails;

import java.util.List;

/**
 * Created by sharanangadi on 28/12/16.
 */

public class AdapterStudentsDetail extends ArrayAdapter<ModelStudentDetails> {

    List<ModelStudentDetails> modelStudentDetailsList;
    Context mContext;

    public AdapterStudentsDetail(Context context, int resource,
                                 List<ModelStudentDetails> objects) {
        super(context, resource, objects);
        mContext = context;
        modelStudentDetailsList = objects;
    }


    @Override
    public int getCount() {
        Log.d("MYAPP", "inside getCount drawing item at ");

        return modelStudentDetailsList.size();
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_student_list, null);
        }

        Log.d("MYAPP", "inside getView drawing item at " + position);

        ModelStudentDetails modelStudentDetails = modelStudentDetailsList.get(position);

        ((TextView) convertView.findViewById(R.id.name)).setText(modelStudentDetails.getName());
        ((TextView) convertView.findViewById(R.id.usn)).setText(modelStudentDetails.getUsn());
        ((TextView) convertView.findViewById(R.id.branch)).setText(modelStudentDetails.getBranch());
        ((TextView) convertView.findViewById(R.id.address)).setText(modelStudentDetails.getAddress());

        return convertView;
    }
}
