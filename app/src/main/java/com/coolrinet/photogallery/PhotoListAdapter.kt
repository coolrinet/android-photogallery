package com.coolrinet.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.coolrinet.photogallery.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem, onGalleryItemClicked: (galleryItem: GalleryItem) -> Unit) {
        binding.itemImageView.load(galleryItem.url) {
            placeholder(R.drawable.bill_up_close)
        }

        binding.root.setOnClickListener {
            onGalleryItemClicked(galleryItem)
        }
    }
}

class PhotoListAdapter(
    private val galleryItems: List<GalleryItem>,
    private val onGalleryItemClicked: (galleryItem: GalleryItem) -> Unit
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItems[position]
        holder.bind(item, onGalleryItemClicked)
    }

    override fun getItemCount() = galleryItems.size
}