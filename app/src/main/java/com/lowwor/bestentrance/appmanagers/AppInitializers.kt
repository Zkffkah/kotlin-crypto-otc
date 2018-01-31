package com.lowwor.bestentrance.appmanagers

import android.app.Application
import com.lowwor.bestentrance.BuildConfig
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by lowwor on 2018/1/23.
 */
class AppInitializers(private vararg val initializers: AppInitializer) : AppInitializer {
    override fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}

class LeakCanaryInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        if (!LeakCanary.isInAnalyzerProcess(application)) {
            LeakCanary.install(application)
        }
    }
}

class TimberInitializer @Inject constructor() : AppInitializer {
    override fun init(application: Application) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}