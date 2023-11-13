package com.coolrinet.photogallery

import android.content.Context
import androidx.room.Room
import com.coolrinet.photogallery.database.GalleryDatabase

private const val DATABASE_NAME = "gallery-database"

class GalleryRepository private constructor(
    context: Context
) {
    private val database: GalleryDatabase = Room
        .databaseBuilder(
            context,
            GalleryDatabase::class.java,
            DATABASE_NAME
        ).build()

    fun getPhotos() = database.galleryDao().getPhotos()

    suspend fun getPhotoByUrl(photoUrl: String) =
        database.galleryDao().getPhotoByUrl(photoUrl)

    suspend fun addPhoto(photo: GalleryItem) {
        database.galleryDao().addPhoto(photo)
    }

    suspend fun deleteAllPhotos() {
        database.galleryDao().deleteAllPhotos()
    }

    companion object {
        private var INSTANCE: GalleryRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = GalleryRepository(context)
            }
        }

        fun get(): GalleryRepository {
            return INSTANCE ?:
            throw IllegalStateException("GalleryRepository must be initialized")
        }
    }
}