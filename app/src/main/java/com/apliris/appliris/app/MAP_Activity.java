package com.apliris.appliris.app;

import android.app.TabActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MAP_Activity extends TabActivity {
    private TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);
        setTitle("");

        tabhost = getTabHost();

        tabhost.addTab(tabhost.newTabSpec("Me").setContent(R.id.contentlayout1)
                .setIndicator("Me"));
        tabhost.addTab(tabhost.newTabSpec("EE").setContent(R.id.contentlayout2)
                .setIndicator("EE"));
        tabhost.addTab(tabhost.newTabSpec("Ci").setContent(R.id.contentlayout3)
                .setIndicator("Ci"));
        tabhost.addTab(tabhost.newTabSpec("Ec").setContent(R.id.contentlayout4)
                .setIndicator("Ec"));
        tabhost.addTab(tabhost.newTabSpec("Mb").setContent(R.id.contentlayout5)
                .setIndicator("Mb"));
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
