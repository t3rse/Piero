package com.t3rse.piero.core

import android.content.Context
import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.t3rse.piero.*

/**
 * Created by david on 7/28/17.
 */
open class BaseActivity : AppCompatActivity(){

    lateinit var currentLocation: Location

     fun setText(text: String){

     }


    fun navigate(location: Location, context: Context){
        if(currentLocation != location) {
            val intent = when (location) {
                Location.HOME -> Intent(context, MainActivity::class.java)
                Location.CHART -> Intent(context, ChartActivity::class.java)
                Location.NEWS -> Intent(context, NewsActivity::class.java)
                Location.SEARCH -> Intent(context, SearchActivity::class.java)
                else -> null
            }
            startActivity(intent)
            this.overridePendingTransition(0,0)
            finish()
        }
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