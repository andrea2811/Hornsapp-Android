package com.yesferal.hornsapp.app.framework.retrofit.entity

import com.yesferal.hornsapp.domain.util.formatted
import com.yesferal.hornsapp.domain.util.timeFormatted
import com.yesferal.hornsapp.domain.entity.Concert
import com.yesferal.hornsapp.domain.util.toSafeUri
import java.util.*

data class GetConcerts(
    val _id: String,
    val name: String?,
    val description: String?,
    val posterImage: String?,
    val trailerUrl: String?,
    val socialNetworks: List<String>?,
    val headlinerImage: String?,
    val dateTime: Date?
)

fun GetConcerts.mapToConcert(): Concert {
    val date = this
        .dateTime
        ?.formatted()

    val time = this
        .dateTime
        ?.timeFormatted()

    val facebookUrl = socialNetworks?.first()

    val isFavorite = false

    return Concert(
        this._id,
        this.name,
        this.description,
        this.posterImage,
        this.headlinerImage,
        date,
        time,
        this.trailerUrl?.toSafeUri(),
        facebookUrl?.toSafeUri(),
        isFavorite
    )
}