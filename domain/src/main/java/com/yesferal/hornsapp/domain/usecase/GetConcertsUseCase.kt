package com.yesferal.hornsapp.domain.usecase

import com.yesferal.hornsapp.domain.abstraction.ConcertRepository
import com.yesferal.hornsapp.domain.entity.Concert

class GetConcertsUseCase(
    private val concertRepository: ConcertRepository
) {
    operator fun invoke(
        onSuccess: (response: List<Concert>) -> Unit,
        onError: (t: Throwable) -> Unit
    ) {
        concertRepository.getConcerts(
            onSuccess = { concerts ->
                onSuccess(concerts)
                concertRepository.insertConcerts(concerts)
            },
            onError = {
                onError(it)
            }
        )
    }
}