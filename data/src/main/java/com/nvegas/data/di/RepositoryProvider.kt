package com.nvegas.data.di

import com.nvegas.data.local.database.dao.SuggestionsDao
import com.nvegas.data.network.services.products.ProductsServices
import com.nvegas.data.repositories.ProductsRepository
import com.nvegas.data.repositories.SuggestionsRepository
import com.nvegas.domain.repositories.IProductsRepository
import com.nvegas.domain.repositories.ISuggestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryProvider {

    @Provides
    @Singleton
    fun provideProductsRepository(api: ProductsServices): IProductsRepository {
        return ProductsRepository(api)
    }


    @Provides
    @Singleton
    fun provideSuggestRepository(dao: SuggestionsDao): ISuggestRepository {
        return SuggestionsRepository(dao)
    }

}