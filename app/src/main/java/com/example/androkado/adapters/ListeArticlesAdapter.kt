package com.example.androkado.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androkado.bo.Article
import com.example.androkado.R

class ListeArticlesAdapter(private val dataset: ArrayList<Article>, private val clickListener: OnClickListener):
    RecyclerView.Adapter<ListeArticlesAdapter.ViewHolder>() {

    class ViewHolder(view: View, clickListener: OnClickListener): RecyclerView.ViewHolder(view)
    {
        //val articleName: TextView = view.findViewById(R.id.articleName)
        val articleName: TextView
        val price: TextView
        val articleDetail: TextView
        val rating: RatingBar
        init {
            // Define click listener for the ViewHolder's View
            articleName = view.findViewById(R.id.articleName)
            price = view.findViewById(R.id.price)
            articleDetail = view.findViewById(R.id.articleDetail)
            rating = view.findViewById(R.id.rating)
            view.setOnClickListener(clickListener)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.article_line_view, parent, false), clickListener)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataRow: Article = dataset[position]
        holder.articleName.text = dataRow.name
        holder.price.text = String.format("%.2f €", dataRow.price)
        holder.articleDetail.text = dataRow.details
        holder.rating.rating = dataRow.rating
    }
}