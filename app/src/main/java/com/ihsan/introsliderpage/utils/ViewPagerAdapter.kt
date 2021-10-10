package com.ihsan.introsliderpage.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList: MutableList<Fragment> = mutableListOf()

    fun setItem(items: MutableList<Fragment>) {
        fragmentList.addAll(items)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    // untuk nge create item
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}