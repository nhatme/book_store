package com.example.meowproj.HomeScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.meowproj.Adapter.SpecialOfferAdapter;
import com.example.meowproj.Model.Category;
import com.example.meowproj.Model.CategoryAdapter;
import com.example.meowproj.Model.Item;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setStatusBarAppearance();
        setViewPager2();
        setHorizontalItems();

    }
    private void setHorizontalItems() {
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.setData(getListCategory());
        binding.rcvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.prod1, "The Kite Runner", "$14.99"));
        itemList.add(new Item(R.drawable.prod2, "The NHAT Runner", "$20.99"));
        itemList.add(new Item(R.drawable.prod3, "The Best Runner", "$14.99"));
        itemList.add(new Item(R.drawable.prod4, "The Kite Meow", "$14.99"));
        itemList.add(new Item(R.drawable.prod5, "The Kite Meow", "$14.99"));

        listCategory.add(new Category(itemList));

        return listCategory;
    }

    private void setViewPager2() {
        SpecialOfferAdapter specialOfferAdapter = new SpecialOfferAdapter(this);
        binding.viewpagerOffer.setAdapter(specialOfferAdapter);
        binding.viewpagerOffer.setPageTransformer(new DepthPageTransformer());
        binding.circleOffer.setViewPager(binding.viewpagerOffer);
    }

    private void setStatusBarAppearance() {
        ActionBar actBar = getSupportActionBar();
        if (actBar != null) {
            actBar.hide();
        }

        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setNavigationBarColor(ContextCompat.getColor(this, R.color.white));
    }
}