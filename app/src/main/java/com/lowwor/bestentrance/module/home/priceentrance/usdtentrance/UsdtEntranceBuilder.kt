package com.lowwor.bestentrance.module.home.priceentrance.usdtentrance

import android.arch.lifecycle.ViewModel
import com.lowwor.bestentrance.inject.ViewModelKey
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