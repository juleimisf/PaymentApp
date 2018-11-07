package com.paymentapp.cl.paymentapp.domain.interceptors;

import com.paymentapp.cl.paymentapp.utils.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        String token = Constants.user != null ? Constants.user.getTokenComposed() : "";
        Request newRequest = originalRequest.newBuilder()
                .header("Referer", token)
                .header("Content-Type", "application/json")
                .build();

        return  chain.proceed(newRequest);
    }
}
