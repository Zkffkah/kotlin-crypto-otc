package com.lowwor.cryptootc.module.home.priceentrance.btcentrance

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
internal abstract class  BtcEntranceBuilder{
    @ContributesAndroidInjector
    internal abstract fun btcEntranceFragment(): BtcEntranceFragment

    @Binds
    @IntoMap
    @ViewModelKey(BtcEntranceViewmodel::class)
    abstract fun bindBtcEntranceViewmodel(viewModel: BtcEntranceViewmodel): ViewModel
}