package com.example.androkado

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import android.content.Intent
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import com.example.androkado.bo.Article

class MainActivity : ComponentActivity() {
    private lateinit var art: Article;
    private var TAG: String = "MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        art = Article(
            "Croissant",
            "Une viennoiserie moins chère",
            0.95F,
            3.5F,
            "https://mapatisserie.fr/recette/viennoiseries/recette-croissant/"
        );

        setContentView(R.layout.layout_main)
        findViewById<TextView>(R.id.articleName).text = art.name;
        findViewById<TextView>(R.id.price).text = String.format("%.2f €", art.price)
        findViewById<TextView>(R.id.articleDetail).text = art.description
        findViewById<RatingBar>(R.id.rating).rating = art.rating
    }

    fun clickValidBtn(view: View) {
        //Toast.makeText(this, art.url, Toast.LENGTH_SHORT).show()
        var intent: Intent =  Intent(this, InfoUrlActivity::class.java)
        intent.putExtra("article", this.art)
        startActivity(intent)
    }

    fun clickBuyBtn(view: View){
        if(findViewById<ToggleButton>(R.id.toggleBuying).isChecked) {
            Log.i(TAG, "Article acheté");
        }
    }

}
