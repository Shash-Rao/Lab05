package com.raoshashwat.lab05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    String TAG = "com.raoshashwat.lab03.sharedprefs";
    TextView textDisplay1;
    TextView textDisplay2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ConstraintLayout layout;

    int countonCreate = 0;
    int countonStart = 0;
    int countonResume = 0;
    int countonPause = 0;
    int countonStop = 0;
    int countonRestart = 0;
    int countonDestroy = 0;

    int countonCreateLoc = 0;
    int countonStartLoc = 0;
    int countonResumeLoc = 0;
    int countonPauseLoc = 0;
    int countonStopLoc = 0;
    int countonRestartLoc = 0;
    int countonDestroyLoc = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDisplay1 = findViewById(R.id.text_display1);
        textDisplay2 = findViewById(R.id.text_display2);
        layout = findViewById(R.id.activity_main_layout);
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        editor = sharedPreferences.edit();
        layout.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View view)
            {
                editor.clear().apply();
                setInitialValues();
                storeValues();
                return false;
            }
        });
        setInitialValues();
        countonCreate ++;
        countonCreateLoc ++;
        storeValues();
    }

    private void setInitialValues()
    {
        countonCreate = sharedPreferences.getInt("onCreate", 0);
        countonStart = sharedPreferences.getInt("onStart", 0);
        countonResume = sharedPreferences.getInt("onResume", 0);
        countonPause = sharedPreferences.getInt("onPause", 0);
        countonStop = sharedPreferences.getInt("onStop", 0);
        countonRestart = sharedPreferences.getInt("onRestart", 0);
        countonDestroy = sharedPreferences.getInt("onDestroy", 0);

        countonCreateLoc = 0;
        countonStartLoc = 0;
        countonResumeLoc = 0;
        countonPauseLoc = 0;
        countonStopLoc = 0;
        countonRestartLoc = 0;
        countonDestroyLoc = 0;
    }

    private void storeValues()
    {
        editor.putInt("onCreate", countonCreate);
        editor.putInt("onStart", countonStart);
        editor.putInt("onResume", countonResume);
        editor.putInt("onPause", countonPause);
        editor.putInt("onStop", countonStop);
        editor.putInt("onRestart", countonRestart);
        editor.putInt("onDestroy", countonDestroy);
        editor.apply();

        displayVals();
    }

    private void displayVals()
    {
        textDisplay1.setText(
                "onCreate: " + countonCreate + "\n" +
                "onStart: " + countonStart + "\n" +
                "onResume: " + countonResume + "\n" +
                "onPause: " + countonPause + "\n" +
                "onStop: " + countonStop + "\n" +
                "onRestart: " + countonRestart + "\n" +
                "onDestroy: " + countonDestroy + "\n");

        textDisplay2.setText(
                "onCreate: " + countonCreateLoc + "\n" +
                "onStart: " + countonStartLoc + "\n" +
                "onResume: " + countonResumeLoc + "\n" +
                "onPause: " + countonPauseLoc + "\n" +
                "onStop: " + countonStopLoc + "\n" +
                "onRestart: " + countonRestartLoc + "\n" +
                "onDestroy: " + countonDestroyLoc + "\n");
    }

    @Override
    public void onClick(View view)
    {
        TextView x = (TextView) view;
        x.setText("" + (Integer.parseInt(x.getText().toString()) + 1));
        editor.putString(x.getTag().toString(), x.getText().toString());
    }

    protected void onStart()
    {
        super.onStart();
        countonStart ++;
        countonStartLoc ++;
        storeValues();
    }
    protected void onResume()
    {
        super.onResume();
        countonResume ++;
        countonResumeLoc ++;
        storeValues();
    }
    protected void onPause()
    {
        super.onPause();
        countonPause ++;
        countonPauseLoc ++;
        storeValues();
    }
    protected void onStop()
    {
        super.onStop();
        countonStop ++;
        countonStopLoc ++;
        storeValues();
    }
    protected void onRestart()
    {
        super.onRestart();
        countonRestart ++;
        countonRestartLoc ++;
        storeValues();
    }
    protected void onDestroy()
    {
        super.onDestroy();
        countonDestroy ++;
        countonDestroyLoc ++;
        storeValues();
    }

}