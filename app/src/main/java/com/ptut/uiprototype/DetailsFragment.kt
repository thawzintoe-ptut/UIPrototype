package com.ptut.uiprototype

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.ptut.uiprototype.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {


    private lateinit var binding : FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.carPictureTv.show("https://images.hgmsites.net/hug/2021-tesla-model-3_100777876_h.jpg")

        binding.toolbar.addBackNavButton(requireActivity() as AppCompatActivity,R.drawable.ic_baseline_arrow_back_24)
    }


}