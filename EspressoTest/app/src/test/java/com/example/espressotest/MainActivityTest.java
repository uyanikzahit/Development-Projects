package com.example.espressotest;

import junit.framework.TestCase;
import androidx.test.rule.ActivityTestRule;





import org.junit.Rule;

public class MainActivityTest  {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    public void setUp() throws Exception {
    }

    public void tearDown() throws Exception {
    }
}