package edu.asu.msse.smurthy3.listexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

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
public class MovieLibrary extends AppCompatActivity {

    public LinkedHashMap l;


    public MovieLibrary(){
        this.l = new LinkedHashMap();
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.movie);
        Intent i = new Intent(getIntent());
        ArrayList movie = i.getStringArrayListExtra("movie");

        TextView t1 = (TextView) findViewById(R.id.textView1);
        TextView t2 = (TextView) findViewById(R.id.textView2);
        TextView t3 = (TextView) findViewById(R.id.textView3);
        TextView t4 = (TextView) findViewById(R.id.textView4);
        TextView t5 = (TextView) findViewById(R.id.textView5);
        TextView t6 = (TextView) findViewById(R.id.textView6);
        TextView t7 = (TextView) findViewById(R.id.textView7);
        t1.setText(movie.get(0).toString());
        t2.setText(movie.get(1).toString());
        t3.setText(movie.get(2).toString());
        t4.setText(movie.get(3).toString());
        t5.setText(movie.get(4).toString());
        t6.setText(movie.get(5).toString());
        t7.setText("2015");
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }


    public void add(MovieDescription m){
        l.put(m.name, m);
       // setL(l);

    }
    public void setL(LinkedHashMap m){
        this.l = m;
        Log.d(this.getClass().getSimpleName(),"In setL in movieLibraryclass");
        MovieDescription movie = (MovieDescription) l.get("Baby");
        Log.d(this.getClass().getSimpleName(),movie.name);
    }

    public LinkedHashMap getL(){
        return this.l;
    }

    public LinkedHashMap get(){
        return l;
    }

    public LinkedHashMap remove(String title){
        if(l.containsKey(title)){
            l.remove(title);}
            return l;

    }
}
