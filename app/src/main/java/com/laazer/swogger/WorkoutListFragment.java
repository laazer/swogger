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


public class WorkoutListFragment extends Fragment {

    private ExerDataProvider dataProvider;

    public WorkoutListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided
     * parameters.
     *
     * @return A new instance of fragment WorkoutListFragment.
     */
    public static WorkoutListFragment newInstance() {
        WorkoutListFragment fragment = new WorkoutListFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_simple_list, container, false);
        FontManager fontManager = new FontManager(getActivity());
        fontManager.markAsIconContainer(rootView.findViewById(R.id.button_pair_frame),
                FontManager.FONTAWESOME);
        dataProvider = ExerDataProviderFactory.getDefaultProiver();
        Button addExerciseButton = (Button)rootView.findViewById(R.id.add_button);
        addExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new BasicListFragment(); //TODO set to corect type of list
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                //dayFragment.setArguments(getSmallDateBundle(new Bundle()));
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        ListView exerList = (ListView)rootView.findViewById(R.id.basic_list);
        ListAdapter adapter = new ArrayAdapter<Workout>(getActivity(), R.layout.content_simple_string_item, dataProvider.getWorkouts());
        exerList.setAdapter(adapter);
        return rootView;
    }

}
