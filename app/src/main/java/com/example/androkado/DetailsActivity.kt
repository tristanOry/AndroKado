package com.example.androkado

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.androkado.bo.Article

class DetailsActivity : AppCompatActivity() {
    val TAG: String = "DETAILS_ACTIVITY"
    var article: Article? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if(intent.hasExtra("article")){
            article = intent.getParcelableExtra("article", Article::class.java)
            if(!(article === null)) {
                findViewById<TextView>(R.id.details_name).text = article!!.name
                findViewById<TextView>(R.id.details_details).text = article!!.details
                findViewById<TextView>(R.id.details_price).text =  String.format("%.2f €", article!!.price)
                findViewById<RatingBar>(R.id.details_rating).rating = article!!.rating
                if(!(article!!.url.isNullOrBlank())) {
                    findViewById<TextView>(R.id.details_url).text = article!!.url
                }
            }
        }

    }
}