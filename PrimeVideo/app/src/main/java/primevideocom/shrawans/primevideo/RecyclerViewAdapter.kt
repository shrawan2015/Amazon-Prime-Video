package primevideocom.shrawans.primevideo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v7.widget.LinearLayoutManager
import java.util.ArrayList


class RecyclerViewAdapter(val movieList: ArrayList<SectionModel>, val mainContext: Context): RecyclerView.Adapter<RecyclerViewAdapter.SingleSectionView>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleSectionView {
        println("qqqqqqqqqq")

        val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.single_section,parent, false)

        return  SingleSectionView(inflatedView)
    }

    override fun getItemCount(): Int =  movieList.size


    override fun onBindViewHolder(holder: SingleSectionView, position: Int) {
        println("qqqqqqqqqq")
        holder.bindItems(movieList[position] ,mainContext )
    }


    class SingleSectionView(v: View): RecyclerView.ViewHolder(v){

        private var view: View = v
        private var photo: SectionModel? = null

        fun bindItems(movie: SectionModel , mContext:Context ) {

            val itemTitle = view.findViewById(R.id.itemTitle) as TextView
            itemTitle.setText(movie.headerTitle)
            val recyclerview = view.findViewById(R.id.recycler_view_list) as RecyclerView
            recyclerview.setHasFixedSize(true)
            val sectionadapter = SectionAdapter(movie.sectionlist ,mContext)
            val layoutmanager = LinearLayoutManager(mContext )
            layoutmanager.orientation = LinearLayoutManager.HORIZONTAL
            recyclerview.layoutManager = layoutmanager
            recyclerview.adapter = sectionadapter

        }

    }
}