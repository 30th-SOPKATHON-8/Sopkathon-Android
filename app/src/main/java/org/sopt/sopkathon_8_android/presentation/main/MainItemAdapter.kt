package org.sopt.sopkathon_8_android.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sopkathon_8_android.databinding.ItemMainBinding

class MainItemAdapter : RecyclerView.Adapter<MainItemAdapter.MainItemViewHolder>() {
    private val itemList = mutableListOf<ItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val binding =
            ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    class MainItemViewHolder(
        private val binding: ItemMainBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ItemData) {
            binding.tvItemTitle.text = data.title
            binding.tvItemDate.text = data.createdAt
            binding.tvItemContent.text = data.price
            //binding.ivMood.setImageResource(R.drawble.) Todo
        }
    }

}
