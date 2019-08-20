package com.example.fordlabs.fragfinally;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.Logger;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

   // private OnFragmentInteractionListener mListener;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =   inflater.inflate(R.layout.fragment_fragment1, container, false);
        Button btn = view.findViewById(R.id.submit);
        final EditText name  = view.findViewById(R.id.name);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              //  String names = name.getText().toString();
                //Log.d("msg",names);


                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fmt = fm.beginTransaction();

                FragmentManager fmgr = getActivity().getSupportFragmentManager();
                FragmentTransaction ftxn = fmgr.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("name",String.valueOf(name.getText()));



                Fragment2 frag2 = new Fragment2();
                frag2.setArguments(bundle);
                ftxn.add(R.id.frameLayout,frag2);
                ftxn.commit();
            }
        });
        return view;

    }













}
