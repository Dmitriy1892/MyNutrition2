package com.manoolsbl4.mynutrition2.viewmodel.startfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.manoolsbl4.mynutrition2.R
import com.manoolsbl4.mynutrition2.model.Food
import com.squareup.picasso.Picasso

open class StartRecyclerViewHolder(open val itemView: View, open val context: Context): RecyclerView.ViewHolder(itemView), View.OnClickListener{
    var foodId: String = ""
    val foodName: TextView = itemView.findViewById(R.id.food_name)
    val foodCalories: TextView = itemView.findViewById(R.id.food_calories)
    val foodImage: ImageView = itemView.findViewById(R.id.food_image)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            itemView.findNavController().navigate(StartFragmentDirections.actionStartFragmentToDetailsFragment2(foodId))
        }
    }

}

class StartRecyclerViewAdapter: RecyclerView.Adapter<StartRecyclerViewHolder>() {

    var data = listOf<Food>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartRecyclerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_rec_view, parent, false) as ConstraintLayout
        return StartRecyclerViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: StartRecyclerViewHolder, position: Int) {
        val item = data[position]
        holder.foodName.text = item.label
        holder.foodCalories.text = item.nutrients.enerc_kcal.toString()
        holder.foodId = item.foodId!!
        Picasso.with(holder.context).load(item.image).resize(120, 120).into(holder.foodImage)
    }

    override fun getItemCount() = data.size

}