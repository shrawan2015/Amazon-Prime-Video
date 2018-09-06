package primevideocom.shrawans.primevideo.Fragment

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import primevideocom.shrawans.primevideo.Model.Movies
import primevideocom.shrawans.primevideo.Model.TV_Show


class MainFragmentAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){

    private val fragmentList = listOf("Home", "TV Show" , "Movies" , "Kids" )

    override fun getCount(): Int  = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence?  = fragmentList[position]

    override fun getItem(p0: Int): Fragment =  when (p0) {
            0 -> HomeFragment()
            1 -> TV_Show()
            2 -> Movies()
            3 -> Kids()
              else -> Kids()
        }

}