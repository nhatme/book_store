package com.example.meowproj.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.HomeScreen.ViewPagerHome;
import com.example.meowproj.Model.Author;
import com.example.meowproj.Model.CategoryViewHome;
import com.example.meowproj.Model.ItemBook;
import com.example.meowproj.Model.Vendor;
import com.example.meowproj.databinding.ActivityHomeCategoryBinding;
import com.example.meowproj.ui.AuthorDetail.AuthorListFragment;
import com.example.meowproj.ui.TopWeekDetail.TopWeekGridFragment;
import com.example.meowproj.ui.VendorDetail.VendorsGridFragment;

import java.util.List;

public class CategoryViewHomeAdapter extends RecyclerView.Adapter<CategoryViewHomeAdapter.CategoryViewHolder> {
    private ActivityHomeCategoryBinding binding;
    private final Context mContext;
    private List<CategoryViewHome> mCategoryListViewHome;
    private final IClickItemListener iClickItemListener;

//    public void setIClickItemListener(IClickItemListener listener) {
//        this.iClickItemListener = listener;
//    }

    public CategoryViewHomeAdapter(Context mContext, IClickItemListener iClickItemListener) {
        this.mContext = mContext;
        this.iClickItemListener = iClickItemListener;
    }

    public interface IClickItemListener {
        void onShowBottomSheetTopWeek();

        void onShowDialogVendorModal();

        void onShowBottomSheetAuthor();
    }

    public void setData(List<CategoryViewHome> list) {
        this.mCategoryListViewHome = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ActivityHomeCategoryBinding.inflate(inflater, parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryViewHome categoryViewHome = mCategoryListViewHome.get(position);
        if (categoryViewHome == null) {
            return;
        }

        holder.rcvTopWeek.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        holder.rcvVendor.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));
        holder.rcvAuthor.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false));

        TopWeekAdapter topWeekAdapter = new TopWeekAdapter();
        topWeekAdapter.setData(categoryViewHome.getTopWeekList());

        VendorAdapter vendorAdapter = new VendorAdapter();
        vendorAdapter.setData(categoryViewHome.getVendorList());

        AuthorAdapter authorAdapter = new AuthorAdapter();
        authorAdapter.setData(categoryViewHome.getAuthorList());

        holder.rcvTopWeek.setAdapter(topWeekAdapter);
        holder.rcvVendor.setAdapter(vendorAdapter);
        holder.rcvAuthor.setAdapter(authorAdapter);

        topWeekAdapter.setOnItemClickListener(new TopWeekAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ItemBook item) {

                // Show BottomSheetFragment
                if (iClickItemListener != null) {
                    iClickItemListener.onShowBottomSheetTopWeek();
                }
            }
        });

        vendorAdapter.setOnItemClickListener(new VendorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Vendor vendor) {
                if (iClickItemListener != null) {
                    iClickItemListener.onShowDialogVendorModal();
                }
            }
        });

        authorAdapter.setOnItemClickListener(new AuthorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Author author) {
                if (iClickItemListener != null) {
                    iClickItemListener.onShowBottomSheetAuthor();
                }
            }
        });


        holder.see_more_TopWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryViewHomeAdapter.this.replaceFragment(new TopWeekGridFragment());
            }
        });

        holder.see_more_Vendor.setOnClickListener(v -> replaceFragment(new VendorsGridFragment()));

        holder.see_more_Author.setOnClickListener(v -> replaceFragment(new AuthorListFragment()));
    }

    private void replaceFragment(Fragment fragment) {
        if (mContext instanceof ViewPagerHome) {
            ViewPagerHome viewPagerHome = (ViewPagerHome) mContext;
            viewPagerHome.replaceFragment(fragment);
        }
    }

    @Override
    public int getItemCount() {
        if (mCategoryListViewHome != null) {
            return mCategoryListViewHome.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rcvTopWeek, rcvVendor, rcvAuthor;
        private TextView see_more_TopWeek, see_more_Vendor, see_more_Author;

        public CategoryViewHolder(@NonNull ActivityHomeCategoryBinding binding) {
            super(binding.getRoot());
            rcvTopWeek = binding.rcvTopWeek;
            rcvVendor = binding.rcvVendors;
            rcvAuthor = binding.rcvAuthors;
            see_more_TopWeek = binding.seeMoreTopweek;
            see_more_Vendor = binding.seeMoreVendor;
            see_more_Author = binding.seeMoreAuthor;
        }
    }
}
