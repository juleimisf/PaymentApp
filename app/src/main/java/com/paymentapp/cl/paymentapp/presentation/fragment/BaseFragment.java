package com.paymentapp.cl.paymentapp.presentation.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paymentapp.cl.paymentapp.R;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getName();
    Context context;
    abstract public int getFragmentLayout();
    FragmentTransaction fragTansaction;
    ProgressDialog progress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(getFragmentLayout(),container, false);
        ButterKnife.bind(this, view);
        onViewReady(inflater, container,savedInstanceState, view );
        return  view;
    }

    abstract public void onViewReady(LayoutInflater inflater, @Nullable ViewGroup container,
                                     @Nullable Bundle savedInstanceState, View view);


    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

    public void pushFragment(Fragment frag, String tag){
        fragTansaction = getFragmentManager().beginTransaction().setCustomAnimations(R.anim.right_out, R.anim.right_in, R.anim.left_out, R.anim.left_in).replace(R.id.contenedorPrincipalFragmento, frag);
        fragTansaction.addToBackStack(null);
        fragTansaction.commit();
    }

    public void showProgressDialog(Context context){
        Log.i(TAG, "showProgressDialogB: " + context);
        progress = new ProgressDialog(context);
        progress.setMessage(getResources().getString(R.string.progress));
        progress.show();

    }

    public void dismissDialog(){
        if(progress != null){
            progress.dismiss();
        }
    }

}
