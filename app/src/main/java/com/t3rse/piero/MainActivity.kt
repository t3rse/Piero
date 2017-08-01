package com.t3rse.piero;

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.t3rse.piero.core.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentLocation = Location.HOME
        setContentView(R.layout.activity_main)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        setNavigation(navigation, currentLocation)



    }


}
