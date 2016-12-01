package com.laazer.swogger;

import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.laazer.swogger.models.Day;
import com.laazer.swogger.models.Schedule;
import com.laazer.swogger.models.ScheduleFactory;
import com.laazer.swogger.models.SmallDateBundleable;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String TAG = "MAIN";
    // ...
    private char topFrag = 0;
    private View rootView;
    private Schedule schedule;
    private Day currentDay;
    private Fragment topFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schedule = ScheduleFactory.getDefaultSchedule();
        currentDay = schedule.getToday();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getFragmentManager().addOnBackStackChangedListener(this);
        makeEmptyDayTopFrag();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackStackChanged() {

    }

    private void makeEmptyDayTopFrag() {
        Fragment dayFragment;
        if(currentDay.getWorkout().isEmpty()) {
            dayFragment = new EmptyDayFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, dayFragment);
            dayFragment.setArguments(getSmallDateBundle(new Bundle()));
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    private Bundle getSmallDateBundle(Bundle b) {
        return new SmallDateBundleable(currentDay.getDate()).updateBundle(b);
    }
}
