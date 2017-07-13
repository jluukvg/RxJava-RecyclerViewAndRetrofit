package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.R;
import com.example.jluukvg.rxjava_jsonparserrecyclerview.model.Android;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Android> mAndroidList;

    public DataAdapter(ArrayList<Android> androidList) {
        mAndroidList = androidList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mTvName.setText(mAndroidList.get(position).getName());
        holder.mTvVersion.setText(mAndroidList.get(position).getVer());
        holder.mTvApi.setText(mAndroidList.get(position).getApi());
    }

    @Override
    public int getItemCount() {
        return mAndroidList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTvName, mTvVersion, mTvApi;

        ViewHolder(View view) {
            super(view);

            mTvName = view.findViewById(R.id.tv_name);
            mTvVersion = view.findViewById(R.id.tv_version);
            mTvApi = view.findViewById(R.id.tv_api_level);
        }
    }
}

