package com.musamohannad.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView temp;
    static Button button;
    private int tempFinals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button9);


        DownloadTask getData = new DownloadTask();
        getData.execute("https://samples.openweathermap.org/data/2.5/weather?lat=29&lon=95&appid=524f5bed27b2fee5b488c047beef0530");

    }

    public static void setTempFinals(int tempFinals) {
        tempFinals = tempFinals;
    }

    public void ontap(View V){

    }
}