package com.laazer.swogger;

import android.app.FragmentTransaction;
import android.app.Fragment;
import android.os.Bundle;
import android.app.FragmentManager;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.laazer.swogger.models.Day;
import com.laazer.swogger.models.Schedule;
import com.laazer.swogger.models.ScheduleFactory;
import com.laazer.swogger.models.SmallDateBundleable;
import com.laazer.swogger.utils.FontManager;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private static final String TAG = "MAIN";
    // ...
    private View rootView;
    private Schedule schedule;
    private Day currentDay;
    private int dayOffset;
    private FontManager fontManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schedule = ScheduleFactory.getDefaultSchedule();
        currentDay = schedule.getToday();
        rootView = findViewById(R.id.activity_main);
        dayOffset = 0;
        setContentView(R.layout.activity_main);
        Button nextDay = (Button)findViewById(R.id.next_day_btn);
        Button prevDay = (Button)findViewById(R.id.prev_day_btn);
        fontManager = new FontManager(this);
        fontManager.markAsIconContainer(findViewById(R.id.date_picker), FontManager.FONTAWESOME);
        nextDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayOffset++;
                setDay();
            }
        });
        prevDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayOffset--;
                setDay();
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getFragmentManager().addOnBackStackChangedListener(this);
        makeEmptyDayTopFrag();
        fontManager.destroy();
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
        FragmentManager fm = getFragmentManager();
        if(fm.getBackStackEntryCount() < 2) {
            findViewById(R.id.date_picker).setVisibility(View.VISIBLE);
            View content = findViewById(R.id.content_frame);
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)content.getLayoutParams();
            params.topMargin = (int)getResources().getDimension(R.dimen.under_date_picker_top_margin);
            content.setLayoutParams(params);
        }
        else {
            findViewById(R.id.date_picker).setVisibility(View.GONE);
            View content = findViewById(R.id.content_frame);
            CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams)content.getLayoutParams();
            params.topMargin = (int)getResources().getDimension(R.dimen.under_action_bar_top_margin);
            content.setLayoutParams(params);
        }
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
        return new SmallDateBundleable(currentDay.getSmallDate()).updateBundle(b);
    }

    private void setDay() {
        currentDay = schedule.getDateByOffset(dayOffset);
        TextView tv = (TextView)findViewById(R.id.date_text_view);
        if (dayOffset == 0) {
            tv.setText("Today");
        } else {
            tv.setText(currentDay.toString());
        }
    }

}
