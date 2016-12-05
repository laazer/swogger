package com.laazer.swogger;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.laazer.swogger.models.ExerDataProvider;
import com.laazer.swogger.models.ExerDataProviderFactory;
import com.laazer.swogger.models.Workout;


public class NewWorkoutFragment extends Fragment {

    private ExerDataProvider dataProvider;

    public NewWorkoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided
     * parameters.
     *
     * @return A new instance of fragment NewWorkoutFragment.
     */
    public static NewWorkoutFragment newInstance() {
        NewWorkoutFragment fragment = new NewWorkoutFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_new_workout, container, false);
        dataProvider = ExerDataProviderFactory.getDefaultProiver();
        ListView exerList = (ListView)rootView.findViewById(R.id.exercise_list);
        ListAdapter adapter = new ArrayAdapter<Workout>(getActivity(), R.layout.content_simple_string_item, dataProvider.getWorkouts());
        exerList.setAdapter(adapter);
        return rootView;
    }

}
