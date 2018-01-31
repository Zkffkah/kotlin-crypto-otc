package com.lowwor.bestentrance.module.home.priceentrance

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


/**
 * Created by lowwor on 2018/1/31.
 */
internal class PriceEntranceViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
    private val fragments = arrayListOf<Fragment>()
    private val titles = arrayListOf<String>()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}