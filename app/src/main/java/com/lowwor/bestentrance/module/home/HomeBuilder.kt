package com.lowwor.bestentrance.module.home

import android.arch.lifecycle.ViewModel
import com.lowwor.bestentrance.inject.ViewModelKey
import com.lowwor.bestentrance.module.home.priceentrance.PriceEntranceBuilder
import com.lowwor.bestentrance.module.home.priceentrance.btcentrance.BtcEntranceBuilder
import com.lowwor.bestentrance.module.home.priceentrance.usdtentrance.UsdtEntranceBuilder
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by lowwor on 2018/1/23.
 */
@Module
internal abstract class HomeBuilder {
    @ContributesAndroidInjector(modules = [HomeModule::class, PriceEntranceBuilder::class,
    BtcEntranceBuilder::class, UsdtEntranceBuilder::class])
    internal abstract fun homeActivity(): HomeActivity

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(viewModel: HomeActivityViewModel): ViewModel

}