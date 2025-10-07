package com.ciscodeto.fortunecookie.domain.repository

import com.ciscodeto.fortunecookie.domain.model.Fortune

interface FortuneRepository {
    suspend fun getRandomFortune(): Fortune
}
