package yakov.dev.type_hero.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import yakov.dev.type_hero.data.database.GameResultDatabase
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object DatabaseModule {

    @[Provides Singleton]
    fun provideGameResultDatabase(@ApplicationContext context: Context): GameResultDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = GameResultDatabase::class.java,
            name = GameResultDatabase.DB_NAME
        ).build()
    }
}