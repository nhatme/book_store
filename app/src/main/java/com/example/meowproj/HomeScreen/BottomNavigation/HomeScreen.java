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
import com.example.meowproj.ui.Decoration.DepthPageTransformer;
import com.example.meowproj.Model.Author;
import com.example.meowproj.Model.CategoryViewHome;
import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.Model.Vendor;
import com.example.meowproj.R;
import com.example.meowproj.databinding.ActivityHomeBinding;
import com.example.meowproj.ui.AuthorDetail.BottomSheetAuthorFragment;
import com.example.meowproj.ui.TopWeekDetail.BottomSheetTopWeekFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends Fragment implements CategoryViewHomeAdapter.IClickItemListener {
    public HomeScreen() {
    }

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
        categoryViewHomeAdapter = new CategoryViewHomeAdapter(getActivity(), this);

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
        authorList.add(new Author(R.drawable.author1, "John Freeman", "Writer", ""));
        authorList.add(new Author(R.drawable.author2, "Tess Gunty", "Novelist", ""));
        authorList.add(new Author(R.drawable.author3, "Richard Perston", "Writer", ""));
        authorList.add(new Author(R.drawable.author4, "The Kite Runner", "Novelists", ""));
        authorList.add(new Author(R.drawable.author5, "The Kite Runner", "Playwrights", ""));
        authorList.add(new Author(R.drawable.author6, "The Kite Runner", "Journalists", ""));

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
    public void onShowBottomSheetTopWeek() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        BottomSheetTopWeekFragment bottomSheetFragment = new BottomSheetTopWeekFragment();
        bottomSheetFragment.show(fragmentManager, bottomSheetFragment.getTag());
    }

    @Override
    public void onShowDialogVendorModal() {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_vendor_modal);

        Window window = dialog.getWindow();
        if (window == null){
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
