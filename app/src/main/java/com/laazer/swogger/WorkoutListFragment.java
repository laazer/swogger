package com.laazer.swogger;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.laazer.swogger.models.ExerDataProvider;
import com.laazer.swogger.models.ExerDataProviderFactory;
import com.laazer.swogger.models.Workout;
import com.laazer.swogger.utils.FontManager;


public class WorkoutListFragment extends BasicListFragment {

    public WorkoutListFragment() {
        super();
    }

    public static WorkoutListFragment newInstance() {
        WorkoutListFragment fragment = new WorkoutListFragment();
        return fragment;
    }

    @Override
    protected void updateTitleButton(Button button) {
        button.setText(getResources().getString(R.string.add_workout));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment dayFragment = new WorkoutEditorFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, dayFragment);
                //dayFragment.setArguments(getSmallDateBundle(new Bundle()));
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

}
