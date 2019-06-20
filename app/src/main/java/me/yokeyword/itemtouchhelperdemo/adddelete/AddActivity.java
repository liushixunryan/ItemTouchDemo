package me.yokeyword.itemtouchhelperdemo.adddelete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


import java.util.ArrayList;
import java.util.List;

import me.yokeyword.itemtouchhelperdemo.R;

public class AddActivity extends AppCompatActivity {
    private RecyclerView addrv;
    private AddAdapterDemo adapterDemo;
    private List<String> list;
    private TouchHelperDemo touchHelperDemo;
    private ItemTouchHelper.Callback callback;
    private ItemTouchHelper itemTouchHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();
    }

    private void initView() {
        addrv = findViewById(R.id.addrv);
        List<String> list= new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            list.add("Index " + i);
        }

        adapterDemo=new AddAdapterDemo(this,list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        callback = new TouchHelperDemo(adapterDemo);
        addrv.setAdapter(adapterDemo);
        addrv.setLayoutManager(manager);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(addrv);

    }


}

