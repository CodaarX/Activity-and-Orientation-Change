

package com.decagon.week2Task_Activity_Fragment_LifeCycle_and_Orientation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment__one.*


private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class Fragment_One : Fragment() {

    private var param1: String? = null // param1 variable set to hold strings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1) // set the value coming from companion object using the it.getString method to param 1
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
    : View? {
        return inflater.inflate(R.layout.fragment__one, container, false)  // Inflate the layout for this fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        fragmentCount.text = param1    // set text content to value coming in from activity (containing the stack position of fragment)
    }

    /**
     * Companion object is used for passing data from activity to fragment
     * @param1 param1 takes in data from activity
     */

    companion object {
        fun newInstance(param1: String) =
                Fragment_One().apply {  // apply bundle to fragment
                    arguments = Bundle().apply {  // bundle data coming from argument
                        putString(ARG_PARAM1, param1)
            }
        }
    }
}







