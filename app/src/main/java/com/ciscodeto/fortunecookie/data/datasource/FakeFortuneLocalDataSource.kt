package com.ciscodeto.fortunecookie.data.datasource

import kotlinx.coroutines.delay
import kotlin.random.Random

class FakeFortuneLocalDataSource(
    private val fortunes: List<String> = defaultFortunes,
    private val random: Random = Random.Default
) : FortuneLocalDataSource {

    override suspend fun getRandomFortune(): String {
        delay(500)
        return fortunes[random.nextInt(fortunes.size)]
    }

    private companion object {
        val defaultFortunes = listOf(
            "Uma oportunidade empolgante está à sua frente.",
            "Uma surpresa agradável está esperando por você em breve.",
            "Você conquistará obstáculos para alcançar o sucesso.",
            "A felicidade começa ao encarar a vida com um sorriso.",
            "Seus talentos serão reconhecidos e devidamente recompensados.",
            "A aventura pode ser a verdadeira felicidade.",
            "Agora é a hora de tentar algo novo.",
            "Acredite que pode ser feito.",
            "Boas notícias virão até você de longe.",
            "Um amigo fiel é uma forte defesa."
        )
    }
}
