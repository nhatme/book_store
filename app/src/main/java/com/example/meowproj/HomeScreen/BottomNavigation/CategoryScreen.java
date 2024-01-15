package com.example.meowproj.HomeScreen.BottomNavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Adapter.CategoryTabItemAdapter;
import com.example.meowproj.ui.Decoration.GridSpacingItemDecoration;
import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityCategoryBinding;
import com.example.meowproj.ui.common.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class CategoryScreen extends Fragment {
    private ActivityCategoryBinding binding;
    private static final String TAG = CategoryScreen.class.getName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityCategoryBinding.inflate(inflater, container, false);
        categoryGridLayout();
        categorySelectedTab();
        return binding.getRoot();
    }

    private void categoryGridLayout() {
        CategoryTabItemAdapter categoryTabItemAdapter = new CategoryTabItemAdapter(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        binding.rcvCategoryTab.setLayoutManager(gridLayoutManager);

        categoryTabItemAdapter.setData(getListBook());
        binding.rcvCategoryTab.setAdapter(categoryTabItemAdapter);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        binding.rcvCategoryTab.addItemDecoration(new GridSpacingItemDecoration(spacingInPixels));
    }

    private void categorySelectedTab() {
        // category selected tab
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getActivity());
        binding.tabCategorySelect.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        String[] data = {"All", "Novels", "Self Love", "Science", "Romantic", "Nhat"};
        tabLayoutAdapter.setData(data);
        binding.tabCategorySelect.setAdapter(tabLayoutAdapter);
    }

    private List<ItemBook> getListBook() {
        List<ItemBook> itemBookList = new ArrayList<>();
        itemBookList.add(new ItemBook(R.drawable.image1, "The Da vinci Code", "$19.99"));
        itemBookList.add(new ItemBook(R.drawable.image2, "The Da vinci Code", "$19.99"));
        itemBookList.add(new ItemBook(R.drawable.image3, "The Da vinci Code", "$19.99"));
        itemBookList.add(new ItemBook(R.drawable.image2, "The Da vinci Code", "$19.99"));
        itemBookList.add(new ItemBook(R.drawable.image1, "The Da vinci Code", "$19.99"));

        return itemBookList;
    }

}
