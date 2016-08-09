package com.lee.greendao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lee.greendao.R;
import com.lee.greendao.db.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ExampleAdapter
 * Auther lijun lee mingyangnc@163.com
 * Date 2016/8/8 11:49
 */
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleHolder> {

    private List<User> mList;

    private Context mContext;

    public ExampleAdapter(Context context, List<User> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public ExampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ExampleHolder(LayoutInflater.from(mContext).inflate(R.layout.example_item_layout, null));
    }

    @Override
    public void onBindViewHolder(ExampleHolder holder, int position) {
        holder.userIdTv.setText("userId : " + mList.get(position).getUserId());
        holder.nameTv.setText("name : " + mList.get(position).getName());
        holder.ageTv.setText("age : " + mList.get(position).getAge());
        holder.locaTv.setText("城市 : " + mList.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void setList(List<User> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public List<User> getList() {
        return mList;
    }

    public void cleanData() {
        if (null != mList)
            mList.clear();
        notifyDataSetChanged();
    }

    public void addMoreList(List<User> list) {
        if (mList == null) {
            this.mList = new ArrayList<User>();
            mList.addAll(list);
            notifyDataSetChanged();
        } else {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void addMore(User data) {
        if (mList == null) {
            this.mList = new ArrayList<User>();
            mList.add(data);
            notifyDataSetChanged();
        } else {
            mList.add(data);
            notifyDataSetChanged();
        }
    }

    class ExampleHolder extends RecyclerView.ViewHolder {

        TextView locaTv;
        TextView userIdTv;
        TextView nameTv;
        TextView ageTv;

        public ExampleHolder(View itemView) {
            super(itemView);
            locaTv = (TextView) itemView.findViewById(R.id.locaTv);
            userIdTv = (TextView) itemView.findViewById(R.id.userIdTv);
            nameTv = (TextView) itemView.findViewById(R.id.nameTv);
            ageTv = (TextView) itemView.findViewById(R.id.ageTv);
        }
    }
}
