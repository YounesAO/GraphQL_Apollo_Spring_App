package ma.ensa.banque.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ma.ensa.banque.repository.CompteRepository


class CompteViewModelFactory(
    private val repository: CompteRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CompteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}