package com.example.sihdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.example.sihdemo.databinding.ActivityCenterBinding

class CenterActivity : AppCompatActivity() {
    lateinit private var mBinding: ActivityCenterBinding
    lateinit private var mDrawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var menuIdentifier:Int = -9999
        intent.getIntExtra("type",-9999).let{
            menuIdentifier = it
        }
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_center)
        val toolbar = mBinding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        mDrawer = mBinding.drawerLayout
        mBinding.navView.apply{
            menu.clear()
            when(menuIdentifier){
                1-> inflateMenu(R.menu.menu)
                2-> inflateMenu(R.menu.menu_admin)
                3->inflateMenu(R.menu.menu_stake)
            }
        }
        val toggle = ActionBarDrawerToggle(this,mDrawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        mDrawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}