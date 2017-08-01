package com.t3rse.piero.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.t3rse.piero.*
import com.t3rse.piero.core.ext.disableShift

/**
 * Created by david on 7/28/17.
 */
open class BaseActivity : AppCompatActivity(){

    lateinit var currentLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    fun navigate(location: Location, context: Context){
        if(currentLocation != location) {
            val intent = when (location) {
                Location.HOME -> Intent(context, MainActivity::class.java)
                Location.CHART -> Intent(context, ChartActivity::class.java)
                Location.NEWS -> Intent(context, NewsActivity::class.java)
                Location.SEARCH -> Intent(context, SearchActivity::class.java)
                else -> Intent(context, MainActivity::class.java)
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)



            startActivity(intent)
            this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }
    }

    fun setNavigation(navigation: BottomNavigationView, location: Location){
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId =
                when(location){
                    Location.HOME -> R.id.navigation_home
                    Location.CHART -> R.id.navigation_notifications
                    Location.NEWS -> R.id.navigation_dashboard
                    Location.SEARCH -> R.id.navigation_search
                    else -> R.id.navigation_home
                }
        navigation.disableShift()
    }

    enum class Location{
        HOME,
        NEWS,
        CHART,
        SEARCH,
        UNSET
    }


    val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                navigate(Location.HOME, this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                navigate(Location.NEWS, this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                navigate(Location.CHART, this)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                navigate(Location.SEARCH, this)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}