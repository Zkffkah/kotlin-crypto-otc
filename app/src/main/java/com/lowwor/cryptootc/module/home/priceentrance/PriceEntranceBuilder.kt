package com.lowwor.cryptootc.module.home.priceentrance

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
internal abstract class PriceEntranceBuilder {
    @ContributesAndroidInjector
    internal abstract fun priceEntranceFragment(): PriceEntranceFragment

    @Binds
    @IntoMap
    @ViewModelKey(PriceEntranceViewmodel::class)
    abstract fun bindPriceEntranceViewmodel(viewModel: PriceEntranceViewmodel): ViewModel
}