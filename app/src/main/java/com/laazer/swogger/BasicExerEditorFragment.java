package com.laazer.swogger;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.laazer.common.collections.KVPair;
import com.laazer.swogger.models.ExerItem;
import com.laazer.swogger.models.ExerItemFactory;
import com.laazer.swogger.utils.FontManager;
import com.laazer.swogger.utils.ViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link BasicExerEditorFragment.OnFragmentInteractionListener} interface to handle interaction
 * events. Use the {@link BasicExerEditorFragment#newInstance} factory method to create an instance
 * of this fragment.
 */
public class BasicExerEditorFragment extends Fragment {


    private ExerItem model;
    private int state;
    private OnFragmentInteractionListener mListener;

    public BasicExerEditorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of this fragment using the provided
     * parameters.
     *
     * @return A new instance of fragment BasicExerEditorFragment.
     */
    public static BasicExerEditorFragment newInstance(int state) {
        BasicExerEditorFragment fragment = new BasicExerEditorFragment();
        fragment.model = ExerItemFactory.getExerItem(state);
        fragment.state = state;
        Bundle args = new Bundle();
        fragment.setArguments(args);
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
        View rootView = inflater.inflate(R.layout.fragment_basic_editor, container, false);
        FontManager fontManager = new FontManager(getActivity());
        fontManager.markAsIconContainer(rootView.findViewById(R.id.button_pair_frame),
                FontManager.FONTAWESOME);
        setNames(rootView);
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
                model.setName(s.toString());
            }
        });
        ListView listView = (ListView)rootView.findViewById(R.id.item_list_view);
        ListAdapter adapter = new ItemPairAdapter(getActivity(), model.getItems());
        listView.setAdapter(adapter);
        Button addButton = (Button)rootView.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtils.simpleFragmentStart(getFragmentManager(), R.id.content_frame, getAddButtonFragment());
            }
        });

        return rootView;
    }

    private void setNames(View view) {
        Resources res = getResources();
        switch (this.state) {
            case ExerItemFactory.WORKOUT: setNames(view, res.getString(R.string.workout_name_hint),
                    res.getString(R.string.exercises), res.getString(R.string.add_exercise)); return;
            case ExerItemFactory.EXERCISE: setNames(view, res.getString(R.string.exer_name_hint),
                    res.getString(R.string.sets), res.getString(R.string.add_set)); return;
            case ExerItemFactory.SET: setNames(view, res.getString(R.string.workout_name_hint),
                    res.getString(R.string.exercises), res.getString(R.string.add_exercise)); return;
        }
    }

    protected void setNames(View view, String modelTitle, String listTitle, String buttonTitle) {
        TextView textView = (TextView)view.findViewById(R.id.title_edit_text);
        textView.setHint(modelTitle);
        textView = (TextView)view.findViewById(R.id.list_title_text_view);
        textView.setText(listTitle);
        textView = (TextView)view.findViewById(R.id.add_button);
        textView.setText(buttonTitle);
    }

    private Fragment getAddButtonFragment() {
        switch (this.state) {
            case ExerItemFactory.WORKOUT: return new ExerciseListFragment();
            default: return new ExerSetListFragment();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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

    class ItemPairAdapter extends ArrayAdapter<KVPair<String, Integer>> {
        public ItemPairAdapter(Context context, List<String> items) {
            super(context, R.layout.content_item_set, new ArrayList<KVPair<String, Integer>>());
            ArrayList<KVPair<String, Integer>> arrayList = new ArrayList<>();
            for (int i = 1; i < items.size(); i++) {
                if (arrayList.size() == 0)
                    arrayList.add(new KVPair<>(items.get(i), 1));
                else {
                    KVPair<String, Integer> item = arrayList.get(arrayList.size() - 1);
                    String name = items.get(i);
                    if(item.getKey().equals(name)) item.setValue(item.getValue() + 1);
                    else arrayList.add(new KVPair<>(name, 1));
                }
            }
            this.addAll(arrayList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            KVPair<String, Integer> item = getItem(position);
            TextView leftItem = (TextView)convertView.findViewById(R.id.left_item);
            TextView rightItem = (TextView)convertView.findViewById(R.id.right_item);
            leftItem.setText(item.getKey());
            rightItem.setText(rightItem.toString());
            return convertView;
        }

    }
}
