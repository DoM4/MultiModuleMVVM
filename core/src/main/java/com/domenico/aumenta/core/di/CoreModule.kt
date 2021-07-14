package com.domenico.aumenta.core.di

import com.domenico.aumenta.core.network.UserApiService
import com.domenico.aumenta.core.utils.LiveDataCallAdapterFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val coreModule = module {
    single { provideRetrofit(get(), get()) }
    single { provideOkHttpClient() }
    single { provideGson() }
    single { provideUserApiService(get()) }
}

fun provideGson(): Gson {
    return GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
}

fun provideUserApiService(retrofit: Retrofit): UserApiService = retrofit.create(
    UserApiService::class.java
)

private const val BASE_URL = "https://api.stackexchange.com"