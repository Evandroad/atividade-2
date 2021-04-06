package br.edu.uniritter.mobile.nossaprimeiraappnoite.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;

public class Albums implements Parcelable{
    private int userId;
    private int id;
    private String title;

    public Albums(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Albums(Parcel parcel) {
        this.userId = parcel.readInt();
        this.id = parcel.readInt();
        this.title = parcel.readString();
    }

    public static final Parcelable.Creator<Albums> CREATOR = new Parcelable.Creator<Albums>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUser (int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.userId);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
    }
}
