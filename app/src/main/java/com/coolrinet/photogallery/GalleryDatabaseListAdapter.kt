package com.coolrinet.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.coolrinet.photogallery.databinding.ListItemGalleryDatabaseBinding

class GalleryDatabaseViewHolder(
    private val binding: ListItemGalleryDatabaseBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: GalleryItem) {
        binding.photoImageView.load(photo.url) {
            placeholder(R.drawable.bill_up_close)
        }
        binding.photoTitleTextView.text = photo.title
    }
}

class GalleryDatabaseListAdapter(
    private val photos: List<GalleryItem>
) : RecyclerView.Adapter<GalleryDatabaseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GalleryDatabaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryDatabaseBinding.inflate(inflater, parent, false)
        return  GalleryDatabaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryDatabaseViewHolder, position: Int) {
        val item = photos[position]
        holder.bind(item)
    }

    override fun getItemCount() = photos.size
}