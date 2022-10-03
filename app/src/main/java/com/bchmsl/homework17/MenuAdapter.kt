package com.bchmsl.homework17

import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bchmsl.homework17.databinding.LayoutMenuItemBinding

class MenuAdapter : ListAdapter<MenuItem, MenuAdapter.MenuItemViewHolder>(callback) {

    var itemClick: ((MenuItem.MenuType) -> Unit)? = null
    inner class MenuItemViewHolder(private val binding: LayoutMenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val currentItem = getItem(adapterPosition)
            binding.apply {
                ivMenuIcon.setImageResource(currentItem.icon)
                tvMenuTitle.text = currentItem.title
                currentItem.badgeCount?.let {
                    tvBadge.text = it.toString()
                    tvBadge.background.setTint(currentItem.badgeColor)
                    tvBadge.visibility = View.VISIBLE
                }
                root.setOnClickListener { itemClick?.invoke(currentItem.menuType) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return MenuItemViewHolder(
            LayoutMenuItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        holder.bind()
    }

    companion object{
        val callback = object: ItemCallback<MenuItem>(){
            override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
                return oldItem.menuType == newItem.menuType
            }

            override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}