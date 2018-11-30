package com.paymentapp.cl.paymentapp.presentation.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.paymentapp.cl.paymentapp.R;
import com.paymentapp.cl.paymentapp.domain.model.InfPayment;
import com.paymentapp.cl.paymentapp.domain.model.PaymentMethod;
import com.paymentapp.cl.paymentapp.presentation.listener.TypePaymentListener;
import com.paymentapp.cl.paymentapp.presentation.adapter.viewHolder.TypePaymentViewHolder;

import java.util.List;

public class TypePaymentAdapter extends RecyclerView.Adapter<TypePaymentViewHolder> {
    private Context context;
    private TypePaymentListener mListener;
    private List<PaymentMethod> mList;
    private InfPayment infPayment;

    public TypePaymentAdapter(Context applicationContext, List<PaymentMethod> body, TypePaymentListener listener) {
        this.context = applicationContext;
        this.mListener = listener;
        this.mList = body;
        infPayment = InfPayment.getInstance();
    }

    @NonNull
    @Override
    public TypePaymentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View convertView = inflater.inflate(R.layout.item_type_payment, parent, false);
        return new TypePaymentViewHolder(convertView);

    }

    @Override
    public void onBindViewHolder(@NonNull TypePaymentViewHolder holder, int position) {
        final PaymentMethod currentItem = mList.get(position);
        holder.tv_type.setText(currentItem.getName().toLowerCase());

        Glide.with(context)
                .load(currentItem.getSecureThumbnail())
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher_round))
                .into(holder.iv_type);


        if (mListener != null) {
            holder.cv_cont.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentItem.getPaymentTypeId().equals("credit_card")) {
                        infPayment.setPayment_type_id(currentItem.getPaymentTypeId());
                        infPayment.setPayment_method_id(currentItem.getId());
                        infPayment.setImagen_method(currentItem.getSecureThumbnail());
                        mListener.selectTypePayment(currentItem.getId());
                    } else {
                        mListener.showError("Solo tárjeta de crédito");
                    }
                }


            });
            holder.cv_cont.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if (currentItem.getPaymentTypeId().equals("credit_card")) {
                        infPayment.setPayment_type_id(currentItem.getPaymentTypeId());
                        infPayment.setPayment_method_id(currentItem.getId());
                        infPayment.setImagen_method(currentItem.getSecureThumbnail());
                        mListener.selectTypePayment(currentItem.getId());
                    } else {
                        mListener.showError("Solo tárjeta de crédito");

                    }
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
