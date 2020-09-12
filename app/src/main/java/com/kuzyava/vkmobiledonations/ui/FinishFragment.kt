package com.kuzyava.vkmobiledonations.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kuzyava.vkmobiledonations.db.DonationDatabase
import com.kuzyava.vkmobiledonations.R
import com.kuzyava.vkmobiledonations.databinding.FragmentFinishBinding
import com.kuzyava.vkmobiledonations.model.DonationModel

class FinishFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentFinishBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_finish, container, false)
        val model = arguments?.get("model2") as DonationModel
        binding.model = model

        binding.btnExit.setOnClickListener {
            findNavController().popBackStack(R.id.nav_home, true)
        }

        binding.btnFinish.setOnClickListener {
            model.label = binding.label.text.toString()
            DonationDatabase.donations.add(model)
            findNavController().popBackStack(R.id.nav_home, true)
        }
        return binding.root
    }
}