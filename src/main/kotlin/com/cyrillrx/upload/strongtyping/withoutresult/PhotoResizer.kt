package com.cyrillrx.upload.strongtyping.withoutresult

import com.cyrillrx.upload.strongtyping.Photo

interface PhotoResizer {
    fun resize(photoToResize: Photo.ToResize): Photo.Resized
}


