package com.example.androkado

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androkado.adapters.ListeArticlesAdapter
import com.example.androkado.bo.Article

class MainActivity : ComponentActivity(), OnClickListener {
    private var arts: ArrayList<Article> = ArrayList<Article>()
    private var TAG: String = "MAIN_ACTIVITY"
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<ListeArticlesAdapter.ViewHolder>
    private lateinit var mLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arts.add(Article(
            "Croissant",
            "Une viennoiserie moins chère",
            0.95F,
            3.5F,
            "https://mapatisserie.fr/recette/viennoiseries/recette-croissant/"
        ))
        arts.add(Article(
                "Pain au chocolat",
                "Une viennoiserie controversée",
                1.25F,
                6.5F
            ))
        arts.add(Article(
            "Chouquette",
            "Pack de 6",
            3.5F,
            -2F
        ))
        setContentView(R.layout.layout_main)
        mRecyclerView = findViewById(R.id.liste_articles)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager
        mAdapter = ListeArticlesAdapter(arts, this)
        mRecyclerView.adapter = mAdapter
    }

    override fun onClick(v: View?) {
        if(v != null){
            val pos: Int? = v.tag?.toString()?.toInt()
            val intent = Intent(this, DetailsActivity::class.java)
            if(pos != null){
                intent.putExtra("article", arts[pos])
            }
            startActivity(intent)
        }

    }


}
