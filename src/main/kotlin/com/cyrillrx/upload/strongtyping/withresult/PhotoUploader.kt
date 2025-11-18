package com.cyrillrx.upload.strongtyping.withresult

import com.cyrillrx.upload.strongtyping.Photo
import com.cyrillrx.upload.strongtyping.withresult.error.Result
import com.cyrillrx.upload.strongtyping.withresult.error.UploaderError

interface PhotoUploader {
    fun upload(photo: Photo.Resized): Result<Photo.Uploaded, UploaderError>
}
