package com.corypotwin.jokepage;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public final String JOKE_TAG = "joke";

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeTextViewOne = (TextView) rootView.findViewById(R.id.joke_part_1);
        TextView jokeTextViewTwo = (TextView) rootView.findViewById(R.id.joke_part_2);

        Intent jokeIntent = getActivity().getIntent();
        String jokePartOne = jokeIntent.getStringExtra(JOKE_TAG);

        if(jokePartOne != null){
            jokeTextViewOne.setText(jokePartOne);
        } else if(!isNetWorkAvailable(getContext())){
            jokeTextViewTwo.setText(getString(R.string.no_network));
        } else {
            jokeTextViewTwo.setText(getString(R.string.user_too_fast));
        }

        return rootView;
    }

    public boolean isNetWorkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
