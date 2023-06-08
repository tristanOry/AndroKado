package com.example.androkado.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androkado.DetailsActivity
import com.example.androkado.R
import com.example.androkado.bo.Article

class ListeArticlesAdapter(private val dataset: ArrayList<Article>):
    RecyclerView.Adapter<ListeArticlesAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view), OnClickListener
    {
         var dataset: ArrayList<Article>? = null
             set(value) {
                 field = value
             }

        val articleName: TextView
        val rating: RatingBar
        init {
            articleName = view.findViewById(R.id.articleName)
            rating = view.findViewById(R.id.rating)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if(v != null){
                val ctx = v.context
                val pos = this.absoluteAdapterPosition
                val intent = Intent(ctx, DetailsActivity::class.java)
                val item = dataset?.get(pos)
                if(item != null) {
                    intent.putExtra("article", item)
                }
                v.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.article_card_view, parent, false))
        vh.dataset = dataset
        return vh
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataRow: Article = dataset[position]
        holder.articleName.text = dataRow.name
        holder.rating.rating = dataRow.rating
        holder.rating.contentDescription = "Note de " + dataRow.rating.toString() + " sur 4"
    }
}