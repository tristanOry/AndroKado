package com.example.androkado.bo

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import android.util.Log
import java.util.function.Consumer

/**
 * Created by Moi on 06/06/2023.
 */
class Article : Parcelable {
    val TAG: String = "ARTICLE"
    var name: String = ""
    var details: String = ""
    var url: String? = null
    var price = 0f
    var rating = 0f

    constructor() {}
    constructor(name: String, details: String, price: Float, rating: Float): this() {
        val err = Consumer { x: String? -> Log.e(TAG, x!!) }
        val errMsg = ArrayList<String>()
        this.name = name
        this.details = details
        if (price >= 0) {
            this.price = price
        } else {
            errMsg.add("Le prix ne peut pas être négatif, il a été mis à 0")
            this.price = 0f
        }
        if (rating <= 4.0 && rating >= 0) {
            this.rating = rating
        } else if (rating > 4.0) {
            errMsg.add("La note ne doit pas être supérieure à 4, elle a été mise à 4")
            this.rating = 4.0f
        } else {
            errMsg.add("La note ne doit pas être inférieure à 0, elle a été mise à 0")
            this.rating = 0.0f
        }
        if (!errMsg.isEmpty()) {
            errMsg.forEach(err)
        }
        this.url = ""
    }
    constructor(name: String, details: String, price: Float, rating: Float, url: String):
            this(name, details, price, rating) {
        this.url = url
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString().toString()
        details = `in`.readString().toString()
        url = `in`.readString()
        price = `in`.readFloat()
        rating = `in`.readFloat()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(details)
        dest.writeString(url)
        dest.writeFloat(price)
        dest.writeFloat(rating)
    }

    companion object CREATOR : Creator<Article> {
        override fun createFromParcel(parcel: Parcel): Article {
            return Article(parcel)
        }

        override fun newArray(size: Int): Array<Article?> {
            return arrayOfNulls(size)
        }
    }
}