package com.baudelio.test.home.ui

import android.graphics.Bitmap
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.baudelio.test.home.R
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.Code128Writer

fun HomeFragment.initElements() {
    binding.apply {
        txtTitle.text = getString(R.string.title_holder, viewModel.getClaims().titular)
        txtEmail.text = getString(R.string.email_holder, viewModel.getClaims().email)
        txtFolio.text = getString(R.string.folio_holder, viewModel.getClaims().solicitud)
        val widthPixels = resources.getDimensionPixelSize(R.dimen.width_barcode)
        val heightPixels = resources.getDimensionPixelSize(R.dimen.height_barcode)
        val hashcode = viewModel.getAuthModel().token.hashCode().toString()
        imgCode.setImageBitmap(
            createBarcodeBitmap(
                barcodeValue = hashcode,
                barcodeColor = ContextCompat.getColor(requireContext(), R.color.primary_300),
                backgroundColor = ContextCompat.getColor(requireContext(), android.R.color.white),
                widthPixels = widthPixels,
                heightPixels = heightPixels
            )
        )
        txtHashCode.text = hashcode
    }
}

private fun createBarcodeBitmap(
    barcodeValue: String,
    @ColorInt barcodeColor: Int,
    @ColorInt backgroundColor: Int,
    widthPixels: Int,
    heightPixels: Int
): Bitmap {
    val bitMatrix = Code128Writer().encode(
        barcodeValue,
        BarcodeFormat.CODE_128,
        widthPixels,
        heightPixels
    )

    val pixels = IntArray(bitMatrix.width * bitMatrix.height)
    for (y in 0 until bitMatrix.height) {
        val offset = y * bitMatrix.width
        for (x in 0 until bitMatrix.width) {
            pixels[offset + x] =
                if (bitMatrix.get(x, y)) barcodeColor else backgroundColor
        }
    }

    val bitmap = Bitmap.createBitmap(
        bitMatrix.width,
        bitMatrix.height,
        Bitmap.Config.ARGB_8888
    )
    bitmap.setPixels(
        pixels,
        0,
        bitMatrix.width,
        0,
        0,
        bitMatrix.width,
        bitMatrix.height
    )
    return bitmap
}
