package com.manoolsbl4.mynutrition2.viewmodel.startfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.manoolsbl4.mynutrition2.R
import com.manoolsbl4.mynutrition2.databinding.StartFragmentBinding

class StartFragment : Fragment() {

    private lateinit var viewModel: StartViewModel
    private lateinit var binding: StartFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<StartFragmentBinding>(inflater, R.layout.start_fragment, container, false)

        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        val rvAdapter = StartRecyclerViewAdapter()
        binding.searchResultRecyclerView.adapter = rvAdapter
        binding.searchResultRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.rvData.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvAdapter.data = it
            }
        })

        binding.searchButton.setOnClickListener {
            viewModel.searchFood(binding.searchEditText.text.toString())
        }

        return binding.root
    }
}