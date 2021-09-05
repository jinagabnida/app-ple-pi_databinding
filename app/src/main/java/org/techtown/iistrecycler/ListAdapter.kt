package org.techtown.iistrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.techtown.iistrecycler.databinding.ItemLayoutBinding

class ListAdapter(val data: ArrayList<Data>,private val OnClick : (data : Data, position : Int) -> Unit) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {



    class MyViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        val itemNumberText : TextView = binding.itemNumberText
        // itemView.findViewById(R.id.itemNumberText)
        val itemNameText : TextView = binding.itemNameText
        // itemView.findViewById(R.id.itemNameText)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        val myViewHolder = MyViewHolder(ItemLayoutBinding.bind(v))
        v.setOnClickListener{
            OnClick(data[myViewHolder.adapterPosition],myViewHolder.adapterPosition)
        }
        return MyViewHolder(ItemLayoutBinding.bind(v))
    // myViewHolder(ItemLayoutBinding.bind(v))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.data = data[position]
    }

    override fun getItemCount(): Int = data.size

}