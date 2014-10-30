package com.apliris.appliris.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class Event_Activity extends ActionBarActivity {
    private boolean mIsClickEvent;

    @Override
    protected void onResume() {
        super.onResume();
        mIsClickEvent = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        setTitle("");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ImageView playBtn = (ImageView)findViewById(R.id.play);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playInt = new Intent();
                if(mIsClickEvent) return;
                mIsClickEvent = true;
                playInt.setClass(Event_Activity.this, Play_Activity.class);
                startActivity(playInt);
            }
        });

        ImageView watchBtn = (ImageView)findViewById(R.id.watch);
        watchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent watchInt = new Intent();
                if(mIsClickEvent) return;
                mIsClickEvent = true;
                watchInt.setClass(Event_Activity.this, Watch_Activity.class);
                startActivity(watchInt);
            }
        });

        ImageView eatBtn = (ImageView)findViewById(R.id.eat);
        eatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eatInt = new Intent();
                if(mIsClickEvent) return;
                mIsClickEvent = true;
                eatInt.setClass(Event_Activity.this, Eat_Activity.class);
                startActivity(eatInt);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event_, menu);
        return true;
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
