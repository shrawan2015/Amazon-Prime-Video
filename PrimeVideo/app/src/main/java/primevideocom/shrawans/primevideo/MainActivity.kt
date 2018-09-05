package primevideocom.shrawans.primevideo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NavigationRes
import android.support.design.R.styleable.NavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import primevideocom.shrawans.primevideo.R.id.nav_view


class MainActivity : AppCompatActivity()  {

    //Must be initlize before use
    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpFragment()
        setUpToolbar()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                println("4444")
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setUpToolbar(){
        mDrawerLayout = findViewById(R.id.drawable_layout)
        val navigationView =  nav_view  ////(NavigationView) findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->

            menuItem.isChecked = true
            when (menuItem.itemId)  {
                R.id.home -> {
                    openFragmentWithViewPager(0)
                }
                R.id.tv_show -> {
                    openFragmentWithViewPager(1)
                }
                R.id.movies -> {
                    openFragmentWithViewPager(2)
                }
                R.id.watchlist -> {
                    openFragmentWithViewPager(3)
                }
                R.id.downloads -> {
                    openFragmentWithViewPager(4)
                }

                R.id.settings -> {
                    openFragmentWithViewPager(4)
                }
                R.id.help -> {
                    openFragmentWithViewPager(4)
                }
            }
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            true
        }
        addToolBar()

    }

    fun addToolBar(){
        // to allow toolbar to set
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.burger)
        }
    }


    fun  setUpFragment(){
        var fragmentManager = getSupportFragmentManager()
        var fragmentTranscation =  fragmentManager.beginTransaction()
        var mainfragment =  MainFrgment()
        mainfragment.mainContextFromContext = this
        fragmentTranscation.replace(R.id.content_frame, mainfragment)
        fragmentTranscation.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTranscation.commit()
    }

    fun openFragmentWithViewPager(ofIndex:Int){
        var fragmentManager = getSupportFragmentManager()
        var mainfragment =  MainFrgment.newInstance(ofIndex)
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame,mainfragment)
                .addToBackStack(null)
                .commit()
    }
}