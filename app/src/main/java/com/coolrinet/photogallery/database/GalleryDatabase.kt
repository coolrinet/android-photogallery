package com.coolrinet.photogallery.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coolrinet.photogallery.GalleryItem

@Database(entities = [GalleryItem::class], version = 1)
abstract class GalleryDatabase: RoomDatabase() {
    abstract fun galleryDao(): GalleryDao
}