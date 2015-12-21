package com.yuqirong.expandrecyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.yuqirong.expandrecyclerview.R;
import com.yuqirong.expandrecyclerview.adapter.MTestAdapter;
import com.yuqirong.mylibrary.view.ExpandRecyclerView;

public class MainActivity extends AppCompatActivity {

    private MTestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExpandRecyclerView recyclerView = (ExpandRecyclerView) findViewById(R.id.mRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        View headerView = View.inflate(this,R.layout.header,null);
        recyclerView.addHeaderView(headerView);
        View footerView = View.inflate(this,R.layout.footer,null);
        recyclerView.addFooterView(footerView);

        adapter = new MTestAdapter(this);
        recyclerView.setAdapter(adapter);
    }
}
