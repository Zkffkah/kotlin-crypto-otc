package com.lowwor.cryptootc.inject

import android.content.Context
import com.lowwor.cryptootc.CryptoOtcApplication
import com.lowwor.cryptootc.appmanagers.AppInitializers
import com.lowwor.cryptootc.appmanagers.LeakCanaryInitializer
import com.lowwor.cryptootc.appmanagers.TimberInitializer
import dagger.Module
import dagger.Provides

/**
 * Created by lowwor on 2018/1/23.
 */

@Module
class AppModule {
    @Provides
    fun provideContext(application: CryptoOtcApplication): Context {
        return application.applicationContext
    }

    @Provides
    fun provideAppManagers(
            leakCanaryManager: LeakCanaryInitializer,
            timberManager: TimberInitializer): AppInitializers {
        return AppInitializers(leakCanaryManager, timberManager)
    }

}