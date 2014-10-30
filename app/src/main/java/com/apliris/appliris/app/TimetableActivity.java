package com.apliris.appliris.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TimetableActivity extends ActionBarActivity {

    // アダプターを定義
    SectionsPagerAdapter mSectionsPagerAdapter;

    // ViewPagerを定義
    public ViewPager mViewPager;

    int x, y, day = 0;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        setTitle("");

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        createPager();

        SharedPreferences pref = getSharedPreferences( "DisplaySize", MODE_PRIVATE );

        x = pref.getInt( "user_width", 0) - 40;
        y = pref.getInt( "user_height", 0);


        LinearLayout layout_Top = (LinearLayout) findViewById(R.id.TimeTable_Top_Area);
        layout_Top.setLayoutParams(createPram_Top());

        LinearLayout layout_Button = (LinearLayout)findViewById(R.id.Timetable_Button_Area);
        layout_Button.setLayoutParams(createPram_Button());

        LinearLayout layout_Scroll = (LinearLayout)findViewById(R.id.Timetable_Scroll_Area);
        layout_Scroll.setLayoutParams(createPram_Scroll());

        LinearLayout layout_Bottom = (LinearLayout)findViewById(R.id.TimeTable_Bottom_Area);
        layout_Bottom.setLayoutParams(createPram_Bottom());

//        LinearLayout layout_schedule = (LinearLayout)findViewById(R.id.timetable_schedule);
//        layout_schedule.setLayoutParams(createPram_Schedule());

        LinearLayout layout = (LinearLayout) findViewById(R.id.timetabele_time);
        for (int i = 9; i < 19; i++) {
            View view = getLayoutInflater().inflate(R.layout.timetable_time, null);
            LinearLayout layout_height = (LinearLayout) view.findViewById(R.id.TimeTable_timeheight);
            layout_height.setLayoutParams(createParam_Time());
            TextView timeTxt = (TextView) view.findViewById(R.id.Timetable_timetxt);
            timeTxt.setText(i + ":00");
            layout.addView(view);
        }

        {//ボタン管理
            ImageView first_gymBtn = (ImageView) findViewById(R.id.first_gym);
            first_gymBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimetableActivity.this.mViewPager.setCurrentItem(0+day);
                }
            });
            ImageView second_gymBtn = (ImageView) findViewById(R.id.second_gym);
            second_gymBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimetableActivity.this.mViewPager.setCurrentItem(1+day);
                }
            });
            ImageView cafeBtn = (ImageView) findViewById(R.id.cafe);
            cafeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimetableActivity.this.mViewPager.setCurrentItem(2+day);
                }
            });
            ImageView firstday = (ImageView)findViewById(R.id.firstday);
            firstday.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    day = 0;;
                    TimetableActivity.this.mViewPager.setCurrentItem(0 + day);
                }
            });
            ImageView secondday = (ImageView)findViewById(R.id.secondday);
            secondday.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    day = 3;
                    TimetableActivity.this.mViewPager.setCurrentItem(0 + day);
                }
            });
            ImageView finalday = (ImageView)findViewById(R.id.finalday);
            finalday.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    day = 6;
                    TimetableActivity.this.mViewPager.setCurrentItem(0 + day);
                }
            });

        }

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                ImageView first_gymbtn = (ImageView)findViewById(R.id.first_gym);
                ImageView second_gymbtn = (ImageView)findViewById(R.id.second_gym);
                ImageView cafebtn = (ImageView)findViewById(R.id.cafe);
                ImageView firstday = (ImageView)findViewById(R.id.firstday);
                ImageView secondday = (ImageView)findViewById(R.id.secondday);
                ImageView finalday = (ImageView)findViewById(R.id.finalday);
                switch(position){
                    case 0:
                        first_gymbtn.setImageResource(R.drawable.daiichi_ari);
                        second_gymbtn.setImageResource(R.drawable.daini_nashi);
                        cafebtn.setImageResource(R.drawable.sonota_nashi);
                        firstday.setImageResource(R.drawable.h1031line);
                        secondday.setImageResource(R.drawable.h1101);
                        finalday.setImageResource(R.drawable.h1102);
                        day = 0;
                        return;
                    case 1:
                        first_gymbtn.setImageResource(R.drawable.daiichi_nashi);
                        second_gymbtn.setImageResource(R.drawable.daini_ari);
                        cafebtn.setImageResource(R.drawable.sonota_nashi);
                        day = 0;
                        return;
                    case 2:
                        first_gymbtn.setImageResource(R.drawable.daiichi_nashi);
                        second_gymbtn.setImageResource(R.drawable.daini_nashi);
                        cafebtn.setImageResource(R.drawable.sonota_ari);
                        firstday.setImageResource(R.drawable.h1031line);
                        secondday.setImageResource(R.drawable.h1101);
                        day = 0;
                        return;
                    case 3:
                        first_gymbtn.setImageResource(R.drawable.daiichi_ari);
                        second_gymbtn.setImageResource(R.drawable.daini_nashi);
                        cafebtn.setImageResource(R.drawable.sonota_nashi);
                        firstday.setImageResource(R.drawable.h1031);
                        secondday.setImageResource(R.drawable.h1101line);
                        finalday.setImageResource(R.drawable.h1102);
                        day = 3;
                        return;
                    case 4:
                        first_gymbtn.setImageResource(R.drawable.daiichi_nashi);
                        second_gymbtn.setImageResource(R.drawable.daini_ari);
                        cafebtn.setImageResource(R.drawable.sonota_nashi);
                        day = 3;
                        return;
                    case 5:
                        first_gymbtn.setImageResource(R.drawable.daiichi_nashi);
                        second_gymbtn.setImageResource(R.drawable.daini_nashi);
                        cafebtn.setImageResource(R.drawable.sonota_ari);
                        secondday.setImageResource(R.drawable.h1101line);
                        finalday.setImageResource(R.drawable.h1102);
                        day = 3;
                        return;
                    case 6:
                        first_gymbtn.setImageResource(R.drawable.daiichi_ari);
                        second_gymbtn.setImageResource(R.drawable.daini_nashi);
                        cafebtn.setImageResource(R.drawable.sonota_nashi);
                        firstday.setImageResource(R.drawable.h1031);
                        secondday.setImageResource(R.drawable.h1101);
                        finalday.setImageResource(R.drawable.h1102line);
                        day = 6;
                        return;
                    case 7:
                        first_gymbtn.setImageResource(R.drawable.daiichi_nashi);
                        second_gymbtn.setImageResource(R.drawable.daini_ari);
                        cafebtn.setImageResource(R.drawable.sonota_nashi);
                        day = 6;
                        return;
                    case 8:
                        first_gymbtn.setImageResource(R.drawable.daiichi_nashi);
                        second_gymbtn.setImageResource(R.drawable.daini_nashi);
                        cafebtn.setImageResource(R.drawable.sonota_ari);
                        day = 6;
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

    private LinearLayout.LayoutParams createPram_Schedule() {
        int w = x - 200;
        int h = (int)(y / 1.295);
        return new LinearLayout.LayoutParams(w, h);    }

    private LinearLayout.LayoutParams createPram_Bottom() {
        int w = x;
        int h = (int)(y / 12.38);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createPram_Scroll() {
        int w = x;
        int h = (int)(y / 1.295);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createPram_Button(){
        int w = x;
        int h = (int)(y / 10);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createPram_Top() {
        int w = x;
        int h = (int)(y / 12.3);
        return new LinearLayout.LayoutParams(w, h);
    }

    private LinearLayout.LayoutParams createParam_Time(){
        int w = x / 6;
        int h = (int)(y / 4.765);
        return new LinearLayout.LayoutParams(w, h);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            bundle = new Bundle();
            bundle.putInt("height",y);
            bundle.putInt("width",x / 6 * 5);

            switch (position) {
                case 0:
                       Timetable_first_tab1Activity fragment0_1 = new Timetable_first_tab1Activity();
                       fragment0_1.setArguments(bundle);
                       return fragment0_1;
                case 1:
                    Timetable_first_tab2Activity fragment1_1 = new Timetable_first_tab2Activity();
                    fragment1_1.setArguments(bundle);
                    return fragment1_1;
                case 2:
                    Timetable_first_tab3Activity fragment2 = new Timetable_first_tab3Activity();
                    fragment2.setArguments(bundle);
                    return fragment2;
                case 3:
                    Timetable_second_tab1Activity fragment0_2 = new Timetable_second_tab1Activity();
                    fragment0_2.setArguments(bundle);
                    return fragment0_2;
                case 4:
                    Timetable_second_tab2Activity fragment1_2 = new Timetable_second_tab2Activity();
                    fragment1_2.setArguments(bundle);
                    return fragment1_2;
                case 5:
                    Timetable_second_tab3Activity fragment2_2 = new Timetable_second_tab3Activity();
                    fragment2_2.setArguments(bundle);
                    return fragment2_2;
                case 6:
                    Timetable_final_tab1Activity fragment0_3 = new Timetable_final_tab1Activity();
                    fragment0_3.setArguments(bundle);
                    return fragment0_3;
                case 7:
                    Timetable_final_tab2Activity fragment1_3 = new Timetable_final_tab2Activity();
                    fragment1_3.setArguments(bundle);
                    return fragment1_3;
                case 8:
                    Timetable_final_tab3Activity fragment2_3 = new Timetable_final_tab3Activity();
                    fragment2_3.setArguments(bundle);
                    return fragment2_3;
                default:
                    return null;
            }
        }

        //タブの数
        @Override
        public int getCount() {
            return 9;
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
