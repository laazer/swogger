
package com.laazer.swogger;

import android.view.View;
import android.widget.Button;

import com.laazer.swogger.models.ExerItemFactory;
import com.laazer.swogger.utils.ViewUtils;


public class ExerSetListFragment extends BasicListFragment {

    public ExerSetListFragment() {
        super();
    }

    public static ExerSetListFragment newInstance() {
        ExerSetListFragment fragment = new ExerSetListFragment();
        return fragment;
    }

    @Override
    protected void updateTitleButton(Button button) {
        button.setText(getResources().getString(R.string.add_set));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.simpleFragmentStart(getFragmentManager(), R.id.content_frame,
                        BasicExerEditorFragment.newInstance(ExerItemFactory.SET));
            }
        });
    }

}
