package com.cyrillrx.upload.strongtyping.withresult

import com.cyrillrx.upload.strongtyping.Photo
import com.cyrillrx.upload.strongtyping.withresult.error.ResizerError
import com.cyrillrx.upload.strongtyping.withresult.error.Result

interface PhotoResizer {
    fun resize(photoToResize: Photo.ToResize): Result<Photo.Resized, ResizerError>
}

