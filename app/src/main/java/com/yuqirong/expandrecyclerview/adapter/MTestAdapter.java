package com.yuqirong.expandrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yuqirong.expandrecyclerview.R;
import com.yuqirong.mylibrary.adapter.ExpandRecyclerViewAdapter;

/**
 * Created by Anyway on 2015/12/20.
 */
public class MTestAdapter extends ExpandRecyclerViewAdapter<String> {

    private int[] PIC_IDS = new int[]{
            R.drawable.wall01, R.drawable.wall02, R.drawable.wall03, R.drawable.wall04,
            R.drawable.wall05, R.drawable.wall06, R.drawable.wall07, R.drawable.wall08,
            R.drawable.wall09, R.drawable.wall10, R.drawable.wall01, R.drawable.wall02,
            R.drawable.wall03, R.drawable.wall04, R.drawable.wall05, R.drawable.wall06,
            R.drawable.wall07, R.drawable.wall08, R.drawable.wall09, R.drawable.wall10
    };

    private final Context mContext;


    public MTestAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public RecyclerView.ViewHolder createCustomViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_wall, null);
        return new MyViewHolder(view);
    }

    @Override
    public void bindCustomViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder mholder = (MyViewHolder) holder;
        mholder.iv_bg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mholder.iv_bg.setImageResource(PIC_IDS[position]);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_name;
        private ImageView iv_bg;
        private View view_blk;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            iv_bg = (ImageView) itemView.findViewById(R.id.iv_bg);
            view_blk = itemView.findViewById(R.id.view_blk);
        }

    }

}
