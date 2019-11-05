package com.fju.water;

import android.app.AlertDialog;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText month;
    private EditText next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        month = findViewById(R.id.month);
        next = findViewById(R.id.next);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }





    public void calculate(View view){
        float degree_month = Float.parseFloat((month.getText().toString()));
        float degree_next = Float.parseFloat((next.getText().toString()));
        float money=0.0f;
        if(!TextUtils.isEmpty(month.getText().toString())){
            if(degree_month>=1&&degree_month<=10){
                money =(degree_month*7.35f)+0;
            }else if (degree_month>=11&&degree_month<=30){
                money =(degree_month*9.45f)-21;
            }else if (degree_month>=31&&degree_month<=50){
                money =(degree_month*11.25f)-84;
            }else if (degree_month>=51){
                money =(degree_month*12.075f)-110.25f;
            }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用: "+money)
                        .setPositiveButton("ok",null)
                        .show();


        }else if (!TextUtils.isEmpty(next.getText().toString())){
            if(degree_next>=1&&degree_next<=20){
                money =(degree_next*7.35f)+0;
            }else if (degree_next>=21&&degree_next<=60){
                money =(degree_next*9.45f)-42;
            }else if (degree_month>=61&&degree_month<=100){
                money =(degree_month*11.25f)-168;
            }else if (degree_month>=101){
                money =(degree_month*12.075f)-220.5f;
            }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用: " + money)
                        .setPositiveButton("ok", null)
                        .show();

        }




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
