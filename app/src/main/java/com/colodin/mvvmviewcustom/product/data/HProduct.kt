package com.colodin.mvvmviewcustom.product.data

interface HProduct {
    /**
     *
     * [HProductImpl.getImagesWithoutThumbnail]
     */
    fun getImagesWithoutThumbnail(images: List<String>): List<String>
}