package com.apliris.appliris.app;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import static com.apliris.appliris.app.R.drawable.*;

public class Main2Activity extends ActionBarActivity {

    // アダプターを定義
    SectionsPagerAdapter mSectionsPagerAdapter;

    // ViewPagerを定義
    public ViewPager mViewPager;

    int x, y;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("");

        LinearLayout layout = (LinearLayout) findViewById(R.id.enngeki_waku);
        Drawable drawable = getResources().getDrawable(R.drawable.enngeki_waku);
        drawable.setAlpha(254);
        layout.setBackgroundDrawable(drawable);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        createPager();

        {//ボタン管理
            Button Btn1 = (Button) findViewById(R.id.button1);
            Btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Main2Activity.this.mViewPager.setCurrentItem(0);
                }
            });
            Button Btn2 = (Button) findViewById(R.id.button2);
            Btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Main2Activity.this.mViewPager.setCurrentItem(1);
                }
            });
            Button Btn3 = (Button) findViewById(R.id.button3);
            Btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Main2Activity.this.mViewPager.setCurrentItem(2);
                }
            });
            Button Btn4 = (Button) findViewById(R.id.button4);
            Btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Main2Activity.this.mViewPager.setCurrentItem(3);
                }
            });
            Button Btn5 = (Button) findViewById(R.id.button5);
            Btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Main2Activity.this.mViewPager.setCurrentItem(4);
                }
            });
        }

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Button Btn1 = (Button) findViewById(R.id.button1);
                Button Btn2 = (Button) findViewById(R.id.button2);
                Button Btn3 = (Button) findViewById(R.id.button3);
                Button Btn4 = (Button) findViewById(R.id.button4);
                Button Btn5 = (Button) findViewById(R.id.button5);

                switch(position){
                    case 0:
                        Btn1.setBackgroundResource(R.drawable.btnon);
                        Btn2.setBackgroundResource(R.drawable.btnoff);
                        Btn3.setBackgroundResource(R.drawable.btnoff);
                        Btn4.setBackgroundResource(R.drawable.btnoff);
                        Btn5.setBackgroundResource(R.drawable.btnoff);
                        return;
                    case 1:
                        Btn1.setBackgroundResource(R.drawable.btnoff);
                        Btn2.setBackgroundResource(R.drawable.btnon);
                        Btn3.setBackgroundResource(R.drawable.btnoff);
                        Btn4.setBackgroundResource(R.drawable.btnoff);
                        Btn5.setBackgroundResource(R.drawable.btnoff);
                        return;
                    case 2:
                        Btn1.setBackgroundResource(R.drawable.btnoff);
                        Btn2.setBackgroundResource(R.drawable.btnoff);
                        Btn3.setBackgroundResource(R.drawable.btnon);
                        Btn4.setBackgroundResource(R.drawable.btnoff);
                        Btn5.setBackgroundResource(R.drawable.btnoff);
                        return;
                    case 3:
                        Btn1.setBackgroundResource(R.drawable.btnoff);
                        Btn2.setBackgroundResource(R.drawable.btnoff);
                        Btn3.setBackgroundResource(R.drawable.btnoff);
                        Btn4.setBackgroundResource(R.drawable.btnon);
                        Btn5.setBackgroundResource(R.drawable.btnoff);
                        return;
                    case 4:
                        Btn1.setBackgroundResource(R.drawable.btnoff);
                        Btn2.setBackgroundResource(R.drawable.btnoff);
                        Btn3.setBackgroundResource(R.drawable.btnoff);
                        Btn4.setBackgroundResource(R.drawable.btnoff);
                        Btn5.setBackgroundResource(R.drawable.btnon);
                        return;
                }

            }
        });
    }

    private void createPager(){
        // FragmentPagerAdapterを継承したクラスのアダプターを作成
        mSectionsPagerAdapter = new SectionsPagerAdapter(
                getSupportFragmentManager());

        // ViewPagerにSectionPagerAdapterをセット
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            bundle = new Bundle();
            bundle.putInt("position",position);


            switch (position) {
                case 0:
                    engeki_fragmentActivity fragment0 = new engeki_fragmentActivity();
                    fragment0.setArguments(bundle);
                    return fragment0;
                case 1:
                    engeki_fragmentActivity fragment1 = new engeki_fragmentActivity();
                    fragment1.setArguments(bundle);
                    return fragment1;
                case 2:
                    engeki_fragmentActivity fragment2 = new engeki_fragmentActivity();
                    fragment2.setArguments(bundle);
                    return fragment2;
                case 3:
                    engeki_fragmentActivity fragment3 = new engeki_fragmentActivity();
                    fragment3.setArguments(bundle);
                    return fragment3;
                case 4:
                    engeki_fragmentActivity fragment4 = new engeki_fragmentActivity();
                    fragment4.setArguments(bundle);
                    return fragment4;
                default:
                    return null;
            }
        }

        //タブの数
        @Override
        public int getCount() {
            return 5;
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
