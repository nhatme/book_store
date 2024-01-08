package com.example.meowproj.ui.TopWeekDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.meowproj.databinding.FragmentTopweekGridBinding;

public class TopWeekGridFragment extends Fragment {
    private FragmentTopweekGridBinding binding;

    public TopWeekGridFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentTopweekGridBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        return view;
    }
}