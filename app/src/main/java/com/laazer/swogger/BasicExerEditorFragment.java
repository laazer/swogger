package com.laazer.swogger;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laazer.swogger.models.ExerItem;
import com.laazer.swogger.utils.FontManager;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link BasicExerEditorFragment.OnFragmentInteractionListener} interface to handle interaction
 * events. Use the {@link BasicExerEditorFragment#newInstance} factory method to create an instance
 * of this fragment.
 */
public class BasicExerEditorFragment extends Fragment {


    private ExerItem model;
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
    public static BasicExerEditorFragment newInstance() {
        BasicExerEditorFragment fragment = new BasicExerEditorFragment();
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
        return rootView;
    }


    protected void setNames(View view, String modelTitle, String listTitle, String buttonTitle) {
        TextView textView = (TextView)view.findViewById(R.id.title_edit_text);
        textView.setHint(modelTitle);
        textView = (TextView)view.findViewById(R.id.list_title_text_view);
        textView.setText(listTitle);
        textView = (TextView)view.findViewById(R.id.add_button);
        textView.setText(buttonTitle);
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
}
