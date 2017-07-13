package com.example.jluukvg.rxjava_jsonparserrecyclerview.adapter.holders;

import com.example.jluukvg.rxjava_jsonparserrecyclerview.R;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jluukvg on 3/13/2017.
 *
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    public final TextView vHeader;

    public HeaderViewHolder(View v) {
        super(v);
        vHeader = v.findViewById(R.id.section_header);
    }
}
