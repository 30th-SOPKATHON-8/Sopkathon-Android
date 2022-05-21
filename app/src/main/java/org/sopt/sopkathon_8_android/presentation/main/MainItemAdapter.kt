package org.sopt.sopkathon_8_android.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import okhttp3.internal.notify
import org.sopt.sopkathon_8_android.data.ItemData
import org.sopt.sopkathon_8_android.databinding.ItemMainBinding

class MainItemAdapter(private val itemClick: (ItemData) -> Unit) :
    RecyclerView.Adapter<MainItemAdapter.MainItemViewHolder>() {
    private var itemList = mutableListOf<ItemData>()

    fun replaceItem(list: List<ItemData>) {
        itemList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainItemViewHolder {
        val binding =
            ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainItemViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: MainItemViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    class MainItemViewHolder(
        private val binding: ItemMainBinding,
        private val itemClick: (ItemData) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ItemData) {
            binding.data = data
            binding.root.setOnClickListener {
                itemClick(data)
            }
        }
    }

}
