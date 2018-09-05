package primevideocom.shrawans.primevideo

import android.content.Context
import android.support.v4.view.ViewPager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.LinearLayoutManager
import android.transition.CircularPropagation
import me.relex.circleindicator.CircleIndicator
import primevideocom.shrawans.primevideo.R.id.indicator
import java.util.ArrayList


class RecyclerViewAdapter(val movieList: ArrayList<SectionModel>, private val mainContext: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int =  movieList.size

    override fun getItemViewType(position: Int): Int {

        when(movieList[position].sectionType) {
             SectionType.NoHeaderOfSection ->  return 0
             SectionType.MovieMaxCellWidth ->  return 1
             else -> return 2
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

                when(viewType) {
            0 -> {
                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.slider_recycle_view,parent, false)
                return SliderSectionView(inflatedView)
            }

            1-> {
                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.single_section,parent, false)
                return  SingleSectionView(inflatedView)

            }
            else -> {
                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.single_section,parent, false)
                return  SingleSectionView(inflatedView)
            }

        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> {
                var holder2 = holder as  SliderSectionView
                holder2.bindItems(movieList[position], mainContext)
            }

            1 -> {
                var holder2 = holder as  SingleSectionView
                holder2.bindItems(movieList[position], mainContext)
            }
            else -> {
                var holder2 = holder as  SingleSectionView
                holder2.bindItems(movieList[position], mainContext)
            }

        }
    }

        class SingleSectionView(v: View) : RecyclerView.ViewHolder(v) {

            private var view: View = v
            private var photo: SectionModel? = null

            fun bindItems(movie: SectionModel, mContext: Context) {

                val itemTitle = view.findViewById(R.id.itemTitle) as TextView
                itemTitle.setText(movie.headerTitle)
                val recyclerview = view.findViewById(R.id.recycler_view_list) as RecyclerView
                recyclerview.setHasFixedSize(true)
                val sectionadapter = SectionAdapter(movie.sectionlist, mContext)
                val layoutmanager = LinearLayoutManager(mContext)
                layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
                recyclerview.layoutManager = layoutmanager
                recyclerview.adapter = sectionadapter

            }

        }

        class SliderSectionView(v: View) : RecyclerView.ViewHolder(v) {

            private var view: View = v
            private var photo: SectionModel? = null

            fun bindItems(movie: SectionModel, mContext: Context) {

                var viewpager = view.findViewById(R.id.pager) as ViewPager
                var adapter = SlideAdapter(context = mContext)
                viewpager.adapter = adapter
                var indicator = view.findViewById(R.id.indicator) as CircleIndicator
                indicator.setViewPager(viewpager)  //setViewPager(viewpager)

            }

        }

    }


//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//                when(viewType) {
//            1 -> {
//                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.slider_recycle_view,parent, false)
//                return SliderSectionView(inflatedView) as RecyclerView.ViewHolder
//            }
//
//            2-> {
//                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.single_section,parent, false)
//                return  SingleSectionView(inflatedView)
//
//            }
//            else -> {
//                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.single_section,parent, false)
//                return  SingleSectionView(inflatedView)
//            }
//
//        }
//    }
//
//
//    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getItemId(position: Int): Long {
//        return super.getItemId(position)
//    }
//
//    override fun getItemViewType(position: Int): Int {
//
//
//        return super.getItemViewType(position)
//    }
//    class ViewHolder( v :View) : RecyclerView.ViewHolder(v){
//
//    }


//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
//        when(viewType) {
//            1 -> {
//                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.slider_recycle_view,parent, false)
//                return (ViewHolder)SliderSectionView(inflatedView)
//            }
//
//            2-> {
//                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.single_section,parent, false)
//                return  SingleSectionView(inflatedView)
//
//            }
//            else -> {
//                val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.single_section,parent, false)
//                return  (ViewHolder)SingleSectionView(inflatedView)
//            }
//
//        }
//
//    }
//

//
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//    }
//
////    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
////
////
//////        holder.bindItems(movieList[position] ,mainContext )
////    }
//
//
//
//    ///Type of viewholder in recyclerview in android
//    class  ViewHolder(v:View) :RecyclerView.ViewHolder(v){
//
//    }
//

//}