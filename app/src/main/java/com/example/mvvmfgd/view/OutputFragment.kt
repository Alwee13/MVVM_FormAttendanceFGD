package com.example.mvvmfgd.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mvvmfgd.R
import com.example.mvvmfgd.databinding.FragmentOutputBinding
import com.example.mvvmfgd.viewmodel.AttandanceViewModel

class OutputFragment : Fragment() {

    private lateinit var binding: FragmentOutputBinding

    private val viewModel: AttandanceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOutputBinding.inflate(inflater, container, false)

        viewModel.attendanceData.observe(viewLifecycleOwner) { model ->
            binding.txtNamaResult.text = model.name
            binding.txtTelefonResult.text = model.phone
            binding.txtEmailResult.text = model.email
            binding.txtGenderResult.text = model.gender
            binding.txtSkillsetResult.text = model.skillset.joinToString (", ")
            binding.txtKategoriResult.text = model.kategori
        }

        return binding.root
    }

}