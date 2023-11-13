package com.coolrinet.photogallery.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.coolrinet.photogallery.GalleryItem

@Dao
interface GalleryDao {
    @Query("SELECT * FROM photos")
    suspend fun getPhotos(): List<GalleryItem>

    @Query("SELECT * FROM photos WHERE url = :photoUrl")
    suspend fun getPhotoByUrl(photoUrl: String): GalleryItem?

    @Insert
    suspend fun addPhoto(photo: GalleryItem)

    @Query("DELETE FROM photos")
    suspend fun deleteAllPhotos()
}