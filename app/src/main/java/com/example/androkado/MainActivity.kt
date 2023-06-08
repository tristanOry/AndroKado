package com.example.androkado

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androkado.adapters.ListeArticlesAdapter
import com.example.androkado.bo.Article

class MainActivity : AppCompatActivity() {
    private var arts:
            ArrayList<Article> = ArrayList<Article>()
    private var TAG:
            String = "MAIN_ACTIVITY"
    private lateinit var mRecyclerView:
            RecyclerView
    private lateinit var mAdapter:
            RecyclerView.Adapter<ListeArticlesAdapter.ViewHolder>
    private lateinit var mLayoutManager:
            LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arts.add(Article("Croissant","Une viennoiserie moins chère",0.95F,3.5F,"https://mapatisserie.fr/recette/viennoiseries/recette-croissant/"))
        arts.add(Article("Pain au chocolat","Une viennoiserie controversée",1.25F,6.5F))
        arts.add(Article("Chouquette","Pack de 6",3.5F,-2F))

        setContentView(R.layout.layout_main)
        Log.d(TAG, "Chargement de la vue (l.35)")
        val mToolbar: Toolbar = findViewById(R.id.tb_main)
        Log.d(TAG, "Initialisation de la toolbar (l.37)")
        setSupportActionBar(mToolbar)
        Log.d(TAG, "Appel de setSupportActionBar sur la toolbar (l.39)")
        Log.d(TAG, "supportActionBar : " + supportActionBar.toString() + " (l.40)")

        mRecyclerView = findViewById(R.id.liste_articles)
        mLayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager
        mAdapter = ListeArticlesAdapter(arts)
        mRecyclerView.adapter = mAdapter
        //supportActionBar?.show()
        //Log.d(TAG, supportActionBar?.show().toString())
        Log.d(TAG,"Fin de la création de l'app")
        Log.d(TAG,"supportActionBar : " + supportActionBar.toString())
        Log.d(TAG, "mToolbar : $mToolbar")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        Log.d(TAG, "Création des options du menu (l.50)")
        val isMenu = menu != null
        if (isMenu) {
            Log.d(TAG, menu.toString() + " (l.53)")
            menuInflater.inflate(R.menu.main_menu, menu)
        }
        return isMenu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_menu_config -> Toast.makeText(this, "Configuration", Toast.LENGTH_SHORT).show()
            R.id.add_article -> Toast.makeText(this, "Ajout d'article", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
