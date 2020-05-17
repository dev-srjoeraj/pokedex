package dev.srjoeraj.pokedex.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CardSeperator extends RecyclerView.ItemDecoration {


   private final int verticalSpaceHeight;
   private final int horizontalSpaceHeight;

    public CardSeperator(int verticalSpaceHeight, int horizontalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
        this.horizontalSpaceHeight = horizontalSpaceHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
        outRect.top = verticalSpaceHeight;
        outRect.left = horizontalSpaceHeight;
        outRect.right = horizontalSpaceHeight;
    }
}
