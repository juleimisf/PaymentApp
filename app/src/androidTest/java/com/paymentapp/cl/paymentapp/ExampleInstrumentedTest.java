package com.paymentapp.cl.paymentapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.paymentapp.cl.paymentapp.presentation.activities.MainActivity;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.allOf;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.paymentapp.cl.paymentapp", appContext.getPackageName());
    }


//    private Matcher<View> withItemText(final String itemText) {
//        checkArgument(!TextUtils.isEmpty(itemText), "itemText cannot be null or empty");
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public boolean matchesSafely(View item) {
//                return allOf(
//                        isDescendantOfA(isAssignableFrom(RecyclerView.class)),
//                        withText(itemText)).matches(item);
//            }
//
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("is isDescendantOfA RV with text " + itemText);
//            }
//        };
//    }

    @Rule
    public ActivityTestRule<MainActivity> mNotesActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);


    @Test
    public void clickAddNoteButton_opensAddNoteUi() throws Exception {
        // Click on the add note button
        onView(withId(R.id.btn_accept)).perform(click());

        // Check if the add note screen is displayed
        onView(withId(R.id.input_amount)).check(matches(isDisplayed()));
    }
}
