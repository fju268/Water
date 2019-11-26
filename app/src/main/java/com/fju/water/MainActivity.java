package com.fju.water;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText month;
    float degree_month;
    float money=0.0f;
    boolean isNext =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        month = findViewById(R.id.month);
        FloatingActionButton fab = findViewById(R.id.fab);
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.tyoe);
                text.setText(isChecked?getString(R.string.every_other_month):getString(R.string.monthly));
            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String month1 = month.getText().toString();

        /*
        try {
             degree_month = Float.parseFloat((month.getText().toString()));
        }catch (Exception e){
            degree_month = 0.0f;
        }
        try {
            degree_next = Float.parseFloat((next.getText().toString()));
        }catch (Exception e){
            degree_next = 0.0f;
        }

         */
                DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        month.setText("");
                    }
                };
                if (!TextUtils.isEmpty(month1)){
                    if (!isNext) {
                        degree_month = Float.parseFloat(month1);
                        if (degree_month >= 1 && degree_month <= 10) {
                            money = (degree_month * 7.35f) + 0;
                        } else if (degree_month >= 11 && degree_month <= 30) {
                            money = (degree_month * 9.45f) - 21;
                        } else if (degree_month >= 31 && degree_month <= 50) {
                            money = (degree_month * 11.55f) - 84;
                        } else if (degree_month >= 51) {
                            money = (degree_month * 12.075f) - 110.25f;
                        }
                    }else{

                        if (degree_month >= 1 && degree_month <= 20) {
                            money = (degree_month * 7.35f) + 0;
                        } else if (degree_month >= 21 && degree_month <= 60) {
                            money = (degree_month * 9.45f) - 42;
                        } else if (degree_month >= 61 && degree_month <= 100) {
                            money = (degree_month * 11.55f) -168 ;
                        } else if (degree_month >= 101) {
                            money = (degree_month * 12.075f) - 220.5f;
                        }
                    }

                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra(getString(R.string.extra_money),money);
                    startActivity(intent);
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("每月抄表費用")
//                        .setMessage(getString(R.string.fee) + money)
//                        .setPositiveButton(R.string.ok, listener)
//                        .show();


                }

//                else if (!TextUtils.isEmpty(next1)){
//                    degree_next = Float.parseFloat(next1);
//                    if (degree_next >= 1 && degree_next <= 20) {
//                        money = (degree_next * 7.35f) + 0;
//                    } else if (degree_next >= 21 && degree_next <= 60) {
//                        money = (degree_next * 9.45f) - 42;
//                    } else if (degree_next >= 61 && degree_next <= 100) {
//                        money = (degree_next * 11.55f) -168 ;
//                    } else if (degree_next >= 101) {
//                        money = (degree_next * 12.075f) - 220.5f;
//                    }
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("隔月抄表費用")
//                            .setMessage("費用: " + money)
//                            .setPositiveButton("ok", listener)
//                            .show();
//                }else if(TextUtils.isEmpty(month1)&&TextUtils.isEmpty(next1)){
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("錯誤")
//                            .setMessage("無法計算")
//                            .setPositiveButton("ok", listener)
//                            .show();
//                }
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void calculate(View view){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
