package com.example.fordlabs.fragment2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class Frag2 extends Fragment implements  Frag1.OnFragmentInteractionListener {

    TextView textView, textDesc;


    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.txtName);
        textDesc = (TextView) view.findViewById(R.id.txtDesc);
    }

    @Override
    public void onFragmentInteraction(String name, String desc) {
        textView.setText(name);
        textDesc.setText(desc);
    }
    }
