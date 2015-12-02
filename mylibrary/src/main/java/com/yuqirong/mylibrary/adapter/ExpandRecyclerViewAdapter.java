package com.yuqirong.mylibrary.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * ExpandRecyclerView的适配器
 * Created by Anyway on 2015/12/2.
 */
public abstract class ExpandRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //尾view标志
    private static final int TYPE_FOOTER = 1001;
    //头view标志
    private static final int TYPE_HEADER = 1002;
    // 头ViewHolder
    private FooterViewHolder mFooterViewHolder;
    // 尾ViewHolder
    private HeaderViewHolder mHeaderViewHolder;
    //头view
    private View mHeaderView;
    //尾view
    private View mFooterView;

    public List<T> getList() {
        return list;
    }

    private List<T> list = new ArrayList<>();


    public void addHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
    }

    public void addFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER && mHeaderView != null) {
            mHeaderViewHolder = new HeaderViewHolder(mHeaderView);
            return mHeaderViewHolder;
        } else if (viewType == TYPE_FOOTER && mFooterView != null) {
            mFooterViewHolder = new FooterViewHolder(mFooterView);
            return mFooterViewHolder;
        } else {
            return createCustomViewHolder(parent, viewType);
        }
    }

    public abstract RecyclerView.ViewHolder createCustomViewHolder(ViewGroup parent, int viewType);

    public abstract void bindCustomViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mHeaderView != null && holder.getItemViewType() == TYPE_HEADER) {
            return;
        } else if (mFooterView != null && holder.getItemViewType() == TYPE_FOOTER) {
            return;
        } else {
            if (mHeaderView != null) {
                position--;
            }
            bindCustomViewHolder(holder, position);
        }
    }

    @Override
    public int getItemCount() {
        int expandViewNum = 0;
        //如果有头View或尾View
        if (mHeaderView != null) {
            expandViewNum++;
        }
        if (mFooterView != null) {
            expandViewNum++;
        }
        return list.size() + expandViewNum;
    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView != null && position == 0) {
            return TYPE_HEADER;
        } else if (mFooterView != null && position == getItemCount() - 1) {
            return TYPE_FOOTER;
        } else {
            if (mHeaderView != null) {
                return super.getItemViewType(position - 1);
            }
            return super.getItemViewType(position);
        }
    }

    //footer viewholder
    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    //header viewhoder
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

}
