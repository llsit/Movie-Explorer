package com.example.common

object ImageConfig {
    const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/"

    // Different poster sizes available
    object PosterSize {
        const val W92 = "w92"     // Small poster
        const val W154 = "w154"   // Medium poster
        const val W185 = "w185"   // Slightly larger
        const val W342 = "w342"   // Recommended for most uses
        const val W500 = "w500"   // Large poster
        const val W780 = "w780"   // Very large poster
        const val ORIGINAL = "original" // Original size (can be very large)
    }
}

fun String.getFullPosterUrl(size: String = ImageConfig.PosterSize.W342): String {
    if (this.isBlank()) return ""
    return "${ImageConfig.BASE_POSTER_URL}${size}${this}"
}