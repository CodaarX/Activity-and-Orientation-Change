package com.decagon.week2Task_Activity_Fragment_LifeCycle_and_Orientation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_implememtation_2.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment__one.*

class Task_2 : AppCompatActivity() {
    /**
     * @param fragmentCount -> variable to hold count for each fragment added to the backstack and shown on screen
     * Activity life cycle states, each overriding its super method
     * each state logging its current state and changing the current text view to that state.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // set layout to the desired activity
        setContentView(R.layout.activity_implememtation_2)

        addButton.setOnClickListener(){
            var fragmentCounter = supportFragmentManager.backStackEntryCount
                supportFragmentManager.beginTransaction().apply {     // begins a new transaction to create a fragment
                    // replace fragment with a new instance of the fragment
                add(R.id.frameFragment, Fragment_One.newInstance("Fragment position in back stack: $fragmentCounter"))
                addToBackStack("Fragment $fragmentCounter")    // adds fragment to backStack
                commit()
            }
        }

        removeButton.setOnClickListener{
            supportFragmentManager.popBackStack(); // removes the topmost fragment from the backStack
        }
    }
}