package com.example.androkado

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import com.example.androkado.bo.Article

class InfoUrlActivity : ComponentActivity() {
    var TAG: String = "URL ACTIVITY"
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        
        Log.i(TAG, "Entrée dans l'activity URL")
        super.onCreate(savedInstanceState)
        val intent: Intent = intent
        Log.i(TAG, "Lecture de l'intent")
        setContentView(R.layout.layout_url_activity)
        Log.i(TAG, "Chargement du layout")
        val art: Article = intent.getParcelableExtra("article", Article::class.java)!!
        Log.i(TAG, "Récupération de l'article")
        if (art.url.isNotEmpty()) {
            findViewById<TextView>(R.id.url).text = art.url
            Log.i(TAG, "Modification du TextView")
        }
    }
}
