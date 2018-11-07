package com.paymentapp.cl.paymentapp.presentation.adapter.viewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.paymentapp.cl.paymentapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypePaymentViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_type) public TextView tv_type;
    @BindView(R.id.iv_type) public ImageView iv_type;
    @BindView(R.id.cv_cont) public CardView cv_cont;

    public TypePaymentViewHolder(View convertView) {
        super(convertView);
        ButterKnife.bind(this, convertView);
    }

}
