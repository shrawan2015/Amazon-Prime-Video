package primevideocom.shrawans.primevideo

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


class MainFragmentAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){

    private val fragmentList = listOf("Home", "TV Show" , "Movies" , "Kids" )

    override fun getCount(): Int  = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence?  = fragmentList[position]

    override fun getItem(p0: Int): Fragment =  when (p0) {
            0 ->HomeFragment()
            1 -> TV_Show()
            2 -> Movies()
            3 -> Kids()
              else -> Kids()
        }

}