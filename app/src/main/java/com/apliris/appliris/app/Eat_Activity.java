package com.apliris.appliris.app;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Eat_Activity extends ActionBarActivity {
    private Drawable imageDraw;
    private String string;
    private int i;
    private boolean mIsClickEvent;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsClickEvent = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);
        setTitle("");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        LinearLayout layout = (LinearLayout) findViewById(R.id.eat_top);
        for (i = 0; i < 27; i++) {
            View view = getLayoutInflater().inflate(R.layout.data_list, null);
            layout.addView(view);

            LinearLayout eatlayout = (LinearLayout) view.findViewById(R.id.list_button);
            eatlayout.setBackgroundResource(R.drawable.frame_4);

            eatlayout.setClickable(true);
            eatlayout.setOnClickListener(new View.OnClickListener() {
                int data = i;

                @Override
                public void onClick(View view) {
                    Intent infoint = new Intent(Eat_Activity.this, Information_Activity.class);
                    if(mIsClickEvent) return;
                    mIsClickEvent = true;
                    infoint.putExtra("data", data);
                    infoint.putExtra("Activity", 3);
                    startActivity(infoint);
                }
            });

            //配列からタイトルを呼び出してセット
            TypedArray Array = getResources().obtainTypedArray(R.array.eat_title);
            string = Array.getString(i);
            TextView titletxt = (TextView) view.findViewById(R.id.list_title);
            titletxt.setText(string);


            //企画者をセット
            Array = getResources().obtainTypedArray(R.array.eat_person);
            TextView personText = (TextView) view.findViewById(R.id.list_person);
            string = Array.getString(i);
            personText.setText(string);

            //場所をセット
            Array = getResources().obtainTypedArray(R.array.eat_place);
            TextView placeText = (TextView) view.findViewById(R.id.list_place);
            string = Array.getString(i);
            placeText.setText(string);

            //画像をセット
            TypedArray Arrayimage = getResources().obtainTypedArray(R.array.eat_image);
            ImageView imageImage = (ImageView) view.findViewById(R.id.list_image);
            imageDraw = Arrayimage.getDrawable(i);
            imageImage.setImageDrawable(imageDraw);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = true;
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                result = super.onOptionsItemSelected(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
