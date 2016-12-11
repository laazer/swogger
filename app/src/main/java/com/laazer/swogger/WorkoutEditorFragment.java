package com.laazer.swogger;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.laazer.swogger.models.Workout;

/**
 * Created by Laazer.
 */
public class WorkoutEditorFragment extends BasicExerEditorFragment {

    private Workout model;

    /**
     * Use this factory method to create a new instance of this fragment using the provided
     * parameters.
     *
     * @return A new instance of fragment WorkoutEditorFragment.
     */
    public static WorkoutEditorFragment newInstance() {
        WorkoutEditorFragment fragment = new WorkoutEditorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        model = new Workout();
        EditText title = (EditText)rootView.findViewById(R.id.title_edit_text);
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //do nothing
            }

            @Override
            public void afterTextChanged(Editable s) {
                model.setName(s.toString().trim());
            }
        });
        Resources resources = getResources();
        setNames(rootView, resources.getString(R.string.workout_name_hint),
                resources.getString(R.string.exercises), resources.getString(R.string.add_exercise));
        return rootView;
    }

}
