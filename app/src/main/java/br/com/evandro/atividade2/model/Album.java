package br.com.evandro.atividade2.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;

public class Album implements Parcelable{

    private int userId;
    private int id;
    private String title;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Album(Parcel parcel) {
        this.userId = parcel.readInt();
        this.id = parcel.readInt();
        this.title = parcel.readString();
    }

    public static final Parcelable.Creator<Album> CREATOR = new Parcelable.Creator<Album>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Album createFromParcel(Parcel in) { return new Album(in); }

        @Override
        public Album[] newArray(int size) { return new Album[size]; }
    };

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Override
    public int describeContents() { return 0; }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.userId);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
    }
}
