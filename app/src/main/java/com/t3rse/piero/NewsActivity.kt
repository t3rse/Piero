package com.t3rse.piero

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView
import com.t3rse.piero.core.BaseActivity


class NewsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        currentLocation = Location.NEWS

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        setNavigation(navigation, currentLocation)
    }

}
