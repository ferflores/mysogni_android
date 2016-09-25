package com.mysogni.mysogni.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mysogni.mysogni.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DreamSavedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DreamSavedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DreamSavedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DreamSavedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DreamSavedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DreamSavedFragment newInstance(String param1, String param2) {
        DreamSavedFragment fragment = new DreamSavedFragment();
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
        View view = inflater.inflate(R.layout.fragment_dream_saved, container, false);
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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void bindEvents(final View view){
        view.findViewById(R.id.gotoDreamList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(new DreamListFragment());
            }
        });

        view.findViewById(R.id.gotoNewDream).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTo(new NewDreamFragment());
            }
        });
    }

    private void goTo(Fragment newFragment){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        transaction.replace(R.id.mainFragment, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
