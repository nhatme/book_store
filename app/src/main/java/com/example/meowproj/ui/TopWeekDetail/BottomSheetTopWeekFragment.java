package com.example.meowproj.ui.TopWeekDetail;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.meowproj.Api.ApiService;
import com.example.meowproj.Api.Model.OneProduct.RootOneProduct;
import com.example.meowproj.R;
import com.example.meowproj.databinding.BottomSheetProductDetailBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BottomSheetTopWeekFragment extends BottomSheetDialogFragment {
    private static final String ARG_ITEM_ID = "ARG_ITEM_ID";
    private String itemId;

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

    public static BottomSheetTopWeekFragment newInstance(String itemId) {
        BottomSheetTopWeekFragment fragment = new BottomSheetTopWeekFragment();
        Bundle arg = new Bundle();
        arg.putString(ARG_ITEM_ID, itemId);
        fragment.setArguments(arg);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = BottomSheetProductDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        if (getArguments() != null) {
            itemId = getArguments().getString(ARG_ITEM_ID);
            fetchProduct();
        } else {
            Toast.makeText(getActivity(), "There's no item", Toast.LENGTH_SHORT).show();
        }

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

    private void fetchProduct() {
        ApiService.apiService.getOneProduct(itemId).enqueue(new Callback<RootOneProduct>() {
            @Override
            public void onResponse(Call<RootOneProduct> call, Response<RootOneProduct> response) {
                RootOneProduct product = null;
                if (response.isSuccessful()) {
                    product = response.body();
                    String url = "https://api-book-store-78sd.onrender.com/" + product.getProduct().getImageProduct().source;
                    Glide.with(getActivity()).load(url).into(binding.imageProduct);
                    binding.titleProduct.setText(product.getProduct().getName());
                    binding.descriptionProduct.setText(product.getProduct().getDescription());
                    binding.priceProduct.setText(String.valueOf(product.getProduct().getPrice()));
                } else {
                    Log.e("NHATOKE", product.getMessage());
                }
            }

            @Override
            public void onFailure(Call<RootOneProduct> call, Throwable t) {
                Log.e("NHATOKE", "status :" + t);
            }
        });
    }
}