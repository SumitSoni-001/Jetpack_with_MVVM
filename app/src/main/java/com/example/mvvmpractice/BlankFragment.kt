package com.example.mvvmpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpractice.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)

//        viewModel = ViewModelProvider(this, MainViewModelFactory(5)).get(MainViewModel::class.java)

        viewModel = ViewModelProvider(activity as MainActivity).get(MainViewModel::class.java)

        binding.textLiveData = viewModel
        binding.lifecycleOwner = this

//        viewModel.livedata.observe(viewLifecycleOwner) {
//            view.findViewById<TextView>(R.id.textFrag).text = it
//        }

//        view.findViewById<Button>(R.id.update).setOnClickListener {
//            viewModel.increaseCount()
//            setTextFrag()
//        }

        binding.next.setOnClickListener {
            (activity as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.container , FragmentTwo()).commit()
        }

        return binding.root
//        return view
    }

//    fun setTextFrag() {
//        view?.findViewById<TextView>(R.id.textFrag)?.text = viewModel.count.toString()
//    }

}