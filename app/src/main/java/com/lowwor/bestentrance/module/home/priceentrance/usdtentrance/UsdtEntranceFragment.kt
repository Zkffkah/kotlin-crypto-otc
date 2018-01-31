package com.lowwor.bestentrance.module.home.priceentrance.usdtentrance

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lowwor.bestentrance.R
import com.lowwor.bestentrance.base.BaseFragment
import com.lowwor.bestentrance.util.observeK
import kotlinx.android.synthetic.main.fragment_btc_entrance.*
import javax.inject.Inject

/**
 * Created by lowwor on 2018/1/31.
 */
class UsdtEntranceFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {


    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: UsdtEntranceViewmodel
    private lateinit var usdtEntranceAdapter: UsdtEntranceAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_usdt_entrance, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(UsdtEntranceViewmodel::class.java)
        initSwipeRefresh()
        initRecyclerView()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.entrancePrices.observeK(this) {
            usdtEntranceAdapter.setNewData(it)
            swipe_layout.isRefreshing = false
        }
    }

    private fun initSwipeRefresh() {

        swipe_layout.setOnRefreshListener(this)
        swipe_layout.setColorSchemeColors(Color.rgb(47, 223, 189))
    }

    private fun initRecyclerView() {
        usdtEntranceAdapter = UsdtEntranceAdapter()
        usdtEntranceAdapter.setEnableLoadMore(false)
        recycler_view.adapter = usdtEntranceAdapter
        recycler_view.layoutManager = LinearLayoutManager(activity)
    }


    override fun onRefresh() {
        viewModel.updatePrices()
    }


}