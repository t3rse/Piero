package com.t3rse.piero.core.ext

import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView

/**
 * Created by david on 8/1/17.
 */
// https://stackoverflow.com/questions/40176244/how-to-disable-bottomnavigationview-shift-mode
fun BottomNavigationView.disableShift(){

    val menuView = this.getChildAt(0) as BottomNavigationMenuView
    try {
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        with(shiftingMode){
            isAccessible = true
            setBoolean(menuView, false)
            isAccessible = false
        }
        (0..menuView.childCount).map {
            val menuItemView = menuView.getChildAt(it) as BottomNavigationItemView
            menuItemView.setShiftingMode(false)
            menuItemView.setChecked(menuItemView.itemData.isChecked)
        }

    }
    catch(e: Exception){
        // NOOP, fail while testing
    }
}