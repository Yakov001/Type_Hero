package yakov.dev.type_hero.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import yakov.dev.type_hero.domain.repository.StatsRepository
import yakov.dev.type_hero.domain.use_case.GameFlowUseCase

@[Module InstallIn(ViewModelComponent::class)]
object GameViewModelModule {

    @[ViewModelScoped Provides]
    fun provideGameFlowUseCase(repo: StatsRepository) : GameFlowUseCase = GameFlowUseCase(repo)
}