package com.moringaschool.myrestaurants;

import android.content.Intent;
import android.widget.TextView;

import com.moringaschool.myrestaurants.ui.MainActivity;
import com.moringaschool.myrestaurants.ui.RestaurantsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.*;
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 27)
public class MainActivityTest {
private MainActivity activity;

    @Before
    public void setUp(){

        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView appNameTextView = activity.findViewById(R.id.appNameTextView);
        assertTrue("MyRestaurants".equals(appNameTextView.getText().toString()));
    }
    @Test
    public void secondActivityStarted(){
        activity.findViewById(R.id.findRestaurantsButton).performClick();
        Intent expectedIntent = new Intent(activity, RestaurantsActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}