package com.paymentapp.cl.paymentapp.presentation.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.paymentapp.cl.paymentapp.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getName();
    ProgressDialog progress;

    abstract public int getLayout();
    abstract public void onCreateView(Bundle savedInstanceState);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(getLayout());
//        Fabric.with(this, new Crashlytics());
        ButterKnife.bind(this);
        onCreateView(savedInstanceState);
    }


    public void pushFragment(Fragment fragment, String TAG){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().setCustomAnimations(R.anim.left_out, R.anim.left_in, R.anim.right_in, R.anim.right_out).replace(R.id.contenedorPrincipalFragmento, fragment, TAG).addToBackStack("main").commit();
    }


    public void setchangeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void showProgressDialogB(Context context){
        progress = new ProgressDialog(context);
        progress.setTitle("Cargando");
        progress.show();

    }

    public void dismissDialog(){
        if(progress != null){
            progress.dismiss();
        }
    }

}
