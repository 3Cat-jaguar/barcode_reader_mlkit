package com.example.barcode_scanner

import android.app.Activity
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseIntArray
import android.view.Surface
import android.view.SurfaceHolder
import androidx.annotation.RequiresApi
import com.example.barcode_scanner.databinding.ActivityBarcodeScanBinding
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.camera.CameraSourceConfig
import com.google.mlkit.vision.camera.DetectionTaskCallback
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.interfaces.Detector
import java.util.*

class BarcodeScan : AppCompatActivity() {

    private val binding by lazy { ActivityBarcodeScanBinding.inflate(layoutInflater) }
    private val options = BarcodeScannerOptions.Builder()
        .setBarcodeFormats(Barcode.FORMAT_CODE_128)
        .build()
    private lateinit var barcodeDetector : BarcodeScanner
    private lateinit var cameraSource : CameraSourceConfig
    private lateinit var inputImage : InputImage
    private lateinit var task : Task<List<Barcode>>

    private fun scanBarcodes(image: InputImage) {

        // [START get_detector]
        val scanner = BarcodeScanning.getClient(options)
        // Or, to specify the formats to recognize:
        // val scanner = BarcodeScanning.getClient(options)
        // [END get_detector]

        // [START run_detector]
        val result = scanner.process(image)
            .addOnSuccessListener { barcodes ->
                // Task completed successfully
                // [START_EXCLUDE]
                // [START get_barcodes]
                for (barcode in barcodes) {
                    val bounds = barcode.boundingBox
                    val corners = barcode.cornerPoints

                    val rawValue = barcode.rawValue

                    val valueType = barcode.valueType
                    // See API reference for complete list of supported types
                    when (valueType) {
                        Barcode.TYPE_WIFI -> {
                            val ssid = barcode.wifi!!.ssid
                            val password = barcode.wifi!!.password
                            val type = barcode.wifi!!.encryptionType
                        }
                        Barcode.TYPE_URL -> {
                            val title = barcode.url!!.title
                            val url = barcode.url!!.url
                        }
                        Barcode.TYPE_TEXT -> {
                            barcode.displayValue
                        }
                    }
                }
                // [END get_barcodes]
                // [END_EXCLUDE]
            }
            .addOnFailureListener {
                // Task failed with an exception
                // ...
            }
        // [END run_detector]
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        barcodeDetector = BarcodeScanning.getClient(options)
        task = barcodeDetector.process(inputImage)
        task.addOnSuccessListener(){

        }

        cameraSource = CameraSourceConfig.Builder(this, barcodeDetector)
            .setRequestedPreviewSize(1024, 768)
            .build()

        binding.svBarcode.holder.addCallback(object : SurfaceHolder.Callback2{
            override fun surfaceRedrawNeeded(holder: SurfaceHolder) {
                TODO("Not yet implemented")
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                TODO("Not yet implemented")
            }

            override fun surfaceCreated(holder: SurfaceHolder) {
                TODO("Not yet implemented")
            }
        })
        setContentView(binding.root)
    }
}