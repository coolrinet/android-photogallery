package com.coolrinet.photogallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.coolrinet.photogallery.databinding.FragmentGalleryDatabaseBinding

class GalleryDatabaseFragment: Fragment() {
    private var _binding: FragmentGalleryDatabaseBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentGalleryDatabaseBinding.inflate(inflater, container, false)
        binding.galleryDatabaseList.layoutManager = LinearLayoutManager(context)
        return binding.root
    }
}