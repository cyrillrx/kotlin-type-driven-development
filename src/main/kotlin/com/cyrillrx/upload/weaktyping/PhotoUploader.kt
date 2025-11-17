package com.cyrillrx.upload.weaktyping

import kotlin.random.Random

interface PhotoUploader {
    fun upload(photo: SimplePhoto): SimplePhoto
}

class DummyPhotoUploader : PhotoUploader {
    override fun upload(photo: SimplePhoto): SimplePhoto = photo.apply { uploadedHash = Random.nextInt().toString() }
}

