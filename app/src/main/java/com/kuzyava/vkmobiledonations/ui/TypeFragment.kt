package com.kuzyava.vkmobiledonations.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kuzyava.vkmobiledonations.R

class TypeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_type, container, false)
        root.findViewById<LinearLayout>(R.id.type1)
            .setOnClickListener { findNavController().navigate(R.id.nav_target) }

        root.findViewById<LinearLayout>(R.id.type2)
            .setOnClickListener {
                Toast.makeText(activity, "В разработке...", Toast.LENGTH_SHORT).show()
            }

        root.findViewById<ImageView>(R.id.backToHome)
            .setOnClickListener { findNavController().popBackStack() }
        return root
    }
}