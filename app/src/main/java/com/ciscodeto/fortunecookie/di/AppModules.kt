package com.ciscodeto.fortunecookie.di

import com.ciscodeto.fortunecookie.data.datasource.FakeFortuneLocalDataSource
import com.ciscodeto.fortunecookie.data.datasource.FortuneLocalDataSource
import com.ciscodeto.fortunecookie.data.repository.FortuneRepositoryImpl
import com.ciscodeto.fortunecookie.domain.repository.FortuneRepository
import com.ciscodeto.fortunecookie.domain.usecase.GetRandomFortuneUseCase
import com.ciscodeto.fortunecookie.presentation.fortune.FortuneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    single<FortuneLocalDataSource> { FakeFortuneLocalDataSource() }
    single<FortuneRepository> { FortuneRepositoryImpl(get()) }
}

val domainModule = module {
    factory { GetRandomFortuneUseCase(get()) }
}

val presentationModule = module {
    viewModel { FortuneViewModel(get()) }
}
