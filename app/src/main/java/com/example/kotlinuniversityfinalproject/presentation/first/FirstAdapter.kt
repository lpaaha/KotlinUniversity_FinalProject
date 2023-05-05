package com.example.kotlinuniversityfinalproject.presentation.first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinuniversityfinalproject.R
import com.example.kotlinuniversityfinalproject.data.local.CoffeeDC

class FirstAdapter(
    val onClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<FirstAdapter.ViewHolder>() {

    val lisOfCoffee = ArrayList<CoffeeDC>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        val button: Button = itemView.findViewById(R.id.button)

    }

    fun setArrayListOfAnimals(arrayOfCoffee: List<CoffeeDC>) {
        this.lisOfCoffee.clear()
        this.lisOfCoffee.addAll(arrayOfCoffee)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {

        val coffee = lisOfCoffee[i]
        holder.button.setOnClickListener {
            onClick(i)
        }
        Glide.with(holder.itemView.context)
            .load(lisOfCoffee.get(i).URL).fitCenter().into(holder.itemImage)
        holder.itemTitle.text = coffee.name

    }

    override fun getItemCount(): Int {
        return lisOfCoffee.size
    }

}