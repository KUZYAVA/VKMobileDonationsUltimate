package com.kuzyava.vkmobiledonations.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kuzyava.vkmobiledonations.R
import com.kuzyava.vkmobiledonations.databinding.ItemDonationBinding
import com.kuzyava.vkmobiledonations.model.DonationModel

class DonationAdapter :
    RecyclerView.Adapter<DonationAdapter.DonationsVH>() {
    private val items: MutableList<DonationModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonationsVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemDonationBinding>(
                inflater,
                R.layout.item_donation,
                parent,
                false
            )
        return DonationsVH(binding)
    }

    fun addDonations(docList: List<DonationModel>) {
        items.addAll(docList)
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: DonationsVH, position: Int) {
        val item = items[position]
        holder.binding.apply {
            model = item
            executePendingBindings()
        }
    }

    override fun getItemCount() = items.size

    class DonationsVH(val binding: ItemDonationBinding) :
        RecyclerView.ViewHolder(binding.root)
}
