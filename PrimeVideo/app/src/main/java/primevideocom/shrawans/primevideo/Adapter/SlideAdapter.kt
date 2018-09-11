package primevideocom.shrawans.primevideo.Adapter

import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso
import primevideocom.shrawans.primevideo.Model.NewMovieModel
import primevideocom.shrawans.primevideo.Model.SectionModel
import primevideocom.shrawans.primevideo.R
import primevideocom.shrawans.primevideo.R.id.itemImage
import java.util.ArrayList

// private val images: ArrayList<Int>
class SlideAdapter( val context: Context ,val movie:Array<NewMovieModel>) : PagerAdapter() {
    private val inflater: LayoutInflater

    init {
        inflater = LayoutInflater.from(context)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return   movie.size //images.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val myImageLayout = inflater.inflate(R.layout.slide, view, false)

        //TODO:
        val myImage = myImageLayout
                .findViewById(R.id.image) as ImageView

        val url =  "https://image.tmdb.org/t/p/w500/" + movie[position].poster_path
        Log.e("IMAGE",url)
        Picasso.get().load(url).into(myImage)


//        Picasso.get().load("https://i.imgur.com/tGbaZCY.jpg").into(myImage)
//        Picasso.get().load("https://image.tmdb.org/t/p/w500/$").into(myImage)

        view.addView(myImageLayout, 0)
        return myImageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }
}