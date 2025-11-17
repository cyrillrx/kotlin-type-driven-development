package com.cyrillrx.upload.weaktyping

interface PhotoResizer {
    fun resize(photo: SimplePhoto): SimplePhoto
}

class DummyPhotoResizer : PhotoResizer {
    override fun resize(photo: SimplePhoto): SimplePhoto {
        return photo.apply { filePath = "${filePath}_resized" }
    }
}