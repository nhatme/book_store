package com.example.meowproj.ui.AuthorDetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meowproj.Model.Author;
import com.example.meowproj.R;
import com.example.meowproj.databinding.FragmentAuthorListBinding;
import com.example.meowproj.ui.common.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class AuthorListFragment extends Fragment {
    private FragmentAuthorListBinding binding;

    public AuthorListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAuthorListBinding.inflate(inflater, container, false);

        AuthorItemListAdapter authorItemListAdapter = new AuthorItemListAdapter(getActivity());
        authorItemListAdapter.setData(getListData());
        binding.rcvAuthorList.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        binding.rcvAuthorList.setAdapter(authorItemListAdapter);
        authorListSelectedTab();
        return binding.getRoot();
    }

    private void authorListSelectedTab() {
        // vendor grid selected tab
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getActivity());
        binding.rcvTablayout.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        String[] data = {"All", "Books", "Poems", "Special for you", "Stationary", "Poems"};
        tabLayoutAdapter.setData(data);
        binding.rcvTablayout.setAdapter(tabLayoutAdapter);
    }

    @Nullable
    private List<Author> getListData() {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(R.drawable.author1, "John Freeman", "", "American writer he was the editor of the"));
        authors.add(new Author(R.drawable.author2, "John Freeman", "", "He is the senior fiction editor of guernica ma fdfd fsdfsdfsd dfdf He is the senior dfdf df df dfd"));
        authors.add(new Author(R.drawable.author3, "John Freeman", "", "He is the professor and Linda R . Meier and "));
        authors.add(new Author(R.drawable.author4, "John Freeman", "", "Gunty was born and raised in south bend,indiana"));
        authors.add(new Author(R.drawable.author5, "John Freeman", "", "She is the author of the novels A Good Hard"));
        authors.add(new Author(R.drawable.author6, "John Freeman", "", "American writer he was the editor of the"));
        return authors;
    }
}