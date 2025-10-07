package com.ciscodeto.fortunecookie.data.repository

import com.ciscodeto.fortunecookie.data.datasource.FortuneLocalDataSource
import com.ciscodeto.fortunecookie.domain.model.Fortune
import com.ciscodeto.fortunecookie.domain.repository.FortuneRepository

class FortuneRepositoryImpl(
    private val localDataSource: FortuneLocalDataSource
) : FortuneRepository {

    override suspend fun getRandomFortune(): Fortune {
        return Fortune(message = localDataSource.getRandomFortune())
    }
}
