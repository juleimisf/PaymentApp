package com.paymentapp.cl.paymentapp.presentation.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.domain.model.InfPayment;
import com.paymentapp.cl.paymentapp.domain.model.PayerCost;
import com.paymentapp.cl.paymentapp.presentation.adapter.viewHolder.InstallmentViewHolder;
import com.paymentapp.cl.paymentapp.presentation.listener.TypePaymentListener;

import java.util.List;

public class InstanllmentAdapter extends RecyclerView.Adapter<InstallmentViewHolder> {
    private Context context;
    private TypePaymentListener mListener;
    private List<PayerCost> mList;
    private InfPayment infPayment;

    public InstanllmentAdapter(Context applicationContext, List<PayerCost> body, TypePaymentListener listener) {
        this.context = applicationContext;
        this.mListener = listener;
        this.mList = body;
        infPayment = InfPayment.getInstance();
    }

    @NonNull
    @Override
    public InstallmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View convertView = inflater.inflate(R.layout.item_installment, parent, false);
        return new InstallmentViewHolder(convertView);

    }

    @Override
    public void onBindViewHolder(@NonNull InstallmentViewHolder holder, int position) {
        final PayerCost currentItem = mList.get(position);
        holder.tv_type.setText(currentItem.getRecommendedMessage());

        if (mListener != null) {
            holder.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    infPayment.setInstallment(currentItem.getRecommendedMessage());
                    mListener.selectTypePayment(currentItem.getInstallmentAmount().toString());
                }
            });
            holder.container.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    infPayment.setInstallment(currentItem.getRecommendedMessage());
                    mListener.selectTypePayment(currentItem.getInstallmentAmount().toString());
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
