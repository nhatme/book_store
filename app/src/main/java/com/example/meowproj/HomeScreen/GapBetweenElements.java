package com.example.meowproj.HomeScreen;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GapBetweenElements extends RecyclerView.ItemDecoration {

    private final int spacing;

    public GapBetweenElements(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        // Apply spacing to all items except the first one
        if (position > 0) {
            outRect.left = spacing;
        }
    }
}
