package com.example.meowproj.ui.AuthorDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.meowproj.R;
import com.example.meowproj.databinding.BottomSheetAuthorBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetAuthorFragment extends BottomSheetDialogFragment {

    private BottomSheetAuthorBinding binding;

    public BottomSheetAuthorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = BottomSheetAuthorBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

}