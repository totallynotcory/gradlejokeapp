package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.corypotwin.finalproject.jokebackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Pair<AsyncResponse, Integer>, Void, String> {
    private static MyApi myApiService = null;
    private AsyncResponse callingActivity;

    @Override
    protected String doInBackground(Pair<AsyncResponse, Integer>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://joke-server-1143.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        callingActivity = params[0].first;
        int jokeNum = params[0].second;

        try {
            return myApiService.returnJoke(jokeNum).execute().getData();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        callingActivity.processFinish(result);
    }
}