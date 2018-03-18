package com.lowwor.cryptootc.module.home.priceentrance.btcentrance

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lowwor.cryptootc.R
import com.lowwor.cryptootc.base.BaseFragment
import com.lowwor.cryptootc.util.observeK
import kotlinx.android.synthetic.main.fragment_btc_entrance.*
import javax.inject.Inject

/**
 * Created by lowwor on 2018/1/31.
 */
class BtcEntranceFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener {


    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: BtcEntranceViewmodel
    private lateinit var btcEntranceAdapter: BtcEntranceAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_btc_entrance, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(BtcEntranceViewmodel::class.java)
        initSwipeRefresh()
        initRecyclerView()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.entrancePrices.observeK(this) {
            btcEntranceAdapter.setNewData(it)
            swipe_layout.isRefreshing = false
        }
        viewModel.refreshStatus.observeK(this){
            swipe_layout.isRefreshing = true
        }
    }

    private fun initSwipeRefresh() {

        swipe_layout.setOnRefreshListener(this)
        swipe_layout.setColorSchemeColors(Color.rgb(47, 223, 189))
    }

    private fun initRecyclerView() {
        btcEntranceAdapter = BtcEntranceAdapter()
        btcEntranceAdapter.setEnableLoadMore(false)
        recycler_view.adapter = btcEntranceAdapter
        recycler_view.layoutManager = LinearLayoutManager(activity)
    }


    override fun onRefresh() {
        viewModel.updatePrices()
    }


}