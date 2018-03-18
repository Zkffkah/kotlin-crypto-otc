package com.lowwor.cryptootc.module.home.priceentrance.usdtentrance

import android.arch.lifecycle.ViewModel
import com.lowwor.cryptootc.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by lowwor on 2018/1/31.
 */
@Module
internal abstract class UsdtEntranceBuilder {
    @ContributesAndroidInjector
    internal abstract fun usdtEntranceFragment(): UsdtEntranceFragment

    @Binds
    @IntoMap
    @ViewModelKey(UsdtEntranceViewmodel::class)
    abstract fun bindUsdtEntranceViewmodel(viewModel: UsdtEntranceViewmodel): ViewModel
}