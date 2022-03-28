package com.example.a15017498.clashroyale2ndtime;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by 15017498 on 12/3/2017.
 */

public class ItemObject implements Parcelable {

    private String name;
    private int photo;
    private int number;

    public ItemObject(String name, int photo,int number) {
        this.name = name;
        this.photo = photo;
        this.number = number;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }


    private ItemObject(Parcel in) {
        name = in.readString();
        photo = in.readInt();
    }

    public static final Creator<ItemObject> CREATOR = new Creator<ItemObject>() {
        @Override
        public ItemObject createFromParcel(Parcel in) {
            return new ItemObject(in);
        }

        @Override
        public ItemObject[] newArray(int size) {
            return new ItemObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(photo);
    }
}