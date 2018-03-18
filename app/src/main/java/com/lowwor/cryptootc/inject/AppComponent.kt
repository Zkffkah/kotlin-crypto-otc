package com.lowwor.cryptootc.inject

import com.lowwor.cryptootc.CryptoOtcApplication
import com.lowwor.cryptootc.module.home.HomeBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by lowwor on 2018/1/23.
 */
@Singleton
@Component(modules = [
AndroidSupportInjectionModule::class,
AppModule::class,
ViewModelBuilder::class,
HomeBuilder::class,
NetworkModule::class
])
interface AppComponent : AndroidInjector<CryptoOtcApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CryptoOtcApplication>()
}