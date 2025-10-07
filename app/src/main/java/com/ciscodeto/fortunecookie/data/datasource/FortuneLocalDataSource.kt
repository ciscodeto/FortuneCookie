package com.ciscodeto.fortunecookie.data.datasource

interface FortuneLocalDataSource {
    suspend fun getRandomFortune(): String
}
