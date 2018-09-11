package primevideocom.shrawans.primevideo.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import okhttp3.HttpUrl
import primevideocom.shrawans.primevideo.*
import primevideocom.shrawans.primevideo.Adapter.RecyclerViewAdapter
import primevideocom.shrawans.primevideo.Model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {


    private val allSampleData =  ArrayList<SectionModel>()

    lateinit var recyclerView:RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view  =  LayoutInflater.from( activity!!.applicationContext).inflate(R.layout.fragment_home, container, false)
         recyclerView = view.findViewById(R.id.my_recycler_view) as RecyclerView
        recyclerView.setHasFixedSize(true)
        createDummyData()

        val adapter = RecyclerViewAdapter(allSampleData as ArrayList<SectionModel>, activity!!.applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        createMovieList()

        return view

    }


//    val moveiListArray = listOfNotNull<NewMovieModel>(null)
//    var someList: ArrayList<List<Int>> = arrayListOf(emptyList())

    val moviearray = arrayListOf<NewMovieModel>()

    private val callback = object : Callback<MovieList> {
        override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
            Log.e("MainActivity", "Problem calling Github API", t)
        }

        override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {

            response?.isSuccessful.let {

                response?.body()?.results.let {
                    if (it != null) {
                        moviearray.addAll(it)
                    }
                }

                val URL = response?.raw()?.request()?.url() as HttpUrl
                val sectiontitle = URL.toString()
                val top_rated = sectiontitle.contains("top_rated" ,false)
                val upcoming = sectiontitle.contains("upcoming" ,false)
                val popular = sectiontitle.contains("popular" ,false)

                Log.e("value","${moviearray.size}")

                if (top_rated){
                    val dm = SectionModel(SectionType.NoHeaderOfSection, "Top Rated", response?.body()?.results!!.toTypedArray())
                    allSampleData?.add(dm)

                }
                if(upcoming){

                    val dm = SectionModel(SectionType.MovieMaxCellWidth, "Upcoming", response?.body()?.results!!.toTypedArray())

                    allSampleData?.add(dm)

                }
                if(popular){
                    val dm = SectionModel(SectionType.MovieMaxCellWidth, "Popular", response?.body()?.results!!.toTypedArray())

                    allSampleData?.add(dm)

                }

                activity?.runOnUiThread(java.lang.Runnable {
                    recyclerView.adapter.notifyDataSetChanged()
                })



            }

        }
    }

    private val repoRetriever = RepositoryRetriever()

     fun  createMovieList(){
         repoRetriever.getPopularMoviesList(callback)
         repoRetriever.getTopRatedMovie(callback)
         repoRetriever.getupcomingMovie(callback)
    }


    private fun createDummyData() {
//        var singlemdoel = arrayOf(MovieModel("item", "this is url"), MovieModel("Item ", "UR22L"), MovieModel("Item ", "URL33"), MovieModel("Item ", "URL44"), MovieModel("Item ", "URL55"), MovieModel("Item ", "URL66"), MovieModel("Item ", "URL5555"), MovieModel("Item ", "URL555555"))
//        val dm = SectionModel(SectionType.NoHeaderOfSection, "Watch Next TV and Movies", singlemdoel)
//        val dm2 = SectionModel(SectionType.MovieMaxCellWidth, "Tov Movies", singlemdoel)
//        val dm3 = SectionModel(SectionType.MovieMinCellWidth, "Recommended Movies", singlemdoel)
//
//        allSampleData?.add(dm)
//        allSampleData?.add(dm2)
//        allSampleData?.add(dm3)
//        allSampleData?.add(dm)
//        allSampleData?.add(dm3)
//        allSampleData?.add(dm)
//        allSampleData?.add(dm2)
    }




}
