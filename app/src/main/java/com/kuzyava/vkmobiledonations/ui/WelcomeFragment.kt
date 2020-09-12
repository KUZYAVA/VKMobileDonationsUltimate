package com.kuzyava.vkmobiledonations.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.kuzyava.vkmobiledonations.db.DonationDatabase
import com.kuzyava.vkmobiledonations.R
import com.kuzyava.vkmobiledonations.model.DonationModel
import com.kuzyava.vkmobiledonations.ui.adapter.DonationAdapter

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout: Int =
            if (DonationDatabase.donations.isEmpty()) R.layout.fragment_welcome else R.layout.fragment_welcome2

        val root = inflater.inflate(layout, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = DonationAdapter(object : DonationAdapter.ItemClickListener {
            override fun onItemClick(item: DonationModel) {
                val bundle = bundleOf("item" to item)
                //findNavController().navigate(R.id.nav_detail, bundle)
                Toast.makeText(activity, "В разработке...", Toast.LENGTH_SHORT).show()
            }

        })
        adapter.addDonations(DonationDatabase.donations)
        recyclerView.adapter = adapter

        root.findViewById<TextView>(R.id.btn_create)
            .setOnClickListener { findNavController().navigate(R.id.nav_type) }
        return root
    }

}