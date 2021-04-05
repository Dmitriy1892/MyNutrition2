package com.manoolsbl4.mynutrition2.viewmodel.detailfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.manoolsbl4.mynutrition2.R
import com.manoolsbl4.mynutrition2.databinding.DetailsFragmentBinding
import com.squareup.picasso.Picasso
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
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        viewModel.loadFood(foodId)

        viewModel.food.observe(viewLifecycleOwner, {
            it?.let {
                binding.apply {
                    lifecycleScope.launch {
                        Picasso.with(context).load(it.image).into(detailImage)
                    }
                    detailLabel.text = it.label.toString()
                    kcalValue.text = it.nutrients.enerc_kcal.toString()
                    proteinValue.text = it.nutrients.procnt.toString()
                    fatValue.text = it.nutrients.fat.toString()
                    carbValue.text = it.nutrients.chocdf.toString()
                }

            }
        })

        return binding.root
    }
}