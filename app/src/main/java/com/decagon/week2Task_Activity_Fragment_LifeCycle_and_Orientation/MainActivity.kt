package com.decagon.week2Task_Activity_Fragment_LifeCycle_and_Orientation

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

// class Main Avtivity -> entry poit to my application and inherits from AppCompactActivity super class
class MainActivity : AppCompatActivity() {
    /**
     * @param handler -> object from the Handler class to access post delay
     * @param portraitcounter -> variable to hold count for each portrait orientation
     * @param landscapeCounter -> variable to hold count for each landScape orientation
     * @param screenHeight -> Saves the value of screen height measured in pixels
     * @param screenWidth -> Saves the value of screen width measured in pixels
     */

    var handler = Handler()
    var portraitCounter = 0
    var landscapeCounter = 0

    /**
     * Methods below contains all activity life cycle states, with each overriding its super method
     * each state logging its current state and changing the current text view to that state.
     * @param SavedInstanceState -> saves the data for each Instance (session) in the onSaveInstance method and loads it in the onCreate method
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        // override parent method
        super.onCreate(savedInstanceState)

        // sets the display to the main activity
        setContentView(R.layout.activity_main)

        /**
         * @param handler delays time for each state to show on screen
         */
        handler.postDelayed({activityState.text = "On Create State"}, 1000)
        Log.d("MainActivity", "On Create")

        // condition below checks if savedInstance contains any data before loading
        if (savedInstanceState != null){
            landscapeCounter = savedInstanceState.getInt("landscapeCounter")
            portraitCounter = savedInstanceState.getInt("portriateCounter")
        }

        // checks if width of screen is greater than height for orientation detection
        if( getResources().getDisplayMetrics().widthPixels > getResources().getDisplayMetrics().heightPixels) {
            landscapeCounter ++
            orientationState.text = "Landscape Count: ${landscapeCounter}"
        } else {
            portraitCounter ++
            orientationState.text = "Portrait Count: ${portraitCounter}"
        }
    }


    override fun onStart(){
        // override parent method
        super.onStart()
        Log.d("MainActivity", "On Start")
        handler.postDelayed({activityState.text = "On Start State"}, 2000)
    }

    override fun onResume(){
        // override parent method
        super.onResume()
        Log.d("MainActivity", "On Resume")
        handler.postDelayed({activityState.text = "On Resume State"}, 2500)
        //activityState.text = "On Resume State"
    }

    override fun onPause() {
        // override parent method
        super.onPause()
        handler.postDelayed({activityState.text = "On Pause State"}, 0)
        Log.d("MainActivity", "On Pause")
    }

    override fun onRestart() {
        // override parent method
        super.onRestart()
        handler.postDelayed({activityState.text = "On Restart State"}, 1500)
        Log.d("MainActivity", "On Restart")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle){
        // override parent method
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt("portriateCounter", portraitCounter)
        savedInstanceState.putInt("landscapeCounter", landscapeCounter)
        Log.d("MainActivity", "On Save instance")
        activityState.text = "On Save Instance State"

    }

    override fun onStop(){
        // override parent method
        super.onStop()
        activityState.text = "On Stop State"
        Log.d("MainActivity", "On Stop")
    }

    override fun onDestroy(){
        // override parent method
        super.onDestroy()
        activityState.text = "On Destroy State"
        Log.d("MainActivity", "On Destroy")
    }

    override fun finish() {
        super.finish()
    }

    fun open_Second_Task(view: View){
        var intent = Intent(this, Task_2:: class.java)
        startActivity(intent)
    }
}