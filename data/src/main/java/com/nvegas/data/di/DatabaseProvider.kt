package com.nvegas.data.di

import android.content.Context
import com.nvegas.data.local.database.GapsiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseProvider {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): GapsiDatabase {
        return GapsiDatabase.create(context)
    }

    @Singleton
    @Provides
    fun provideSuggestionsDao(db: GapsiDatabase) = db.getSuggestionsDao()

}