package com.example.mvvmfgd.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.example.mvvmfgd.R
import com.example.mvvmfgd.databinding.ActivityMainBinding
import com.example.mvvmfgd.databinding.FragmentInputBinding
import com.example.mvvmfgd.model.AttendanceModel
import com.example.mvvmfgd.viewmodel.AttandanceViewModel



class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    private val viewModel: AttandanceViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater, container, false)

        // Populate spinner with items from resource array
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.kategori_peserta,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spCategory.adapter = adapter
        }

        // Getting values from view fields
        binding.btnSubmit.setOnClickListener {
            val model = AttendanceModel(
                name = binding.edtNama.text.toString(),
                phone = binding.edtTelefon.text.toString(),
                email = binding.edtEmail.text.toString(),
                gender = if(binding.radLakilaki.isChecked) "Laki-laki" else "Perempuan",
                skillset = listOfNotNull(
                    if (binding.chkAlgo.isChecked) "Algoritma" else null,
                    if (binding.chkProblemSolving.isChecked) "Problem Solving" else null,
                    if (binding.chkCriticalthinking.isChecked) "Critical Thinking" else null,
                    if (binding.chkProgamming.isChecked) "Programming" else null,
                    if (binding.chkDesignthinking.isChecked) "Design Thinking" else null
                ),
                kategori = binding.spCategory.selectedItem?.toString() ?: "Tidak Diketahui"
            )

            viewModel.setAttandanceData(model)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OutputFragment())
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }
}