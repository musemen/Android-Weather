package com.musamohannad.weatherapp;

import android.os.AsyncTask;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DownloadTask extends AsyncTask<String,Void,String> {

    String result;
    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL link;
        HttpURLConnection myconnection = null;

        try {
            link = new URL(urls[0]);
            myconnection = (HttpURLConnection)link.openConnection();
            InputStream in = myconnection.getInputStream();
            InputStreamReader myStreamReader = new InputStreamReader(in);
            int data = myStreamReader.read();
            while(data!= -1){
                char current = (char)data;
                result+= current;
                data = myStreamReader.read();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject myObject = new JSONObject(result);
            JSONObject main = new JSONObject(myObject.getString("main"));
            String temperature = main.getString("temp");
            double d = Double.parseDouble(temperature);
            double tempfinal= d - 273.5;
            final String tempfinals= Double.toString(tempfinal);

           MainActivity.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.temp.setText(tempfinals+" celcius");
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}