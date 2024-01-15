package com.example.meowproj.ui.TopWeekDetail;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.Nullable;

import com.example.meowproj.R;
import com.example.meowproj.databinding.BottomSheetProductDetailBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetTopWeekFragment extends BottomSheetDialogFragment {

    private BottomSheetProductDetailBinding binding;

    public BottomSheetTopWeekFragment() {
        // Required empty public constructor
    }
    private int qty;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = BottomSheetProductDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        qty = Integer.parseInt(binding.qtyDisplay.getText().toString());

        if (qty > 0) {
            binding.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (qty == 1) {
                        Toast.makeText(getActivity(), "Can't lower than 0", Toast.LENGTH_SHORT).show();
                    } else {
                        qty--;
                        binding.qtyDisplay.setText(String.valueOf(qty));
                    }
                }
            });
            binding.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (qty < 20) {
                        qty++;
                        binding.qtyDisplay.setText(String.valueOf(qty));
                    } else {
                        Toast.makeText(getActivity(), "Can't greater than 20", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        return view;
    }

}