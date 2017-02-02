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
    TextView showIncreaseNum2;
    int counter = 0;
    int initSize;
    Integer num;
    Integer increaseByNum = 1;
    Integer incNum;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showValue = (TextView) findViewById(R.id.counterValue);
        initSize = (int) showValue.getTextSize();
        showIncreaseNum2 = (TextView) findViewById(R.id.textView2);

    }

    public void countIncrease(View view){
        counter = counter+increaseByNum;
        showValue.setText(Integer.toString(counter));
    }

    public void countDecrease(View view){
        counter = counter-increaseByNum;
        showValue.setText(Integer.toString(counter));
    }

    public void clearCount (View view) {
        counter = 0;
        showValue.setText(Integer.toString(counter));
    }

    public void countByIncrease(View view){
        increaseByNum++;
        showIncreaseNum2.setText(Integer.toString(increaseByNum));
    }

    public void countByDecrease(View view){
        if(increaseByNum > 1){
            increaseByNum--;
        }
        showIncreaseNum2.setText(Integer.toString(increaseByNum));
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        //Log.i("Instance state", "onSaveInstanceState");
        outState.putInt("count", counter);
        outState.putInt("countBy", increaseByNum);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        //Log.i("Instance state", "onSaveInstanceState");
        num = savedInstanceState.getInt("count");
        showValue.setText(num.toString());
        incNum = savedInstanceState.getInt("countBy");
        showIncreaseNum2.setText(incNum.toString());
    }
}
