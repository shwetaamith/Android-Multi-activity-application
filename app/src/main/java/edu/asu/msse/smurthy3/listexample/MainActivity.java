package edu.asu.msse.smurthy3.listexample;

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

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends ListActivity {
    String moviename1 = "{\"Title\":\"Baby\",\"Year\":\"2015\",\"Rated\":\"8.5\",\"Released\":\"23 Jan 2015\",\"Runtime\":\"159 min\",\"Genre\":\"Action, Crime, Thriller\",\"Director\":\"Neeraj Pandey\",\"Writer\":\"Neeraj Pandey\",\"Actors\":\"Akshay Kumar, Danny Denzongpa, Rana Daggubati, Tapsee Pannu\",\"Plot\":\"An elite counter-intelligence unit learns of a plot, masterminded by a maniacal madman. With the clock ticking, it's up to them to track the terrorists' international tentacles and prevent them from striking at the heart of India.\"}";
    String moviename2 = "{\"Title\":\"Exam\",\"Year\":\"2009\",\"Rated\":\"NOT RATED\",\"Released\":\"17 Jun 2010\",\"Runtime\":\"101 min\",\"Genre\":\"Mystery, Thriller\",\"Actors\":\"Adar Beck, Gemma Chan, Nathalie Cox, John Lloyd Fillingham\",\"Plot\":\"The final eight candidates for a highly desirable corporate job are locked together in an exam room and given a test with one question. It seems simple yet confusing that soon, tensions begin to unravel.\"}";
    String moviename3 = "{\"Title\":\"Full Metal Jacket\",\"Year\":\"1987\",\"Rated\":\"R\",\"Released\":\"10 Jul 1987\",\"Runtime\":\"116 min\",\"Genre\":\"Drama, War\",\"Director\":\"Stanley Kubrick\",\"Writer\":\"Gustav Hasford (novel), Stanley Kubrick (screenplay), Michael Herr (screenplay), Gustav Hasford (screenplay)\",\"Actors\":\"Matthew Modine, Adam Baldwin, Vincent D'Onofrio, R. Lee Ermey\",\"Plot\":\"A pragmatic U.S. Marine observes the dehumanizing effects the Vietnam War has on his fellow recruits from their brutal boot camp training to the bloody street fighting in Hue.\",\"Language\":\"English, Vietnamese\",\"Country\":\"UK, USA\",\"Awards\":\"Nominated for 1 Oscar. Another 7 wins & 9 nominations.\",\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMjA4NzY4ODk4Nl5BMl5BanBnXkFtZTgwOTcxNTYxMTE@._V1_SX300.jpg\",\"Metascore\":\"78\",\"imdbRating\":\"8.3\",\"imdbVotes\":\"457,736\",\"imdbID\":\"tt0093058\",\"Type\":\"movie\",\"Response\":\"True\"}";
    String moviename4 = "{\"Title\":\"The Shining\",\"Year\":\"1980\",\"Rated\":\"R\",\"Released\":\"23 May 1980\",\"Runtime\":\"146 min\",\"Genre\":\"Drama, Horror\",\"Director\":\"Stanley Kubrick\",\"Writer\":\"Stephen King (novel), Stanley Kubrick (screenplay), Diane Johnson (screenplay)\",\"Actors\":\"Jack Nicholson, Shelley Duvall, Danny Lloyd, Scatman Crothers\",\"Plot\":\"A family heads to an isolated hotel for the winter where an evil and spiritual presence influences the father into violence, while his psychic son sees horrific forebodings from the past and of the future.\",\"Language\":\"English\",\"Country\":\"USA, UK\",\"Awards\":\"3 wins & 5 nominations.\",\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BODMxMjE3NTA4Ml5BMl5BanBnXkFtZTgwNDc0NTIxMDE@._V1_SX300.jpg\",\"Metascore\":\"61\",\"imdbRating\":\"8.4\",\"imdbVotes\":\"569,063\",\"imdbID\":\"tt0081505\",\"Type\":\"movie\",\"Response\":\"True\"}";
    String moviename5 = "{\"Title\":\"The Proposal\",\"Year\":\"2009\",\"Rated\":\"PG-13\",\"Released\":\"19 Jun 2009\",\"Runtime\":\"108 min\",\"Genre\":\"Comedy, Drama, Romance\",\"Director\":\"Anne Fletcher\",\"Writer\":\"Pete Chiarelli\",\"Actors\":\"Sandra Bullock, Ryan Reynolds, Mary Steenburgen, Craig T. Nelson\",\"Plot\":\"A pushy boss (Sandra Bullock) forces her young assistant (Ryan Reynolds) to marry her in order to keep her Visa status in the U.S. and avoid deportation to Canada.\",\"Language\":\"English\",\"Country\":\"USA\",\"Awards\":\"Nominated for 1 Golden Globe. Another 7 wins & 18 nominations.\",\"Poster\":\"http://ia.media-imdb.com/images/M/MV5BMTU1MzY1ODIyNV5BMl5BanBnXkFtZTcwNDU4NTE3Mg@@._V1_SX300.jpg\",\"Metascore\":\"48\",\"imdbRating\":\"6.7\",\"imdbVotes\":\"215,612\",\"imdbID\":\"tt1041829\",\"Type\":\"movie\",\"Response\":\"True\"}";
    public MovieDescription m1 = new MovieDescription(moviename1);
    public MovieDescription m2 = new MovieDescription(moviename2);
    public MovieDescription m3 = new MovieDescription(moviename3);
    public MovieDescription m4 = new MovieDescription(moviename4);
    public MovieDescription m5 = new MovieDescription(moviename5);
    public List<String> movies;
    public LinkedHashMap titles;
    public MovieLibrary m;
    public ListView listView;

    // private static final String[] items={"lorem", "ipsum", "dolor", "sit", "amet", "consectetuer", "adipiscing", "elit", "morbi", "vel", "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam", "vel", "erat", "placerat", "ante", "porttitor", "sodales", "pellentesque", "augue", "purus"};
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        m = new MovieLibrary();
        m.add(m1);
        m.add(m2);
        m.add(m3);
        m.add(m4);
        m.add(m5);
        titles = m.get();

        movies = new ArrayList<String>(titles.keySet());

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,movies);
        setListAdapter(adapter);
        System.out.println(movies);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        android.util.Log.d(this.getClass().getSimpleName(), "called onCreateOptionsMenu()");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        android.util.Log.d(this.getClass().getSimpleName(), "called onOptionsItemSelected()");
        switch (item.getItemId()) {
            case R.id.action_delete:
                Intent i = new Intent(MainActivity.this,Delete.class);
                /*ArrayList a = new ArrayList();
                for( int it=0;it<movies.size();it++){
                    a.add(movies.get(it));
                }*/
                Log.d(this.getClass().getSimpleName(), "Movie names received and converted");
                //Log.d(this.getClass().getSimpleName(),a.toString());
                i.putStringArrayListExtra("movies", (ArrayList<String>) movies);
                startActivityForResult(i, 2);
                return true;
            case R.id.action_addmovie:
                m.setL(titles);
                Intent intent = new Intent(MainActivity.this, MovieDescription.class);
                startActivityForResult(intent, 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public MovieDescription mnew;
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri names = intent.getData();
                String movieinfo = names.toString();
                Log.d(this.getClass().getSimpleName(),"IN activityResult");
                Log.d(this.getClass().getSimpleName(), movieinfo);
                mnew = new MovieDescription(movieinfo);
                m.add(mnew);
                movies.add(mnew.name);
                addItems(getListView());}

            }
        if(requestCode == 2){
            if(resultCode == RESULT_OK){
                Uri value = intent.getData();
                String s = value.toString();
                Log.d(this.getClass().getSimpleName(), s);
                m.remove(s);
                movies.remove(s);
                ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,movies);
                setListAdapter(adapter);

            }

        }
        }





    public void addItems(View v) {
        ArrayAdapter adapter =new ArrayAdapter(this,android.R.layout.simple_list_item_1,movies);
        setListAdapter(adapter);
    }
        @Override
        protected void onListItemClick (ListView listView, View v,int position, long id){
            super.onListItemClick(listView, v, position, id);

            String movie = (String) listView.getItemAtPosition(position);
            Log.d(this.getClass().getSimpleName(), movie);
            LinkedHashMap n = m.get();
            MovieDescription m1 = (MovieDescription) n.get(movie);
            ArrayList<String> moviestuff = new ArrayList<String>();
            moviestuff.add(m1.name);
            moviestuff.add(m1.actors);
            moviestuff.add(m1.plot);
            moviestuff.add(m1.genre);
            moviestuff.add(m1.rated);
            moviestuff.add(m1.released);

            Intent intent = new Intent(MainActivity.this, MovieLibrary.class);
            intent.putStringArrayListExtra("movie", moviestuff);
            startActivity(intent);


        }
    }


