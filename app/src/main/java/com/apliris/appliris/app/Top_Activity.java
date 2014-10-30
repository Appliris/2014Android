package com.apliris.appliris.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Top_Activity extends ActionBarActivity {
    private boolean mIsClickEvent;

    @Override
    protected void onResume() {
        super.onResume();
        mIsClickEvent = false;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        int x = findViewById(R.id.main).getWidth();
        int y = findViewById(R.id.main).getHeight();
        SharedPreferences pref = getSharedPreferences( "DisplaySize", MODE_PRIVATE );

        SharedPreferences.Editor editor = pref.edit();

        editor.putInt( "user_width", x);
        editor.putInt( "user_height", y);
        editor.commit();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        setTitle("");
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Button eventBtn = (Button) findViewById(R.id.Event);
        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsClickEvent) return;
                mIsClickEvent = true;
                Intent eventInt = new Intent();
                eventInt.setClass(Top_Activity.this, Event_Activity.class);
                startActivity(eventInt);

            }
        });
        Button TimetableBtn = (Button) findViewById(R.id.TimeTable);
        TimetableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mIsClickEvent) return;
                mIsClickEvent = true;
                Intent TimeInt = new Intent();
                TimeInt.setClass(Top_Activity.this, TimetableActivity.class);
                startActivity(TimeInt);
            }
        });
        Button MapBtn = (Button) findViewById(R.id.MAP);
        MapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIsClickEvent) return;
                mIsClickEvent = true;
                Intent MapInt = new Intent();
                MapInt.setClass(Top_Activity.this, Main2Activity.class);
                startActivity(MapInt);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

}
