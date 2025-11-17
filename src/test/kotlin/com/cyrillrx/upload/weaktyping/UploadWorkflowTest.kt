package com.cyrillrx.upload.weaktyping

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UploadWorkflowTest {

    private val workflow: UploadWorkflow = UploadWorkflow(
        resizer = DummyPhotoResizer(),
        uploader = DummyPhotoUploader(),
    )

    @Test
    fun `after calling upload, the photo is uploaded`() {
        val photo = SimplePhoto("path/to/photo.jpg")

        workflow.addPhoto(photo)

        assertTrue(photo.isUploaded())
        assertTrue(workflow.allPhotosUploaded())
    }

    @Test
    fun `after calling upload, upload can be altered`() {
        val photo = SimplePhoto("path/to/photo.jpg")

        workflow.addPhoto(photo)

        // Altering the uploaded hash
        photo.uploadedHash = null

        assertFalse(photo.isUploaded())
        assertFalse(workflow.allPhotosUploaded())
    }
}