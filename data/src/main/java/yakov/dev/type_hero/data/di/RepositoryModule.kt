package yakov.dev.type_hero.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yakov.dev.type_hero.data.repository.StatsRepositoryImpl
import yakov.dev.type_hero.data.repository.WordBankRepositoryImpl
import yakov.dev.type_hero.domain.repository.StatsRepository
import yakov.dev.type_hero.domain.repository.WordBankRepository

@[Module InstallIn(SingletonComponent::class)]
interface RepositoryModule {

    @Binds
    fun bindWordBankRepository(repo : WordBankRepositoryImpl) : WordBankRepository

    @Binds
    fun bindStatsRepository(repo : StatsRepositoryImpl) : StatsRepository
}