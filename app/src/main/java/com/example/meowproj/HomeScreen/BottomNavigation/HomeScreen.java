package com.example.meowproj.HomeScreen.BottomNavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Adapter.CategoryViewHomeAdapter;
import com.example.meowproj.Adapter.SpecialOfferAdapter;
import com.example.meowproj.HomeScreen.DepthPageTransformer;
import com.example.meowproj.Model.Author;
import com.example.meowproj.Model.CategoryViewHome;
import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.Model.Vendor;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends Fragment {
    private ActivityHomeBinding binding;
    private CategoryViewHomeAdapter categoryViewHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityHomeBinding.inflate(inflater, container, false);
        setHorizontalTopItems();
        setViewPager2();
        return binding.getRoot();
    }

    private void setHorizontalTopItems() {
        categoryViewHomeAdapter = new CategoryViewHomeAdapter(getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.rcvHomeCategory.setLayoutManager(linearLayoutManager);

        categoryViewHomeAdapter.setData(getListCategory());
        binding.rcvHomeCategory.setAdapter(categoryViewHomeAdapter);
    }

    private List<CategoryViewHome> getListCategory() {
        List<CategoryViewHome> listCategoryViewHome = new ArrayList<>();

        List<ItemBook> itemBookList = new ArrayList<>();
        itemBookList.add(new ItemBook(R.drawable.prod1, "The Kite Runner", "$14.99"));
        itemBookList.add(new ItemBook(R.drawable.prod2, "The NHAT Runner", "$20.99"));
        itemBookList.add(new ItemBook(R.drawable.prod3, "The NHAT Runner", "$20.99"));
        itemBookList.add(new ItemBook(R.drawable.prod4, "The Best Runner", "$14.99"));
        itemBookList.add(new ItemBook(R.drawable.prod3, "The Best Runner", "$14.99"));
        itemBookList.add(new ItemBook(R.drawable.prod5, "The Kite Meow", "$14.99"));
        itemBookList.add(new ItemBook(R.drawable.prod2, "The Kite Meow", "$14.99"));
        itemBookList.add(new ItemBook(R.drawable.prod1, "The Kite Meow", "$14.99"));

        List<Vendor> vendorList = new ArrayList<>();
        vendorList.add(new Vendor(R.drawable.lg_vendor1));
        vendorList.add(new Vendor(R.drawable.lg_vendor2));
        vendorList.add(new Vendor(R.drawable.lg_vendor3));
        vendorList.add(new Vendor(R.drawable.lg_vendor4));
        vendorList.add(new Vendor(R.drawable.lg_vendor5));
        vendorList.add(new Vendor(R.drawable.lg_vendor6));

        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(R.drawable.author1, "The Kite Runner", "$14.99"));
        authorList.add(new Author(R.drawable.author2, "The Kite Runner", "$14.99"));
        authorList.add(new Author(R.drawable.author3, "The Kite Runner", "$14.99"));
        authorList.add(new Author(R.drawable.author4, "The Kite Runner", "$14.99"));
        authorList.add(new Author(R.drawable.author5, "The Kite Runner", "$14.99"));
        authorList.add(new Author(R.drawable.author6, "The Kite Runner", "$14.99"));

        listCategoryViewHome.add(new CategoryViewHome(itemBookList, vendorList, authorList));
        return listCategoryViewHome;
    }
    private void setViewPager2() {
        SpecialOfferAdapter specialOfferAdapter = new SpecialOfferAdapter(getActivity());
        binding.viewpagerOffer.setAdapter(specialOfferAdapter);
        binding.viewpagerOffer.setPageTransformer(new DepthPageTransformer());
        binding.circleOffer.setViewPager(binding.viewpagerOffer);
    }
}
