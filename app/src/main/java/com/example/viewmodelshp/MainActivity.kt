package com.example.viewmodelshp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.viewmodelshp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MyViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        myViewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        binding.data = myViewModel
        binding.lifecycleOwner = this

    }
}
