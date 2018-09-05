package primevideocom.shrawans.primevideo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MainFrgment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MainFrgment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MainFrgment() : Fragment() {

     var mainContextFromContext:Context? = null

        var selectedTab = 0

    var tabLayout:TabLayout? = null
    var viewPager:ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getInt("REPLACE")?.let {
            selectedTab = it
        }
        print("ssssssss" + selectedTab)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        val view =  inflater.inflate(R.layout.fragment_main_frgment, container, false)
         viewPager = view.findViewById(R.id.mainviewpager) as ViewPager

        // Give the TabLayout the ViewPager

         tabLayout = view.findViewById(R.id.sliding_tabs) as TabLayout
        tabLayout?.setupWithViewPager(viewPager)




        viewPager?.adapter =  MainFragmentAdapter(getChildFragmentManager())


        return view
    }

    // TODO: Rename method, update argument and hook method into UI event


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }


    override fun onResume() {
        super.onResume()

        print("SELECTED")
        print(selectedTab)


        if (selectedTab ==  0) {

            tabLayout?.setScrollPosition(0,0f,true);
            viewPager?.setCurrentItem(0);
//                viewPager.setCurrentItem(0,true)
        }
        if (selectedTab ==  1) {
            tabLayout?.setScrollPosition(1,0f,true);
            viewPager?.setCurrentItem(1);

        }
        if (selectedTab ==  2) {
            tabLayout?.setScrollPosition(2,0f,true);
            viewPager?.setCurrentItem(2,false)
        }
        if (selectedTab ==  3) {
            tabLayout?.setScrollPosition(3,0f,true);
            viewPager?.setCurrentItem(3,true)
        }

        viewPager?.adapter?.notifyDataSetChanged()

    }

    companion object {

        fun newInstance(indexValue: Int) = MainFrgment().apply {
            arguments = Bundle().apply {
                putInt("REPLACE", indexValue)
            }
        }
    }

}
