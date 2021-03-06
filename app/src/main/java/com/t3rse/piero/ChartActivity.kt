package com.t3rse.piero

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.t3rse.piero.core.BaseActivity

class ChartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentLocation = Location.CHART
        setContentView(R.layout.activity_chart)

        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        setNavigation(navigation, currentLocation)
    }
}
