package com.example.krsnaism.dagger.network

import com.example.krsnaism.BuildConfig
import com.example.krsnaism.dagger.network.repository.RetrofitServiceInterfaceKLADR
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    //    private val baseURL = BuildConfig.baseURL
    private val baseURL ="https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/"

    @Singleton
    @Provides
    fun getRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun getHttpClint(): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor { chain ->
//                return@addInterceptor chain.proceed(
//                    chain
//                        .request()
//                        .newBuilder()
//                        .url("https://suggestions.dadata.ru/suggestions/api/4_1/rs/suggest/address/")
////                            headers: {
////                        "Content-Type": "application/json",
////                        "Accept": "application/json",
////                        "Authorization": "Token " + token
////                    }
//                        .addHeader("Authorization", "516769fe93685fa955636eb7d1857ec1f669f6cf")
//                        .build()
//                )
//            }
            .addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        if (BuildConfig.DEBUG) {
                            level = HttpLoggingInterceptor.Level.BASIC
                        }
                    })
            .build()
    }


    @Singleton
    @Provides
    fun getRetrofitServiceInterfaceKLADR(retrofit: Retrofit): RetrofitServiceInterfaceKLADR {
        return retrofit.create(RetrofitServiceInterfaceKLADR::class.java)
    }

}