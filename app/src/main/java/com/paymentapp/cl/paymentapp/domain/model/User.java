package com.paymentapp.cl.paymentapp.domain.model;

import com.google.gson.annotations.SerializedName;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    @SerializedName("id_user")
    private int mIdUser;

    @SerializedName("access_token")
    private String mAccessToken;

    @SerializedName("email")
    private String mEmail;

    @SerializedName("name")
    private String mName;

    @SerializedName("lastname")
    private String mLastName;

    @SerializedName("genre")
    private String mGenre;

    @SerializedName("birth_day")
    private String mBirthDay;

    @SerializedName("country")
    private String mCountry;

    @SerializedName("city")
    private String mCity;

    @SerializedName("colony")
    private String mColony;

    @SerializedName("address")
    private String mAddress;

    @SerializedName("postalcode")
    private String mPostalCode;

    @SerializedName("phone")
    private String mPhone;

    @SerializedName("profile_image")
    private String mProfileImage;

    @SerializedName("state")
    private String mState;

    @SerializedName("user_type")
    private String mUserType;

    @SerializedName("suscription_status")
    private String mSuscriptionStatus;

    public int getmIdUser() {
        return mIdUser;
    }

    public String getmAccesToken(){
        return mAccessToken;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmName() {
        return mName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmGenre() {
        return mGenre;
    }

    public String getmBirthDay() {
        return mBirthDay;
    }

    public String getmCountry() {
        return mCountry;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmColony() {
        return mColony;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmPostalCode() {
        return mPostalCode;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmProfileImage() {
        return mProfileImage;
    }

    public String getmState() {
        return mState;
    }

    public String getmUserType() {
        return mUserType;
    }

    public String getmSuscriptionStatus() {
        return mSuscriptionStatus;
    }

    private static String token;

    public String getTokenComposed(){
        if( token == null ) {
            String original = getmName();
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            token =  getmAccesToken() + "." + sb.toString();
        }

        return token;
    }
}

