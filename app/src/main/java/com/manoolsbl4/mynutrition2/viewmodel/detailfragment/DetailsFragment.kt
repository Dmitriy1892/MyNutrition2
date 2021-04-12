package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.WorkerThread
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.manoolsbl4.mynutrition2.R
import com.manoolsbl4.mynutrition2.databinding.DetailsFragmentBinding
import com.manoolsbl4.mynutrition2.model.Food
import com.manoolsbl4.mynutrition2.room.FoodDatabase
import com.manoolsbl4.mynutrition2.room.FoodModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: DetailsFragmentBinding

    private lateinit var foodId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        foodId = DetailsFragmentArgs.fromBundle(requireArguments()).foodId
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetailsFragmentBinding.inflate(inflater, container, false)

        val dbDao = FoodDatabase.getDatabase(requireContext()).foodDao()
        viewModel = ViewModelProvider(this, DetailsViewModelFactory(dbDao)).get(DetailsViewModel::class.java)
        viewModel.loadFood(foodId)

        binding.addToFavoriteButton.setOnClickListener{
            viewModel.addToFavorites()
            binding.addToFavoriteButton.isEnabled = false
        }

        viewModel.food.observe(viewLifecycleOwner, {
            binding.apply {
                detailLabel.text = it.label.toString()
                kcalValue.text = it.nutrients.enerc_kcal.toString()
                proteinValue.text = it.nutrients.procnt.toString()
                fatValue.text = it.nutrients.fat.toString()
                carbValue.text = it.nutrients.chocdf.toString()
                lifecycleScope.launch {
                    Picasso.with(context).load(it.image).into(detailImage)
                }
            }
        })

        return binding.root
    }

}