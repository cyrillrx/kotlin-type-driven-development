package com.cyrillrx.upload.strongtyping.withresult

import com.cyrillrx.upload.strongtyping.Photo
import com.cyrillrx.upload.strongtyping.withresult.error.ResizerError
import com.cyrillrx.upload.strongtyping.withresult.error.Result

class SuccessfulPhotoResizer : PhotoResizer {
    override fun resize(photoToResize: Photo.ToResize): Result<Photo.Resized, ResizerError> {
        val resizedPhoto = Photo.Resized(
            resizedFilePath = photoToResize.filePath + "_resized",
            widthPx = 100,
            heightPx = 100,
        )
        return Result.Success(resizedPhoto)
    }
}