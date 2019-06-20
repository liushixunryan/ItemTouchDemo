package me.yokeyword.itemtouchhelperdemo.adddelete;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

public class TouchHelperDemo extends android.support.v7.widget.helper.ItemTouchHelper.Callback {
    private AddAdapterDemo addAdapterDemo;

    public TouchHelperDemo(AddAdapterDemo addAdapterDemo) {
        this.addAdapterDemo=addAdapterDemo;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        //允许上下得拖动
        int dragFlags= android.support.v7.widget.helper.ItemTouchHelper.UP| android.support.v7.widget.helper.ItemTouchHelper.DOWN;
        //允许左右拖动
        int swipeFlags = android.support.v7.widget.helper.ItemTouchHelper.RIGHT|android.support.v7.widget.helper.ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        addAdapterDemo.onItemMove(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        addAdapterDemo.onItemDissmiss(viewHolder.getAdapterPosition());

    }
    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        if(actionState == android.support.v7.widget.helper.ItemTouchHelper.ACTION_STATE_SWIPE) {
            //滑动时改变Item的透明度
            final float alpha = 1 - Math.abs(dX) / (float)viewHolder.itemView.getWidth();
            viewHolder.itemView.setAlpha(alpha);
        }
    }
}