package com.yuqirong.mylibrary.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.yuqirong.mylibrary.adapter.ExpandRecyclerViewAdapter;

/**
 * 扩展的RecyclerView
 * Created by Anyway on 2015/12/2.
 */
public class ExpandRecyclerView extends RecyclerView {

    //头view
    private View mHeaderView;
    //尾view
    private View mFooterView;

    /**
     * 添加头View,在 setAdapter(Adapter adapter) 之前调用
     * @param mHeaderView
     */
    public void addHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
    }

    /**
     * 添加尾View,在 setAdapter(Adapter adapter) 之前调用
     * @param mFooterView
     */
    public void addFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
    }

    public ExpandRecyclerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public ExpandRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    //初始化ExpandRecyclerView
    private void initView() {

    }

    public ExpandRecyclerView(Context context) {
        this(context, null);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter instanceof ExpandRecyclerViewAdapter){
            if(mHeaderView!=null)
                ((ExpandRecyclerViewAdapter) adapter).addHeaderView(mHeaderView);
            if(mFooterView!=null)
                ((ExpandRecyclerViewAdapter) adapter).addFooterView(mFooterView);
        }
    }
}
