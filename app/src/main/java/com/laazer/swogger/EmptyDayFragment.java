package com.laazer.swogger;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link EmptyDayFragment.OnFragmentInteractionListener} interface to handle interaction events.
 * Use the {@link EmptyDayFragment#newInstance} factory method to create an instance of this
 * fragment.
 */
public class EmptyDayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private Button newWorkoutButton;
    private Button copyWorkoutButton;
    private Button restDayButton;

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
        newWorkoutButton = (Button)rootView.findViewById(R.id.add);
        copyWorkoutButton = (Button)rootView.findViewById(R.id.copy);
        restDayButton = (Button)rootView.findViewById(R.id.rest);
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
