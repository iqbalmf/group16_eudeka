package com.eudekagroup16.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eudekagroup16.myapplication.R;

import java.util.ArrayList;

public class DetailDomainAdapter extends RecyclerView.Adapter<DetailDomainAdapter.DetailDomainViewHolder> {

    private Context context;

    private ArrayList<Pair<String, String>> details;

    public DetailDomainAdapter(Context context, ArrayList<Pair<String, String>> details) {
        this.context = context;
        this.details = details;
    }

    @NonNull
    @Override
    public DetailDomainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_detail_domain, parent, false);
        return new DetailDomainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailDomainViewHolder holder, int position) {
        holder.bind(details.get(position));
    }

    @Override
    public int getItemCount() {
        return details.size();
    }

    public class DetailDomainViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvValue;

        public DetailDomainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvValue = itemView.findViewById(R.id.tv_value);
        }

        public void bind(Pair<String, String> data){
            tvTitle.setText(data.first);
            tvValue.setText(!TextUtils.isEmpty(data.second) ? data.second : "-");
        }
    }
}
