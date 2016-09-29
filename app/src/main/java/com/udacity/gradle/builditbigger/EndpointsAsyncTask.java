package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.akshat.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by akshat on 29/09/16.
 */

public class EndpointsAsyncTask extends AsyncTask<MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private MainActivityFragment mainActivityFragment ;
    @Override
    protected String doInBackground(MainActivityFragment... params) {
        mainActivityFragment = params[0];
        context = mainActivityFragment.getActivity();

        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://192.168.1.3:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {

            return myApiService.getJoke().execute().getData();
        }catch (Exception e){
           return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
      //  Toast.makeText(context, s, Toast.LENGTH_LONG).show();
        mainActivityFragment.joke = s ;
        mainActivityFragment.launchJokeActivity();


    }
}
