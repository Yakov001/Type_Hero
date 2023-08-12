package yakov.dev.type_hero.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yakov.dev.type_hero.data.repository.StatsRepositoryImpl
import yakov.dev.type_hero.data.repository.WordBankRepositoryImpl
import yakov.dev.type_hero.domain.repository.StatsRepository
import yakov.dev.type_hero.domain.repository.WordBankRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface AppModule {

    @Binds
    fun bindWordBankRepository(repo : WordBankRepositoryImpl) : WordBankRepository

    @Binds
    fun bindStatsRepository(repo : StatsRepositoryImpl) : StatsRepository
}