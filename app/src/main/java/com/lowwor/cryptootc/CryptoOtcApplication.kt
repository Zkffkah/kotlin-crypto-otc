package com.lowwor.cryptootc

import com.lowwor.cryptootc.appmanagers.AppInitializers
import com.lowwor.cryptootc.inject.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

/**
 * Created by lowwor on 2018/1/23.
 */
class CryptoOtcApplication : DaggerApplication() {
    @Inject lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        initializers.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}