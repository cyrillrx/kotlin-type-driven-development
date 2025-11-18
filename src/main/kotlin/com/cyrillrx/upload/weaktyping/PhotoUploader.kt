package com.cyrillrx.upload.weaktyping

interface PhotoUploader {
    fun upload(photo: SimplePhoto): SimplePhoto
}
