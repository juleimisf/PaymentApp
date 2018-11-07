package com.paymentapp.cl.paymentapp.utils;

import com.paymentapp.cl.paymentapp.domain.model.User;

public class Constants {
    public static final String BASE_URL = "https://api.mercadopago.com/v1/";
    public static final String PUBLIC_KEY = "TEST-707aea2c-3c80-4063-84ac-b9e701044fff";
    public static User user;


    public static class Network {

        public static final int MAX_TIMEOUT_SECONDS = 10;
        public static final String WS_UPDATE_CALIFICACION_CONCE = "";

    }

    //login_status
    public final static int ONLINE = 1;
    public final static int OFFLINE = 0;
    public final static int IN_GALLERY = 3;

    //login_status
    public static String LOGIN_STATUS = "login_status";
    public final static int LOGIN_IN = 1;
    public final static int LOGIN_OUT = 0;

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 6920;
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 6921;
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 6922;
    public static final int MY_PERMISSIONS_REQUEST_RECORD_AUDIO = 6923;
    public static final int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 6924;

}
