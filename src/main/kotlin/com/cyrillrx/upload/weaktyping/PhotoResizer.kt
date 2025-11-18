package com.cyrillrx.upload.weaktyping

interface PhotoResizer {
    fun resize(photo: SimplePhoto): SimplePhoto
}
