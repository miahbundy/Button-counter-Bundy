package com.introtoandroid.button_counter_bundy;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    TextView showValue;
    int counter = 0;
    int initSize;
    Integer num;

    //warnings

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showValue = (TextView) findViewById(R.id.counterValue);
        initSize = (int) showValue.getTextSize();
    }

    public void countIncrease(View view){
        counter++;
        showValue.setText(Integer.toString(counter));
    }

    public void countDecrease(View view){
        counter--;
        showValue.setText(Integer.toString(counter));
    }

    public void clearCount (View view) {
        counter = 0;
        showValue.setText(Integer.toString(counter));
    }


    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        //Log.i("Instance state", "onSaveInstanceState");
        outState.putInt("count", counter);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        //Log.i("Instance state", "onSaveInstanceState");
        num = savedInstanceState.getInt("count");
        showValue.setText(num.toString());
    }
}
