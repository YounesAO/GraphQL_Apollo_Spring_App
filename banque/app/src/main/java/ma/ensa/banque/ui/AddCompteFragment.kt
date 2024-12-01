package ma.ensa.banque.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.apollographql.apollo3.api.Optional
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ma.ensa.banque.databinding.FragmentAddCompteBinding
import ma.ensa.banque.type.CompteRequest
import ma.ensa.banque.type.TypeCompte
import ma.ensa.banque.viewmodel.CompteViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddCompteFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentAddCompteBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CompteViewModel
    private var selectedType: TypeCompte? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCompteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CompteViewModel::class.java]
        setupAccountTypeDropdown()
        setupSubmitButton()
    }

    private fun setupAccountTypeDropdown() {
        val types = TypeCompte.values().filter { it != TypeCompte.UNKNOWN__ }
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            types
        )

        binding.spinnerType.setAdapter(adapter)
        binding.spinnerType.setOnItemClickListener { _, _, position, _ ->
            selectedType = types[position]
        }
    }

    private fun setupSubmitButton() {
        binding.btnSubmit.setOnClickListener {
            val solde = binding.etSolde.text.toString().toDoubleOrNull()
            if (solde == null) {
                binding.etSolde.error = "Please enter a valid amount"
                return@setOnClickListener
            }

            if (selectedType == null) {
                binding.spinnerType.error = "Please select an account type"
                return@setOnClickListener
            }

            val currentDate = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(Date())

            val compte = CompteRequest(
                solde = Optional.present(solde),
                dateCreation = Optional.present(currentDate),
                type = Optional.present(selectedType!!)
            )

            viewModel.addCompte(compte)
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}