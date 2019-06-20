package me.yokeyword.itemtouchhelperdemo.adddelete;

public interface IOperationData {
    /**
     * 数据交换
     * @param fromPosition
     * @param toPosition
     */
    void onItemMove(int fromPosition, int toPosition);

    /**
     * 数据删除
     * @param position
     */
    void onItemDissmiss(int position);
}
