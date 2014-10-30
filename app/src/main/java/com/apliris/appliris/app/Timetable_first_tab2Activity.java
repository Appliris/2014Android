package com.apliris.appliris.app;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Timetable_first_tab2Activity extends Fragment {

    int x, y;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_timetable_tab2, container, false);

        Bundle bundle = getArguments();

        y = bundle.getInt("height");
        x = bundle.getInt("width") - 50;

        LinearLayout layout = (LinearLayout) v.findViewById(R.id.timetable_tab2);
        for (int i = 0; i < 2; i++) {
            View view = inflater.inflate(R.layout.timetable_list, null);
            TextView timeTxt = (TextView) view.findViewById(R.id.timetable_list_text);
            TypedArray Array = getResources().obtainTypedArray(R.array.second_first_time);
            LinearLayout tab1 = (LinearLayout) view.findViewById(R.id.timetable_list_frame);
            tab1.setLayoutParams(create_tab1(Integer.parseInt(Array.getString(i))));
            Array = getResources().obtainTypedArray(R.array.second_first_event);
            if(Array.getString(i).length() != 0) {
                timeTxt.setText(Array.getString(i));
                LinearLayout frame = (LinearLayout) view.findViewById(R.id.timetable_list_frame);
                frame.setBackgroundResource(R.drawable.frame_1);
            }
            layout.addView(view);
        }

        return v;

    }

    private LinearLayout.LayoutParams create_tab1(int i) {
        return new LinearLayout.LayoutParams(x, (int)((y / 4.765 / 12.0) * (double)i));
    }

}