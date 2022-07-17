package com.example.sihdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import com.example.sihdemo.databinding.FragmentAuthBinding
import com.example.sihdemo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

   lateinit private var mBinding:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        val toolbar = mBinding.toolbar
        val drawer = mBinding.drawerLayout
        val toggle = ActionBarDrawerToggle(activity,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        (activity as MainActivity).setSupportActionBar(toolbar)
        return mBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}