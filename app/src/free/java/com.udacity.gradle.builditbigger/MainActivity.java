package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.corypotwin.jokepage.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends ActionBarActivity implements AsyncResponse{

    InterstitialAd mInterstitialAd;
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Loading an Interstitial Add
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                launchJokeIntent();
            }
        });

        requestNewInterstitial();
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
        findViewById(R.id.jokeLoadBar).setVisibility(View.INVISIBLE);

        // Load a new Joke whenever we come back to the Main Activity.
        new EndpointsAsyncTask().execute(new Pair<AsyncResponse, Integer>(this, 1));
    }

    /**
     * Launches InterstitialAd if it exists, else launches the joke intent
     * @param view
     */
    public void tellJoke(View view){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            findViewById(R.id.jokeLoadBar).setVisibility(View.VISIBLE);
            launchJokeIntent();
        }
    }

    /**
     * Requests a new full page interstitial ad
     */
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("B8480992F05E260480B83EF57ECC9DD2")
                .build();

        mInterstitialAd.loadAd(adRequest);
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


