
package com.laazer.swogger;

import android.view.View;
import android.widget.Button;

import com.laazer.swogger.models.ExerItemFactory;
import com.laazer.swogger.utils.ViewUtils;


public class ExerciseListFragment extends BasicListFragment {

    public ExerciseListFragment() {
        super();
    }

    public static ExerciseListFragment newInstance() {
        ExerciseListFragment fragment = new ExerciseListFragment();
        return fragment;
    }

    @Override
    protected void updateTitleButton(Button button) {
        button.setText(getResources().getString(R.string.add_exercise));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.simpleFragmentStart(getFragmentManager(), R.id.content_frame,
                        BasicExerEditorFragment.newInstance(ExerItemFactory.EXERCISE));
            }
        });
    }

}
