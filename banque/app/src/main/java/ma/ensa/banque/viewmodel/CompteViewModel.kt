package ma.ensa.banque.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ma.ensa.banque.model.Compte
import ma.ensa.banque.repository.CompteRepository
import ma.ensa.banque.type.CompteRequest
import ma.ensa.banque.utils.Resource

class CompteViewModel(private val repository: CompteRepository) : ViewModel() {
    private val _comptes = MutableLiveData<Resource<List<Compte>>>()
    val comptes: LiveData<Resource<List<Compte>>> = _comptes

    fun loadComptes() {
        viewModelScope.launch {
            _comptes.value = Resource.Loading()
            _comptes.value = repository.getAllComptes()
        }
    }

    fun addCompte(compte: CompteRequest) {
        viewModelScope.launch {
            repository.addCompte(compte)
            loadComptes()
        }
    }

    fun deleteCompte(id: String) {
        viewModelScope.launch {
            repository.deleteCompte(id)
            loadComptes()
        }
    }
}