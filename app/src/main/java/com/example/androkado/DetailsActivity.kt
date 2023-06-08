package com.example.androkado

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androkado.bo.Article

class DetailsActivity : AppCompatActivity() {
    val TAG: String = "DETAILS_ACTIVITY"
    var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if(intent.hasExtra("article")){
            // Current syntax : Require API 33+ to work (=> Android 13+)
            // article = intent.getParcelableExtra("article", Article::class.java)
            // Legacy version. Used for compatibility with API 24+ (=> Android 7+)
            article = intent.getParcelableExtra<Article>("article")
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