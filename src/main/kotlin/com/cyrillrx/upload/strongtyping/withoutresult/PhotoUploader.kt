package com.cyrillrx.upload.strongtyping.withoutresult

import com.cyrillrx.upload.strongtyping.Photo

interface PhotoUploader {
    fun upload(photo: Photo.Resized): Photo.Uploaded
}

