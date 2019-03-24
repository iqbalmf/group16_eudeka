package com.eudekagroup16.myapplication.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eudekagroup16.myapplication.R;
import com.eudekagroup16.myapplication.databinding.ItemDomainBinding;
import com.eudekagroup16.myapplication.listener.ItemDomainClickListener;
import com.eudekagroup16.myapplication.model.DomainDetail;
import com.eudekagroup16.myapplication.viewmodel.ItemDomainViewModel;

import java.util.ArrayList;
import java.util.List;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.ViewHolder> {
    List<DomainDetail> domains = new ArrayList<>();
    private ItemDomainClickListener listener;

    public DomainAdapter(ItemDomainClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemDomainBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_domain, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bindData(domains.get(position));
    }

    @Override
    public int getItemCount() {
        return domains.size();
    }

    public void setItems(List<DomainDetail> domains) {
        this.domains.clear();
        this.domains.addAll(domains);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemDomainBinding binding;
        private ItemDomainViewModel viewModel;

        ViewHolder(@NonNull ItemDomainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(final DomainDetail domainDetail) {
            viewModel = new ItemDomainViewModel(domainDetail);
            binding.setVm(viewModel);
            binding.executePendingBindings();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(domainDetail);
                }
            });
        }
    }
}
