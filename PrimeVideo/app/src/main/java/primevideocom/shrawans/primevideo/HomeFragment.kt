package primevideocom.shrawans.primevideo


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.util.*
import kotlin.text.Typography.section


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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view  =  LayoutInflater.from( activity!!.applicationContext).inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById(R.id.my_recycler_view) as RecyclerView
        recyclerView.setHasFixedSize(true)
        createDummyData()

        val adapter = RecyclerViewAdapter(allSampleData as ArrayList<SectionModel>, activity!!.applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        return view

    }

    private fun createDummyData() {

        var singlemdoel = arrayOf(MovieModel("item", "this is url" ) , MovieModel("Item ", "UR22L") , MovieModel("Item ", "URL33"), MovieModel("Item ", "URL44"), MovieModel("Item ", "URL55"), MovieModel("Item ", "URL66"), MovieModel("Item ", "URL5555"), MovieModel("Item ", "URL555555"))

        val dm = SectionModel( SectionType.NoHeaderOfSection , "Watch Next TV and Movies" , singlemdoel)
        val dm2 = SectionModel(  SectionType.MovieMaxCellWidth, "Tov Movies" , singlemdoel)
        val dm3 = SectionModel( SectionType.MovieMinCellWidth , "Recommended Movies" , singlemdoel)

        allSampleData?.add(dm)
        allSampleData?.add(dm2)
        allSampleData?.add(dm3)
        allSampleData?.add(dm)
        allSampleData?.add(dm3)
        allSampleData?.add(dm)
        allSampleData?.add(dm2)
    }

}
