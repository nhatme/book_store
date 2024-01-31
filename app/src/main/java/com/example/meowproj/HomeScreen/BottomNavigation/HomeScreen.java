package com.example.meowproj.HomeScreen.BottomNavigation;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Adapter.CategoryViewHomeAdapter;
import com.example.meowproj.Adapter.SpecialOfferAdapter;
import com.example.meowproj.Api.ApiService;
import com.example.meowproj.Api.Model.Product.Product;
import com.example.meowproj.Api.Model.Product.RootProduct;
import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.ui.Decoration.DepthPageTransformer;
import com.example.meowproj.Model.Author;
import com.example.meowproj.Model.CategoryViewHome;
import com.example.meowproj.Model.Vendor;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityHomeBinding;
import com.example.meowproj.ui.AuthorDetail.BottomSheetAuthorFragment;
import com.example.meowproj.ui.TopWeekDetail.BottomSheetTopWeekFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreen extends Fragment implements CategoryViewHomeAdapter.IClickItemListener {
    private static final String TAG = "NHAT_LOG";

    public HomeScreen() {
    }

    private ActivityHomeBinding binding;
    private CategoryViewHomeAdapter categoryViewHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityHomeBinding.inflate(inflater, container, false);
        callAPI();
        setViewPager2();
        return binding.getRoot();
    }

    private void setHorizontalTopItems(List<CategoryViewHome> listCategoryViewHome) {
        categoryViewHomeAdapter = new CategoryViewHomeAdapter(getActivity(), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.rcvHomeCategory.setLayoutManager(linearLayoutManager);

        categoryViewHomeAdapter.setData(listCategoryViewHome);
        binding.rcvHomeCategory.setAdapter(categoryViewHomeAdapter);
    }

    public void callAPI() {
        ApiService.apiService.getAllProducts().enqueue(new Callback<RootProduct>() {
            @Override
            public void onResponse(Call<RootProduct> call, Response<RootProduct> response) {
                if (response.isSuccessful()) {
                    RootProduct rootProduct = response.body();
                    Toast.makeText(getActivity(), "Call API: " + rootProduct.getMessage() + " " + response.code(), Toast.LENGTH_SHORT).show();
                    List<ItemBook> itemBookList = convertToItemBook(rootProduct);
                    List<CategoryViewHome> listCategoryViewHome = getListCategory(itemBookList);
                    setHorizontalTopItems(listCategoryViewHome);
                } else {
                    Toast.makeText(getActivity(), "Call API error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RootProduct> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), "get products error 3 / server offline", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<ItemBook> convertToItemBook(RootProduct rootProduct) {
        List<ItemBook> itemBookList = new ArrayList<>();
        List<Product> productList = rootProduct.getProducts();
        for (Product product : productList) {
            ItemBook itemBook = new ItemBook(
                    product.getId(),
                    product.getImageProduct().getSource(),
                    product.getName(),
                    String.valueOf(product.getPrice())
            );
            itemBookList.add(itemBook);
        }
        return itemBookList;
    }

    private List<CategoryViewHome> getListCategory(List<ItemBook> itemBookList) {
        final List<CategoryViewHome> listCategoryViewHome = new ArrayList<>();

        List<Vendor> vendorList = new ArrayList<>();
        vendorList.add(new Vendor(R.drawable.lg_vendor1));
        vendorList.add(new Vendor(R.drawable.lg_vendor1));
        vendorList.add(new Vendor(R.drawable.lg_vendor1));
        vendorList.add(new Vendor(R.drawable.lg_vendor1));
        vendorList.add(new Vendor(R.drawable.lg_vendor1));
        vendorList.add(new Vendor(R.drawable.lg_vendor1));
        vendorList.add(new Vendor(R.drawable.lg_vendor1));

        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));

        listCategoryViewHome.add(new CategoryViewHome(itemBookList, vendorList, authorList));
        return listCategoryViewHome;
    }

    private void setViewPager2() {
        SpecialOfferAdapter specialOfferAdapter = new SpecialOfferAdapter(getActivity());
        binding.viewpagerOffer.setAdapter(specialOfferAdapter);
        binding.viewpagerOffer.setPageTransformer(new DepthPageTransformer());
        binding.circleOffer.setViewPager(binding.viewpagerOffer);
    }

    @Override
    public void onShowBottomSheetTopWeek(String itemId) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        BottomSheetTopWeekFragment bottomSheetFragment = BottomSheetTopWeekFragment.newInstance(itemId);
        bottomSheetFragment.show(fragmentManager, bottomSheetFragment.getTag());
    }

    @Override
    public void onShowDialogVendorModal() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_vendor_modal);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btn1 = dialog.findViewById(R.id.entered_dismiss);
        Button btn2 = dialog.findViewById(R.id.entered_explore);
        btn1.setOnClickListener(v -> dialog.dismiss());
        btn2.setOnClickListener(v -> Toast.makeText(getActivity(), "No data", Toast.LENGTH_SHORT).show());
        dialog.show();
    }

    @Override
    public void onShowBottomSheetAuthor() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        BottomSheetAuthorFragment bottomSheetFragment = new BottomSheetAuthorFragment();
        bottomSheetFragment.show(fragmentManager, bottomSheetFragment.getTag());
    }
}
