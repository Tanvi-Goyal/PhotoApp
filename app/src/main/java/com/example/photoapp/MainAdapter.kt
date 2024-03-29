package com.example.photoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photoapp.models.Photo
import com.example.photoapp.models.PhotoList
import java.text.ParsePosition

class MainAdapter(var photos : List<Photo>,
                  var clickListener: View.OnClickListener) :
    RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {

    fun getPhoto(adapterPosition: Int) :Photo {
        return photos[adapterPosition]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).
        inflate(R.layout.photo_item,parent,false))
    }

    override fun getItemCount(): Int {
        return photos.size;
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = photos[position]
        holder?. tags ?.text = photo.tags
        holder?. likes ?.text = photo.likes.toString()
        holder?. favorites ?.text = photo.favorites.toString()
        if(photo.previewURL.isNotEmpty()) {
            Glide.with(holder?.tags?.context)
                .load(photo.previewURL)
                .into(holder?.photo_item)
        }
    }

    inner class PhotoViewHolder (itemview:View) : RecyclerView.ViewHolder
        (itemview){

        var tags: TextView
        var likes : TextView
        var favorites : TextView
        var photo_item : ImageView

        init{
            if(clickListener!=null) {
                itemview.setOnClickListener(clickListener)
            }

            itemview.tag = this
            tags = itemview.findViewById(R.id.tags) as TextView
            likes = itemview.findViewById(R.id.likes) as TextView
            favorites = itemview.findViewById(R.id.favorites) as TextView
            photo_item = itemview.findViewById(R.id.photo_item) as ImageView


        }

    }
}