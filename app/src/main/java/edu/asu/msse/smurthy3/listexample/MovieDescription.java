package edu.asu.msse.smurthy3.listexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Copyright (c) 2016 Shweta Murthy,
 * You may not use this file except for self-evaluation and practice
 * This file is allowed to be used for grading puroposes
 * through the spring semester 2016, ASU, by  the grader, TA and the instructor
 * Unless agreed to in writing, this material can is to be
 * distributed on an "AS IS" BASIS
 *
 * @author Shweta Murthy mailTo: smurthy3@asu.edu
 * @version 2/6/16
 */
public class MovieDescription extends AppCompatActivity {
    public String name;
    public int year;
    public String rated;
    public String released;
    public String genre;
    public String plot;
    public String actors;


    public MovieDescription(){

    }
    MovieDescription(String jsonStr) {
        try {
            JSONObject jo = new JSONObject(jsonStr);
            name = jo.getString("Title");
            year = jo.getInt("Year");
            rated = jo.getString("Rated");
            released = jo.getString("Released");
            genre = jo.getString("Genre");
            plot = jo.getString("Plot");
            actors = jo.getString("Actors");
            Log.d(this.getClass().getSimpleName(),"Successfully created object");
        } catch (Exception ex) {
            android.util.Log.w(this.getClass().getSimpleName(),
                    "error converting to/from json");
        }
    }
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.movie);
       final Intent intent = getIntent();
        Log.d(this.getClass().getSimpleName(),"In MovieDescription, got intent");

        final TextView t1 = (TextView) findViewById(R.id.textView1);
        final TextView t2 = (TextView) findViewById(R.id.textView2);
        final TextView t3 = (TextView) findViewById(R.id.textView3);
        final TextView t4 = (TextView) findViewById(R.id.textView4);
        final TextView t5 = (TextView) findViewById(R.id.textView5);
        final TextView t6 = (TextView) findViewById(R.id.textView6);
        final TextView t7 = (TextView) findViewById(R.id.textView7);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = String.valueOf(t1.getText());
                String actors = String.valueOf(t2.getText());
                String plot = String.valueOf(t3.getText());
                String genre = String.valueOf(t4.getText());
                String released = String.valueOf(t5.getText());
                String rated = String.valueOf(t6.getText());
                String year = String.valueOf(t7.getText());
                String movienew = new String("{\"Title\":\""+name+"\",\"Plot\":\""+plot+"\",\"Actors\":\""+actors+"\",\"Year\":\""+year+"\",\"Rated\":\""+rated+"\",\"Released\":\""+released+"\",\"Genre\":\""+genre+"\"}");
                intent.setData(Uri.parse(movienew));
                setResult(RESULT_OK, intent);
               finish();
            }
        });

    }

    public String toJsonString() {
        String ret = "";
        try {
            JSONObject jo = new JSONObject();
            jo.put("Title", name);
            jo.put("Year", year);
            jo.put("Rated", rated);
            jo.put("Released", released);
            jo.put("Genre", genre);
            jo.put("Plot", plot);
            jo.put("actors", actors);
            ret = jo.toString();
        } catch (Exception ex) {
            android.util.Log.w(this.getClass().getSimpleName(),
                    "error converting to/from json");
        }
        return ret;
    }
}
