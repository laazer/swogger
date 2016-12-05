package com.laazer.swogger;

import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.laazer.swogger.models.BasicExerDataProvider;
import com.laazer.swogger.models.Day;
import com.laazer.swogger.models.ExerDataProvider;
import com.laazer.swogger.models.Schedule;
import com.laazer.swogger.models.ScheduleFactory;
import com.laazer.swogger.models.SmallDateBundleable;


/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link EmptyDayFragment.OnFragmentInteractionListener} interface to handle interaction events.
 * Use the {@link EmptyDayFragment#newInstance} factory method to create an instance of this
 * fragment.
 */
public class EmptyDayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private FloatingActionButton newWorkoutButton;
    private FloatingActionButton copyWorkoutButton;
    private FloatingActionButton restDayButton;
    private Day currentDay;
    public EmptyDayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided
     * parameters.
     *
     * @return A new instance of fragment EmptyDayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmptyDayFragment newInstance() {
        EmptyDayFragment fragment = new EmptyDayFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_empty_day, container, false);
        newWorkoutButton = (FloatingActionButton)rootView.findViewById(R.id.add);
        newWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment dayFragment = new NewWorkoutFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, dayFragment);
                //dayFragment.setArguments(getSmallDateBundle(new Bundle()));
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        copyWorkoutButton = (FloatingActionButton)rootView.findViewById(R.id.copy);
        restDayButton = (FloatingActionButton)rootView.findViewById(R.id.rest);
        Schedule schedule = ScheduleFactory.getDefaultSchedule();
        Bundle args = this.getArguments();
        currentDay = schedule.getDate(new SmallDateBundleable(args).getItem());
        ExerDataProvider dataProvider = BasicExerDataProvider.getInstance();
        if(schedule.isEmpty()) copyWorkoutButton.setVisibility(View.GONE);
        else if(dataProvider.getWorkouts().isEmpty()) copyWorkoutButton.setVisibility(View.GONE);
        // Inflate the layout for this fragment
        return rootView;
    }

    /**
     * This interface must be implemented by activities that contain this fragment to allow an
     * interaction in this fragment to be communicated to the activity and potentially other
     * fragments contained in that activity. <p> See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html" >Communicating
     * with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
