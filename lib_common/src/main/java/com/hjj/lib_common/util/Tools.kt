package com.hjj.lib_common.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.graphics.Rect
import android.media.ExifInterface
import android.util.Log
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

/**
 *
 * @Author: hjj
 * @CreateDate: 2022/3/2 10:22
 * @Description: 裁剪图片指定区域
 */
object Tools {

    /**
     * 裁剪图片指定区域
     */
    fun clipAndSaveBitmap(
        originPath: String,
        savePath: String,
        clipRect: Rect,
        targetRect: Rect,
    ): Boolean {
        val matrix = pictureDegree(originPath)
        var clipBitmap = BitmapFactory.decodeFile(originPath)
        Log.d("clipBitmap","裁剪图片的宽高0：${clipBitmap.width}    ,    ${clipBitmap.height}")
        clipBitmap = Bitmap.createBitmap(clipBitmap, 0, 0, clipBitmap.width, clipBitmap.height, matrix, true)
        Log.d("clipBitmap","裁剪图片的宽高1：${clipBitmap.width}    ,    ${clipBitmap.height}")
        val clipBitmapWidth = clipBitmap.width  //.coerceAtMost(clipBitmap.height)
        val clipBitmapHeight = clipBitmap.height  //.coerceAtLeast(clipBitmap.height)

        Log.d("clipBitmap","裁剪图片的宽高：$clipBitmapWidth    ,    $clipBitmapHeight")

        var finalRect = Rect()
        val widthRatio = clipRect.width() * 1.0 / targetRect.width()
        val heightRatio = clipRect.height() * 1.0 / targetRect.height()

        Log.d("clipBitmap","裁剪图片的宽高比：$widthRatio    ,    $heightRatio")

        var finalRectWidth = (widthRatio * clipBitmapWidth).toInt()
        var finalRectHeight = (heightRatio * clipBitmapHeight).toInt()


        Log.d("clipBitmap","最终图片的宽高比：$finalRectWidth    ,    $finalRectHeight")

        finalRect.top = (clipBitmapHeight - finalRectHeight) / 2
        finalRect.left = (clipBitmapWidth - finalRectWidth) / 2
        finalRect.right = finalRectWidth
        finalRect.bottom = finalRectHeight

        clipBitmap = Bitmap.createBitmap(clipBitmap,
            finalRect.left,
            finalRect.top,
            finalRect.right,
            finalRect.bottom,
            null,
            true)

        return saveBitmap(clipBitmap, savePath)
    }


    private fun saveBitmap(bitmap: Bitmap, savePath: String): Boolean {
        try {
            val file = File(savePath)
            val parent = file.parentFile
            if (!parent.exists()) {
                parent.mkdirs()
            }
            val fos = FileOutputStream(file)
            val b = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.flush()
            fos.close()
            return b
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return false
    }

    private fun pictureDegree(imgPath: String): Matrix {
        val matrix = Matrix()
        var exif: ExifInterface? = null
        try {
            exif = ExifInterface(imgPath)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        if (exif == null) return matrix
        var degree = 0
        when (exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1)) {
            ExifInterface.ORIENTATION_ROTATE_90 -> degree = 90
            ExifInterface.ORIENTATION_ROTATE_180 -> degree = 180
            ExifInterface.ORIENTATION_ROTATE_270 -> degree = 270
            else -> {
            }
        }
        matrix.postRotate(degree.toFloat())
        return matrix
    }


}