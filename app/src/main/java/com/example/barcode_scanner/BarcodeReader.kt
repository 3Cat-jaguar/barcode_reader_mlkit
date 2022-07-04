package com.example.barcode_scanner

import android.graphics.Bitmap
import android.graphics.Matrix
import android.media.Image
import com.google.android.gms.tasks.Task
import com.google.android.odml.image.MlImage
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage
import java.nio.ByteBuffer

class BarcodeReader : BarcodeScanner {
    override fun getDetectorType(): Int {
        TODO("Not yet implemented")
    }

    override fun close() {
        TODO("Not yet implemented")
    }

    override fun process(p0: InputImage): Task<MutableList<Barcode>> {
        TODO("Not yet implemented")
    }

    override fun process(p0: MlImage): Task<MutableList<Barcode>> {
        TODO("Not yet implemented")
    }

    override fun process(p0: Bitmap, p1: Int): Task<MutableList<Barcode>> {
        TODO("Not yet implemented")
    }

    override fun process(p0: Image, p1: Int): Task<MutableList<Barcode>> {
        TODO("Not yet implemented")
    }

    override fun process(p0: Image, p1: Int, p2: Matrix): Task<MutableList<Barcode>> {
        TODO("Not yet implemented")
    }

    override fun process(
        p0: ByteBuffer,
        p1: Int,
        p2: Int,
        p3: Int,
        p4: Int
    ): Task<MutableList<Barcode>> {
        TODO("Not yet implemented")
    }
}