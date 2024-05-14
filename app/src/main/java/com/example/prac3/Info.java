package com.example.prac3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Info implements Parcelable {

    String info;
    int n;

    public Info(String info, int n) {
        this.info = info;
        this.n = n;
    }

    protected Info(Parcel in) {
        info = in.readString();
        n = in.readInt();
    }

    public static final Creator<Info> CREATOR = new Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel in) {
            return new Info(in);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(info);
        dest.writeInt(n);
    }
}
