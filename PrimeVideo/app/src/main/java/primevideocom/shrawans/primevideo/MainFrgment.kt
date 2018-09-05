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
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_main_frgment, container, false)
        viewPager = view.findViewById(R.id.mainviewpager) as ViewPager
        tabLayout = view.findViewById(R.id.sliding_tabs) as TabLayout
        tabLayout?.setupWithViewPager(viewPager)
        viewPager?.adapter =  MainFragmentAdapter(getChildFragmentManager())

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }


    override fun onResume() {
        super.onResume()
        selectPage(selectedTab)
    }

    fun selectPage(ofIndex:Int){
        tabLayout?.setScrollPosition(ofIndex,0f,true);
        viewPager?.setCurrentItem(ofIndex);
    }


    companion object {
        fun newInstance(indexValue: Int) = MainFrgment().apply {
            arguments = Bundle().apply {
                putInt("REPLACE", indexValue)
            }
        }
    }

}
