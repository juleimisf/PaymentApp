package com.paymentapp.cl.paymentapp.presentation.adapter.viewHolder;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.paymentapp.cl.paymentapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstallmentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_type) public TextView tv_type;
    @BindView(R.id.container) public ConstraintLayout container;

    public InstallmentViewHolder(View convertView) {
        super(convertView);
        ButterKnife.bind(this, convertView);
    }

}
