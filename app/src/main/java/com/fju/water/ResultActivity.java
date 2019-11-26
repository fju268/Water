package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.sql.SQLOutput;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = ResultActivity.class.getSimpleName();
    private static final float DEFAULT_MONEY = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView month = findViewById(R.id.month_money);
        Intent intent = getIntent();
        float money = intent.getFloatExtra(getString(R.string.extra_money),DEFAULT_MONEY);
        Log.d(TAG, ""+money);
  /*       int monthInteger = (int)(money+0.5f);
         float monthFloat = (money+0.5f)-monthInteger;
   */
        
        month.setText(""+money);
    }
}
