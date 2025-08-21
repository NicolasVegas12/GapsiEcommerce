package com.nvegas.data.di

import com.nvegas.data.BuildConfig
import com.nvegas.data.network.services.products.IProductsServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiProvider {


    @Provides
    @Singleton
    fun provideProductsService(): IProductsServices = ApiBuilder.getService(BuildConfig.BASE_URL)


}