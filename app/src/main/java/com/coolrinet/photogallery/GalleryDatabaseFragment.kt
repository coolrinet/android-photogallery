package com.coolrinet.photogallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.coolrinet.photogallery.databinding.FragmentGalleryDatabaseBinding
import kotlinx.coroutines.launch

class GalleryDatabaseFragment: Fragment() {
    private var _binding: FragmentGalleryDatabaseBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    private val galleryDatabaseViewModel: GalleryDatabaseViewModel by viewModels()

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                galleryDatabaseViewModel.photos.collect { photos ->
                    binding.galleryDatabaseList.adapter = GalleryDatabaseListAdapter(photos)
                }
            }
        }
    }
}