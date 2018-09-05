package primevideocom.shrawans.primevideo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import primevideocom.shrawans.primevideo.R.id.itemImage
import kotlin.coroutines.experimental.coroutineContext



class SectionAdapter(val movieList: Array<MovieModel> , val mainContext:Context): RecyclerView.Adapter<SectionAdapter.SingleItemRowHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleItemRowHolder {
        val inflatedView =  LayoutInflater.from(mainContext).inflate(R.layout.movie_cell,parent, false)
        return  SingleItemRowHolder(inflatedView)
    }

    override fun getItemCount(): Int =  movieList.size


    override fun onBindViewHolder(holder: SingleItemRowHolder, position: Int) {
        holder.bindItems(movieList[position])
    }


    class SingleItemRowHolder(v: View): RecyclerView.ViewHolder(v){

        private var view: View = v
        private var photo: MovieModel? = null

        fun bindItems(movie: MovieModel) {


            val itemImage =  itemView.findViewById(R.id.itemImage) as ImageView
            Picasso.get().load("https://i.imgur.com/tGbaZCY.jpg").into(itemImage)


            // no feature
            // val textViewName = itemView.findViewById(R.id.tvTitle) as TextView
            //  textViewName.text = movie.name
        }

    }
}