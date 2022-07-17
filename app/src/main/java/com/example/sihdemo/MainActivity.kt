package com.example.sihdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.sihdemo.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlin.reflect.KClass

class MainActivity : AppCompatActivity() {

    lateinit private var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        if(savedInstanceState==null)
            inflateFragment(AuthFragment::class.java)
    }
    fun <T: Fragment> inflateFragment(className:Class<T>,args:Bundle?=null){
        supportFragmentManager.commit{
            replace(R.id.container,className,args)
        }
    }
}