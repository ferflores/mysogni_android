package com.mysogni.mysogni.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysogni.mysogni.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TagSelectionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TagSelectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TagSelectionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TagSelectionFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TagSelectionFragment newInstance(String param1, String param2) {
        TagSelectionFragment fragment = new TagSelectionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tag_selection, container, false);

        bindEvents(view);
        return view;
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
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void bindEvents(View view){
        view.findViewById(R.id.selectTagsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTagSelector();
            }
        });

        view.findViewById(R.id.gotoSavedDream).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDreamSaved();
            }
        });
    }

    private void showTagSelector(){
        final View tagSelectorView = View.inflate(this.getContext(), R.layout.tag_selector_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(this.getContext()).create();
        dialog.setView(tagSelectorView);
        dialog.show();
    }

    private void goToDreamSaved(){
        Fragment newFragment = new DreamSavedFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.mainFragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
