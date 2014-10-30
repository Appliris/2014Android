package com.apliris.appliris.app;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class Information_Activity extends ActionBarActivity {
    private Drawable imageDraw;
    private String string;
    private TextView titletxt;
    private TextView personText;
    private TextView placeText;
    private TextView messageText;
    private TypedArray Arrayimage;
    private ImageView imageImage;
    private TypedArray Array;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        setTitle("企画情報");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        int activity_data = intent.getIntExtra("Activity", 0);
        int i = intent.getIntExtra("data", 0);

        switch (activity_data) {
            case 1:;
                Array = getResources().obtainTypedArray(R.array.play_title);
                string = Array.getString(i);
                titletxt = (TextView) findViewById(R.id.Info_title);
                titletxt.setText(string);

                //企画者をセット
                Array = getResources().obtainTypedArray(R.array.play_person);
                personText = (TextView) findViewById(R.id.Info_person);
                string = Array.getString(i);
                personText.setText(string);

                //場所をセット
                Array = getResources().obtainTypedArray(R.array.play_place);
                placeText = (TextView) findViewById(R.id.Info_place);
                string = Array.getString(i);
                placeText.setText(string);

                Array = getResources().obtainTypedArray(R.array.play_message);
                messageText = (TextView) findViewById(R.id.Info_message);
                string = Array.getString(i);
                messageText.setText(string);

                //画像をセット
                Arrayimage = getResources().obtainTypedArray(R.array.play_image);
                imageImage = (ImageView) findViewById(R.id.Info_image);
                imageDraw = Arrayimage.getDrawable(i);
                imageImage.setImageDrawable(imageDraw);
                break;
            case 2:
                Array = getResources().obtainTypedArray(R.array.watch_title);
                string = Array.getString(i);
                titletxt = (TextView) findViewById(R.id.Info_title);
                titletxt.setText(string);

                //企画者をセット
                Array = getResources().obtainTypedArray(R.array.watch_person);
                personText = (TextView) findViewById(R.id.Info_person);
                string = Array.getString(i);
                personText.setText(string);

                //場所をセット
                Array = getResources().obtainTypedArray(R.array.watch_place);
                placeText = (TextView) findViewById(R.id.Info_place);
                string = Array.getString(i);
                placeText.setText(string);

                Array = getResources().obtainTypedArray(R.array.watch_message);
                messageText = (TextView) findViewById(R.id.Info_message);
                string = Array.getString(i);
                messageText.setText(string);

                //画像をセット
                Arrayimage = getResources().obtainTypedArray(R.array.watch_image);
                imageImage = (ImageView) findViewById(R.id.Info_image);
                imageDraw = Arrayimage.getDrawable(i);
                imageImage.setImageDrawable(imageDraw);
                break;
            case 3:
                Array = getResources().obtainTypedArray(R.array.eat_title);
                string = Array.getString(i);
                titletxt = (TextView) findViewById(R.id.Info_title);
                titletxt.setText(string);

                //企画者をセット
                Array = getResources().obtainTypedArray(R.array.eat_person);
                personText = (TextView) findViewById(R.id.Info_person);
                string = Array.getString(i);
                personText.setText(string);

                //場所をセット
                Array = getResources().obtainTypedArray(R.array.eat_place);
                placeText = (TextView) findViewById(R.id.Info_place);
                string = Array.getString(i);
                placeText.setText(string);

                Array = getResources().obtainTypedArray(R.array.eat_message);
                messageText = (TextView) findViewById(R.id.Info_message);
                string = Array.getString(i);
                messageText.setText(string);

                //画像をセット
                Arrayimage = getResources().obtainTypedArray(R.array.eat_image);
                imageImage = (ImageView) findViewById(R.id.Info_image);
                imageDraw = Arrayimage.getDrawable(i);
                imageImage.setImageDrawable(imageDraw);
                break;
            case 4:
                Array = getResources().obtainTypedArray(R.array.eat_title);
                string = Array.getString(i);
                titletxt = (TextView) findViewById(R.id.Info_title);
                titletxt.setText(string);

                //企画者をセット
                Array = getResources().obtainTypedArray(R.array.eat_person);
                personText = (TextView) findViewById(R.id.Info_person);
                string = Array.getString(i);
                personText.setText(string);

                //場所をセット
                Array = getResources().obtainTypedArray(R.array.eat_place);
                placeText = (TextView) findViewById(R.id.Info_place);
                string = Array.getString(i);
                placeText.setText(string);

                Array = getResources().obtainTypedArray(R.array.eat_message);
                messageText = (TextView) findViewById(R.id.Info_message);
                string = Array.getString(i);
                messageText.setText(string);

                //画像をセット
                Arrayimage = getResources().obtainTypedArray(R.array.eat_image);
                imageImage = (ImageView) findViewById(R.id.Info_image);
                imageDraw = Arrayimage.getDrawable(i);
                imageImage.setImageDrawable(imageDraw);
                break;
            default:break;
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