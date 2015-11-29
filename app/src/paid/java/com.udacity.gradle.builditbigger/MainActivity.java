package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.corypotwin.jokepage.JokeActivity;


public class MainActivity extends ActionBarActivity implements AsyncResponse{

    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public void onResume(){
        super.onResume();
        // When we come back to this activity, hide the load bar
        findViewById(R.id.jokeLoadBar).setVisibility(View.INVISIBLE);

        // Load a new Joke whenever we come back to the Main Activity.
        new EndpointsAsyncTask().execute(this);
    }

    /**
     * Sets the load bar and launches the intent
     * @param view
     */
    public void tellJoke(View view){
        findViewById(R.id.jokeLoadBar).setVisibility(View.VISIBLE);
        if(mJoke != null){
            launchJokeIntent();
        }
    }

    /**
     * Launches the jokes intent
     */
    private void launchJokeIntent(){
        Intent jokeIntent = new Intent(this, JokeActivity.class);
        jokeIntent.putExtra("joke", mJoke);
        this.startActivity(jokeIntent);
    }

    /**
     * when the Async task has finished, put the joke to mJoke
     * @param output string returned from asynctask
     */
    @Override
    public void processFinish(String output){
        mJoke = output;
    }


}


