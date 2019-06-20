package me.yokeyword.itemtouchhelperdemo.demochannel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.itemtouchhelperdemo.R;
import me.yokeyword.itemtouchhelperdemo.helper.ItemDragHelperCallback;

/**
 * 频道 增删改查 排序
 */
public class ChannelActivity extends AppCompatActivity {

    private RecyclerView mRecy;
    private List<ChannelEntity> items = new ArrayList<>();
    private List<ChannelEntity> otherItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mRecy = (RecyclerView) findViewById(R.id.recy);
        init();
    }

    private void init() {
        setData();

        setOtherData();


        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecy.setLayoutManager(manager);

        ItemDragHelperCallback callback = new ItemDragHelperCallback();
        final ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(mRecy);

        final ChannelAdapter adapter = new ChannelAdapter(this, helper, items, otherItems);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                return viewType == ChannelAdapter.TYPE_MY || viewType == ChannelAdapter.TYPE_OTHER ? 1 : 4;
            }
        });
        mRecy.setAdapter(adapter);

        adapter.setOnMyChannelItemClickListener(new ChannelAdapter.OnMyChannelItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(ChannelActivity.this, items.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOtherData() {
        ChannelEntity e = new ChannelEntity();
        e.setName("旅游");
        otherItems.add(e);

        ChannelEntity e1 = new ChannelEntity();
        e1.setName("汽车");
        otherItems.add(e1);

        ChannelEntity e2= new ChannelEntity();
        e2.setName("情感");
        otherItems.add(e2);

        ChannelEntity e3 = new ChannelEntity();
        e3.setName("家具");
        otherItems.add(e3);

        ChannelEntity e4 = new ChannelEntity();
        e4.setName("体育");
        otherItems.add(e4);

        ChannelEntity e5 = new ChannelEntity();
        e5.setName("美食");
        otherItems.add(e5);

        ChannelEntity e6 = new ChannelEntity();
        e6.setName("搞笑");
        otherItems.add(e6);

        ChannelEntity e7 = new ChannelEntity();
        e7.setName("财经");
        otherItems.add(e7);

        ChannelEntity e8 = new ChannelEntity();
        e8.setName("股票");
        otherItems.add(e8);

        ChannelEntity e9 = new ChannelEntity();
        e9.setName("时尚");
        otherItems.add(e9);

    }

    private void setData() {

        ChannelEntity entity = new ChannelEntity();
        entity.setName("频道");
        items.add(entity);

        ChannelEntity entity2 = new ChannelEntity();
        entity2.setName("娱乐");
        items.add(entity2);

        ChannelEntity entity3 = new ChannelEntity();
        entity3.setName("综艺");
        items.add(entity3);

        ChannelEntity entity4 = new ChannelEntity();
        entity4.setName("体育");
        items.add(entity4);

        ChannelEntity entity5 = new ChannelEntity();
        entity5.setName("游戏");
        items.add(entity5);

        ChannelEntity entity6 = new ChannelEntity();
        entity6.setName("视频");
        items.add(entity6);

        ChannelEntity entity7 = new ChannelEntity();
        entity7.setName("小说");
        items.add(entity7);
    }
}
