package com.example.kisileruygulamasi.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisileruygulamasi.R;


public class KisiDetayFragment extends Fragment {
    private FragmentKisiDetayBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        tasarim = FragmentKisiDetayBinding.inflate(inflater, container, false);
        return tasarim.getRoot();
    }
}