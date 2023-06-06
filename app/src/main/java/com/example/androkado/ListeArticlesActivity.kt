package com.example.androkado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androkado.bo.Article

class ListeArticlesActivity : AppCompatActivity() {
    private var articles: ArrayList<Article> = ArrayList<Article>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_liste_articles)
        //Article("Article A", "Premier article", 1.00F, 3.5F, "http://localhost")
        articles.add(Article("Article A",
            "Premier article",
            1.00F,
            1F,
            "http://localhost"))
        articles.add(Article("Article B",
            "Deuxième article",
            42F,
            42F,
            "http://localhost"))
        articles.add(Article("Article C",
            "Troisième article",
            3.14F,
            3.14F,
            "http://localhost"))
    }

    override fun onResume() {
        super.onResume()

    }
}