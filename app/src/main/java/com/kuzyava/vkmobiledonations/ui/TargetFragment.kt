package com.kuzyava.vkmobiledonations.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kuzyava.vkmobiledonations.R
import com.kuzyava.vkmobiledonations.databinding.FragmentTargetBinding
import com.kuzyava.vkmobiledonations.model.DonationModel

const val GALLERY = 123

class TargetFragment : Fragment() {
    private lateinit var binding: FragmentTargetBinding
    private var imageUri: Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_target, container, false)
        binding.cardView.setOnClickListener {
            val chooseIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            )
            startActivityForResult(chooseIntent, GALLERY)
        }
        binding.btnNext.setOnClickListener {
            val title = binding.title.text.toString()
            val amount = binding.amount.text.toString()
            val goal = binding.goal.text.toString()
            val desc = binding.description.text.toString()
            val img = if (imageUri == null) {
                Toast.makeText(activity, "Добавьте изображение!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else imageUri
            val model = DonationModel(title, amount, goal, desc, img = img)
            val bundle = bundleOf("model" to model)
            findNavController().navigate(R.id.nav_additional, bundle)
        }

        binding.backTo.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GALLERY) {
                imageUri = data?.data
                binding.image.setImageURI(imageUri)
                binding.image.visibility = View.VISIBLE
                binding.beforeImage.visibility = View.GONE
            }
        }
    }


}