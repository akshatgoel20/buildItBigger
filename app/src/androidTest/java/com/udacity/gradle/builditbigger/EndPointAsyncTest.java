package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Created by akshat on 29/09/16.
 */
@RunWith(AndroidJUnit4.class)
public class EndPointAsyncTest {

    @Test
    public void testasyncfetch () throws InterruptedException {
        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        mainActivityFragment.testflag = true ;
        new EndpointsAsyncTask().execute(mainActivityFragment);
        Thread.sleep(5000);
        assertTrue( "Error: fetchedJoke is : " + mainActivityFragment.joke,mainActivityFragment.joke.contains("joke teller"));
    }
}
