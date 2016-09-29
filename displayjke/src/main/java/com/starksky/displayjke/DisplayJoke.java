package com.starksky.displayjke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {
    public static String JOKE_KEY = "Joke key";
    String joke = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent != null){
             joke = intent.getStringExtra(JOKE_KEY);
        }
        setContentView(R.layout.activity_display_joke);
        TextView textView = (TextView)findViewById(R.id.textview_joke);
        textView.setText(joke);
    }
}
