package com.kuzyava.vkmobiledonations.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kuzyava.vkmobiledonations.R
import com.kuzyava.vkmobiledonations.databinding.FragmentAdditionalBinding
import com.kuzyava.vkmobiledonations.model.DonationModel

class AdditionalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAdditionalBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_additional, container, false)
        val model: DonationModel = arguments?.get("model") as DonationModel

        binding.btnCreate2.setOnClickListener {
            model.author = binding.author.text.toString()
            model.date = binding.date.text.toString()
            val bundle = bundleOf("model2" to model)
            findNavController().navigate(R.id.nav_finish, bundle)
        }
        binding.backTo2.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
}