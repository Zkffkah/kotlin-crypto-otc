package com.lowwor.cryptootc.appmanagers

import android.app.Application

/**
 * Created by lowwor on 2018/1/23.
 */
interface AppInitializer {
    fun init(application: Application)
}