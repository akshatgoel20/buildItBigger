package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.starksky.displayjke.DisplayJoke;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    public String joke = null;
    public boolean testflag = false;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button) root.findViewById(R.id.button_joke);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJoke();
            }
        });


        return root;
    }

    private void fetchJoke() {
        new EndpointsAsyncTask().execute(this);
    }

    public void launchJokeActivity() {
        if (!testflag) {
            Intent intent = new Intent(getActivity(), DisplayJoke.class);
            intent.putExtra(DisplayJoke.JOKE_KEY, joke);
            startActivity(intent);
        }
    }
}
