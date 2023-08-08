package yakov.dev.type_hero.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yakov.dev.type_hero.data.repository.WordBankRepositoryImpl
import yakov.dev.type_hero.domain.repository.WordBankRepository
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object AppModule {

    @[Singleton Provides]
    fun provideWordBankRepository() : WordBankRepository = WordBankRepositoryImpl()
}