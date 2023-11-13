package com.coolrinet.photogallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class GalleryDatabaseViewModel: ViewModel() {
    private val galleryRepository = GalleryRepository.get()

    private val _photos: MutableStateFlow<List<GalleryItem>> = MutableStateFlow(emptyList())
    val photos: StateFlow<List<GalleryItem>>
        get() = _photos.asStateFlow()

    init {
        viewModelScope.launch {
            galleryRepository.getPhotos().collect {
                _photos.value = it
            }
        }
    }
}