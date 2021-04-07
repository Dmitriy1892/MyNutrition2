package com.manoolsbl4.mynutrition2.viewmodel.favoritesfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.manoolsbl4.mynutrition2.databinding.FavoritesFragmentBinding
import com.manoolsbl4.mynutrition2.room.FoodDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class FavoritesFragment : Fragment() {

    private lateinit var viewModel: FavoritesViewModel
    private lateinit var binding: FavoritesFragmentBinding
    private lateinit var rvAdapter: FavoritesRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FavoritesFragmentBinding.inflate(inflater, container, false)

        rvAdapter = FavoritesRecyclerViewAdapter()
        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.favoritesRecyclerView.adapter = rvAdapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val db = FoodDatabase.getDatabase(requireContext()).foodDao()

        viewModel = ViewModelProvider(this, FavoritesViewModelFactory(db)).get(FavoritesViewModel::class.java)
        viewModel.rvData.observe(viewLifecycleOwner, {
            rvAdapter.data = it
        })
    }
}