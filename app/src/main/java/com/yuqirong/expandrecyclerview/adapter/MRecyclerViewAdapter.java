package com.yuqirong.expandrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuqirong.expandrecyclerview.R;
import com.yuqirong.mylibrary.adapter.ExpandRecyclerViewAdapter;

/**
 * Created by Anyway on 2015/12/2.
 */
public class MRecyclerViewAdapter extends ExpandRecyclerViewAdapter<String> {

    @Override
    public RecyclerView.ViewHolder createCustomViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,null);
        MViewHolder mViewHolder = new MViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void bindCustomViewHolder(RecyclerView.ViewHolder holder, int position) {
        MViewHolder mHolder = (MViewHolder) holder;
        String str = getList().get(position);
        mHolder.tv_name.setText(str);
    }

    static class MViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;

        public MViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }

    }
}
