package br.com.evandro.atividade2.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RequiresApi;

public class Posts implements Parcelable{

    private int userId;
    private int id;
    private String title;
    private String body;

    public Posts() {}

    public Posts(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private Posts(Parcel parcel) {
        this.userId = parcel.readInt();
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.body = parcel.readString();
    }

    public static final Parcelable.Creator<Posts> CREATOR = new Parcelable.Creator<Posts>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Posts createFromParcel(Parcel in) { return new Posts(in); }

        @Override
        public Posts[] newArray(int size) { return new Posts[size]; }
    };

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    @Override
    public int describeContents() { return 0; }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.userId);
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
    }

}