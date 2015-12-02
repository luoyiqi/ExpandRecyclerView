package com.yuqirong.expandrecyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ProgressBar;

import com.yuqirong.expandrecyclerview.R;
import com.yuqirong.expandrecyclerview.adapter.MRecyclerViewAdapter;
import com.yuqirong.mylibrary.view.ExpandRecyclerView;

public class MainActivity extends AppCompatActivity {

    private ExpandRecyclerView mExpandRecyclerView;
    private MRecyclerViewAdapter adapter = new MRecyclerViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandRecyclerView = (ExpandRecyclerView)findViewById(R.id.mExpandRecyclerView);
        mExpandRecyclerView.setHasFixedSize(true);
        mExpandRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mExpandRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MRecyclerViewAdapter();
        mExpandRecyclerView.addHeaderView(new ProgressBar(this));
        mExpandRecyclerView.addFooterView(new ProgressBar(this));
        adapter.getList().add("A");
        adapter.getList().add("B");
        adapter.getList().add("C");
        adapter.getList().add("D");
        adapter.getList().add("E");
        adapter.getList().add("F");
        adapter.getList().add("G");
        mExpandRecyclerView.setAdapter(adapter);
    }
}
