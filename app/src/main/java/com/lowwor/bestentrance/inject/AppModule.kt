package com.lowwor.bestentrance.inject

import android.content.Context
import com.lowwor.bestentrance.BestEntranceApplication
import com.lowwor.bestentrance.appmanagers.AppInitializers
import com.lowwor.bestentrance.appmanagers.LeakCanaryInitializer
import com.lowwor.bestentrance.appmanagers.TimberInitializer
import dagger.Module
import dagger.Provides

/**
 * Created by lowwor on 2018/1/23.
 */

@Module
class AppModule {
    @Provides
    fun provideContext(application: BestEntranceApplication): Context {
        return application.applicationContext
    }

    @Provides
    fun provideAppManagers(
            leakCanaryManager: LeakCanaryInitializer,
            timberManager: TimberInitializer): AppInitializers {
        return AppInitializers(leakCanaryManager, timberManager)
    }

}