package com.ihsan.introsliderpage.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.ihsan.introsliderpage.databinding.ActivityMainBinding
import com.ihsan.introsliderpage.ui.formfragment.FormFragment
import com.ihsan.introsliderpage.ui.sliderfragment.SliderFragment
import com.ihsan.introsliderpage.utils.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initViewPager()
    }

    private fun initViewPager() {
        val fragmentAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        val items = mutableListOf(
            SliderFragment(
                "",
                "",
                "https://raw.githubusercontent.com/Femastia/Binar/main/gambar2.png"
            ),
            SliderFragment(
                "",
                "",
                "https://raw.githubusercontent.com/Femastia/Binar/main/gambar1.png"
            ),
            FormFragment()
        )
        fragmentAdapter.setItem(items)

        binding.vpIntro.apply {
            adapter = fragmentAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when {
                        position == 0 -> {
                            binding.tvNext.visibility = View.VISIBLE
                            binding.tvNext.isEnabled = true
                            binding.tvPrevious.visibility = View.INVISIBLE
                            binding.tvPrevious.isEnabled = false
                        }
                        position < fragmentAdapter.itemCount - 1 -> {
                            binding.tvNext.visibility = View.VISIBLE
                            binding.tvNext.isEnabled = true
                            binding.tvPrevious.visibility = View.VISIBLE
                            binding.tvPrevious.isEnabled = true
                        }
                        position == fragmentAdapter.itemCount - 1 -> {
                            binding.tvNext.visibility = View.INVISIBLE
                            binding.tvNext.isEnabled = false
                            binding.tvPrevious.visibility = View.VISIBLE
                            binding.tvPrevious.isEnabled = true
                        }
                    }
                    super.onPageSelected(position)
                }
            })
        }
        binding.dotsIndicator.setViewPager2(binding.vpIntro)
        binding.tvNext.setOnClickListener {
            if (getNextIndex() != -1) {
                binding.vpIntro.setCurrentItem(getNextIndex(), true)
            }
        }
        binding.tvPrevious.setOnClickListener {
            if (getPreviousIndex() != -1) {
                binding.vpIntro.setCurrentItem(getPreviousIndex(), true)
            }
        }
    }

    private fun getPreviousIndex(): Int {
        val currentPage = binding.vpIntro.currentItem //0
        return if (currentPage - 1 >= 0) {
            currentPage - 1
        } else {
            -1 // unselected index , index always start by 0
        }
    }

    private fun getNextIndex(): Int {
        val maxPages = binding.vpIntro.adapter?.itemCount // 4
        val currentIndex = binding.vpIntro.currentItem // 4
        var selectedIndex = -1 //unselected index
        maxPages?.let {
            if (currentIndex + 1 < maxPages) { // 4+1 = 5
                selectedIndex = currentIndex + 1
            }
        }
        return selectedIndex // -1
    }

    override fun onBackPressed() {
    }
}