package edu.asu.msse.smurthy3.listexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Copyright (c) 2016 Shweta Murthy,
 * You may not use this file except for self-evaluation and practice
 * This file is allowed to be used for grading puroposes
 * through the spring semester 2016, ASU, by  the grader, TA and the instructor
 * Unless agreed to in writing, this material can is to be
 * distributed on an "AS IS" BASIS
 *
 * @author Shweta Murthy mailTo: smurthy3@asu.edu
 * @version 2/9/16
 */
public class Delete extends AppCompatActivity  {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.spinner);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        final Intent intent = getIntent();
        ArrayList<String> movies = intent.getStringArrayListExtra("movies");
        Log.d(this.getClass().getSimpleName(),"In on create of delete");
        Log.d(this.getClass().getSimpleName(), movies.toString());


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_spinner_item, movies
        );
    //Log.d(this.getClass().getSimpleName(), movies.toString());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Log.d(this.getClass().getSimpleName(),"set adapter");
        Button b = (Button) findViewById(R.id.ok);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("ButtonClicked");
                String s = (String) spinner.getSelectedItem();
                System.out.println(s);
                intent.setData(Uri.parse(s));
                setResult(RESULT_OK,intent);
                finish();
            }
            });

        //Log.d(this.getClass().getSimpleName(), s);


    }

   /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        m = String.valueOf(parent.getItemAtPosition(position));
        Log.d(this.getClass().getSimpleName(),m);
        Intent intent = new Intent(this,MainActivity.class);
       intent.putExtra("value",m);
       startActivity(intent);
        }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        parent.setEmptyView(parent.getEmptyView());
        finish();
    }*/
}
