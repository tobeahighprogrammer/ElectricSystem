package com.tlh.electricsystem.desk.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.desk.R;


/**
 * 工作台首页
 * A simple {@link Fragment} subclass.
 */
public class DeskFragment extends Fragment {


    public DeskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_desk, container, false);
    }

}
