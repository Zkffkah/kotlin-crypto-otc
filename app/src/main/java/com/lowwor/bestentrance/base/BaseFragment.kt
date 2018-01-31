package com.lowwor.bestentrance.base

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerFragment

/**
 * Created by lowwor on 2018/1/23.
 */
abstract class BaseFragment : DaggerFragment() {

    private var startedTransition = false
    private var postponed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun postponeEnterTransition() {
        super.postponeEnterTransition()
        postponed = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }


}