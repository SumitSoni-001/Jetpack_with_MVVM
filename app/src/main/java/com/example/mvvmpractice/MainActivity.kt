package com.example.mvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)

        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.replace(R.id.container, BlankFragment()).commit()

//        lifecycle.addObserver(observer())

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        mainViewModel = ViewModelProvider(this, MainViewModelFactory(10)).get(MainViewModel::class.java)

        mainViewModel.livedata.observe(this) {
            binding.tvShow.text = it
        }

        val data = Quote("Yes you Can")
        binding.data = data

    }

    fun setText() {
        mainViewModel.livedata.observe(this) {
            binding.tvShow.text = it
        }
    }

    fun increment(view: View) {
        mainViewModel.increaseCount()
    }

}