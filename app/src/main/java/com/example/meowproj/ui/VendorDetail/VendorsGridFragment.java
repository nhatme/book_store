package com.example.meowproj.ui.VendorDetail;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meowproj.R;
import com.example.meowproj.databinding.FragmentVendorsGridBinding;
import com.example.meowproj.ui.common.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class VendorsGridFragment extends Fragment {

    private FragmentVendorsGridBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVendorsGridBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        VendorGridAdapter vendorGridAdapter = new VendorGridAdapter(getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        binding.rcvVendorsGrid.setLayoutManager(gridLayoutManager);
        vendorGridAdapter.setData(getListVendors());
        binding.rcvVendorsGrid.setAdapter(vendorGridAdapter);
        vendorGridSelectedTab();

        return view;
    }

    private void vendorGridSelectedTab() {
        // vendor grid selected tab
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getActivity());
        binding.rcvTablayout.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        String[] data = {"All", "Books", "Poems", "Special for you", "Stationary", "Poems"};
        tabLayoutAdapter.setData(data);
        binding.rcvTablayout.setAdapter(tabLayoutAdapter);

    }

    private List<VendorsItem> getListVendors() {
        List<VendorsItem> vendorsItemList = new ArrayList<>();
        Resources resources = getResources();
        int resourceId = resources.getIdentifier("ic_star_16", "drawable", getActivity().getPackageName());
        int resourceId2 = resources.getIdentifier("ic_star_filled_16", "drawable", getActivity().getPackageName());
        if (resourceId != 0 && resourceId2 != 0) {
            // The resource was found, you can use it now
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor1, 3, R.drawable.ic_star_16, R.drawable.ic_star_filled_16, "Wattpad"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor2, 2, R.drawable.ic_star_16, R.drawable.ic_star_filled_16, "Kuromi"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor3, 5, R.drawable.ic_star_16, R.drawable.ic_star_filled_16, "Crane & Co"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor4, 6, resourceId, resourceId2, "GooDay"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor5, 3, resourceId, resourceId2, "Warehouse"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor6, 1, resourceId, resourceId2, "Peppa Pig"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor7, 5, resourceId, resourceId2, "Jstor"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor8, 4, resourceId, resourceId2, "Peloton"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor9, 4, resourceId, resourceId2, "Warehouse"));
            vendorsItemList.add(new VendorsItem(R.drawable.lg_vendor3, 4, resourceId, resourceId2, "Kuromi"));
        } else {
            Log.e("NHATE", "Cannot found image1");
        }

        return vendorsItemList;
    }
}