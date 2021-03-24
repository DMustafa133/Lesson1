package com.example.lesson1;

import android.os.Parcel;
import android.os.Parcelable;

public class DataClass implements Parcelable {

    private int image;
    private String fio;
    private String date;
    private String email;

    public DataClass(String fio, String date, String  email, int image) {
        this.fio = fio;
        this.date = date;
        this.email = email;
        this.image = image;
    }


    protected DataClass(Parcel in) {
        image = in.readInt();
        fio = in.readString();
        date = in.readString();
        email = in.readString();
    }

    public static final Creator<DataClass> CREATOR = new Creator<DataClass>() {
        @Override
        public DataClass createFromParcel(Parcel in) {
            return new DataClass(in);
        }

        @Override
        public DataClass[] newArray(int size) {
            return new DataClass[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(fio);
        dest.writeString(date);
        dest.writeString(email);
    }
}
