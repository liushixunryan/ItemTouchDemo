package me.yokeyword.itemtouchhelperdemo.adddelete;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

import me.yokeyword.itemtouchhelperdemo.R;

public class AddAdapterDemo extends RecyclerView.Adapter<AddAdapterDemo.DragViewHolder> implements IOperationData {
    private Context context;
    private List<String> list;

    //
    public AddAdapterDemo(Context context, List<String> list) {
       this.context=context;
       this.list=list;
    }

    @NonNull
    @Override
    public DragViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DragViewHolder(LayoutInflater.from(context).inflate(R.layout.item_move,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DragViewHolder dragViewHolder, int i) {
        dragViewHolder.tv_move.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
//        mDataList == null ? 0 : mDataList.size()
        return  list == null ? 0 : list.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //交换位置
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);

    }

    @Override
    public void onItemDissmiss(int position) {
        //移除数据
        list.remove(position);
        notifyItemRemoved(position);

    }

    //创建ViewHolder
    public class DragViewHolder extends RecyclerView.ViewHolder {
        TextView tv_move;
        public DragViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_move=itemView.findViewById(R.id.tv_move);
        }
    }
}
