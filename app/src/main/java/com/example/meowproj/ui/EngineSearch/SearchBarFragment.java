package com.example.meowproj.ui.EngineSearch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.meowproj.databinding.FragmentSearchBarBinding;


public class SearchBarFragment extends Fragment {

    FragmentSearchBarBinding binding;

    public SearchBarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSearchBarBinding.inflate(inflater, container, false);


        return binding.getRoot();

    }

}