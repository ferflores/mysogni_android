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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.mysogni.mysogni.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class NewDreamFragment extends Fragment implements MoodSelectionFragment.OnFragmentInteractionListener{

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String DATE_FORMAT = "MMM - dd - yyyy";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NewDreamFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static NewDreamFragment newInstance(String param1, String param2) {
        NewDreamFragment fragment = new NewDreamFragment();
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


        View view = inflater.inflate(R.layout.fragment_newdream, container, false);
        setDefaults(view);
        bindEvents(view);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    private void setDefaults(View view){
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date today = new Date();
        TextView datePickerText = (TextView)view.findViewById(R.id.datePicker);
        datePickerText.setText(dateFormat.format(today));
    }

    private void bindEvents(View view){
        TextView datePicker = (TextView)view.findViewById(R.id.datePicker);
        datePicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               showDatePicker(v);
            }
        });

        Button nextButton = (Button)view.findViewById(R.id.gotoFaces);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new MoodSelectionFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.mainFragment, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void showDatePicker(final View mainView){
        final View dialogView = View.inflate(this.getContext(), R.layout.datepicker, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(this.getContext()).create();

        dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);
                TextView datePickerText = (TextView)mainView.findViewById(R.id.datePicker);
                DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
                Calendar calendar = new GregorianCalendar(datePicker.getYear(),
                        datePicker.getMonth(),
                        datePicker.getDayOfMonth(),
                        0,
                        0);

                Date selectedDate = calendar.getTime();

                datePickerText.setText(dateFormat.format(selectedDate));

                alertDialog.dismiss();
            }});
        alertDialog.setView(dialogView);
        alertDialog.show();
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
