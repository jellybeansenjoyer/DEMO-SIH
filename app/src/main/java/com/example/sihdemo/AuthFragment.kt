package com.example.sihdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import com.example.sihdemo.databinding.FragmentAuthBinding
import com.google.android.material.button.MaterialButtonToggleGroup
private const val TAG = ".AuthFragment"
class AuthFragment : Fragment() {

    lateinit private var mBinding: FragmentAuthBinding
    lateinit private var mToggleButtonGroup: MaterialButtonToggleGroup
    private var state:Int? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return (DataBindingUtil.inflate(inflater,R.layout.fragment_auth,container,false) as FragmentAuthBinding).run {
            mBinding = this
            this.root
        }
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mToggleButtonGroup = mBinding.toggleButtonGroup
        if(savedInstanceState!=null)
        {
            //Selection not happening on Screen Rotation
            val selection = savedInstanceState.getInt("click")
            mToggleButtonGroup.check(selection)
        }
        mBinding.materialButtonLogin.setOnClickListener {
            if(mToggleButtonGroup.checkedButtonId!=-1){
                val intent = Intent(requireContext(),CenterActivity::class.java)
                when(mToggleButtonGroup.checkedButtonId){
                    R.id.admin_button-> intent.putExtra("type",2)
                    R.id.provider_button->intent.putExtra("type",3)
                    R.id.seeker_button->intent.putExtra("type",1)
                }
                startActivity(intent)
            }else{
                Toast.makeText(activity,"User Type is Required",Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val selected = mToggleButtonGroup.checkedButtonId
        outState.putInt("click",selected)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if(savedInstanceState!=null)
            savedInstanceState.getInt("click")
    }
}