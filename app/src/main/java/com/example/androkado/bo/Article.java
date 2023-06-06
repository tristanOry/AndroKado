package com.example.androkado.bo;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by Moi on 06/06/2023.
 */
public class Article implements Parcelable {
    private String name, description, url;
    private static final String TAG="Article";
    private float price, rating;

    public Article(String name, String description, float price, float rating, String url) {

        Consumer<String> err = x -> Log.e(TAG, x);

        ArrayList<String> errMsg = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.url = url;

        if (price >=0) {
            this.price = price;
        } else {
            errMsg.add("Le prix ne peut pas être négatif, il a été mis à 0");
            this.price = 0;
        }

        if(rating<=4.0 && rating >=0) {
            this.rating = rating;
        } else if (rating>4.0) {
            errMsg.add("La note ne doit pas être supérieure à 4, elle a été mise à 4");
            this.rating = 4.0F;
        } else {
            errMsg.add("La note ne doit pas être inférieure à 0, elle a été mise à 0");
            this.rating = 0.0F;
        }
        if(!errMsg.isEmpty()){
            errMsg.forEach(err);
        }
    }

    protected Article(Parcel in) {
        name = in.readString();
        description = in.readString();
        url = in.readString();
        price = in.readFloat();
        rating = in.readFloat();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeFloat(price);
        dest.writeFloat(rating);
    }
}
