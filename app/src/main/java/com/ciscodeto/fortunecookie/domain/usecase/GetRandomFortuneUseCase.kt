package com.ciscodeto.fortunecookie.domain.usecase

import com.ciscodeto.fortunecookie.domain.model.Fortune
import com.ciscodeto.fortunecookie.domain.repository.FortuneRepository

class GetRandomFortuneUseCase(
    private val fortuneRepository: FortuneRepository
) {
    suspend operator fun invoke(): Fortune = fortuneRepository.getRandomFortune()
}
