package com.lowwor.cryptootc.module.home.priceentrance

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lowwor.cryptootc.R
import com.lowwor.cryptootc.base.BaseFragment
import com.lowwor.cryptootc.module.home.priceentrance.btcentrance.BtcEntranceFragment
import com.lowwor.cryptootc.module.home.priceentrance.usdtentrance.UsdtEntranceFragment
import kotlinx.android.synthetic.main.fragment_price_entrance.*
import javax.inject.Inject

/**
 * Created by lowwor on 2018/1/31.
 */
class PriceEntranceFragment : BaseFragment() {


    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: PriceEntranceViewmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_price_entrance, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHeader()
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(PriceEntranceViewmodel::class.java)

    }

    private fun initHeader() {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setupViewPager(view_pager)
        tab_layout.setupWithViewPager(view_pager)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = PriceEntranceViewPagerAdapter(fragmentManager!!)
        adapter.addFragment(BtcEntranceFragment(), "BTC")
        adapter.addFragment(UsdtEntranceFragment(), "USDT")
        viewPager.adapter = adapter
    }


}