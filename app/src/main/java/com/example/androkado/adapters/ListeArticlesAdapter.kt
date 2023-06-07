package com.example.androkado.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androkado.bo.Article

class ListeArticlesAdapter(private val dataset: ArrayList<Article>):
    RecyclerView.Adapter<ListeArticlesAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        //val articleName: TextView = view.findViewById(R.id.articleName)
        val articleName: TextView

        init {
            // Define click listener for the ViewHolder's View
            articleName = view.findViewById(R.id.textView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.article_line_view, parent, false)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}