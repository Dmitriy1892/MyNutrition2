package com.manoolsbl4.mynutrition2.viewmodel.favoritesfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.manoolsbl4.mynutrition2.R
import com.manoolsbl4.mynutrition2.room.FoodModel
import com.manoolsbl4.mynutrition2.viewmodel.startfragment.StartRecyclerViewHolder
import com.squareup.picasso.Picasso

class FavoritesRecyclerViewHolder(override val itemView: View, override val context: Context): StartRecyclerViewHolder(itemView, context) {
    override fun onClick(v: View?) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            itemView.findNavController().navigate(FavoritesFragmentDirections.actionFavoritesFragmentToDetailsFragment(foodId))
        }
    }
}

class FavoritesRecyclerViewAdapter: RecyclerView.Adapter<FavoritesRecyclerViewHolder>() {

    var data = listOf<FoodModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_rec_view, parent, false) as ConstraintLayout
        return FavoritesRecyclerViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: FavoritesRecyclerViewHolder, position: Int) {
        val item = data[position]
        holder.foodName.text = item.label
        holder.foodCalories.text = item.enerc_kcal.toString()
        holder.foodId = item.foodId
        Picasso.with(holder.context).load(item.image).resize(120, 120).into(holder.foodImage)
    }

    override fun getItemCount(): Int {
        return data.size
    }


}