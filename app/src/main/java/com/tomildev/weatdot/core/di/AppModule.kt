package com.tomildev.weatdot.core.di

import com.tomildev.weatdot.core.data.remote.ApiConstants
import com.tomildev.weatdot.core.data.remote.GeocodingApi
import com.tomildev.weatdot.core.data.remote.WeatherApi
import com.tomildev.weatdot.core.data.repository.WeatherRepositoryImpl
import com.tomildev.weatdot.core.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    companion object {
        @Provides
        @Singleton
        fun provideGeocodingApi(): GeocodingApi {
            return Retrofit.Builder()
                .baseUrl(ApiConstants.GEO_CODING_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GeocodingApi::class.java)
        }

        @Provides
        @Singleton
        fun provideWeatherApi(): WeatherApi {
            return Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
        }
    }
}