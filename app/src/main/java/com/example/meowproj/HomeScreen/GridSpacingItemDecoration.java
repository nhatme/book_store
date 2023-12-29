package com.example.meowproj.HomeScreen;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private int spacing;

    public GridSpacingItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int spanCount = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();
        int column = position % spanCount;
        Log.d("NHATD", "Position: " + Integer.toString(position));
        Log.d("NHATD", "Spancount: " + Integer.toString(spanCount));
        Log.d("NHATD", "column: " + Integer.toString(column));
        // Only add spacing between items, not on the outer edges
        outRect.left = column * spacing / spanCount;
        outRect.right = spacing - (column + 1) * spacing / spanCount;

        if (position >= spanCount) {
            outRect.top = spacing;
        }

        /*// Calculate spacing for the left and right edges
        outRect.left = spacing - column * spacing / spanCount;
        outRect.right = (column + 1) * spacing / spanCount;

        // Add spacing between items
        if (position >= spanCount) {
            outRect.top = spacing;
        }

        // Add spacing to the bottom edge
        outRect.bottom = spacing;*/
    }
}
