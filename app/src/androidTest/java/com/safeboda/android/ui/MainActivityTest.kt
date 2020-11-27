package com.safeboda.android.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.safeboda.android.R
import com.safeboda.android.ui.activities.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    val activityScenarioRule: IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)


    @Test
    fun check_search_icon_displayed_and_click(){

        onView(withId(R.id.action_search)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.action_search)).perform(click())

    }

}