package com.eudekagroup16.myapplication.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.databinding.ItemDomainBinding;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemDomainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_domain, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindData();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemDomainBinding binding;

        public ViewHolder(@NonNull ItemDomainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData() {

            binding.executePendingBindings();
        }
    }
}
