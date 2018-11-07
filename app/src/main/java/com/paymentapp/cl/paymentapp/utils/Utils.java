package com.paymentapp.cl.paymentapp.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.paymentapp.cl.paymentapp.R;

public class Utils {
    public static final String TAG = Utils.class.getSimpleName();

    public static void hideKeyboard(Activity activity) {
        View view = activity.findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void showSnackBar(Context context, String message, View view) {
        if (context != null) {
            if (view != null) {
                Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
                snackbar.show();
                snackbar.getView().setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            }
        } else
            Log.e(TAG, "Contexto es NULO");
    }
}
