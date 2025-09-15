package com.colodin.mvvmviewcustom.utilis

import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Shader
import com.squareup.picasso.Transformation
import androidx.core.graphics.createBitmap

class RoundCornersTransform(private val radiusInPx: Float) : Transformation {

    override fun transform(source: Bitmap): Bitmap {
        val bitmap = createBitmap(source.width, source.height, source.config!!)
        val canvas = Canvas(bitmap)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
        val shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        paint.shader = shader
        val rect = RectF(0.0f, 0.0f, source.width.toFloat(), source.height.toFloat())
        canvas.drawRoundRect(rect, radiusInPx, radiusInPx, paint)
        source.recycle()

        return bitmap
    }

    override fun key(): String {
        return "round_corners"
    }

}